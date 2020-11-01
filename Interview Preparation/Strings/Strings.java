// Initialising String Class
public class Strings {
    public static void main(String args[]) {

        // Char Array -> String
        char c[] ={'h','e','l','l','o'};                                            // OUTPUT: 'hello' - char array
        String s = new String("hello");                                      // OUTPUT: 'hello' - string
        String converted = new String(c);                                           // OUTPUT: 'hello' - char array -> string

        // Substring - .substring()
        String s1 = converted.substring(0);                                         // OUTPUT: 'hello'
        String s2 = converted.substring(1,3);                                       // OUTPUT: 'el'

        // String Comparison - .equals()
        System.out.println(s.equals(converted));                                    // OUTPUT: 'true' - both strings of same value

        // String Comparison - .compareTo() - converted to unicode value
        String s3 = "String method tutorial";
        String s4 = "compareTo method example";
        String s5 = "String method tutorial";

        int var1 = s3.compareTo(s4);                                           // OUTPUT: -16 (not the same)
        int var2 = s4.compareTo(s5);                                         // OUTPUT: 0 (the same)
        int var3 = s4.compareToIgnoreCase(s5);                                 // OUTPUT: -16 - ignoreCase() doesn't make difference

        // Prefix Comparison - .startsWith()
        String s6 = "Hello";
        s6.startsWith("He");                                                      // OUTPUT: 'true'

        // Index of First Character Occurrence - .indexOf()
        String s7 = "Java String JS";
        char ch1 = 'J';                                                              // OUTPUT: 0
        char ch2 = 'S';                                                             // OUTPUT: 5

        // Index of Last Character Occurrence - .lastIndexOf()
        String s8 = "Java String JS";
        char ch3 = 'J';                                                              // OUTPUT: 12
        char ch4 = 'S';                                                              // OUTPUT: 13

        // Replace Part of String - .replace()
        String s9 = new String("hello");
        System.out.println(s9.replace('o', 'p'));                   // OUTPUT: 'hellp'

        // Concatenate String -.concat()
        String s10="Beginners";
        s10= s10.concat("Book").concat(".").concat("com");                         // OUTPUT: 'BeginnersBook.com'

        // Empty Strings? -.isEmpty()
        String s11="";
        String s12="hello";

        System.out.println(s11.isEmpty());                                         // OUTPUT: 'true'
        System.out.println(s12.isEmpty());                                         // OUTPUT: 'false'

        // Upper and Lower Case - .toLowerCase()/ - .toUpperCase()
        String s13 = "HELLO";
        System.out.println(s13.toLowerCase());                                      // OUTPUT: 'hello'
        System.out.println(s13.toUpperCase());                                      // OUTPUT: 'HELLO'
    }
}
