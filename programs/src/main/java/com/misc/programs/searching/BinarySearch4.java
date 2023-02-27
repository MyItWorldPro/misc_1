package com.misc.programs.searching;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch4 {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(2, 3, 4, 10, 40);
        int x = 10;
        int result = Collections.binarySearch(arr, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }

}
