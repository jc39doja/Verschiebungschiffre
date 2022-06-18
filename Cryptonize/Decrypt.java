package Cryptonize;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * This is a class to decrypt a text
 *
 * @author grueni95
 *
 */

    //maybe just let put this whole stuff to an overall cypherclass
    // or made the hard decode stuff in a separate class
public class Decrypt {

    public static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public static String frequencies = "enisratdhulcgmobwfkzpvjyxq";

    /**
     * The constructor for the decryption class
     * @param key the key to decrypt
     * @param cypherString the encrypted string to decode
     */
    public Decrypt(int key, String cypherString) {
        startDecryption(key, cypherString);
    }

    /**
     * The overloaded constructor in case that the key isn't known
     * @param cypher the cypher string to analyse
     */
    public Decrypt(String cypher){
        cryptAnalysis(cypher);
        //bruteForce(cypher);
    }

    /**
     * A method to start the decryption by shifting each character by its alphabetic value difference to the origin
     * @param key the decryption key
     * @param cypherString the encrypted strind to decode
     */
    public void startDecryption(int key, String cypherString) {
        StringBuilder plain = new StringBuilder();
        for (int i = 0; i < cypherString.length(); i++) {
            char a = cypherString.charAt(i);
            plain.append(shiftBack(a, 26-key));
        }
        System.out.println(plain);
        //showDecTable(key);
    }

    /**
     * A method to shift each character from the cypher to its original position in the alphabet
     * @param a the character to shift
     * @param key the value to shift the character at its original position
     * @return the shifted character
     */
    public static char shiftBack(char a, int key) {
        if (!Character.isLetter(a)) {
            return a;
        } else {
            int b =  Math.floorMod((alphabet.indexOf(a) + key),26); //floormod for a clean handeling of negative values in case the key is >26
            return alphabet.charAt(b);
        }
    }

    /**
     * A method to get the unknown key of a cypher by using cryptanalysis
     * @param cypher the cypher which we want to get the key from
     * @return the key
     */
    public int cryptAnalysis(String cypher) {
        int key = 0;
        //fill a hashmap with each letter, and it's count
        HashMap<Character, Integer> letters = new HashMap<>();
        for (int i = 0; i < cypher.length(); i++) {
            char x = cypher.charAt(i);
            if (letters.containsKey(x) && Character.isLetter(x)) {
                int value = letters.get(x);
                value++;
                letters.put(x, value);
            }
            else if (Character.isLetter(x)){
                letters.put(x, 1);
            }
        }
        System.out.println(letters);

        //A loop to get the most used letter
        int max = Collections.max(letters.values());
        for(Entry<Character, Integer> entry: letters.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println("Most used letter: " + entry.getKey() + " with " + max + " times.");
                key = alphabet.indexOf(entry.getKey()) - alphabet.indexOf("e") ;
            }
        }

        //Check if the most used letter is e and the difference the key and go on with the second-frequent if not




        System.out.println(key);
        return key;
    }

    /**
     * A method to check if the given key is the correct key
     * @param key the key to check
     * @return true if the key is correct, else false
     */
    private boolean isKey(int key) {

        return false;
    }

    //muss das extra noch mal mit hin, ist ja dann das selbe wie mit der enc. wenn ja, dann muss hier
    //eine andere shift methode verwendet werden. oder die tabelle wird sauber je nach key ausgegeben, egal on crypt oder decrypt
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

    /*Bruteforce: while cypher alphabet != alphabet, shift 1 (da müssen wir nur irgendwie das cypher alphabet erstellen
    oder es muss anderweitig gecheckt werden, ob gültige wörter dabei herauskommen

    cryptanalyst: häufigster buchstabe im cypher text - e (5) = key? nicht, dann mit n, i, s etc probieren
     */
}
