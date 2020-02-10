import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class RoverControllerShould {
    @Test
    public void default_to_00N_as_initial_position() {
        RoverController roverController = new RoverController();
        RoverController expected = new RoverController(0, 0, 'N');

        assertEquals(expected, roverController);
    }

    private static Stream<Arguments> testCasesForFCommand() {
        return Stream.of(
                Arguments.of(new RoverController(), new RoverController(0, 1, 'N')),
                Arguments.of(new RoverController(0, 1, 'N'), new RoverController(0, 2, 'N')),
                Arguments.of(new RoverController(0, 1, 'E'), new RoverController(1, 1, 'E')),
                Arguments.of(new RoverController(0, 0, 'S'), new RoverController(0, -1, 'S')),
                Arguments.of(new RoverController(0, 0, 'W'), new RoverController(-1, 0, 'W'))
        );
    }

    @ParameterizedTest(name = "{index} => MarsRover={0}, MarsRover={1}")
    @MethodSource("testCasesForFCommand")
    public void move_forward_in_the_direction_is_facing_if_F_is_passed_as_a_navigation_command(RoverController rover, RoverController expectedRover) {
        rover.navigate("F");

        assertEquals(expectedRover, rover);
    }
    @Test
    public void move_twice_forward_when_FF_is_passed_as_navigation_command() {
        RoverController rover = new RoverController();
        RoverController expectedRover = new RoverController(0,2,'N');

        rover.navigate("FF");

        assertEquals(expectedRover, rover);
    }

    private static Stream<Arguments> testCasesForRCommand() {
        return Stream.of(
                Arguments.of(new RoverController(), new RoverController(0, 0, 'E')),
                Arguments.of(new RoverController(0,0,'E'), new RoverController(0, 0, 'S')),
                Arguments.of(new RoverController(0,0,'S'), new RoverController(0, 0, 'W')),
                Arguments.of(new RoverController(0,0,'W'), new RoverController(0, 0, 'N'))

                );
    }

    @ParameterizedTest(name = "{index} => MarsRover={0}, MarsRover={1}")
    @MethodSource("testCasesForRCommand")
    public void rotate_right_when_R_is_passed_as_command(RoverController rover, RoverController expectedRover) {
        rover.navigate("R");

        assertEquals(expectedRover, rover);
    }

    @Test
    public void accept_various_F_and_R_commands_combined(){
        RoverController rover = new RoverController();
        RoverController expectedRover = new RoverController(1,2,'S');

        rover.navigate("FFRFR");

        assertEquals(expectedRover, rover);
    }

    private static Stream<Arguments> testCasesForLCommand() {
        return Stream.of(
                Arguments.of(new RoverController(), new RoverController(0, 0, 'W')),
                Arguments.of(new RoverController(0,0,'E'), new RoverController(0, 0, 'N')),
                Arguments.of(new RoverController(0,0,'S'), new RoverController(0, 0, 'E')),
                Arguments.of(new RoverController(0,0,'W'), new RoverController(0, 0, 'S'))
        );
    }

    @ParameterizedTest(name = "{index} => MarsRover={0}, MarsRover={1}")
    @MethodSource("testCasesForLCommand")
    public void rotate_left_when_L_is_passed_as_command(RoverController rover, RoverController expectedRover) {
        rover.navigate("L");

        assertEquals(expectedRover, rover);
    }

    private static Stream<Arguments> testCasesForBCommand() {
        return Stream.of(
                Arguments.of(new RoverController(), new RoverController(0, -1, 'N')),
                Arguments.of(new RoverController(0, 1, 'N'), new RoverController(0, 0, 'N')),
                Arguments.of(new RoverController(0, 1, 'E'), new RoverController(-1, 1, 'E')),
                Arguments.of(new RoverController(0, 0, 'S'), new RoverController(0, 1, 'S')),
                Arguments.of(new RoverController(0, 0, 'W'), new RoverController(1, 0, 'W'))
        );
    }

    @ParameterizedTest(name = "{index} => MarsRover={0}, MarsRover={1}")
    @MethodSource("testCasesForBCommand")
    public void move_backwards_in_the_direction_is_facing_if_B_is_passed_as_a_navigation_command(RoverController rover, RoverController expectedRover) {
        rover.navigate("B");

        assertEquals(expectedRover, rover);
    }

}
