package Cryptonize;


import java.io.*;
import java.lang.Object.*;
import java.util.Locale;

/**
 * A class to manage the input and output streams
 *
 * @author jc39doja
 */
public class IoStream {

    private String ipath;
    private String opath;
    private int character;

    public IoStream(){
        this.ipath = ipath;
        this.opath = opath;
    }

    public void readFile(){
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



    /*public void replaceSpecialCharacters(String schars) throws IOException{

        schars = schars.replace("ä", "ae").replace("ö", "oe")
                .replace("ü", "ue").replace("ß", "ss");

    }*/

    }








