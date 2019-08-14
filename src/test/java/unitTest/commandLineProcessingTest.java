package unitTest;

import constants.Command;
import controller.Processor;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class commandLineProcessingTest  {
    static Processor processor = null;

    @BeforeClass
    public static void setUp() throws Exception {
        processor = new Processor() {
            @Override
            public void process() throws Exception {

            }
        };
        processor.validateAndProcess("create_parking_lot 6"); // we need to create parking lots before testing other requirements
    }

    @Test
    public void testCreateProcess() {
        try {
            processor.validateAndProcess("create_parking_lot 6");
        } catch (Exception e) {
            fail("Creation of parking slot failed");
        }
    }

    @Test
    public void testPark() {
        try {
            processor.validateAndProcess("park Mh14-111 White");
        } catch (Exception e) {
            fail("Creation of parking slot failed");
        }
    }

    @Test
    public void testGetStatus() {
        try {
            processor.validateAndProcess("status");
        } catch (Exception e) {
            fail("Fetching status functioanlity failed");
        }
    }

    @Test
    public void testGetSlotsByColor() {
        try {
            processor.validateAndProcess("slot_numbers_for_cars_with_colour White");
        } catch (Exception e) {
            fail("slot_numbers_for_cars_with_colour failed");
        }
    }

    @Test
    public void testGetRegNoByColor() {
        try {
            processor.validateAndProcess("registration_numbers_for_cars_with_colour White");
        } catch (Exception e) {
            fail("registration_numbers_for_cars_with_colour failed");
        }
    }

    @Test
    public void testSlotByRegNo() {
        try {
            processor.validateAndProcess("registration_numbers_for_cars_with_colour 1234");
        } catch (Exception e) {
            fail("registration_numbers_for_cars_with_colour failed");
        }
    }

    @Test
    public void testCommandNegative() throws Exception {
        Command command = Command.findByName("create_parking_lot----null");
        assertTrue(command == null);
    }

    @Test
    public void testCommandPositive() throws Exception {
        Command command = Command.findByName("create_parking_lot");
        assertTrue(command != null);
    }

    @Test
    public void testCommandPositive1() throws Exception {
        Command command = Command.findByName("registration_numbers_for_cars_with_colour");
        assertTrue(command != null);
    }
}
