// Initialising Array Class
public class Array {

    // Initialising 1D String Array and Print
    public static void String1DArrayPrint() {
        String array1D[] = {"Volvo", "Fiat", "Ford", "Mazda"};             // initialising 'cars' string array
        array1D[0] = "Opel";                                               // setting 1st element to 'Opel'

        for (int i=0; i<array1D.length; i++) {                             // iterating over 'cars' array
            System.out.print(array1D[i] + "\t");                           // printing out 'cars' elements
        }
    }

    // Initialise 2 x 1D Arrays and Concatenate Them
    public static int[] ConcatenateArrays() {
        int array1[] = {1,2,3};                                         // creating array1
        int array2[] = {4,5,6};                                         // creating array2

        int resultArray[] = new int[array1.length + array2.length];     // creating resultArray (array1 + array2)
        int pos = 0;                                                    // iterator

        for (int element : array1) {                                    // iterate over array1
            resultArray[pos] = element;                                 // set resultArray = array1 elements
            pos++;                                                      // update iterator to next position
        }

        for (int element : array2) {                                    // iterate over array2
            resultArray[pos] = element;                                 // set resultArray = array2 elements
            pos ++;                                                     // update iterator to next position
        }
        return resultArray;                                             // return resultArray to main method
    }

    // Swapping resultArray Elements (2nd and 4th element)
    public static void SwapArrayElements(int[] resultArray) {
        int i = 1, j = 3;                                               // setting 'i' and 'j' values

        int temp = resultArray[i];                                      // 'temp' = 'i'th element
        resultArray[i] = resultArray[j];                                // resultArray[i] = 'j'th element
        resultArray[j] = temp;                                          // resultArray[j] = 'temp'

        for (int n=0; n<resultArray.length; n++) {
            System.out.print(resultArray[n] + "\t");                    // printing concatenated array with swapped elements
        }

    }

    // Initialising 2D Int Array and Print
    public static void Int2DArrayPrint() {
        int array2D[][] = { {1, 2, 3, 4}, {5, 6, 7}};                   // initialising 'array2D' string array
        int x = array2D[1][2];                                          // 'x' = 2nd row, 3rd column
        System.out.println(x);                                          // OUTPUT: 7 (check output)

        for (int i=0; i<array2D.length; i++) {                          // iterating through rows
            for (int j=0; j<array2D[i].length; j++) {                   // iterating through columns
                System.out.print(array2D[i][j] + "\t");                 // printing elements
            }
            System.out.println();                                       // helps visualise table in output
        }
    }

    public static void main(String args[]) {
        String1DArrayPrint();                                         // printing 1D String Array

        int resultArray[] = ConcatenateArrays();                      // getting return value (array) from 'ConcatenateArrays'
        for (int i=0; i<resultArray.length; i++) {
            System.out.print(resultArray[i] + "\t");                  // printing concatenated array (array1 + array2)
        }

        SwapArrayElements(resultArray);                               // printing concatenated array with swapped elements

        Int2DArrayPrint();                                            // printing 2D Int Array
    }
}
