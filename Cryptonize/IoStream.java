package Cryptonize;


import java.io.*;
import java.lang.Object.*;

/**
 * A class to manage the input and output streams
 *
 * @author jc39doja
 */
public class IoStream {

    private String ipath;
    private String opath;
    private char schars;
    private int character;
    private char[] text;

    public IoStream(){
        this.ipath = ipath;
        this.opath = opath;
        this.schars = schars;
        this.character = character;
        this.text = text;
    }

    public void readFile() throws IOException {

        File file1 = new File ("Daten/3/Gedicht.txt");
        File file2 = new File ("Daten/3/Thcideg.txt");
        BufferedReader ipath = (new BufferedReader(new FileReader(file1)));
        PrintWriter opath = (new PrintWriter(new FileWriter(file2)));
        StringBuilder text = new StringBuilder();
        //char[] text = {};
        String line = ipath.readLine();
        //ipath.readLine(text);
        while(line != null){
            text.append(line);
            text.append("\n");
            line = ipath.readLine();
        } text.append("hola");

        /*for(int i = 0; i < text.length; i++) {
            text[i] = Character.toLowerCase(text[i]);
            System.out.print(text[i]);
        }*/
        String string = text.toString();
        replaceSpecialCharacters(string);//modify replaceSpecialCharacters
        text = new StringBuilder(string);
        while(text.length()>0){
            if(text.indexOf("\n") >= 0){
                opath.println(text.substring(0,text.indexOf("\n")));
                text.delete(0,text.indexOf("\n") +1);
            }
            else{
                opath.println(text);
                text.delete(0,text.length());
            }
        }

        //opath.write(text);
        ipath.close();
        opath.close();


        }



    public void replaceSpecialCharacters(String schars){ //replace this method with switchcase or for on a stringbuilder

        schars.replace("ä", "ae");
        schars.replace("ö", "oe");
        schars.replace("ü", "ue");
        schars.replace("ß", "ss");

    }





}
