package mskubilov.tree;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 25.04.17
 */
public class SimpleTreeTest {

    /**
     * SimpleTree for tests.
     */
    private SimpleTree<Integer> tree = new SimpleTree<>();

    private SimpleTree<Integer> simpleTree = new SimpleTree<>();

    /**
     * Fill SimpleTree with values.
     */
    @Before
    public void fillSimpleTree() {
        tree.addChild(10);
        tree.addChild(12);
        tree.addChild(11);
        tree.addChild(6);
        tree.addChild(6);
        tree.addChild(11);


        for (int i = 490; i > 0; i--) {
            simpleTree.addChild(i);
        }
        for (int i = 490; i < 1000; i++) {
            simpleTree.addChild(i);
        }
    }

    /**
     * test of correct tree structure.
     */
    @Test
    public void testOfTreeStructure() {
        assertThat(tree.getRoot().getValue(), is(10));
        assertThat(tree.getRoot().getRight().getValue(), is(12));
        assertThat(tree.getRoot().getRight().getLeft().getValue(), is(11));
        assertThat(tree.getRoot().getLeft().getValue(), is(6));
    }

    /**
     * test Of Getting All Children.
     */
    @Test
    public void testOfGettingAllChildren() {
        assertThat(tree.getChildren().toString(), is("[10, 12, 11, 6]"));
    }

    /**
     * test of binary searching element.
     */
    @Test
    public void testOfBinarySearchingElement() {
        assertThat(simpleTree.binarySearch(490), is(true));
        assertThat(simpleTree.binarySearch(999), is(true));
        assertThat(simpleTree.binarySearch(1), is(true));
        assertThat(simpleTree.binarySearch(0), is(false));
        assertThat(simpleTree.binarySearch(1001), is(false));
    }

    /**
     * test of searching element.
     */
    @Test
    public void testOfSearchingElement() {
        assertThat(simpleTree.search(490), is(true));
        assertThat(simpleTree.search(999), is(true));
        assertThat(simpleTree.search(1), is(true));
        assertThat(simpleTree.search(0), is(false));
        assertThat(simpleTree.search(1001), is(false));
    }

    /**
     * test of balanced tree.
     */
    @Test
    public void testOfBalancedTree() {
        assertThat(tree.isBalanced(tree.getRoot()), is(false));
        tree.addChild(13);
        tree.addChild(5);
        tree.addChild(7);
        assertThat(tree.isBalanced(tree.getRoot()), is(true));
    }
}