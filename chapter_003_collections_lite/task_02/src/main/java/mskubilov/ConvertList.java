package mskubilov;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 07.04.17
 */
public class ConvertList {
    /**
     * toList. Конвертирует двумерный массив в коллекцию интерфейса List.
     * @param array - входящий двумерный массив.
     * @return коллекцию ArrayList полученную из array.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i != array.length; i++) {
            for (int j = 0; j != array[i].length; j++) {
                result.add(array[i][j]);
            }
        }
        return result;
    }

    /**
     * toArray. Возвращает двумерный массив целых чисел.
     * @param list - коллекция, которая будет конвертирвоана в двумерный массив.
     * @param rows - количество строк массива.
     * @return двумерный массив, полученный из коллекции list.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int size = list.size() / rows + 1;
        int[][] result = new int[rows][size];
        Iterator it = list.iterator();
        int i = 0;
        int j = 0;
        while (i != rows) {
            while (j != size && it.hasNext()) {
                result[i][j++] = (int) it.next();
            }
            i++;
            j = 0;
        }
        return result;
    }

    /**
     * convert.
     * @param list - список одномерных массивов.
     * @return коллекцию из значений содержимого списка.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        Iterator it = list.iterator();
        while(it.hasNext()) {
            int[] temp = (int[]) it.next();
            for (int i = 0; i != temp.length; i++) {
                result.add(temp[i]);
            }
        }
        return result;
    }
}
