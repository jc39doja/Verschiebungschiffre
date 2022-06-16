package Cryptonize;

/**
 * This is a class to encrypt a file
 *
 * @author grueni95
 * @author jc39doja
 */
public class encrypt {

    /* here is where the encryption happens and where I lost my hope in my english skills*/

    private int key = 3;

    private String inputString;

    public encrypt(int key, String inputString) {
        this.key = key;
        this.inputString = inputString;
        startEncryption(key, inputString);
    }

    public void startEncryption(int key, String inputString) {
        /* for i in string mache i = (i + key) mod 26*/
        String chiffre = "";
        for (int i = 0; i < inputString.length(); i++) {

            char a = inputString.charAt(i);
            //System.out.println(a + " at " + (a+ key) % 26);
            char b = inputString.charAt((i + key) % 26);
            chiffre = chiffre + b;

            //hier müsste das alphabet noch mit ins spiel damit man das ordentlich verschiebene kann.
            /*System.out.println(a + " at " + i);
            i = (i + key) % 26; // muss in den output string, sonst loooopts ewig
            System.out.println("und danach " + a + " at " + i);*/
        }
        System.out.println(chiffre);
    }
/*
    public static char shift(char a, int key) {

    }*/
}
