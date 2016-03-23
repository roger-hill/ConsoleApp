package com.roger;

import java.io.File;
import java.io.IOException;

/**
 * Author: Roger Hill
 * Date: 16/02/2016
 *
 * Console application for researching spikes
 */
public class ConsoleApp {

    public static void main(String[] args) {

        ConsoleApp app = new ConsoleApp();

        try {
            app.playWithFileFlags();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * @throws IOException
     */
    private void playWithFolderFlags() throws IOException {

        File file = new File("C:\\temp\\testFolder_" + System.currentTimeMillis());

        boolean mkdirsSuccess = file.mkdirs();
        System.out.println("mkDirsSuccess: " + mkdirsSuccess);

        boolean setReadableFalseSuccess = file.setReadable(false);
        System.out.println("setReadableFalseSuccess: " + setReadableFalseSuccess);

        boolean setWritableFalseSuccess = file.setWritable(false);
        System.out.println("setWritableFalseSuccess: " + setWritableFalseSuccess);

        boolean setExecutableFalseSuccess = file.setExecutable(false);
        System.out.println("setExecutableFalseSuccess: " + setExecutableFalseSuccess);
    }

    private void playWithFileFlags() throws IOException {

        File file = new File("C:\\temp\\testFile_" + System.currentTimeMillis() + ".txt");

        boolean createNewFileSuccess = file.createNewFile();
        System.out.println("createNewFileSuccess: " + createNewFileSuccess);

        boolean setReadableFalseSuccess = file.setReadable(false);
        System.out.println("setReadableFalseSuccess: " + setReadableFalseSuccess);

        boolean setWritableFalseSuccess = file.setWritable(false);
        System.out.println("setWritableFalseSuccess: " + setWritableFalseSuccess);

        boolean setExecutableFalseSuccess = file.setExecutable(false);
        System.out.println("setExecutableFalseSuccess: " + setExecutableFalseSuccess);
    }
}
