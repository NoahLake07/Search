import datastructure.BinarySearchTree;
import search.BinarySearch;
import sort.IterativeSorting;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    // test variables
    public static int[] a = new int[]{
            1,3,5,7,9,13,45,124,246,578
    };
    public static int[] z = new int[]{
            1,2,6,15,31,56,92,141,205,286,386,507,651,820,1016,1241,1497,1786,2110,2471,2871,3312,3796,4325,4901,5526,6202,6931,7715,8556,9456,10417,11441,12530,13686,14911,16207,17576,19020,20541,22141,23822,25586,27435,29371,31396,33512,35721,38025,40426,42926,45527,48231,51040,53956,56981,60117,63366,66730,70211,73811,77532,81376,85345,89441,93666,98022,102511,107135,111896,116796,121837,127021,132350,137826,143451,149227,155156,161240,167481,173881,180442,187166,194055,201111,208336,215732,223301,231045,238966,247066,255347,263811,272460,281296,290321,299537,308946,318550,328351,338351,348552,358956,369565,380381,391406,402642,414091,425755,437636,449736,462057,474601,487370,500366,513591,527047,540736,554660,568821,583221,597862,612746,627875,643251,658876,674752,690881,707265,723906,740806,757967,775391,793080,811036,829261,847757,866526,885570,904891,924491,944372,964536,984985,1005721,1026746,1048062,1069671,1091575,1113776,1136276,1159077,1182181,1205590,1229306,1253331,1277667,1302316,1327280,1352561,1378161,1404082,1430326,1456895,1483791,1511016,1538572,1566461,1594685,1623246,1652146,1681387,1710971,1740900,1771176,1801801,1832777,1864106,1895790,1927831,1960231,1992992,2026116,2059605,2093461,2127686,2162282,2197251,2232595,2268316,2304416,2340897,2377761,2415010,2452646,2490671,2529087,2567896,};

    public static void testBinarySearch(){
        int target = 124;
        System.out.println("The value '"+target+"' is at index "+BinarySearch.iterativeBinarySearch(a,target) + " of the int array.");
    }

    public static void testRecursiveBinarySearch(){
        int target = 124;
        System.out.println("The value '"+target+"' is at index "+BinarySearch.recursiveBinarySearch(a,target) + " of the 'a' int array.");
    }

    public static void testRecursiveBinarySearch(int[] arr, int target){
        System.out.println("The value '"+target+"' is at index "+BinarySearch.recursiveBinarySearch(arr,target) + " of the 'z' int array.");
    }

    public static void printZIntArray(int amount){
        System.out.println("public static int[] z = new int[]{");
        ArrayList<Integer> x = new ArrayList<>();
        x.add(1);
        for (int i = 0; i < amount-2; i++) {
            x.add(x.get(i) + (i*i));
            System.out.print(x.get(i+1) + ",");
        }System.out.println("}");
    }

    public static void treeTest(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(5);
        tree.insert(1);
        tree.insert(10);

        System.out.println(tree.contains(10));
    }

    public static void sortTest(String type){
        int[] x = new int[]{
                56,1,67,2,6,2,57,8
        };

        printArr(x);
        System.out.println();

        int[] boohoogi;
        if(type.equals("selection")) {
            boohoogi = IterativeSorting.selectionSort(x);
        } else if (type.equals("bubble")){
            boohoogi = IterativeSorting.bubbleSort(x);
        } else if (type.equals("insertion")){
            boohoogi = IterativeSorting.selectionSort(x);
        } else {
            boohoogi = null;
        }

        printArr(boohoogi);
    }

    public static void printArr(int[] x){
        for (int i = 0; i < x.length-1; i++) {
            System.out.print(x[i] + " ");
        }
    }

    public static void main(String[] args) {
        new Main().sortTest("insertion");
    }

}
