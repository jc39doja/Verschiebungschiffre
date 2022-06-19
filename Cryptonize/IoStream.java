package Cryptonize;
import java.io.*;

/**
 * Class that manages the input and output streams.
 * @author jc39doja
 */
public class IoStream {

    private String ipath;
    private String opath;

    /**
     * Constructor for the IoStream class.
     */
    public IoStream(){
        this.ipath = ipath;
        this.opath = opath;
    }

    /**
     * Method that reads thw original text, changes all letter to lower case letters and exchanges all
     * special characters for letters in the alphabet. It also creates a new file and writes the new text in there.
     */
    public void modifyFile(){
        try {
            File file1 = new File("Daten/3/Gedicht.txt");
            File file2 = new File("Daten/3/Thcideg.txt");
            BufferedReader ipath = (new BufferedReader(new FileReader(file1)));
            PrintWriter opath = (new PrintWriter(new FileWriter(file2)));
            StringBuilder text = new StringBuilder();
            String line = ipath.readLine();
            while (line != null) {
                text.append(line);
                text.append("\n");
                line = ipath.readLine();
            }

            String string = text.toString();
            string = string.replace("ä", "ae").replace("ö", "oe")
                    .replace("ü", "ue").replace("ß", "ss");

            Encrypt encrypt = new Encrypt(3,string);
            encrypt.startEncryption(3,string);


            text = new StringBuilder(string.toLowerCase());
            while (text.length() > 0) {
                if (text.indexOf("\n") >= 0) {
                    opath.println(text.substring(0, text.indexOf("\n")));
                    text.delete(0, text.indexOf("\n") + 1);
                } else {
                    opath.println(text);
                    text.delete(0, text.length());
                }

            }

            ipath.close();
            opath.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }


    }

}








