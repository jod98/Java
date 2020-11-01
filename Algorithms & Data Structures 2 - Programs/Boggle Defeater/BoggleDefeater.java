import java.util.*;

class BoggleDefeater {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the letters to use: ");
        //Allowing user to enter string of letters to find words from - scrabble
        String letters = scan.nextLine();

        //Reading in the dictionary words - words eligible to be made by letters
        FileIO reader = new FileIO();
        String[] dictionary = reader.load("dictionary.txt");

        /*
        Def: An array that has fixed size, but if we exceed its length, array can grow to 	accomodate for new word and if not filled up, array can shrink to ideal length
        	(no NULL elements)
        */
        List<String> array2 = new ArrayList<>(); //Builds empty array list

        /*
        Looping through the dictionary and checking if word from dictionary can be
        made from user inputted letters. If so add word to array list
        */
        for (String dictionaryWord : dictionary)
        {
            // canMake is specific to scrabble.
            if (canMake(dictionaryWord, letters))
            {
                array2.add(dictionaryWord); //Add to array
            }
        }
        /*
        Sorting array list to print both largest word with lowest alphabetical first char
        first i.e. length and lexigraphically
		        'badges' = 6 characters, 'cadges' = 6 characters
		        b > c, therfore 'badges' comes before 'cadges'
        */
        Collections.sort(array2, new Comparator<String>()
        {
            @Override //Means method is overriding parent class
            /*
            Comparing two strings by length and then lexigraphically (lowest in alphabet)
            */
            public int compare(String a, String b)
            {
                // Compare length, then lexigraphical.
                int lengthA = a.length();
                int lengthB = b.length();

				//Comparing length
                if (lengthA > lengthB)
                {
                    return -1;
                }
                if (lengthA < lengthB)
                {
                    return 1;
                }
                return a.compareTo(b); //Return lexigraphical arrangment
            }
        });

		//Looping through string array list and printing its contents (sorted)
		System.out.println("The words that can be made from these letters include: ");
        for (String word : array2)
        {
            System.out.println(word);
        }
    }

    /*
    Method that determines if characters entered can make a word from the dictionary
    */
    public static boolean canMake(String word, String availableLetters)
    {
      	//Example:
        // "see", "letters" -> true
        // "see", "tree" -> false
        // "see", "tres" -> false
		word = word.replaceAll("\\s+", ""); //Eridcates spaces in the dictionary
      	//Looping through charcters entered by user
        for (char c : word.toCharArray())
        {
            /*
            	This method (indexOf) returns the index within this string of the first occurrence of the specified character or -1, if the character does not occur.
            */
            // If c is not in availableLetters return false
            if (availableLetters.indexOf(""+c) == -1)
            {
                return false;
            }
             // Return true if canMake word using availableLetters.
            availableLetters = availableLetters.replaceFirst(""+c, "");
            // "free".replaceFirst("e", "") -> "fre"
        }
        return true;
    }
}


