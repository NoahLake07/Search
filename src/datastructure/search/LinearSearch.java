package datastructure.search;

public class LinearSearch<T> {

    /**
     * Searches a string array and returns the index of the target found
     * @param data
     * @param target
     * @return the index of target found
     */
    public int search(T[] data, T target){
        for (int i = 0; i < data.length-1; i++) {
            if(data[i].equals(target)){
                System.out.println("\t * FOUND '" + target + "' AT INDEX " + i);
                return i;
            }
        }
        System.out.println("\t > TARGET NOT FOUND!");
        return -1;
    }

    /**
     * Searches a double array and returns the index of the target found
     * @param data
     * @param target
     * @return the index of target found
     */
    public int search(double[] data, double target){
        for (int i = 0; i < data.length-1; i++) {
            if(data[i] == target){
                System.out.println("\t * FOUND '" + target + "' AT INDEX " + i+1);
                return i+1;
            }
        }
        System.out.println("\t > TARGET NOT FOUND!");
        return -1;
    }

    public static void testSearch(){
        LinearSearch x = new LinearSearch();

        String[] studentNames = {"Alice", "Bob", "Charlie", "David", "Eve"};
        String target = "Charlie";
        System.out.println(x.search(studentNames, target));

        double[] sheepWeights = {100.0, 105.5, 110.0, 115.0, 120.5};
        double target2 = 111.0;
        System.out.println(x.search(sheepWeights, target2));

        String[] DNA = {"ATCG", "GTAC", "CGAT", "TCGA"};
        String target3 = "CGAT";
        System.out.println(x.search(DNA,target3));

        String[] callNumbers = {"A123", "B456", "C789", "D012", "E345"};
        String target4 = "C789";
        System.out.println(x.search(callNumbers,target4));

        String[] serialNumbers = {"123A", "456B", "789C", "012D", "345E"};
        String target5 = "012D";
        System.out.println(x.search(serialNumbers,target5));
    }

}
