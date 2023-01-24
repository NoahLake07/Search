package sort;

public class IterativeSorting {

    public static int[] selectionSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            // store the smallest thing
            int minIndex = i;

            for (int j = i+1; j < arr.length; j++) {
                // if we find a new smaller thing, update the smallest thing
                if(arr[j] < arr[minIndex]){ minIndex = j; }

            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static int[] bubbleSort1(int[] arr){
        for (int e = 0; e < arr.length-1; e++) {
            for (int i = 0; i < arr.length-i-1; i++) {
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }

        return arr;
    }

    public static int[] bubbleSort(int[] arr){
        int n = arr.length;
        boolean madeSwap;
        for (int i = 0; i < n-1; i++) {
            madeSwap = false;
            for (int j = 0; j < (n-i-1); j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    madeSwap = true;
                }
            }
            if(!madeSwap){
                break;
            }
        }

        return arr;
    }

    public static int[] insertionSort(int[] arr){
        for (int i = 1; i < arr.length-1; i++) {
            int key = arr[i];
            int j = i-1;

            while (j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }

}
