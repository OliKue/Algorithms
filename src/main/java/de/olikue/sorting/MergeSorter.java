package de.olikue.sorting;

import java.util.List;

/**
 * Merge Sort Complexity
 *
 * Time Complexity
 * Best:    O(n*log n)
 * Worst:   O(n*log n)
 * Aver.:   O(n*log n)
 *
 */
public class MergeSorter extends Sorter {



    @Override
    public List<Integer> sortIntegerList(List<Integer> integerList) {
        mergeSort(integerList, 0, integerList.size()-1);
        return integerList;
    }

    private void mergeSort(List<Integer> integerList, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;

            mergeSort(integerList, p, q);
            mergeSort(integerList, q + 1, r);
            merge(integerList, p, q, r);
        }
    }

    private void merge(List<Integer> integerList, int p, int q, int r) {
        List<Integer> sL1 = integerList.subList(p, q);
        List<Integer> sL2 = integerList.subList(q + 1, r);

        int i = 0, j = 0, k = p;

        while (i < sL1.size() && j < sL2.size()) {
            if (sL1.get(i) <= sL2.get(j)) {
                integerList.set(k, sL1.get(i));
                i++;
            } else {
                integerList.set(k, sL2.get(j));
                j++;
            }
            k++;
        }

        while (i < sL1.size()) {
            integerList.set(k, sL1.get(i));
            i++;
            k++;
        }
        while (j < sL2.size()) {
            integerList.set(k, sL2.get(j));
            j++;
            k++;
        }

    }
}
