package mskubilov.nonblocking;

import org.junit.Test;

import java.util.HashMap;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 07.06.17
 */
public class CacheTest {

    /**
     * Cache instance.
     */
    private Cache<Model> cache = new Cache<>();

    /**
     * when Add Model Then It In The Cache.
     */
    @Test
    public void whenAddModelThenItInTheCache() {
        Model model1 = new Model("model #1");
        Model model2 = new Model("madel #2");
        cache.add(model1);
        cache.add(model2);
        assertThat(cache.getMap().size(), is(2));
        assertThat(cache.getMap().contains(model1), is(true));
    }

    /**
     * when Renaming Models In Threads Gets Error Then It Throws Optimistic Exception.
     * @throws InterruptedException if interrupted.
     * @throws OptimisticException if do possible creating two models with same id.
     */
    @Test
    public void whenRenamingModelsInThreadsGetsErrorThenItThrowsOptimisticException() throws InterruptedException, OptimisticException {
        HashMap<Integer, Model> hashMap = new HashMap<>();
        Model model1 = new Model("model #1");
        Model model2 = new Model("madel #2");
        hashMap.put(model1.getId(), model1);
        hashMap.put(model2.getId(), model2);
        Cache<Model> cache = new Cache<>(hashMap);
        Thread t1 = new Thread() {
            @Override
            public void run() {
                int i = model2.getVersion();
                while (i < 50) {
                    try {
                        cache.update(model2, String.format("model_#%s", i + 1));
                    } catch (OptimisticException oe) {
                        System.out.println(oe.getMessage());
                    } finally {
                        i = model2.getVersion();
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                int i = model2.getVersion();
                while (i < 50) {
                    try {
                        cache.update(model2, String.format("model number %s", i + 1));
                    } catch (OptimisticException oe) {
                        System.out.println(oe.getMessage());
                    } finally {
                        i = model2.getVersion();
                    }
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    /**
     * when Deleting Models In Threads Gets Error Then It Throws Optimistic Exception.
     * @throws InterruptedException if interrupted.
     * @throws OptimisticException if do possible creating two models with same id.
     */
    @Test
    public void whenDeletingModelsInThreadsGetsErrorThenItThrowsOptimisticException() throws InterruptedException, OptimisticException {
        HashMap<Integer, Model> hashMap = new HashMap<>();
        Model model;
        for (int i = 1; i <= 100; i++) {
            model = new Model(String.format("%s", i));
            hashMap.put(model.getId(), model);
        }
        Cache<Model> cache = new Cache<>(hashMap);
        System.out.println(cache.getMap().size());
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    try {
                        cache.delete(hashMap.get(i));
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    } catch (OptimisticException e) {
                        System.out.println(e.getMessage());
                    } catch (NoSuchElementException e) {
                        //System.out.println(e.getMessage());
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    try {
                        cache.delete(hashMap.get(i));
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    } catch (OptimisticException e) {
                        System.out.println(e.getMessage());
                    } catch (NoSuchElementException e) {
                        //System.out.println(e.getMessage());
                    }
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        assertThat(cache.getMap().size(), is(50));
        assertThat(cache.getMap().containsKey(51), is(true));
    }
}