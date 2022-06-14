package de.olikue.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SorterTest {

    Random rand = new Random();
    int listSize = 50000;
    int upperBound=1000;
    int lowerBound=-1000;

    @Test
    public void compareSorters() {
        BubbleSorter bSorter = new BubbleSorter();
        System.out.println("Bubble Sort: " + measureSortingTime(bSorter, listSize) + " milliseconds");

        SelectionSorter sSorter = new SelectionSorter();
        System.out.println("Selection Sort: " + measureSortingTime(sSorter, listSize) + " milliseconds");

        InsertionSorter iSorter = new InsertionSorter();
        System.out.println("Insertion Sort: " + measureSortingTime(iSorter, listSize) + " milliseconds");

        MergeSorter mSorter = new MergeSorter();
        System.out.println("Merge Sort: " + measureSortingTime(mSorter, listSize) + " milliseconds");

        QuickSorter qSorter = new QuickSorter();
        System.out.println("Quick Sort: " + measureSortingTime(qSorter, listSize) + " milliseconds");

        CountingSorter cSorter = new CountingSorter();
        System.out.println("Counting Sort: " + measureSortingTime(cSorter, listSize) + " milliseconds");
    }

    @Test
    public void testCountingSorter(){
        CountingSorter cSorter = new CountingSorter();
        List<Integer> result = cSorter.sortIntegerList(createRandomList(100));
        System.out.println(result);
        Assertions.assertTrue(isListSorted(result));
    }

    @Test
    public void testQuickSorter() {

        QuickSorter qSorter = new QuickSorter();
        List<Integer> result = qSorter.sortIntegerList(createRandomList(1000));
        Assertions.assertTrue(isListSorted(result));
    }

    @Test
    public void testMergeSorter() {

        MergeSorter mSorter = new MergeSorter();
        List<Integer> result = mSorter.sortIntegerList(createRandomList(1000));
        Assertions.assertTrue(isListSorted(result));
    }

    @Test
    public void testInsertionSorter() {

        InsertionSorter iSorter = new InsertionSorter();
        List<Integer> result = iSorter.sortIntegerList(createRandomList(1000));

        Assertions.assertTrue(isListSorted(result));
    }

    @Test
    public void testSelectionSorter() {

        SelectionSorter sSorter = new SelectionSorter();
        List<Integer> result = sSorter.sortIntegerList(createRandomList(1000));

        Assertions.assertTrue(isListSorted(result));
    }

    @Test
    public void testBubbleSorter() {

        BubbleSorter bSorter = new BubbleSorter();
        List<Integer> result = bSorter.sortIntegerList(createRandomList(1000));

        Assertions.assertTrue(isListSorted(result));
    }

    private List<Integer> createRandomList(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(lowerBound, upperBound));
        }
        return list;
    }

    private boolean isListSorted(List<Integer> toCheck) {
        boolean sorted = true;

        for (int i = 0; i < toCheck.size() - 1; i++) {
            if (toCheck.get(i) > toCheck.get(i + 1)) {
                sorted = false;
            }
        }
        return sorted;
    }

    private double measureSortingTime(Sorter sorter, int listSize){
        double t0, t1;
        List<Integer> list = createRandomList(listSize);

        t0 = System.currentTimeMillis();
        sorter.sortIntegerList(list);
        t1 = System.currentTimeMillis();

        return t1-t0;
    }
}
