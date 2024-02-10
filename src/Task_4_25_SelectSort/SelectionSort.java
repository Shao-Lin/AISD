package Task_4_25_SelectSort;

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите элементы массива ");
        String line = scanner.nextLine();
        String[] lineArray = line.split(" ");
        int[] numbers = new int[lineArray.length];
        for (int i = 0; i < lineArray.length; i++) {
            numbers[i] = Integer.parseInt(lineArray[i]);
        }
        System.out.println("Введите индекс первого элемента диапазона");
        int from = scanner.nextInt();
        System.out.println("Введите индекс элемента, следующего за последним элементом диапазона");
        int to = scanner.nextInt();
        sort(numbers,from,to);
        for(int value = from; value < to; value++) {
            System.out.print(numbers[value] + " ");
        }

    }
    public static <T extends Comparable<T>> void sort(int[] arr, int from, int to){
        int minEl = arr[from];
        int leftValue = from;
        int index = 0;
        for (int i = from; i < to; i++) {
            for (int j = leftValue; j < to; j++) {
                if (minEl >= arr[j]) {
                    minEl = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[leftValue];
            arr[leftValue] = minEl;
            leftValue++;
            minEl = arr[leftValue];
        }
    }
}