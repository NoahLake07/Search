package search.practice;

import search.practice.Ingredient;

public class BinaryPractice {

    // QUESTION 1: Grade Search
    public static int gradeSearch(){
        int[] grades = {60, 70, 75, 80, 85, 90, 95};
        int target = 80;

        // instantiate split pointer values
        int leftPointer = 0;
        int rightPointer = grades.length-1;

        // while the pointers are not crossed, keep searching
        while(leftPointer <= rightPointer) {
            // find the middle index
            int mid = (leftPointer + leftPointer)/2;

            // check if the middle value matches target
            if(grades[mid] == target){
                return mid;
            }

            // move the pointers
            if(grades[mid] > target){
                // left half
                rightPointer = mid - 1;
            }
            if(grades[mid] < target){
                // right half
                leftPointer = mid + 1;
            }

        }
        return -1;
    }

    // QUESTION 2: First occurrence of the atomic weight
    public static int atomicSearch(){
        double[] atomicWeights = {1.0079, 4.0026, 6.941, 6.941, 9.0122, 10.811, 12.0107, 12.0107, 14.0067};
        double target = 12.0107;

        // instantiate split pointer values
        int leftPointer = 0;
        int rightPointer = atomicWeights.length-1;

        // while the pointers are not crossed, keep searching
        while(leftPointer <= rightPointer) {
            // find the middle index
            int mid = (leftPointer + leftPointer)/2;

            // check for correct
            if(atomicWeights[mid] == target){
                return mid;
            }

            if(atomicWeights[mid] > target){
                // left
                rightPointer = mid - 1;
            }
            if(atomicWeights[mid] < target){
                // right
                leftPointer = mid + 1;
            }

        }
        return -1;
    }

    // QUESTION 3: Last occurrence of years
    public static int yearSearch(){
        short[] years = {1492, 1776, 1803, 1861, 1861, 1861, 1945};
        short target = 1861;

        // pointers
        int left = 0;
        int right = years.length-1;

        // while there is still data to search, keep searching
        while (left <= right){
            int mid = left+left/2;
            if(years[mid] == target){

                int i = mid;
                while(years[i++] == target){}
                return i-2;

            }

            if (years[mid] > target){
                right = mid-1;
            }
            if (years[mid] < target){
                left = mid+1;
            }
        }
        return -1;
    }

    // QUESTION 4: name occurrences
    public static int searchNameDuplicates(){
        String[] patientNames = {"Brown", "Johnson", "Johnson", "Johnson", "Johnson", "Jones", "Smith", "Williams"};
        String target = "Johnson";

        int left = 0;
        int right = patientNames.length-1;

        while (left<=right){
            // find middle
            int mid = left + right/2;

            if(patientNames[mid].equals(target)){
                // found the target
                int i = mid;
                int duplicates = 0;

                // count the occurrences before mid
                while(patientNames[i].equals(target)){
                    duplicates++;
                    i--;
                }

                // count the occurrences after mid
                i = mid+1;
                while(patientNames[i].equals(target)){
                    duplicates++;
                    i++;
                }

                // return the amount of duplicates counted
                return duplicates;
            }

            // move the pointers
            if(patientNames[mid].compareTo(target) > 0){
                // left
                right = mid-1;
            }
            if(patientNames[mid].compareTo(target) < 0){
                // right
                left = mid+1;
            }
        }

        return -1;
    }

    // QUESTION 5: ingredient search
    public static int searchIngredients(){
        Ingredient[] ingredients = {new Ingredient("cinnamon", 12.25f),
                new Ingredient("flour", 400.50f), new Ingredient("pepper", 10.56f),
                new Ingredient("salt", 40.78f), new Ingredient("salt", 50), new Ingredient("sugar")};
        Ingredient target = new Ingredient("pepper");

        // ! perform binary search

        return -1;
    }

    public static void main(String[] args) {
        println("1.\t"+gradeSearch());
        println("2.\t"+atomicSearch());
        println("3.\t"+yearSearch());
        println("4.\t"+searchNameDuplicates());
        println("5.\t"+searchIngredients());
    }

    public static void println(Object o){
        System.out.println(o);
    }

}
