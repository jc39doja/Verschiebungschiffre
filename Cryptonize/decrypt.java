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
            plain.append(shiftBack(a, 26-key));
        }
        System.out.println(plain);
        //showDecTable(key);
    }

    public static char shiftBack(char a, int key) {
        if (!Character.isLetter(a)) {
            return a;
        } else {
            int b =  Math.floorMod((alphabet.indexOf(a) + key),26); //floormod for a clean handeling of negative values in case the key is >26
            return alphabet.charAt(b);
        }
    }

    //muss das extra noch mal mit hin, ist ja dann das selbe wie mit der enc. wenn ja, dann muss hier
    //eine andere shift methode verwendet werden. oder die tabelle wird sauber je nach key ausgegegeben, egal on crypt oder decyrpt
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

    /*Brutefroce: while cypher alphabet != alphabet, shift 1 (da müssen wir nur irgendwie das cypheralphabet erstellen
    oder es muss andersweitig gecheckt werden ob gültige wörter dabei heraus kommen

    cryptoanalyse: häufigsterbuchstabe im cypher text - e (5) = key?
     */
}
