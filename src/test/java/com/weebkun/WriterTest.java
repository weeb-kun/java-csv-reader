package com.weebkun;

import org.hamcrest.core.StringContains;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class WriterTest {

    @Test
    public void test1() throws IOException {
        try (CsvWriter writer = new CsvWriter("test1.csv", false)){
            writer.write("test", true);
        }
        try(CsvReader reader = new CsvReader("test1.csv")){
            assertEquals("Expected: 'test'", "test", reader.nextLine());
        }
    }

    @Test
    public void test2() throws IOException {
        try (CsvWriter writer = new CsvWriter(new File("test2.csv"), false)){
            writer.write(new String[]{"test1", "test2"});
            writer.write(new String[]{"test3", "test4"});
        }
        try (CsvReader reader = new CsvReader("test2.csv")) {
            String line;
            while((line = reader.nextLine()) != null) {
                assertThat(line, new StringContains("test"));
            }
        }
    }
}
