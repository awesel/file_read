package file_read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * worker
 */
public class worker {
    public static void writeFile(String toWrite) {
        String name = "write_this.txt";

        // Write the string to the file
        try {
            FileWriter fileWriter = new FileWriter(name);
            fileWriter.write(toWrite);
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("some didn't work");
        }
    }

    public static String readFile(File file) {
        String currentString = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.ready()) {
                char nextChar = (char) reader.read();
                currentString += nextChar;

            }
            reader.close();
        } catch (IOException ex) {
            System.out.println("nah");
        }
        return currentString;

    }

    public static void main(String args[]) {
        File file = new File("read_this.txt");
        String text = readFile(file);
        System.out.println(text);
        writeFile(text);
    }

    public int countCharacters(String fileName) throws FileNotFoundException {
        int count = 0;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while (br.ready()) {
            count++;
        }
        br.close();
        return count;
    }

}