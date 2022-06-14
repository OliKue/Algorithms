package de.olikue.sorting;

import java.util.List;

/**
 * Insertion Sort Complexity
 *
 * Time Complexity
 * Best:    O(n)
 * Worst:   O(n^2)
 * Aver.:   O(n^2)
 *
 */
public class InsertionSorter extends Sorter{
    @Override
    public List<Integer> sortIntegerList(List<Integer> integerList) {


        for(int i=1; i< integerList.size();i++) {
            int key = integerList.get(i);

            for(int j=0; j<i;j++){
                if(key<integerList.get(j)){
                    int temp = key;
                    for(int k=j;k<i;k++){
                        key = integerList.get(k);
                        integerList.set(k, temp);
                    }
                }
            }
        }
        return integerList;
    }
}
