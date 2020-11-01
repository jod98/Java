import java.util.*;

public class PublicKeyCryptography
{
    public static void main (String args[]){
    
        // Alice's public key (24852977, 2744, 8414508)
		//long p = 24852977L;
		//long g = 2744L; //Starting point
		//long gx_modp = 8414508L; //Modulus value we reach to attain private key to decrypt message code 
		Scanner scan = new Scanner(System.in);
		long p = scan.nextLong();
		long g = scan.nextLong();
		long gx_modp = scan.nextLong();

		long current = g; //Current stores value of g
		long privateKey = 0; //Variable to store private key

		//Iterates from 2 to value of p to attain secret key value
		for(int x = 2; x < p; x++)
		{
			//Performing operation of 2744^(x) % 24852977, trying to reach modulus answer gx_modp (8414508L)
			current *= g; //Multiplying current by g
			current %= p; //Modulating current by p

			if(current == gx_modp) //If (current == 8414508)
			{
				privateKey = x; //Set private key = secret key = x
				break; //Break because there are multiple secret keys but we want key with least number of digits
			}
		}

		//ciphers  (15268076, 743675)
		//long c1 = 15268076L;
		//long c2 = 743675L;
		long c1 = scan.nextLong();
		long c2 = scan.nextLong();

		long messageCode = modPow(c1, p-1-privateKey, p);
		messageCode = modMult(messageCode, c2, p);
		System.out.println(messageCode);
}
    
    public static long modPow(long number, long power, long modulus){
//raises a number to a power with the given modulus
//when raising a number to a power, the number quickly becomes too large to handle
//you need to multiply numbers in such a way that the result is consistently moduloed to keep it in the range
//however you want the algorithm to work quickly - having a multiplication loop would result in an O(n) algorithm!
//the trick is to use recursion - keep breaking the problem down into smaller pieces and use the modMult method to join them back together
        if(power==0)
            return 1;
        else if (power%2==0) {
            long halfpower=modPow(number, power/2, modulus);
        return modMult(halfpower,halfpower,modulus);
        }else{
            long halfpower=modPow(number, power/2, modulus);
            long firstbit = modMult(halfpower,halfpower,modulus);
            return modMult(firstbit,number,modulus);
        }
    }
    
    public static long modMult(long first, long second, long modulus){
//multiplies the first number by the second number with the given modulus
//a long can have a maximum of 19 digits. Therefore, if you're multiplying two ten digits numbers the usual way, things will go wrong
//you need to multiply numbers in such a way that the result is consistently moduloed to keep it in the range
//however you want the algorithm to work quickly - having an addition loop would result in an O(n) algorithm!
//the trick is to use recursion - keep breaking down the multiplication into smaller pieces and mod each of the pieces individually
        if(second==0)
            return 0;
        else if (second%2==0) {
            long half=modMult(first, second/2, modulus);
            return (half+half)%modulus;
        }else{
            long half=modMult(first, second/2, modulus);
            return (half+half+first)%modulus;
        }
    }
}