package process;

import Model.Car;

import java.util.*;

public class ParkingLot {

    private int noOfParkingSlots = 0;

    private List<Integer> availableSlots;

    private Map<Integer, Car> slotCarMap;

    private Map<String, Integer> regNoCarSlotMap;

    private Map<String, List<String>> colorCarMap;

    private static ParkingLot parkingLotProcessor = null;

    private ParkingLot(int noOfParkingSlots) {
        this.noOfParkingSlots = noOfParkingSlots;
        availableSlots = new ArrayList<Integer>();

        for (int i = 1; i <= noOfParkingSlots; i++) {
            availableSlots.add(i);
        }

        slotCarMap = new HashMap<Integer, Car>();
        regNoCarSlotMap = new HashMap<String, Integer>();
        colorCarMap = new HashMap<String, List<String>>();
        System.out.println("Created a parking lot with " + noOfParkingSlots + " slots");
    }

    public static ParkingLot createParkingLot(int noOfParkingSlots) {
        if(parkingLotProcessor != null) {
            return parkingLotProcessor;
        } else {
            parkingLotProcessor =  new ParkingLot(noOfParkingSlots);
            return parkingLotProcessor;
        }

    }

    public void getStatus() {
        if (noOfParkingSlots == 0) {
            System.out.println("Sorry, parking lot is not created");
        } else if (slotCarMap.size() > 0) {
            System.out.println("Slot No.    Registration No    Colour");
            Car car;
            for (int i = 1; i <= noOfParkingSlots; i++) {
                if (slotCarMap.containsKey(i)) {
                    car = slotCarMap.get(i);
                    System.out.println(i + "           " + car.getRegNo() + "      " + car.getColor());
                }
            }
        } else {
            System.out.println("Parking lot is empty");
        }
    }

    public void parkCar(Car car) {
        if (noOfParkingSlots == 0) {
            System.out.println("Sorry, parking lot is not created");
            return;
        } else if (slotCarMap.size() == noOfParkingSlots) {
            System.out.println("Sorry, parking lot is full");
            return;
        } else {
            Collections.sort(availableSlots);
            int slot = availableSlots.get(0);
            slotCarMap.put(slot, car);
            if (!regNoCarSlotMap.containsKey(car.getRegNo())) {
                regNoCarSlotMap.put(car.getRegNo(), slot);
                if (colorCarMap.containsKey(car.getColor())) {
                    List<String> regNoList = colorCarMap.get(car.getColor());
                    colorCarMap.remove(car.getColor());
                    regNoList.add(car.getRegNo());
                    colorCarMap.put(car.getColor(), regNoList);
                } else {
                    LinkedList<String> regNoList =
                            new LinkedList<String>();
                    regNoList.add(car.getRegNo());
                    colorCarMap.put(car.getColor(), regNoList);
                }
                System.out.println("Allocated slot number: " + slot);
                availableSlots.remove(0);
            }else{
                System.out.println("Car with Registration Number already exist.");
            }
        }
    }

    public void leaveSlot(Integer slotNo) {
        if (noOfParkingSlots == 0) {
            System.out.println("Sorry, parking lot is not created");
        } else if (slotCarMap.size() > 0) {
            Car carToLeave = slotCarMap.get(slotNo);
            if (carToLeave != null) {
                slotCarMap.remove(slotNo);
                regNoCarSlotMap.remove(carToLeave.getRegNo());
                List<String> regNoList = colorCarMap.get(carToLeave.getColor());
                if (regNoList.contains(carToLeave.getRegNo())) {
                    regNoList.remove(carToLeave.getRegNo());
                }
                // Add the Lot No. back to available slot list.
                availableSlots.add(slotNo);
                System.out.println("Slot number " + slotNo + " is free");
            } else {
                System.out.println("Slot number " + slotNo + " is already empty");
            }
        } else {
            System.out.println("Parking lot is empty");
        }
    }

    public void getRegistrationNumbersFromColor(String color) {
        if (noOfParkingSlots == 0) {
            System.out.println("Sorry, parking lot is not created");
        } else if (colorCarMap.containsKey(color)) {
            List<String> regNoList = colorCarMap.get(color);
            for (int i = 0; i < regNoList.size(); i++) {
                if (!(i == regNoList.size() - 1)) {
                    System.out.print(regNoList.get(i) + ", ");
                } else {
                    System.out.println(regNoList.get(i));
                }
            }
            //System.out.println();
        } else {
            System.out.println("Not found");
        }
    }

    public void getSlotNumbersFromColor(String color) {
        if (noOfParkingSlots == 0) {
            System.out.println("Sorry, parking lot is not created");
        } else if (colorCarMap.containsKey(color)) {
            List<String> regNoList = colorCarMap.get(color);
            List<Integer> slotList = new ArrayList<Integer>();
            for (int i = 0; i < regNoList.size(); i++) {
                slotList.add(Integer.valueOf(regNoCarSlotMap.get(regNoList.get(i))));
            }
            Collections.sort(slotList);
            for (int j = 0; j < slotList.size(); j++) {
                if (!(j == slotList.size() - 1)) {
                    System.out.print(slotList.get(j) + ", ");
                } else {
                    System.out.print(slotList.get(j));
                }
            }
            System.out.println();
        } else {
            System.out.println("Not found");
        }
    }

    public void getSlotNumberFromRegNo(String regNo) {
        if (noOfParkingSlots == 0) {
            System.out.println("Sorry, parking lot is not created");
        } else if (regNoCarSlotMap.containsKey(regNo)) {
            System.out.println(regNoCarSlotMap.get(regNo));
        } else {
            System.out.println("Not found");
        }
    }

}
