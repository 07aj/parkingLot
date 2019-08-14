package controller;

import constants.Command;
import process.ParkingLot;

public class Processor {
    ParkingLot parkingLot = null;

    public void validateAndProcess(String inputString) throws Exception {

        String[] inputStrArr = inputString.split("");
        if (inputStrArr[0].equals("")) {
            System.out.println("False entry");
            return;
        }
        Command command = Command.findByName(inputStrArr[0]);

        if (command == null) {
            System.out.println("Invalid command");
            return;
        }
    }
}