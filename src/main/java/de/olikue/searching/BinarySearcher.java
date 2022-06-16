package de.olikue.searching;

import java.util.List;

public class BinarySearcher extends Searcher {
    @Override
    public int searchInList(List<Integer> input, int toFind) {
        int lo = 0;
        int hi = input.size();

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            int valOnMid = input.get(mid);
            if (valOnMid == toFind) {
                return mid;
            }
            if (valOnMid > toFind) {
                hi = mid-1;
            }
            if (valOnMid < toFind) {
                lo = mid+1;
            }

        }
        return -1;
    }

    public int searchInListRecursive(List<Integer> input, int toFind, int lo, int hi) {

        if (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int valOnMid = input.get(mid);
            if (valOnMid == toFind) {
                return mid;
            }
            if (valOnMid > toFind) {
                return searchInListRecursive(input,toFind,lo, mid-1);
            }
            if (valOnMid < toFind) {
                return searchInListRecursive(input,toFind,mid+1, hi);
            }

        }
        return -1;
    }

}
