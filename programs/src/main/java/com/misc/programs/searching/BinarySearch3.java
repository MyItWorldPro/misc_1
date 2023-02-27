package com.misc.programs.searching;

import java.util.Arrays;

public class BinarySearch3 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 10;
        int result = Arrays.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }

}
