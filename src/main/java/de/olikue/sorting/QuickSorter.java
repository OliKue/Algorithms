package de.olikue.sorting;

import java.util.List;
/**
 * Quick Sort Complexity
 *
 * Time Complexity
 * Best:    O(n^2)
 * Worst:   O(n*log n)
 * Aver.:   O(n*log n)
 *
 */
public class QuickSorter extends Sorter{
    @Override
    public List<Integer> sortIntegerList(List<Integer> integerList) {
        quickSort(integerList, 0, integerList.size()-1);

        return integerList;
    }

    private void quickSort(List<Integer> integerList, int low, int high){
        if(low < high){
            int pi = partition(integerList, low, high);

            quickSort(integerList, low, pi-1);
            quickSort(integerList, pi+1, high);
        }
    }

    private int partition(List<Integer> integerList, int low, int high) {

        int pivot = integerList.get(high);

        int i = (low-1);

        for(int j =low;j<high;j++){
            if(integerList.get(j) <= pivot){
                i++;

                int temp = integerList.get(i);
                integerList.set(i,integerList.get(j));
                integerList.set(j,temp);
            }
        }
        int temp = integerList.get(i+1);
        integerList.set(i+1, integerList.get(high));
        integerList.set(high, temp);

        return i+1;
    }
}
