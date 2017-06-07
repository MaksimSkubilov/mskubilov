package mskubilov.nonblocking;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 07.06.17
 */
public class ModelTest {

    /**
     * when Create Models Then They Get Right Ids.
     */
    @Test
    public void whenCreateModelsThenTheyGetRightIds() {
        Model model1 = new Model("model #1");
        assertThat(model1.getId(), is(1));
        Model model2 = new Model("madel #2");
        assertThat(model2.getId(), is(2));
    }

    /**
     * when Set New Model's Name Then It's Version Increments.
     */
    @Test
    public void whenSetNewModelsNameThenItsVersionIncrements() {
        Model model1 = new Model("model #1");
        model1.setName("New name");
        assertThat(model1.getName(), is("New name"));
        assertThat(model1.getVersion(), is(2));
    }

    /**
     * when Create Models By Threads Then It Create Models With Unique Ids.
     * @throws InterruptedException if interrupted.
     * @throws OptimisticException if do possible creating two models with same id.
     */
    @Test
    public void whenCreateModelsByThreadsThenItCreateModelsWithUniqueIds() throws InterruptedException, OptimisticException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 100000; i++) {
                    try {
                        new Model(String.format("%s", i));
                    } catch (OptimisticException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 100000; i++) {
                    try {
                        new Model(String.format("%s", i));
                    } catch (OptimisticException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        };

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}