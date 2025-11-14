package task;

import java.util.Arrays;
import java.util.StringJoiner;

//now i think each task just override the execute function


public class TaskBubbleSort extends TaskImpl {

    @Override
    public void execute() {
        //we convert string to string array
        //this tells us the input is of the form 1,2,3,4
        String[] stringArray = input.split(",");
        //convert each item to int
        int[] intArray = Arrays.stream(stringArray).mapToInt(s -> Integer.valueOf(s)).toArray();
        // sort the array
        sort(intArray);
        //result is  a string of "1,2,3,4"
        result = printArray(intArray);
    }


//doing the actual sorting dont care
    private void sort(int array[]) {

        int n = array.length;
        int temp = 0;

        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(array[j-1] > array[j]){
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
//just printing an array
    private String printArray(int[] array) {
        StringJoiner stringJoiner = new StringJoiner(",", "[","]");
        Arrays.stream(array).forEach(item -> stringJoiner.add(String.valueOf(item)));
        return stringJoiner.toString();
    }
}
