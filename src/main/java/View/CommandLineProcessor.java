package View;

import controller.Processor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandLineProcessor extends Processor {

    public void process() throws Exception {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));


        while(true) {
            String inputString = bufferRead.readLine();
            validateAndProcess(inputString);
        }
    }

    public static void main(String[] args) throws Exception {
        new CommandLineProcessor().validateAndProcess("create_parking_lot 6");
    }

}
