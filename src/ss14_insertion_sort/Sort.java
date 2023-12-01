package ss14_insertion_sort;

import java.util.Arrays;

public class Sort {
    private static int[] bubbleSort(int[] array){
        int temp;
        for (int i = 0; i < array.length -1; i++){
            for (int j = array.length - 1; j > i; j--){
                if (array[j] < array[j-1]){
                    temp = array[j];
                    array[j] = array[j -1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }
    private static int[] selectionSort(int[] arr){
        int min;
        int temp;
        temp = 0;
        for (int i = 0; i< arr.length; i++){
            min = i;
            for (int j = i +1; j < arr.length; j++){
                if (arr[j] < arr[min]){
                    min = j; //ghi nhận vị trí phần tử nhỏ nhất cửa mảng.
                }
            }
            if (min != i){
                temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        return new int[]{temp};
    }
    private static int[] insertionSort(int[] array){
        int pos, x;
        for (int i = 1; i< array.length; i++){
            x = array[i];
            pos = i;
            while(pos > 0 && x < array[pos - 1]){
                array[pos] = array[pos -1];
                pos--;
            }
            array[pos] = x;
        }
        return array;
    }

    public static void main(String[] args) {

    }
}
