/**
 * @(#)CaesarCipher.java
 *
 *
 * @author
 * @version 1.00 2025/2/20
 */
import java.util.Arrays;

public class CaesarCipher {

	final private char[] ALPHABET = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	private char[] shifted;
	private int shift;

    public CaesarCipher() {
        shifted = new char[26];
        shift = 4;

        for(int i = 0; i < ALPHABET.length; i++){
            shifted[i+shift % 26] = ALPHABET[i];
        }
    }

    public CaesarCipher(int num){
        shifted = new char[26];
        shift = num;

        shifter(num);
    }

    public String encrypt(String message){
        String cryptic = "";
        boolean found = false;

        for(int i = 0; i < message.length(); i++){
            found = false;
            for(int letter = 0; letter < ALPHABET.length; letter++){
                if(message.charAt(i) == ALPHABET[letter]){
                    cryptic += shifted[letter];
                    found = true;
                }
            }
            if(!found)
                cryptic += message.charAt(i);
        }

        return cryptic;
    }

    public String decrypt(String message){
        String maustic = "";
        boolean found = false;

        for(int i = 0; i < message.length(); i++){
            found = false;
            for(int pos = 0; pos < shifted.length; pos++){
                if(message.charAt(i) == shifted[pos]){
                    maustic += ALPHABET[pos];
                    found = true;
                }
            }
            if(!found)
                maustic += message.charAt(i);
        }
        return maustic;
    }

    public void shifter(int num){

        for(int i = 0; i < ALPHABET.length; i++){
            shifted[(i+num) % 26] = ALPHABET[i];
        }

        //System.out.println(Arrays.toString(ALPHABET));
        System.out.println(Arrays.toString(shifted));
    }


}