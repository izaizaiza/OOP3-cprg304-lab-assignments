import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

public class BinarySearch {

    /*
     * binary search algorithm:
     * 0. assign lower bound index to be the first index
     * 1. assign upper bound index to be the last index
     * 2. assign median index to be the median index of the list.
     * 3. get value of the median index.
     * 4. if value of median index is lower that of the target index,
     * 5. assign the lower bound index to be the index 1 lower of the median else, assign to upper bound index to the index 1 greater
     * 6. repeat till list has been searched.
     *
     */

    int lowerIndex;
    int upperIndex;
    int medianIndex;


    //constructor
    public BinarySearch(){};


    public int binarySearch(ArrayList<Integer> intArray, int targetValue){
        lowerIndex = 0;
        upperIndex = intArray.size() - 1;

        while(lowerIndex <= upperIndex){
            // find out the median value of the integer
            medianIndex = lowerIndex + (upperIndex - lowerIndex)/2;
            //System.out.println("Currently at index: " + medianIndex);
            int medianVal = intArray.get(medianIndex);

            if(targetValue == medianVal){
                return medianIndex;

            }
            else if (targetValue > medianVal){
                lowerIndex = medianIndex + 1;

            }
            else{
                upperIndex = medianIndex - 1;

            }

        } //end of while loop

        // if target not found;
        return -1;


    }

}
