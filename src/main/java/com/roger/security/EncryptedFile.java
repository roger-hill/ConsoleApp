package com.roger.security;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roger on 17/03/2016.
 */
public class EncryptedFile {

    public static void main(String[] args) {

        EncryptedFile ef = new EncryptedFile("kwakkh400", "c:\\temp\\details.txt");

        System.out.println("Start");

        List<String> decryptedLines = ef.read();
        for (String line : decryptedLines) {
            System.out.println(line);
        }

        System.out.println("End");
    }

    private char[] passwordChars;
    private String fileName;

    public EncryptedFile(String password, String fileName) {

        this.fileName = fileName;
        this.passwordChars = password.toCharArray();
    }

    public List<String> read() {

        BufferedReader br = null;
        List<String> lines = new ArrayList<>();

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(fileName));

            while ((sCurrentLine = br.readLine()) != null) {
                lines.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        List<String> plainLines = decrypt(lines);

        return plainLines;
    }

    public void write(List<String> lines) {

        List<String> cypherLines = encrypt(lines);

        try {

            File file = new File(fileName);

            // if file doesn't exist, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (String line : cypherLines) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> encrypt(List<String> plain) {

        index = 0;
        List<String> retVal = new ArrayList<>(plain.size());

        for (String line: plain) {
            retVal.add(encrypt(line));
        }

        return retVal;
    }

    int index = 0;
    private int getIndex() {

        ++index;
        if (index >= passwordChars.length) {
            index = 0;
        }
        return index;
    }

    private String encrypt(String plain) {

        char[] plainChars = plain.toCharArray();
        char[] cypherChars = new char[plainChars.length];

        for (int i = 0; i < plainChars.length; i++) {

            cypherChars[i] = addChars(plainChars[i], passwordChars[getIndex()]);
        }

        return new String(cypherChars);
    }

    private char addChars(char a, char b) {

        int result = a + b;
        if (result > Character.MAX_VALUE) {
            result = Character.MIN_VALUE + (result - Character.MAX_VALUE);
        }

        return (char) result;
    }

    public List<String> decrypt(List<String> cypher) {

        index = 0;
        List<String> retVal = new ArrayList<>(cypher.size());

        for (String line: cypher) {
            retVal.add(decrypt(line));
        }

        return retVal;
    }

    private String decrypt(String cypher) {

        char[] cypherChars = cypher.toCharArray();
        char[] plainChars = new char[cypherChars.length];

        for (int i = 0; i < cypherChars.length; i++) {

            plainChars[i] = subtractChars(cypherChars[i], passwordChars[getIndex()]);
        }

        return new String(plainChars);
    }

    private char subtractChars(char a, char b) {

        int result = a - b;
        if (result < Character.MIN_VALUE) {
            result = Character.MAX_VALUE - (result - Character.MIN_VALUE);
        }

        return (char) result;
    }
}
