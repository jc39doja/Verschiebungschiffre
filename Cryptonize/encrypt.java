package Cryptonize;

/**
 * This is a class to encrypt a file
 *
 * @author grueni95
 * @author jc39doja
 */
public class encrypt {


    public static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    /**
     * The constructor of the class encrypt to initialize the encryption.
     * @param key the key for the encryption, passed by the @see main
     * @param inputString the string which should be encrypted
     */
    public encrypt(int key, String inputString) {
        startEncryption(key, inputString);
    }

    /**
     * A method to start the encryption and pass each character to the @see shift method
     * @param key the key for the encryption
     * @param inputString the string to be encrypted
     */
    public void startEncryption(int key, String inputString) {

        StringBuilder cypher = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            char a = inputString.charAt(i);
            cypher.append(shift(a, key));
        }
        System.out.println(cypher);
        showEncTable(key);
    }



    /**
     * A method to shift each character from the inputString by the given key
     * @param a the character to shift
     * @param key the key by which the character get shifted
     * @return the shifted character
     */
    public static char shift(char a, int key) {
        if (!Character.isLetter(a)) {
            return a;
        } else {
            int b = (alphabet.indexOf(a) + key) % 26;
            return alphabet.charAt(b);
        }
    }

    /**
     * A method to show the encryption table.
     * @param key the key to shift the encryption table
     */
    private void showEncTable(int key) {
        System.out.println("Here you see the used encryption table. \n");
        StringBuilder cypherTable = new StringBuilder();
        for (int i = 0; i < alphabet.length(); i++) {
            char z = alphabet.charAt(i);
            cypherTable.append(shift(z, key));
        }
        System.out.println(alphabet + "\n" + cypherTable);
    }
}
