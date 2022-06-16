package de.olikue.searching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SearcherTest {


    @Test
    public void compareSpeedOnce(){
        double t0, t1, t2,t3;
        List<Integer> sortedList= createSortedList(10000000);
        BinarySearcher BS = new BinarySearcher();
        int indexToFind = 68;

        t0 = System.nanoTime();
        int indexFound1 = BS.searchInList(sortedList, indexToFind);
        t1 = System.nanoTime();
        Assertions.assertEquals(indexToFind,indexFound1);
        System.out.println("Iterativ approach took: "+ (t1-t0)+" nanoseconds");

        t2 = System.nanoTime();
        int indexFound2 = BS.searchInListRecursive(sortedList, indexToFind, 0, sortedList.size());
        t3 = System.nanoTime();
        Assertions.assertEquals(indexToFind,indexFound2);
        System.out.println("Recursive approach took: "+ (t3-t2)+" nanoseconds");

    }
    @Test
    public void compareSpeedMultipleTimes(){
        int timesToTry=1000;
        int listSize=10000000;
        Random rand = new Random();

        List<Integer> sortedList= createSortedList(listSize);
        BinarySearcher BS = new BinarySearcher();

        int recWonCount=0;

        for (int i = 0;i<timesToTry;i++){
            int indexToFind = rand.nextInt(0,listSize);
            if(wasRecursiveFaster(BS, sortedList,indexToFind)){
                recWonCount++;
            }
        }

        System.out.println("In "+timesToTry+" runs recursive was faster "+recWonCount+" times.");

    }

    private boolean wasRecursiveFaster(BinarySearcher BS, List<Integer> sortedList,int indexToFind){
        double t0, t1, t2,t3;

        t0 = System.nanoTime();
        int indexFound1 = BS.searchInList(sortedList, indexToFind);
        t1 = System.nanoTime();

        t2 = System.nanoTime();
        int indexFound2 = BS.searchInListRecursive(sortedList, indexToFind, 0, sortedList.size());
        t3 = System.nanoTime();

        return (t1-t0)>(t3-t2);
    }

    @Test
    public void testBinarySearcher(){
        List<Integer> sortedList= createSortedList(100);

        BinarySearcher BS = new BinarySearcher();

        int indexToFind = 68;

        int indexFound = BS.searchInList(sortedList, indexToFind);

        Assertions.assertEquals(indexToFind,indexFound);
    }
    @Test
    public void testBinarySearcherRecursive(){
        List<Integer> sortedList= createSortedList(100);

        BinarySearcher BS = new BinarySearcher();

        int indexToFind = 68;

        int indexFound = BS.searchInListRecursive(sortedList, indexToFind,0,sortedList.size());

        Assertions.assertEquals(indexToFind,indexFound);
    }

    private List<Integer> createSortedList(int size){
        List<Integer> sortedList = new ArrayList<>();

        for(int i=0; i<size;i++){
            sortedList.add(i);
        }
        return sortedList;
    }
}
