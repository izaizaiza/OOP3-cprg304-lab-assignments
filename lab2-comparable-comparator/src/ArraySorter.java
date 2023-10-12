import java.util.ArrayList;

public class ArraySorter {
    /*
    * holds methods that sorts a given array
    * */



    //constructor
    public ArraySorter(){}


    //bubble sort
    public void bubbleSort(ArrayList<Integer> intArray){
        /*
        * bubble sort algorithm:
        * 1. Start at the beginning of the array.
        * 2. Compare the first two elements (currentIndex, currentIndex + 1):
        * If the first element is larger than the second, swap.
        * 3. move to the next pair of elements. repeat step 2.
        * 4. continue the process till the last element in the list is curIndex + 1
        * 5. after the first lap/round, the largest element would be at the end of the list (lapIndex is used to keep track of each lap)
        * 6. repeat previous steps but ignore the last element since it is the largest element
        * 7. for each iteration, leave the last element alone since it 'bubbled' to the end.
        * 8. sorting is done when a lap is finished but there was no swap that occurred. or
        * if the latest lap is comparing the first two again
        * */
        //print the array BEFORE sorting
        System.out.println("Array BEFORE bubble sort: " + intArray);
        boolean isSwapped; //use for when to break if in the current lap there no swapping occurred

        for (int lapIndex = 0; lapIndex < intArray.size() - 1; lapIndex++){
            isSwapped = false; // for ending the loop if no swap occurred

            for(int currentIndex = 0; currentIndex < intArray.size() - lapIndex - 1; currentIndex++){
                int currentValue = intArray.get(currentIndex);
                int nextValue = intArray.get(currentIndex + 1);
                int valueOnHold; // use as a temporary holder for the value to be re-indexed

                if (currentValue > nextValue){
                    // hold the current value to re-index
                    valueOnHold = currentValue;
                    // swap values and index
                    intArray.set(currentIndex, nextValue);
                    intArray.set(currentIndex + 1, valueOnHold);
                    isSwapped = true; // a swap occurred ==> set to true
                }
            }

            // if isSwapped stays false after the second loop, then no swap occurred during the lap ==> all elements are in ascending order
            if (!isSwapped){
                break;
            }
        }

        //print the array AFTER sorting
        System.out.println("Array AFTER bubble sort: " +intArray);

    } //end of bubbleSort method


    // selection sort method
    public void selectionSort(ArrayList<Integer> intArray){
        /*
        * selection sort algorithm:
        * 1. start with leastValueIndex = 0  being the index of the least element value.
        * 2. go through the array and find the least value element changing the  leastValueIndex
        * once the current value at the current index is less than the previously marked value
        * 3. after one lap, switch the values of the leastValueIndex and the startIndex.
        * 4. repeat the same process but this time the add 1 to the startIndex.
        * 5. Keep going and stop sorting once the startIndex is the size - 1
        * */

        //print the array BEFORE sorting
        System.out.println("Array BEFORE bubble sort: " + intArray);

        for (int startIndex=0; startIndex < intArray.size() - 1; startIndex++){
            int leastValueIndex = startIndex;
            for (int currentIndex= startIndex + 1; currentIndex < intArray.size(); currentIndex++){
                int leastValue = intArray.get(leastValueIndex);
                int currentValue = intArray.get(currentIndex);
                if (currentValue < leastValue){
                    leastValueIndex = currentIndex;
                }

            }
            // time to swap values at the start index and at the least index
            int valueOnHold = intArray.get(leastValueIndex);
            int startValue = intArray.get(startIndex);
            intArray.set(leastValueIndex, startValue);
            intArray.set(startIndex, valueOnHold);
        }

        //print the array AFTER sorting
        System.out.println("Array AFTER bubble sort: " +intArray);

    }


    // quick sort
    public void quickSort(ArrayList<Integer> intArray){
        /*
        * algorithm:
        * 1. choose the middle element or close to middle element to be the pivot element
        * 2. divide the array into two: one for elements less than the pivot and the other for elements
        * greater of the pivot element
        * 3.  keep doing it to the sub arrays until the entire original array is sorted
        * 4. divide and sort, divide and sort,...
        * 5.
        * */
    }

}// end of ArraySorter class
