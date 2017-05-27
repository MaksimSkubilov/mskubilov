package mskubilov.extra;

import java.util.List;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 27.05.17
 */
public class mergeValues {
    /**
     * @param listA sorted list of Numbers to add values.
     * @param listB unsorted list of Number, source of values to merge.
     * @param <T> Numbers.
     */
    public <T extends Number> void merge(List<T> listA, List<T> listB) {
        Double first = listA.get(0).doubleValue();
        Double last = listA.get(listA.size() - 1).doubleValue();
        Double middle = listA.get((listA.size() / 2)).doubleValue();
        for (T number : listB) {
            Double value = number.doubleValue();
            if (value < first) {
                listA.add(0,number);
                first = number.doubleValue();
                middle = listA.get((listA.size() / 2)).doubleValue();
            }
            if (value > last) {
                listA.add(number);
                last = number.doubleValue();
                middle = listA.get((listA.size() / 2)).doubleValue();
            }
            if (value > first && value < middle) {
                if ((value - first) <= (middle - value)) {
                    for (int i = 0; i < listA.size() / 2; i++) {
                        if (value > listA.get(i).doubleValue() && value < listA.get(i + 1).doubleValue()) {
                            listA.add(i + 1, number);
                            middle = listA.get((listA.size() / 2)).doubleValue();
                            break;
                        }
                    }
                } else {
                    for (int i = listA.size() / 2; i > 1; i--) {
                        if (value < listA.get(i).doubleValue() && value > listA.get(i - 1).doubleValue()) {
                            listA.add(i, number);
                            middle = listA.get((listA.size() / 2)).doubleValue();
                            break;
                        }
                    }
                }
            }
            if (value > middle && value < last) {
                if ((value - middle) <= (last - value)) {
                    for (int i = listA.size() / 2; i < listA.size() - 1; i++) {
                        if (value > listA.get(i).doubleValue() && value < listA.get(i + 1).doubleValue()) {
                            listA.add(i + 1 , number);
                            middle = listA.get((listA.size() / 2)).doubleValue();
                            break;
                        }
                    }
                } else {
                    for (int i = listA.size() - 1; i > listA.size() / 2; i--) {
                        if (value < listA.get(i).doubleValue() && value > listA.get(i - 1).doubleValue()) {
                            listA.add(i, number);
                            middle = listA.get((listA.size() / 2)).doubleValue();
                            break;
                        }
                    }
                }
            }
        }
    }
}
