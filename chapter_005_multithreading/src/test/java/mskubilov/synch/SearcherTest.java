package mskubilov.synch;

import org.junit.Test;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 31.05.17
 */
public class SearcherTest {

    /**
     * Searcher for tests.
     */
    private Searcher searcher;

    /**
     * Pseudo test of Searcher Without Stopping When Found Match.
     */
    @Test
    public void testSearcherWithoutStoppingWhenFoundMatch() {
        searcher = new Searcher("some text", false);
        searcher.searchTextInFile();
    }

    /**
     * Pseudo test of Searcher With Stopping When Found Match.
     */
    @Test
    public void testSearcherWithStoppingWhenFoundMatch() {
        searcher = new Searcher("some text", true);
        searcher.searchTextInFile();
    }

}