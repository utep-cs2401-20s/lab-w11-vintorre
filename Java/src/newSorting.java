public class newSorting {

    public void newSorting(int[] A, int size){

        if(A.length < 1) { //adding this just in case someone passes an empty array
            System.out.println("Array empty");
        }

        if(A.length <= size){
            quickSort(A, 0, A.length-1);
        }

        else {
            int mid = (A.length / 2);

            int[] LH = new int[mid];
            int[] RH = new int[A.length - mid];

            for (int i = 0; i < mid; i++) {
                LH[i] = A[i];
            }
            int j = 0;
            for (int i = mid; i < A.length; i++) {
                RH[j] = A[mid];
                j++;
            }

            newSorting(LH, size);
            newSorting(RH, size);

            mergeSortedHalves(A, LH, RH);
        }

    }

    public void quickSort(int[] A, int start, int stop){
        if(start < stop){ //runs until less and more aka start and stop overlap
            int splitID = split(A, start, stop); // finding where the split is
            quickSort(A,start, splitID-1); //this is from the left side up until the split
            quickSort(A, splitID+1, stop); //this is from the split to the rest of the right side
        }
    }

    public int split(int[] A, int start, int stop){ //this method is to go through the array to find where the array
                                                    // can be split by a less side and a more side accoding to the pivot
            int pivot = A[start]; //always set pivot at first index
            int more = stop; //more starts at end
            int less = start; //less starts at start

            while(less<more){
                while(less <= stop && A[less] <= pivot){ //while less is still not overlapping with more and is actually less than the pivot
                    less++;
                }

                while(more >= start && A[more] > pivot){ //while more is greater than less and actually more than the pivot
                    more--;
                }

                if(less<more){ //when the array gets stuck on less on the more side and more on the less side
                    int temp = A[start];
                    A[less] = A[more];
                    A[more] = temp;
                }
            }

            int temp = A[start]; //switching pivot with the last of the less index
            A[start] = A[more];
            A[more] = temp;

            return start; //returning new pivot
        }

        public void mergeSortedHalves(int[] a, int[] LH, int[] RH){
            int j = 0;//index for RH to start at
            int b = 0;// index for LH to start at
        for(int i = 0; i < a.length; i++){
                if(LH[b] > RH[j]){//if left half is greater than right half
                    a[i] = LH[b];
                    b++;
                }

                if(RH[j] > LH[b]){ //if right half is greater than left half
                    a[i] = RH[j];
                    j++;
                }

                if(RH[j] == LH[b]){ //if the two halves are equal at their respective index
                    a[i] = RH[j];
                    a[i++] = LH[b];
                    i++;
                    j++;
                    b++;
                }
            }

        }

}
