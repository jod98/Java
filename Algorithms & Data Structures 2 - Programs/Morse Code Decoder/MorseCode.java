import java.util.*;
import javax.sound.sampled.*; //Importing sample sound

public class MorseCode
{
	public static void main(String args [])
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a sentence: ");
		String input = scan.nextLine(); //User input string to convert to Morse Code
		input = input.toUpperCase(); //Morse Code consists of only Upper Case and Numbers
		
		System.out.println("\nString converted to Morse Code");
		String strMorse = convertToMorse(input); //Convert String to Morse
		
		System.out.print("\nPlaying sentence in Morse Code!");
		playMorseTone(strMorse); //Play Morse Converted String Tone
	}
	
	//Method that converts each user inputted character to its corresponding Morse Code symbols
	public static String convertToMorse(String input)
	{
			//Creating a string array to store values of Morse code symbols that correspond to letters a-z and numbers 0-9
			String MorseCode[] = 
		{
		  "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", //(0-9)
			".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", //A-M
			"-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." //N-Z
		};
		
		String strMorse = ""; //Creating a new string that will contain inputted sentence converted to Morse
		
		//Iterating through each character of the sentence and adding its Morse equivalent to strMorse
		for(int i=0; i<input.length(); i++)
		{
			if(input.charAt(i) >= '0' && input.charAt(i) <= '9')
			{
				strMorse+= MorseCode[input.charAt(i) - 48]; //If '1' ('1' = 49), 49 - 48 = 1. We add 1st position in array to string i.e. Morse equivalent of '1'
			}
			else if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')
			{
				strMorse+= MorseCode[input.charAt(i) - 55]; //If 'B' ('B' = 66), 66 - 55 = 11. We add 11th position in array to string i.e. Morse equivalent for 'B'
			}
			else if(input.charAt(i) == ' ') //If ' ' (space), we add it to the string
			{
				strMorse+= " ";
			}
			else
			{
				System.out.println("Not A Valid String!");
			}
		}
		return strMorse; //Returning Morse converted sentence
	}
	
	//Method that plays the tone with input parameters (frequency, time(MS) and volume)
	public static void play(int frequency, int timeMS, double volume)
	{
		try
		{
			tone(frequency, timeMS, volume);
		}
		catch(LineUnavailableException e) {}
	}
	
	//Method that assigns dot, dash and space to sounds
	public static void playMorseTone(String strMorse)
	{
		int maxFrequency = 800; 
		int minFrequency = 0;
		int maxVolume = 100;
		int minVolume = 0;

		//Length of time each symbol played for i.e. dot = 90ms
		int dot = 90; 
		int dash = 3*dot;
		int spaceWords = 7*dot;
		
		//Iterating through the converted Morse string and playing the Morse symbols
		System.out.print("\nMorse Code Symbols: ");
		for(int i=0; i<strMorse.length(); i++)
		{
			if(strMorse.charAt(i) == '.')
			{
				System.out.print(".");
				play(maxFrequency, dot, maxVolume);
			}
			else if(strMorse.charAt(i) == '-')
			{
				System.out.print("-");
				play(maxFrequency, dash, maxVolume);
			}
			else //It is a space
			{
				System.out.print(" ");
				play(minFrequency, spaceWords, minVolume);
			}
		}
	}
	
	public static void tone(int hz, int msecs, double vol) throws LineUnavailableException
	{
		float SAMPLE_RATE = 8000f;
		byte[] buf = new byte[1];
		AudioFormat af = new AudioFormat(SAMPLE_RATE,8,1,true,false);
		SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
		sdl.open(af);
		sdl.start();
		for (int i=0; i < msecs*8; i++) 
		{
			double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
			buf[0] = (byte)(Math.sin(angle) * 127.0 * vol);
			sdl.write(buf,0,1);
		}
		sdl.drain();
		sdl.stop();
		sdl.close();
	}
}