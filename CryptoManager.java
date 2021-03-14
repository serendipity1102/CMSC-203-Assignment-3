public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		boolean a = false;

		for (int i = 0; i < plainText.length(); i++) {
			if ((int)plainText.charAt(i)>= 32 && (int)plainText.charAt(i) <= 95) {
				a = true;
				break;
			}
		}
		return a;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		int int1;
		String str;
		String str1 = "";
		key = check(key);
		
		for (int i = 0; i < plainText.length();i++) {
		int1 = (int)plainText.charAt(i) + key;
		str = Character.toString(int1);
		str1 += str;
		}
		
		return str1;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String str = "";
		char a;
		
		while (bellasoStr.length() < plainText.length())
			bellasoStr += bellasoStr.substring(0,(plainText.length()-bellasoStr.length()));
		
	    for (int i = 0; i < plainText.length(); i++) 
	    { 
	        a = (char)check((int)plainText.charAt(i) + (int)bellasoStr.charAt(i));
	        str += Character.toString(a);
	    } 
		
		return str;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		int int1;
		String str;
		String str1 = "";
		key = check (key);
		
		for (int i = 0; i < encryptedText.length();i++) {
		int1 = (int)encryptedText.charAt(i) - key;
		str = Character.toString(int1);
		str1 += str;
		}
		return str1;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String str1="";
		char a;
		
		while(bellasoStr.length()<encryptedText.length())
		{
		bellasoStr+=bellasoStr.substring(0,(encryptedText.length()-bellasoStr.length()));
		}
		
		for(int i=0;i < encryptedText.length();i++)
		{
		a = (char)check ((int)encryptedText.charAt(i)-(int)bellasoStr.charAt(i) );
		str1+=Character.toString(a);
		}
		return str1;
	}
	
	public static int check (int a) {
		while (a > 32)
			a -= RANGE;
		return a;
	}
}