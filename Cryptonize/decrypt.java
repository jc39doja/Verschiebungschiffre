package Cryptonize;

/**
 * This is a class to decrypt a text
 *
 * @author grueni95
 *
 */

//maybe just let put this whole stuff to an overall cypherclass
    // or made the hard decode stuff in a separate class
public class decrypt {

    public static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public decrypt(int key, String cypherString) {
        startDecryption(key, cypherString);
    }

    public void startDecryption(int key, String cypherString) {
        StringBuilder plain = new StringBuilder();
        for (int i = 0; i < cypherString.length(); i++) {
            char a = cypherString.charAt(i);
            plain.append(shiftBack(a, key));
        }
        System.out.println(plain);
        //showDecTable(key);
    }
     //hier fehlt noch ein work around, wenn es über die range hinaus geht, vtl auch noch mal eine andere shift methode
    public static char shiftBack(char a, int key) {
        if (!Character.isLetter(a)) {
            return a;
        } else {
            int b = (alphabet.indexOf(a) - key) % 26;
            return alphabet.charAt(b);
        }
    }

    //muss das extra noch mal mit hin, ist ja dann das selbe wie mit der enc. wenn ja, dann muss hier
    //eine andere shift methode verwendet werden.
/*
    private void showDecTable(int key) {
        System.out.println("Here you see the decryption table.");
        StringBuilder cypherTable = new StringBuilder();
        for (int i = 0; i < alphabet.length(); i++) {
            char z = alphabet.charAt(i);
            cypherTable.append(shift(z, key));
        }
        System.out.println(cypherTable + " \n " + alphabet);
    }*/

    //hier muss dann noch die cryptoanalyse und das Brutefroce als Methode kommen
}
