package com.weebkun;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Writer class for writing to csv files.
 * @author weebkun
 * @version 1.1.0-beta
 * @since 1.1.0-alpha
 */
public class CsvWriter implements AutoCloseable {

    private final FileWriter writer;
    private final File file;

    /**
     * creates a new CsvWriter object with given name.
     * @param name - the name of the file
     * @param append - a boolean indicating whether to open file in append mode
     * @throws IOException - if an IO error occurs
     */
    public CsvWriter(String name, boolean append) throws IOException{
        //instantiate the file obj
        this.file = new File(name);
        // create file if not exists.
        if(this.file.createNewFile()) {
            System.out.printf("%s created", this.file.getName());
            this.writer = new FileWriter(this.file);
        } else {
            this.writer = new FileWriter(this.file, append);
        }

    }

    /**
     * creates a CsvReader obj from a given file.
     * @param file - the file obj
     * @param append - a boolean indicating whether to open file in append mode
     * @throws IOException - if an IO error occurs
     */
    public CsvWriter(File file, boolean append) throws IOException{
        if(file.createNewFile()){
            // successfully created file.
            this.file = file;
            System.out.printf("%s created", this.file.getName());
            this.writer = new FileWriter(file);
        } else {
            //file already exists
            this.file = file;
            this.writer = new FileWriter(file, append);
        }
    }

    /**
     * closes the writer object.
     * @throws IOException - if an IO error occurs
     */
    @Override
    public void close() throws IOException {
        this.writer.close();
    }

    /**
     * writes a string to the specified file.
     * @param text - the string to write
     * @param newLine - boolean indicating whether to write a newline to the file
     * @throws IOException - if an IO error occurs
     */
    public void write(String text, boolean newLine) throws IOException{
        if(this.file.exists()){
            this.writer.write(newLine ? text + "\n" : text);
        } else {
            System.out.println("the file does not exist.");
        }
    }

    /**
     * writes a string array to the file.
     * @param row - the string array to write
     * @throws IOException - if an IO error occurs
     */
    public void write(String[] row) throws IOException{
        if(this.file.exists()){
            for(int i = 0; i < row.length; i++){
                if(i != row.length - 1){
                    // write the text along with a comma
                    this.writer.write(row[i] + ", ");
                } else {
                    //last value in row
                    this.writer.write(row[i] + "\n");
                }
            }
        }
    }

    /**
     * checks if the file exists.
     * @return boolean indicating whether the file exists.
     */
    public boolean fileExists(){
        return this.file.exists();
    }

    /**
     * returns the file instance that belongs to this writer.
     * @return the file
     */
    public File getFile(){
        return this.file;
    }
}
