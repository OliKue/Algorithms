package de.olikue.sorting;

import java.util.Collections;
import java.util.List;
/**
 * Counting Sort Complexity
 *
 * Time Complexity
 * Best:    O(n+k)
 * Worst:   O(n+k)
 * Aver.:   O(n+k)
 *
 */
public class CountingSorter extends Sorter {
    @Override
    public List<Integer> sortIntegerList(List<Integer> integerList) {
        List<Integer>[] seperatedValues = this.separateInput(integerList);

        List<Integer> positiveInts= seperatedValues[0];
        List<Integer> negativeInts= this.negateIntegerList(seperatedValues[1]);


        countSort(positiveInts, positiveInts.size());
        countSort(negativeInts, negativeInts.size());

        Collections.reverse(negativeInts);
        for(int i = 0; i<negativeInts.size();i++){
            negativeInts.set(i, -negativeInts.get(i));
        }
        negativeInts.addAll(positiveInts);

        integerList = negativeInts;

        return integerList;
    }

    void countSort(List<Integer> integerList, int size) {
        int[] output = new int[size + 1];

        // Find the largest element of the array
        int max = integerList.get(0);
        for (int i = 1; i < size; i++) {
            if (integerList.get(i) > max)
                max = integerList.get(i);
        }
        int[] count = new int[max + 1];

        // Initialize count array with all zeros.
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }

        // Store the count of each element
        for (int i = 0; i < size; i++) {
            count[integerList.get(i)]++;
        }

        // Store the cummulative count of each array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Find the index of each element of the original array in count array, and
        // place the elements in output array
        for (int i = size - 1; i >= 0; i--) {
            output[count[integerList.get(i)] - 1] = integerList.get(i);
            count[integerList.get(i)]--;
        }

        // Copy the sorted elements into original array
        for (int i = 0; i < size; i++) {
            integerList.set(i, output[i]);
        }
    }
}
