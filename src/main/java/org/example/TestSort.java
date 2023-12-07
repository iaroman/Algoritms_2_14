package org.example;

import java.util.Arrays;

public class TestSort {

    public static void main(String[] args) {
        Integer[] array = new Integer[100_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int)(Math.random() * 310) - 150);
        }
        Integer[] array2 = Arrays.copyOf(array, array.length);
        Integer[] array3 = Arrays.copyOf(array, array.length);

        TestSort testSort = new TestSort();

        long start = System.currentTimeMillis();
        testSort.bubbleSort(array);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        testSort.sortedSelection(array2);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        testSort.sortInsertion(array3);
        System.out.println(System.currentTimeMillis() - start);
        /*
        Result time test:
        1 - bubbleSort
        2 - sortedSelection
        3 - sortInsertion
        test 1
        72553
        8679
        25330

        test 2
        64084
        7602
        23838

        test 3
        65363
        7605
        23864
        */
    }
    public void bubbleSort(Integer[] arr) {;
        boolean sort = false;
        int temp;
        while (!sort) {
            sort = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i+1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sort = false;
                }
            }
        }
//        return arr;
    }

    public void sortedSelection(Integer[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minElementIndex];
            arr[minElementIndex] = temp;
        }
//        return arr;
    }
    public void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
//        return arr;
    }
}
