/*
Decrypter Class
Blake Makholm
CIS 3360
9/13/2020
 */
public class Decrypter {
    public static void main(String[] args){
        String a = decrypt("2867");
        System.out.println(a);
    }

    public static String decrypt(String num){
        String [] array = setToArray(num);
        for(int i = 0; i < 4; i++)
            array[i] = String.valueOf((modulusInverse((array[i]))));
        String decryptedNum = array[2] + array[3] + array[0] + array[1];
        return decryptedNum;
    }

    //Break string into 4 substrings in an array for easy manipulation
    public static String[] setToArray(String cipherText){
        String[] ctArray= new String[4];
        for(int i = 0; i < 4; i++)
            ctArray[i] = cipherText.substring(i, i+1);
        return ctArray;
    }

    // Revert number to "pre-mod" state
    public static int modulusInverse(String num){
        int intNum = Integer.parseInt(num);
        if(intNum >= 7 && intNum <= 9)
            return intNum - 7;
        else if( (intNum >= 1 && intNum <= 6) || intNum == 0)
            return intNum + 3;
        else return -1;
    }
}

