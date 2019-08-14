package View;

import controller.Processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class FileProcessor  extends Processor {
    String filePath = null;

    public FileProcessor(String filePath) {
        this.filePath = filePath;
    }

    public void process() throws Exception {
        File inputFile = new File(filePath);
        @SuppressWarnings("resource")
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String line;
        while ((line = br.readLine()) != null) {
            validateAndProcess(line);
        }
    }

}
