package de.olikue.sorting;

import java.util.List;

/**
 * Bubble Sort Complexity
 *
 * Time Complexity
 * Best:    O(n)
 * Worst:   O(n^2)
 * Aver.:   O(n^2)
 *
 */
public class BubbleSorter extends Sorter{
    @Override
    public List<Integer> sortIntegerList(List<Integer> integerList) {

        int size = integerList.size();
        boolean sorted=false;
        while (!sorted) {
            sorted=true;
            for (int i = 0; i < size - 1; i++) {
                if (integerList.get(i) > integerList.get(i + 1)) {
                    int temp = integerList.get(i + 1);
                    integerList.set(i + 1, integerList.get(i));
                    integerList.set(i, temp);
                    sorted = false;
                }
            }
        }

        return integerList;
    }
}
