import View.CommandLineProcessor;
import View.FileProcessor;
import controller.Processor;

public class Main {

    public static void main(String[] args) throws Exception {

        Processor processor = null;
        if(args.length >= 1) {
            processor = new FileProcessor(args[0]);
        } else {
            processor = new CommandLineProcessor();
        }
        processor.process();
    }

}