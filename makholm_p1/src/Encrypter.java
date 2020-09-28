/*
Encrypter Class
Blake Makholm
CIS 3360
9/13/2020
 */
public class Encrypter {
    public static void main(String[] args){
        String a = encrypt("9051");
        System.out.println(a);
    }

    public static String encrypt(String num){
        String [] array = setToArray(num);
        for(int i = 0; i < 4; i++)
            array[i] = String.valueOf(step1(array[i]));
        String encryptedNum = array[2] + array[3] + array[0] + array[1];
        return encryptedNum;
    }

    // Break string into 4 substrings in an array for easy manipulation
    public static String[] setToArray(String plainText){
        String[] ptArray= new String[4];
        for(int i = 0; i < 4; i++)
            ptArray[i] = plainText.substring(i, i+1);
        return ptArray;
    }

    // Perform mathematics of encryption
    public static int step1(String num){
        int intNum = Integer.parseInt(num);
        return (intNum + 7) % 10;
    }
}
