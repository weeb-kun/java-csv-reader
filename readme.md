# Installation
## maven
```xml
<dependency>
   <groupId>com.weebkun</groupId>
   <artifactId>java-csv-reader</artifactId>
   <version>1.0.0</version>
   <type>pom</type>
 </dependency>
```

## gradle
```groovy
implementation 'com.weebkun:java-csv-reader:1.0.0'
```

# Usage
```java
public class Main {
    public static void main(String[] args) {
        try (CsvReader reader = new CsvReader("filename.csv")){
            String line;
            while((line = reader.nextLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
```

# Documentation
todo