package process;

import com.gojek.model.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private int noOfParkingSlots = 0;

    private List<Integer> availableSlots;

    private Map<Integer, Car> slotCarMap;

    private Map<String, Integer> regNoCarSlotMap;

    private Map<String, List<String>> colorCarMap;

    private static ParkingLot parkingLotProcessor = null;

    //Making the class singleton
    private ParkingLot(int noOfParkingSlots) {
        this.noOfParkingSlots = noOfParkingSlots;
        availableSlots = new ArrayList<Integer>();

        for (int i = 1; i <= noOfParkingSlots; i++) {
            availableSlots.add(i);
        }

        slotCarMap = new HashMap<Integer, Car>();
        regNoCarSlotMap = new HashMap<String, Integer>();
        colorCarMap = new HashMap<String, List<String>>();
        System.out.println("Created parking lot with " + noOfParkingSlots + " slots");
        System.out.println();
    }

    public static ParkingLot createParkingLot(int noOfParkingSlots) {
        if(parkingLotProcessor != null) {
            return parkingLotProcessor;
        } else {
            parkingLotProcessor =
                    new ParkingLot(noOfParkingSlots);
            return parkingLotProcessor;
        }

    }

    public static void main(String args[])
    {
        ParkingLot p = null;
        p.createParkingLot(2);
    }

}
