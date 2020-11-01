import java.util.*;
public class Hashing
{
 public static void main (String[] args)
 {
	 Scanner myscanner = new Scanner(System.in);
	 System.out.println("Enter size of string array: ");
	 int items = myscanner.nextInt(); //Variable that determines size of string array
	 myscanner.nextLine(); //(UNSURE!!!)
	 String[] contents = new String[items]; //Creating a string array of size 'items'
	 System.out.println("Enter " + items + " strings: ");
	 //Iterating through the array and adding strings
	 for(int i=0;i<items;i++)
	 {
	 	contents[i]=myscanner.nextLine();
	 }
	 
	 HashTable mytable = new HashTable(); //Creating a new object (mytable) of type HashTable
	 Solution mysolution = new Solution(mytable); //Creating a new object (mysolution) of type Solution which passes in the HashTable
	 mysolution.fill(contents); //Filling the contents of mysolution object with string array contents
	 mysolution = new Solution(mytable); //(UNSURE!!!!)
	 //Iterating through the string array and swapping current string position with rand array position
	 for(int i=0;i<items;i++)
	 {
		 int rand = (int)(Math.random()*items); //Returns random int between 0 and times (i.e. 0 and 2); 
		 String temp = contents[i]; 
		 contents[i]=contents[rand];
		 contents[rand]=temp;
	 }
	 //Iterating through the string array to search for a particular string (word)
	 for(int i=0;i<items;i++)
	 {
		 int slot = mysolution.find(contents[i]); //slot = array positon of searched string
		 //If string not found in array position return error
		 if(!mytable.check(slot,contents[i]))
		 {
			System.out.println("\nerror!");
		 }
		}
		System.out.println("\nNumber of Collisions: " + mytable.gettotal()); //Printing the number of collisions
	 }
}

class HashTable
{
 public int size = 13; //Setting size of HashTable (no. of slots)
 private String[] hashTable; //Creating string called hashTable
 private int total=0; //Counter used to return number of collisions
 
 //Function that creates a string array of size 99991 and sets all slots = "";
 public HashTable()
 {
	 hashTable = new String[size];
	 for(int i=0;i<size;i++)
	 {
		hashTable[i]="";
	 }
 }
 //Function that checks for a particular string in the hashTable (PARTICULAR STRING OR JUST A STRING I.E. CHECK FOR FREE SLOT)
 public boolean check(int slot, String check)
 {
	 if(hashTable[slot].equals(check)) //If current string = string passed in, return true
	 {
		 return true;
	 }
	 else //Else, increment the number of collisions and return false
	 {
		 total++;
		 return false;
	 }
 }
	
 //Function that sets slot of hashTable = string
 public void set(int slot, String word)
 {
	 hashTable[slot]=word;
 }

 //Function that returns total number of collisions
 public int gettotal()
 {
 	return total;
 }
}

      
      
class Solution
{
 HashTable mytable = new HashTable(); //Creating a new HashTable object
 //Creating a function that ....................
 public Solution(HashTable input)
 {
	 mytable = input;
	 //this is the constructor
 }

//(USED FROM LAST WEEKS LAB)
//raises a number to a power with the given modulus
//when raising a number to a power, the number quickly becomes too large to handle
//you need to multiply numbers in such a way that the result is consistently moduloed to keep it in the range
//however you want the algorithm to work quickly - having a multiplication loop would result in an O(n) algorithm!
//the trick is to use recursion - keep breaking the problem down into smaller pieces and use the modMult method to join them back together     
 public static int modPow(int number, int power, int modulus)
 {
   if(power==0)
   {
     return 1;
	 }
   else if (power%2==0) 
   {
     int halfpower=modPow(number, power/2, modulus);
     return modMult(halfpower,halfpower,modulus);
   }
   else
   {
     int halfpower=modPow(number, power/2, modulus);
     int firstbit = modMult(halfpower,halfpower,modulus);
     return modMult(firstbit,number,modulus);
   }
}

//multiplies the first number by the second number with the given modulus
//a long can have a maximum of 19 digits. Therefore, if you're multiplying two ten digits numbers the usual way, things will go wrong
//you need to multiply numbers in such a way that the result is consistently moduloed to keep it in the range
//however you want the algorithm to work quickly - having an addition loop would result in an O(n) algorithm!
//the trick is to use recursion - keep breaking down the multiplication into smaller pieces and mod each of the pieces individually  
public static int modMult(int first, int second, int modulus)
{
  if(second==0)
  {
    return 0;
  }
  else if (second%2==0) 
  {
    int half=modMult(first, second/2, modulus);
    return (half+half)%modulus;
  }
  else
  {
    int half=modMult(first, second/2, modulus);
    return (half+half+first)%modulus;
  }
}
 
//Raising each character to successive powers of the alphabet size
//assume that the alphabet is ASCII characters - a total of 256 possibilities
//each successive character value should be raised to successive powers of 256
//the whole thing is added together and then moduloed to create a hash table index
    
 //Function to hash inputted word in array
 //Each character raised to successive powers of alphabet size in ascii (256 possbilities)
 //i.e. current_char * 256^(count)%mytable.size
 //value is then moduloed by table size to give us slot in table to insert word
 public int hashing(String word)
 {
   int hashVal = 0; //Variable to store value of Ascii of (c) * 256^(count) % size (table size)
   int counter = 0; //Variable to store power which is incremented after each iteration
   //Iterating through each letter in the word and store in character array
   for(char c1 : word.toCharArray()) 
   {
   	int i = (int) c1; //'i' stores Ascii value of current character in string word
   	hashVal = hashVal + i * modPow(256, counter, mytable.size); //'hash' stores 256^(count) % size (table size)
    counter++; //Increment count
   }
   hashVal = hashVal % mytable.size; //(Ascii of all characters in string * 258^(count) % size), mod slot by size to avoid going out of table size
   return hashVal; //Return slot in hashTable to insert word
 }
 
 ///Function to return jumpSize
 public int jumpSize(String word)
 {
 	int ascii = 0; //'i' stores Ascii value of all characters in string added together
 	//Iterating through string adding all ascii value of characters together
  for(char c2 : word.toCharArray()) 
  {
    ascii = ascii + (int) c2; //Adding all the (ascii) characters of string
  }
  return ascii % mytable.size; //Return Ascii value of string % size
  //return 15 - (ascii % 15);
 }
 
 //Function to find words in hashTable
 public int find(String word)
 {
	 	int slot = hashing(word); //'slot' = hashed value of word
	 	int jump = jumpSize(word); //'jump' = jumpSize of word
	 	//while slot in table != word or !=""
	 	while(!mytable.check(slot, word))
	 	{
	 		slot = slot + jump; //Add jumpSize to current slot
	 		slot = slot % mytable.size; //mod slot by size to avoid going out of table size
	 	}
     return slot; //Return slot in hashTable where word is found
 }
	 
 //Function to fill words into hashTable
 public void fill(String[] array)
 {
 	//Iterates through string array
	 for(int i=0; i<array.length; i++)
	 {
	 	int slot = hashing(array[i]); //'slot' = hash of current word
	 	int jump = jumpSize(array[i]); //'jump' = jumpSize of current word
	 	//while slot !=""
	 	while(!mytable.check(slot, ""))
	 	{
	 		slot = slot + jump; //add jumpSize to current slot
	 		slot = slot % mytable.size; //mod slot by size to avoid going out of table size
	 	}
	 	mytable.set(slot, array[i]); //Insert current word into "" slot in hashTable
	 }
 }
 
}