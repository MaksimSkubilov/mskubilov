package mskubilov;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 19.04.17
 */
public class NodeTest {
    /**
     * test of true cycling.
     */
    @Test
    public void testOfCorrectCyclingDetectingForLinkedNodes() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> fourth = new Node<>(4);
        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(second);
        assertThat(first.hasCycle(first), is(true));
    }

    /**
     * test of false cycling.
     */
    @Test
    public void testOfCorrectNonCyclingDetectingForLinkedNodes2() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> fourth = new Node<>(4);
        first.setNext(third);
        second.setNext(fourth);
        third.setNext(second);
        assertThat(first.hasCycle(first), is(false));
    }


}