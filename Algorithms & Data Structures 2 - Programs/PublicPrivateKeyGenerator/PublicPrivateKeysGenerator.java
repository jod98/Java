import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.math.BigInteger;

public class PublicPrivateKeysGenerator
{
	public static void main(String args[])
	{
		int max = 64;

		String ECDSA = "80" + random64Hex(max);
		System.out.println("Random 64 digit Hexademical String is: " + ECDSA);
		System.out.println("Length: " + ECDSA.length() + "\n");

		try
		{
			System.out.println("TheSHA256 of this Hexadecimal String is: ");
			String s1 = sha256(ECDSA);
			System.out.println("Length: " + s1.length() + "\n");

			System.out.println("2nd run of Sha-256 of this Hexadecimal String is: ");
			String s2=sha256(s1);
			System.out.println("Length: "+s2.length()+ "\n");

			for(int i=0;i<8;i++)
			{
				ECDSA+=s2.charAt(i);
			}

			System.out.println(ECDSA);
			System.out.println("Length: "+ECDSA.length()+ "\n");
		}
		catch (NoSuchAlgorithmException e)
		{

		}

		String privateKey = convBase58(ECDSA);
		System.out.println("Private Key is: " + privateKey);
		System.out.println("Length: " + privateKey.length());
	}
	private static String random64Hex (int max)
	{
		Random rand=new Random();
		StringBuffer hex= new StringBuffer();

		while(hex.length()-1 < max)
		{
			hex.append(Integer.toHexString(rand.nextInt(16)));
		}
		return hex.toString().substring(0, max);
	}

	static String sha256(String input) throws NoSuchAlgorithmException
	{
		byte[] in = hexStringToByteArray(input);
		MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
		byte[] result = mDigest.digest(in);
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < result.length; i++)
		{
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
	public static byte[] hexStringToByteArray(String s)
	{
		int len = s.length();
		byte[] data = new byte[len / 2];

		for (int i = 0; i < len; i += 2)
		{
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)+ Character.digit(s.charAt(i+1), 16));
		}
		return data;
	}

	public static String convBase58(String ECDSA)
	{
		BigInteger hexBigInt = new BigInteger(ECDSA, 16);
		BigInteger b58 = new BigInteger("58");

		String result = new String();
		String base58Digits = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";

		char convStrToChar[]= base58Digits.toCharArray();

		BigInteger mod = new BigInteger("0");

		while(hexBigInt.compareTo(b58)>0)
		{
			mod = hexBigInt.mod(b58);
			result = convStrToChar[mod.intValue()] + result;
			hexBigInt = hexBigInt.divide(b58);
		}

		mod = hexBigInt.mod(b58);
		result = convStrToChar[mod.intValue()]+result;
		hexBigInt = hexBigInt.divide(b58);

		return result;
	}
}

