package de.olikue.sorting;

import java.util.ArrayList;
import java.util.List;

public abstract class Sorter {
    public abstract List<Integer> sortIntegerList(List<Integer> integerList);

    /**
     * seperates positve and negative input into 2 lists
     * @param integerList
     * @return array containing 2 lists [0]=positive list(0 included) [1]= negative list
     */
    protected List<Integer>[] separateInput(List<Integer> integerList){
        List<Integer> positiveInts= new ArrayList<>();
        List<Integer> negativeInts= new ArrayList<>();

        for(int i: integerList){
            if(i < 0){
                negativeInts.add(i);
            }else{
                positiveInts.add(i);
            }
        }
        List<Integer>[] array = new List[]{positiveInts, negativeInts};

        return array;

    }
    protected List<Integer> negateIntegerList(List<Integer> integerList){
        for(int i=0; i < integerList.size(); i++){
            integerList.set(i, -integerList.get(i));
        }
        return integerList;
    }
}
