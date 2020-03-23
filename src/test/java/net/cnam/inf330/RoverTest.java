package net.cnam.inf330;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Class for testing the Rover Mission Command Center application.
 */
public class RoverTest {
    /**
     * Initialize the MCC before the tests are run.
     */

    MissionCommandCenter instance = MissionCommandCenter.getInstance();
    @BeforeClass // This method is run only once, before the test methods are run
    public static void initMissionCommandCenter() {
        // TODO 1) Initialize MCC singleton instance before the test methods are run
    }

    /**
     * Application must catch an InvalidRoverPositionException if a rover has moved out of the grid.
     * Rover must pull back after moving out of the grid.
     */
    // TODO 5) Change this test to check that the rover pulls back after moving out of the grid
    @Test
    public void testRoverOutOfGridException() {
        MissionCommandCenter mcc = new MissionCommandCenter(1, 1);
        Rover rover = new Rover(1, 0, 0, Orientation.N);
        Rover rover2 = new Rover(-1, -1, -1, Orientation.N);
        mcc.addRover(rover);
        mcc.addRover(rover2);
        rover.moveForward();
        rover.moveForward();

        ThrowingRunnable tr = () -> mcc.checkRoverPosition(rover);
        assertThrows(InvalidRoverPositionException.class, tr);

        ThrowingRunnable tr2 = () -> mcc.checkRoverPosition(rover2);
        assertThrows(InvalidRoverPositionException.class, tr2);

        // FIXME Check that rover has pulled back

        mcc.clearRovers();
    }

    /* TODO 3) 5) Write a new test for a scenario where 2 rovers collide at the same position on the grid
     *   and the second rover must pull back as a result
     */
    @Test
    public void testCheckRoverPosition(){
        MissionCommandCenter mcc = new MissionCommandCenter(1, 1);
        Rover rover1 = new Rover(1,0,0,Orientation.N);
        Rover rover2 = new Rover(1,0,0,Orientation.N);
        mcc.addRover(rover1);
        mcc.addRover(rover2);

        ThrowingRunnable tr1 = () -> mcc.checkRoverPosition(rover1);
        ThrowingRunnable tr2 = () -> mcc.checkRoverPosition(rover2);
        assertThrows(InvalidRoverPositionException.class, tr1);
        assertThrows(InvalidRoverPositionException.class, tr2);

        // FIXME Check that rover has pulled back

        mcc.clearRovers();
    }

    /* TODO 5) Write a new test for a scenario where a rover is created at an invalid position
     *   and is not deployed as a result
     */
    @Test
    public void testInvalidPosition(){
        MissionCommandCenter mcc = new MissionCommandCenter(1, 1);
        Rover rover1 = new Rover(1,-1,-1,Orientation.N);
        mcc.addRover(rover1);

        ThrowingRunnable tr1 = () -> mcc.checkRoverPosition(rover1);
        assertThrows(InvalidRoverPositionException.class, tr1);

        // FIXME Check that rover is not deployed (is null)

        mcc.clearRovers();
    }

    /**
     * Application must produce output data that matches the expected output after processing the input rover data.
     */
    @Test
    public void outputDataTest() throws IOException, URISyntaxException {
        List<String> inputLines = Main.readResourceFile("rover_test_input.txt");
        List<String> expectedOutputLines = Main.readResourceFile("rover_test_output.txt");

        // TODO FIXME 7) Test that processing the input lines produces an output that matches the expected output lines
        fail();
    }
}
