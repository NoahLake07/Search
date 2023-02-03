package optimizations;

public class MedicalDataOptimizations {

    public class DataManager {

        private MedicalRecord[] records;
        private int top = 0;

        /**
         * Creates a new Medical Record array pre-populated with 40 slots
         */
        public DataManager(){
            records = new MedicalRecord[40];
        }

        /**
         * Add a record to the medical data
         * @param mr Medical Record to add to the next available slot
         */
        public void addRecord(MedicalRecord mr){

            // check to see if the record slots are full
            if(top>=records.length){
                try {
                    throw new Exception("Medical Records Full. Cannot add new medical record.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                // add a record to the next unpopulated slot of the array
                records[++top] = mr;
            }
        }

        /**
         * Removes a record from the populated slots of the Medical Data. When found, the data
         * will be removed and the rest of the array will slide one index down to fill gaps.
         * @param mr Targeted medical record to be removed
         */
        public void removeRecord(MedicalRecord mr){

            // scan through populated areas
            for (int i = 0; i < top; i++) {

                if(mr.equals(records[i])){
                    // found target to remove
                    for (int j = i; j < top-j; j++) {
                        records[j] = records[j+1];
                    }
                    // narrow down the populated area tracker variable
                    top--;
                }
            }

        }

        /**
         * Scans through the records to find a match of the last and first name. This will not check for ID similarity.
         * If duplicates are found, the scan could be interrupted.
         * @param lastName last name of patient
         * @param firstName first name of patient
         * @return the index in which the first and last name were found, or -1 if it was not found
         */
        private int getRecordIndex(String lastName, String firstName){
            for (int i = 0; i < top; i++) {
                if(records[i].getfName().equals(firstName) && records[i].getlName().equals(lastName)){
                    return i;
                }
            }

            return -1;
        }

        /**
         * Scans through all medical records to find an exact match to the medical record specified.
         * @param mr Targeted Medical Record
         * @return the index in which the medical record was found, or -1 if it was not found
         */
        private int getRecordIndex(MedicalRecord mr){
            for (int i = 0; i < top; i++) {
                if(records[i].equals(mr)){
                    return i;
                }
            }
            return -1;
        }

        /**
         * Sorts through all records using a linear sort, modifying only the known populated areas of the array.
         */
        public void sortRecordsIteratively(){

            for (int i = 0; i < top; i++) {

                int minIndex = i;

                for (int j = 1; j < top; j++) {

                    if(records[j].getId() < records[i].getId()){
                        minIndex = j;
                    }

                }

                MedicalRecord temp = records[minIndex];
                records[minIndex] = records[i];
                records[i] = temp;
            }
        }

        /**
         * Sorts all populated records using the Heap Sorting Algorithm, only sorting the known populated areas of the array.
         */
        public void sortRecordsHeap(){
            MedicalHeapSort sorter = new MedicalHeapSort(records,top);
            sorter.sort();
            records = sorter.getArray();
        }

    }

    public class MedicalHeapSort {

        private MedicalRecord[] medicalRecords;
        private int max = -1;

        public MedicalHeapSort(MedicalRecord[] arr, int top){
            medicalRecords = arr;
            max = top;
        }

        private void heapify(MedicalRecord arr[], int N, int i) {
            int largest = i;
            int l = 2 * i + 1;
            int r = 2 * i + 2;

            if (l < N && arr[l].id > arr[largest].id) {
                largest = l;
            }

            if (r < N && arr[r].id > arr[largest].id) {
                largest = r;
            }

            if (largest != i) {
                MedicalRecord swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;

                heapify(arr, N, largest);
            }
        }

        public void sort() {
            int N = max;

            for (int i = N / 2 - 1; i >= 0; i--)
                heapify(medicalRecords, N, i);

            for (int i = N - 1; i > 0; i--) {
                // swap values
                MedicalRecord temp = medicalRecords[0];
                medicalRecords[0] = medicalRecords[i];
                medicalRecords[i] = temp;

                heapify(medicalRecords, i, 0);
            }
        }

        public MedicalRecord[] getArray(){
            return medicalRecords;
        }

    }

    public class MedicalRecord {

        private int id;
        private String fName;
        private String lName;

        public MedicalRecord(int id, String fName, String lName){
            this.id = id;
            this.fName = fName;
            this.lName = lName;
        }

        public int getId(){
            return id;
        }

        public String getfName(){
            return fName;
        }

        public String getlName(){
            return lName;
        }

        @Override
        public boolean equals(Object obj) {

            if(obj instanceof MedicalRecord){
                return this.id == ((MedicalRecord) obj).getId();
            }

            return false;
        }

        @Override
        public String toString(){
            return "Record: " +
                    "\n\t ID: " + id +
                    "\n\t First Name: " + fName +
                    "\n\t Last Name: " + lName;
        }
    }

}
