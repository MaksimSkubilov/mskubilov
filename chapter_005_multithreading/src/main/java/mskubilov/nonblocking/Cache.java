package mskubilov.nonblocking;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 07.06.17
 *
 */

/**
 * Non-blocking cache based on ConcurrentHashMap.
 * @param <T> extends Model.
 */
public class Cache<T extends Model> {

    /**
     * Cache's models storage.
     */
    private ConcurrentHashMap<Integer, T> map = new ConcurrentHashMap<Integer, T>();

    /**
     * Filled cache instance construct.
     * @param map HashMap filled with models.
     */
    public Cache(HashMap<Integer, T> map) {
        this.map.putAll(map);
    }

    /**
     * Empty cache instance construct.
     */
    public Cache() {
    }

    /**
     * @param model some model instance.
     * @return the previous value associated with key, or
     *         null if there was no mapping for key.
     */
    public T add(T model) {
        return this.map.put(model.getId(), model);
    }

    /**
     * @param model some model instance.
     * @param name new model's name.
     * @return true if update successful, false otherwise.
     */
    public boolean update(T model, String name) {
        T mapsModel = this.map.get(model.getId());
        if (mapsModel == null) {
            return false;
        }
        int version = mapsModel.getVersion();
        mapsModel = map.computeIfPresent(model.getId(), new BiFunction<Integer, T, T>() {
            @Override
            public T apply(Integer id, T element) {
                if (element.getVersion() == version) {
                    element.setName(name);
                    System.out.println(String.format(
                            "Version %s by thread %s renamed to \"%s\"", element.getVersion(), Thread.currentThread().getName(), element.getName()));
                    return element;
                } else {
                    throw new OptimisticException(String.format(
                            "%s failed to rename to \"%s\", another thread has updated version %s to %s already!", Thread.currentThread().getName(), name, version, version + 1));
                }
            }
        });
        return mapsModel.getVersion() - 1 == version;
    }

    /**
     * @param model some model instance.
     * @return true if delete successful false otherwise.
     */
    public boolean delete(T model) {
        if (map.contains(model)) {
            T tempo;
            if (model == null) {
                throw new NullPointerException();
            } else {
                int id = model.getId();
                tempo = map.computeIfPresent(id, new BiFunction<Integer, T, T>() {
                    @Override
                    public T apply(Integer index, T element) {
                        if (index == id && element.getId() == id) {
                            System.out.println(String.format(
                                    "Model %s deleted by thread %s", element.getId(), Thread.currentThread().getName()));
                            map.remove(id, element);
                        }
                        return element;
                    }
                });
            }
            if (tempo == null) {
                throw new OptimisticException(String.format(
                        "%s failed, another thread has deleted model %s already!", Thread.currentThread().getName(), model.getName()));
            }
        } else {
            throw new NoSuchElementException("Model you trying to delete already deleted or never been added to cache");
        }
        return true;
    }

    /**
     * @return this.map for tests.
     */
    ConcurrentHashMap<Integer, T> getMap() {
        return map;
    }

}
