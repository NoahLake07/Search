package datastructure.sort;

public class RecursiveSorting {

    /// region Merge

    public static int[] mergeSort(int[] arr, int l, int r){

        if(l<r){
            int mid = (l+r)/2;

            mergeSort(arr,l,mid);
            mergeSort(arr, mid+1, r);

            merge(arr, l, mid, r);
        }
        return arr;
    }

    private static void merge(int[] mainarr, int l, int mid, int r){
        // find the sizes of two sub arrays that are to be merged
        int n1 = mid-l+1; // length of left
        int n2 = r - mid; // length of right

        // create two temporary arrays, one for the left sub array and one for the right
        int[] leftSub = new int[n1];
        int[] rightSub = new int[n2];

        // copy data from main array to the sub arrays
        for (int i = 0; i < n1; i++) {
            leftSub[i] = mainarr[l+i];
        }

        for (int i = 0; i < n2; i++) {
            rightSub[i] = mainarr[mid+1+i];
        }

        // get the initial indices of the first and second sub arrays
        int i = 0; // left ptr
        int j = 0; // right ptr

        // initial index of the merged array
        int k = l;

        // datastructure.sort
        while(i<n1 && j<n2){
            // copy the smaller value into the main array
            if(leftSub[i] <= rightSub[j]){
                mainarr[k] = leftSub[i];
                i++;
            } else {
                mainarr[k] = rightSub[j];
                j++;
            }

        }

        // copy and extra data directly into the array (it does not get sorted)
        while(i<n1){
            mainarr[k] = leftSub[i];
            i++;
            j++;
        }

        while(j<n2){
            mainarr[k] = rightSub[j];
            j++;
            i++;
        }

    }

    /// endregion

}
