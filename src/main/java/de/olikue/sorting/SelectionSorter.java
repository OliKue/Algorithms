package de.olikue.sorting;

import java.util.List;
/**
 * Selection Sort Complexity
 *
 * Time Complexity
 * Best:    O(n^2)
 * Worst:   O(n^2)
 * Aver.:   O(n^2)
 *
 */
public class SelectionSorter extends Sorter{
    @Override
    public List<Integer> sortIntegerList(List<Integer> integerList) {

        for(int j = 0; j< integerList.size();j++) {
            int minimumIndex= j;
            for (int i = j; i < integerList.size(); i++) {

                if (integerList.get(minimumIndex) > integerList.get(i)) {
                    minimumIndex = i;
                }
            }
            int temp = integerList.get(minimumIndex);
            integerList.set(minimumIndex, integerList.get(j));
            integerList.set(j, temp);

        }

        return integerList;

    }
}
