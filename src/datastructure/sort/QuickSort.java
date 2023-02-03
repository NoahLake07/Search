package datastructure.sort;

public class QuickSort {

    public static void quickSort(int[] arr, int min, int high) {
        if (min < high) {
            int pi = partition(arr, min, high);
            quickSort(arr, min, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swapValues(arr, i, j);
            }
        }
        swapValues(arr, i + 1, high);
        return (i + 1);
    }

    private static void swapValues(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArr(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void test(){
        int[] arr = { 2973,192375,12938,23,12938,9,6,3,2,1 };
        int lengthOfArr = arr.length;
        quickSort(arr, 0, lengthOfArr - 1);
        printArr(arr);
    }

    public static void main(String[] args) {
        QuickSort.test();
    }
}

