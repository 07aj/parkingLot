package controller;

import Model.Car;
import constants.Command;
import process.ParkingLot;

public abstract class Processor {
    ParkingLot parkingLot = null;

    public void validateAndProcess(String inputString) throws Exception {

        String[] inputStrArr = inputString.split(" ");
        if (inputStrArr[0].equals("")) {
            System.out.println("Empty command");
            return;
        }
        Command command = Command.findByName(inputStrArr[0]);

        if (command == null) {
            System.out.println("Invalid command");
            return;
        }
        switch (command) {
            case CREATE:
                if (inputStrArr.length != 2) { // minimum 3 data are required for entry
                    throw new Exception("Invalid no of arguments for command : " + command);
                }
                int noOfPrakingSlots = Integer.parseInt(inputStrArr[1]);
                parkingLot = ParkingLot.createParkingLot(noOfPrakingSlots);
                break;

            case STATUS:
                if (inputStrArr.length != 1) {
                    throw new Exception("Invalid no of arguments for command : " + command);
                }
                parkingLot.getStatus();
                break;

            case PARK:
                if (inputStrArr.length != 3) {
                    throw new Exception("Invalid no of arguments for command : " + command);
                }
                String regNo = inputStrArr[1];
                String color = inputStrArr[2];
                parkingLot.parkCar(new Car(regNo, color));
                break;

            case LEAVE:
                if (inputStrArr.length != 2) {
                    throw new Exception("Invalid no of arguments for command : " + command);
                }
                int slotNo = Integer.parseInt(inputStrArr[1]);
                parkingLot.leaveSlot(slotNo);
                break;

            case FETCH_CARE_FROM_COLOR:
                if (inputStrArr.length != 2) {
                    throw new Exception("Invalid no of arguments for command : " + command);
                }
                parkingLot.getRegistrationNumbersFromColor(inputStrArr[1]);  //color
                break;

            case FETCH_SLOT_FROM_COLOR:
                if (inputStrArr.length != 2) {
                    throw new Exception("Invalid no of arguments for command : " + command);
                }
                parkingLot.getSlotNumbersFromColor(inputStrArr[1]);  //color
                break;
            case FETCH_SLOT_FROM_REG_NO:
                if (inputStrArr.length != 2) {
                    throw new Exception("Invalid no of arguments for command : " + command);
                }
                parkingLot.getSlotNumberFromRegNo(inputStrArr[1]);  //regNo
                break;
            case EXIT:
                break;

        }
    }

    public abstract void process() throws Exception; //to be used by multiple view points

}
