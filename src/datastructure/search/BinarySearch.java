package datastructure.search;

public class BinarySearch {

    /**
     * Performs a binary datastructure.search on an int[] and searches for a given int target. The method returns
     * the index the target is at, but if the target is not found, the method will return '-1'.
     * @param arr int array to datastructure.search
     * @param target int target to datastructure.search for
     * @return the index the target is at in the given int array (arr)
     */
    public static int iterativeBinarySearch(int[] arr, int target){
        // instantiate split pointer values
        int leftPointer = 0;
        int rightPointer = arr.length-1;

        // while the pointers are not crossed, keep searching
        while(leftPointer <= rightPointer) {
            // find the middle index
            int mid = (leftPointer + leftPointer)/2;

            // check if the middle value matches target
            if(arr[mid] == target){
                return mid;
            }

            // move the pointers
            if(arr[mid] > target){
                // left half
                rightPointer = mid - 1;
            }
            if(arr[mid] < target){
                // right half
                leftPointer = mid + 1;
            }

        }
        // if this statement is reached, the target data was not found.
        return -1;
    }

    /**
     * A recursive method that finds the target value of an int array
     * @param arr
     * @param target
     * @param left
     * @param right
     * @return the index the target is at, or the recursive method with new bounds
     */
    public static int recursiveBinarySearch(int[] arr, int target, int left, int right){
        // find the middle index
        int mid = (left + left)/2;

        // base cases
        if(left >= right){
            return -1;
        }
        if(arr[mid] == target){
            return mid;
        }

        // move the pointers
        if(arr[mid] > target){
            // left half
            return recursiveBinarySearch(arr, target, mid, right - 1);
        }
        if(arr[mid] < target){
            // right half
            return recursiveBinarySearch(arr, target, mid + 1, right);
        }

        // if this statement is reached, then the target data was not found.
        return -1;
    }
    public static int recursiveBinarySearch(int[] arr, int target){
        return recursiveBinarySearch(arr, target, arr[0], arr.length-1);
    }


}
