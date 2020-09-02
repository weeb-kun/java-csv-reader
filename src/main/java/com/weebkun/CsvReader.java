package com.weebkun;

import javax.annotation.Nullable;
import java.io.*;

/**
 * the reader class for reading csv files.
 */
public class CsvReader implements AutoCloseable {
    private final BufferedReader reader;

    /**
     * creates a CsvReader with given file name.
     * @param name - the name or path to file.
     * @throws FileNotFoundException - if file does not exist
     */
    public CsvReader(String name) throws FileNotFoundException {
        this.reader = new BufferedReader(new FileReader(name));
    }

    /**
     * creates a CsvReader with given File.
     * @param file - the File object
     * @throws FileNotFoundException - if file does not exist
     */
    public CsvReader(File file) throws FileNotFoundException{
        this.reader = new BufferedReader(new FileReader(file));
    }

    /**
     * creates a CsvReader from given FileReader.
     * @param file - the FileReader
     */
    public CsvReader(FileReader file) {
        this.reader = new BufferedReader(file);
    }

    /**
     * creates a CsvReader from given BufferedReader.
     * @param br - the BufferedReader
     */
    public CsvReader(BufferedReader br) {
        this.reader = br;
    }

    /**
     * closes the reader. implicitly called when used in a try-with-resources block.
     * @throws IOException - if an I/O error occurs
     */
    public void close() throws IOException {
        this.reader.close();
    }

    /**
     * reads each line in the file.
     * @return - the next line in the file.
     */
    @Nullable
    public String nextLine(){
        try {
            return this.reader.readLine();
        } catch (IOException e){
            return null;
        }
    }

    /**
     * reads each column in file.
     * returns each line as a string array.
     * @return the string array.
     */
    @Nullable
    public String[] readColumns(){
        try {
            return this.reader.readLine().split(", ");
        } catch (IOException e){
            return null;
        }
    }
}
