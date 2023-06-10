package ru.moondi.lib;

import java.io.IOException;
import java.util.Arrays;

import jdk.internal.org.jline.utils.Log;

public class Task1and2 {
    public static void main(final String[] args) {
      //  taskTest();
        task2Test();
    }
    //Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив. Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
    //Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    public static int[] task1(int[] arr) throws RuntimeException {
        if (arr.length == 0) { throw new NullPointerException(); }

        int lastIndexOf4 = -1;
        for (int i = 0; i < arr.length; i++) if (arr[i] == 4) lastIndexOf4 = i + 1;

        if (lastIndexOf4 == -1) throw new RuntimeException();
        else return Arrays.copyOfRange(arr, lastIndexOf4, arr.length);
    }

    public static void taskTest() {
        int task1test1[] = {4, 2, 3, 3, 5};
        int task1test2[] = {2, 3, 3, 4, 5, 2, 1, 3};
        int task1test3[] = {2, 3, 3, 1};
        int task1test4[] = {};
        try {
            System.out.println(Arrays.toString(task1(task1test1)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(Arrays.toString(task1(task1test2)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(Arrays.toString(task1(task1test3)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(Arrays.toString(task1(task1test4)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы, то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    public static boolean task2(int[] arr) {
        int count1 = 0, count4 = 0;
        for (int x : arr) {

            if (x == 1) count1++;
            else if (x == 4) count4++;
            else return false;
        }

        return (count1 > 0 && count4 > 0);
    }
    public static void task2Test() {
        int task1test1[] = {1, 1, 1, 4};
        int task1test2[] = {1, 1, 4, 4, 1, 1, 1, 1};
        int task1test3[] = {1,1, 1, 1};
        int task1test4[] = {};
        try {
            System.out.println(task2(task1test1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(task2(task1test2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(task2(task1test3));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(task2(task1test4));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}