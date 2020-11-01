import java.util.Scanner;

public class Huffman
{
    public static void main(String [] args)
    {
        //User Input
        System.out.print("Enter your sentence : ");
        Scanner scan = new Scanner(System.in);
        String sentence = scan.nextLine();
        scan.close(); //Input source closed, no user input after program runs

        int[] freqsOfChar = new int[256]; //Declaring array of 256 (256 characters in ASCII table)

        System.out.println(" ");

	    //Loop through each character in sentence
        for (int i = 0; i < sentence.length(); i++)
        {
            char letter = sentence.charAt(i); //letter set to current character in sentence
            int value = (int)letter; //Casting value of letter to a float

            //Printing out the binary equivalent of the integer (value)
            //If it has less than 7 characters add an extra 0 at front (output requires leading 0's for binary numbers != 7 characters)
            if(Integer.toBinaryString(value).length() != 7)
            {
            	System.out.print("0" + Integer.toBinaryString(value) + " ");
            }
             else
            {
            	System.out.print(Integer.toBinaryString(value) + " ");
            }
            	freqsOfChar[value]++; //Increments that value in the array to show no. of times it appeared
        }
        System.out.println("\n");

	    //Loop through array of ASCII values that were incremented before and print out how many times they appear in the sentence
        for (int i = 0; i < freqsOfChar.length; i++)
        {
        	//If character appeared more than once print "times" else print "time"
            if (freqsOfChar[i] > 1 )
            {
            	//Cast the binary converted integer value of e.g. T - 101001010 back to T and print
                System.out.println("'" + (char)i + "'"  + " appeared " + freqsOfChar[i] + " times");
            }
            if (freqsOfChar[i] == 1)
            {
            	System.out.println("'" + (char)i + "'"  + " appeared " + freqsOfChar[i] + " time");
            }
        }
    }
}