package com.weebkun;

import org.junit.*;

import java.io.IOException;

public class ReaderTest {
    @Test
    public void testReadLine() throws IOException {
        try (CsvReader reader = new CsvReader("test.csv")){
            Assert.assertEquals("Expected 'test1, test2'", "test1, test2", reader.nextLine());
        }
    }

    @Test
    public void testReadColumn() throws IOException {
        try (CsvReader reader = new CsvReader("test.csv")){
            Assert.assertEquals("Expected 'test1'", "test1", reader.readColumns()[0]);
        }
    }
}
