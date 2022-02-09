package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class IOProblems {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\IOProblems\\src\\com\\company\\text.txt");
        System.out.println(isExist(file));

        System.out.println(canRead(file));
        System.out.println(canWrite(file));

        System.out.println(file.isFile());

        System.out.println(isFileOrDirectory(file));

        System.out.println(lastModified(file));

        System.out.println(getSizeInMb(file));
        System.out.println(getSizeInKb(file));
        System.out.println(getSizeInBytes(file));

        System.out.println(Arrays.toString(readIntoByteArray(file)));

        System.out.println(readLine(file));

        System.out.println(readText(file));

        System.out.println(readTextByLine(file));

        System.out.println(readIntoStringArray(file));

        readAndWrite(file);

        System.out.println(findLongestWord(file));
    }

    /*
    * 1) Write a Java program to check if a file or directory specified by pathname exists or not.
    * */
    public static boolean isExist(File file) {
        return file.exists();
    }

    /*
    * 2) Write a Java program to check if a file or directory has read and write permission.
    * */
    public static boolean canRead(File file) {
        return file.canRead();
    }

    public static boolean canWrite(File file) {
        return file.canWrite();
    }

    /*
    * 3) Write a Java program to check if given pathname is a directory or a file.
    * */
    public static boolean isFileOrDirectory(File file) {
        if(file.isFile()){
            return true;
        } else return file.isDirectory();
    }

    /*
    * 4) Write a Java program to get last modified time of a file.
    * */
    public static Date lastModified(File file) {
        return new Date(file.lastModified());
    }

    /*
    * 5) Write a Java program to get file size in bytes, kb, mb.
    * */
    public static long getSizeInMb(File file) {
        return file.length()/(1024*1024);
    }

    public static long getSizeInKb(File file) {
        return file.length()/1024;
    }

    public static long getSizeInBytes(File file) {
        return file.length();
    }

    /*
    * 6) Write a Java program to read contents from a file into byte array.
    * */
    public static byte[] readIntoByteArray(File file) {
        byte[] fileInArray = new byte[(int)file.length()];

        try(FileInputStream f = new FileInputStream(file.getAbsolutePath())){
            f.read(fileInArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileInArray;
    }

    /*
    * 7) Write a Java program to read a file content line by line.
    * */
    public static String readLine(File file) {
        String line = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    /*
    * 8) Write a Java program to read a plain text file.
    * */
    public static String readText(File file) throws IOException{
        return new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
    }

    /*
    * 9) Write a java program to read a file line by line and store it into a variable.
    * */
    public static String readTextByLine(File file) {

        String strLine = "";
        StringBuilder strData = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            while (strLine != null)
            {
                strData.append(strLine);
                strLine = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strData.toString();
    }

    /*
    * 10) Write a Java program to store text file content line by line into an array.
    * */
    public static ArrayList<String> readIntoStringArray(File file) {
        String strLine = "";
        ArrayList<String> strData = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            while (strLine != null)
            {
                strData.add(strLine);
                strLine = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strData;
    }

    /*
    * 11) Write a Java program to write and read a plain text file.
    * */
    public static void readAndWrite(File file) {
        String text = "Hello World!!";

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)){
            byte[] array = text.getBytes();
            fileOutputStream.write(array);
        } catch (IOException e){
            e.printStackTrace();
        }

        try (FileInputStream fin = new FileInputStream(file)){
            int i;
            while((i = fin.read()) != -1){
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * 12) Write a Java program to find the longest word in a text file.
    * */
    public static String findLongestWord(File file) {
        String longestWord = "";
        String current;
        Scanner sc = null;

        try {
            sc = new Scanner(new File(file.getAbsolutePath()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (true) {
            assert sc != null;

            if (!sc.hasNext()) {
                break;
            }

            current = sc.next();

            if (current.length() > longestWord.length()) {
                longestWord = current;
            }

        }
        return longestWord;
    }
}