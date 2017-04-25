package mskubilov.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 25.04.17
 */
public class SimpleTree<E extends Comparable> {

    /**
     * Root of SimpleTree.
     */
    private Leaf<E> root;

    /**
     * Size of SimpleTree.
     */
    private int size;

    /**
     * List of all children.
     */
    private List<E> children = new LinkedList<E>();

    /**
     * Add a child.
     * @param e element.
     */
    public void addChild(E e) {
        if (root == null) {
            root = new Leaf<E>(e);
            size++;
            this.children.add(e);
        } else {
            add(e, root);
        }
    }

    /**
     * @param e element.
     * @param parent parent for element.
     */
    private void add(E e, Leaf<E> parent) {
        int compared = e.compareTo(parent.getValue());
        if (compared == 0) {
            return;
        }
        if (compared < 0) {
            if (parent.getLeft() != null) {
                add(e, parent.getLeft());
            } else {
                parent.setLeft(new Leaf<E>(e, parent));
                size++;
                this.children.add(e);
            }
        }
        if (compared > 0) {
            if (parent.getRight() != null) {
                add(e, parent.getRight());
            } else {
                parent.setRight(new Leaf<E>(e, parent));
                size++;
                this.children.add(e);
            }
        }
    }

    /**
     * @param e element for searching.
     * @return result of searching.
     */
    public boolean search(E e) {
        boolean result = false;
        if (root != null) {
            result = searchRec(e, root);
        } else {
            throw new NoSuchElementException("Tree is empty!");
        }
        return result;
    }

    /**
     * @param e element for searching.
     * @param leaf root for recursion.
     * @return result of recursive searching.
     */
    private boolean searchRec(E e, Leaf<E> leaf) {
        boolean result = false;
        if (leaf.getLeft() != null) {
            result = leaf.getLeft().getValue().equals(e);
            if (result) {
                return result;
            } else {
                result = searchRec(e, leaf.getLeft());
            }
        }
        if (leaf.getRight() != null) {
            result = leaf.getRight().getValue().equals(e);
            if (result) {
                return result;
            } else {
                result = searchRec(e, leaf.getRight());
            }
        }
        return result;
    }

    /**
     * @param leaf root of tree.
     * @return balanced tree or not.
     */
    public boolean isBalanced(Leaf<E> leaf) {
        boolean result = true;
        if ((leaf.getRight() == null && leaf.getLeft() != null) || (leaf.getRight() != null && leaf.getLeft() == null)) {
            result = false;
        } else {
            if(leaf.getLeft() != null && leaf.getRight() != null) {
                result = isBalanced(leaf.getLeft()) && isBalanced(leaf.getRight());
            }
        }
        return result;
    }
    /**
     * @return List of all children.
     */
    public List<E> getChildren() {
        if (this.size == 0) {
            throw new NoSuchElementException("Tree is empty!");
        } else {
            return this.children;
        }
    }

    /**
     * @return tree's root.
     */
    public Leaf<E> getRoot() {
        return root;
    }

    /**
     * Tree's Leaf with value of element and parent, left or right leafs.
     * @param <E> generic.
     */
    static class Leaf<E extends Comparable> {
        /**
         * element's value.
         */
        private E value;

        /**
         * Parent leaf of this child.
         */
        private Leaf<E> parent;

        /**
         * Left child of this leaf.
         */
        private Leaf<E> left;

        /**
         * Right child of this leaf.
         */
        private Leaf<E> right;

        /**
         * Make root Leaf.
         * @param value of element.
         */
        Leaf(E value) {
            this.value = value;
        }

        /**
         * Make children.
         * @param value of element.
         * @param parent of child.
         */
        Leaf(E value, Leaf<E> parent) {
            this.value = value;
            this.parent = parent;
        }

        /**
         * @return left child.
         */
        public Leaf<E> getLeft() {
            return left;
        }

        /**
         * @param left child.
         */
        public void setLeft(Leaf<E> left) {
            this.left = left;
        }

        /**
         * @return right child.
         */
        public Leaf<E> getRight() {
            return right;
        }

        /**
         * @param right child.
         */
        public void setRight(Leaf<E> right) {
            this.right = right;
        }

        /**
         * @return value of this leaf.
         */
        public E getValue() {
            return value;
        }
    }
}
