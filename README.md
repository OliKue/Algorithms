# Algorithms

Collection of different algorithms. 

## Sorting algorithms

Different sorters extending the abstract sorterclass.

``` java
public abstract class Sorter {
    public abstract List<Integer> sortIntegerList(List<Integer> integerList);
```

### Complexity

| Name |  Best | Wost | Average |
|---|---|---|---|
| SelectionSorter | O(n^2) | O(n^2) | O(n^2)|
| BubbleSorter | O(n) | O(n^2) | O(n^2)|
| CountingSorter | O(n+k) | O(n+k) | O(n+k)|
| InsertionSorter | O(n) | O(n^2) | O(n^2)|
| MergeSorter | O(n*log n) | O(n*log n) | O(n*log n)|
| QuickSorter | O(n*log n) | O(n^2) | O(n*log n)|

n is the count of elements in the input

k is the higest element

## Searching algorithm(s)

Implemented recursive and iterative binary search. 
