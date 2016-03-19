package com.roger.security;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roger Hill
 * Date 17/03/2016.
 */
public class EncryptedFileTest {

    @Test
    public void canReadFile() {

        EncryptedFile ef = new EncryptedFile("roger", "c:\\temp\\test.txt");

        for (String line : ef.read()) {
            System.out.println(line);
        }
    }

    @Test
    public void canWriteFile() {

        EncryptedFile ef = new EncryptedFile("roger", "c:\\temp\\test.txt");

        List<String> lines = new ArrayList<>();

        lines.add("Catherine");
        lines.add("Louise");
        lines.add("Hill");

        ef.write(lines);
    }

    @Test
    public void canEncryptBytes() {

        EncryptedFile ef = new EncryptedFile(new String("Password"), "c:\\temp\\test.txt");

        String plain = "P";
        List<String> plainLines = new ArrayList<>();
        plainLines.add(plain);

        List<String> cypherLines = ef.encrypt(plainLines);

        for (String line : cypherLines) {
            System.out.println(line);
        }

        plainLines = ef.decrypt(cypherLines);

        for (String line : plainLines) {
            System.out.println(line);
        }
    }
}
