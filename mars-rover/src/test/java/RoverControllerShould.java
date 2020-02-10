import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import rover.RoverNormal;
import rover.RoverTurbo;

import java.util.stream.Stream;


public class RoverControllerShould {
    @Test
    public void default_to_00N_as_initial_position() {
        RoverController roverController = new RoverController(new RoverNormal(0,0, 'N'));
        RoverController expected = new RoverController(new RoverNormal(0, 0, 'N'));

        assertEquals(expected, roverController);
    }

    private static Stream<Arguments> testCasesForFCommandInRoverNormal() {
            return Stream.of(
                    Arguments.of(new RoverController(new RoverNormal()), new RoverController(new RoverNormal(0, 1, 'N'))),
                    Arguments.of(new RoverController(new RoverNormal(0,1,'N')), new RoverController(new RoverNormal(0, 2, 'N'))),
                    Arguments.of(new RoverController(new RoverNormal(0, 1, 'E')), new RoverController(new RoverNormal(1, 1, 'E'))),
                    Arguments.of(new RoverController(new RoverNormal(0, 0, 'S')), new RoverController(new RoverNormal(0, -1, 'S'))),
                    Arguments.of(new RoverController(new RoverNormal(0, 0, 'W')), new RoverController(new RoverNormal(-1, 0, 'W')))
            );

    }

    @ParameterizedTest(name = "{index} => MarsRover={0}, MarsRover={1}")
    @MethodSource("testCasesForFCommandInRoverNormal")
    public void move_forward_in_the_direction_is_facing_if_F_is_passed_as_a_navigation_command(RoverController rover, RoverController expectedRover) {
        rover.navigate("F");

        assertEquals(expectedRover, rover);
    }

    private static Stream<Arguments> testCasesForFCommandInRoverTurbo() {
        return Stream.of(
                Arguments.of(new RoverController(new RoverTurbo()), new RoverController(new RoverTurbo(0, 2, 'N'))),
                Arguments.of(new RoverController(new RoverTurbo(0, 1, 'N')), new RoverController(new RoverTurbo(0, 3, 'N'))),
                Arguments.of(new RoverController(new RoverTurbo(0, 1, 'E')), new RoverController(new RoverTurbo(2, 1, 'E'))),
                Arguments.of(new RoverController(new RoverTurbo(0, 0, 'S')), new RoverController(new RoverTurbo(0, -2, 'S'))),
                Arguments.of(new RoverController(new RoverTurbo(0, 0, 'W')), new RoverController(new RoverTurbo(-2, 0, 'W')))
        );
    }

    @ParameterizedTest(name = "{index} => MarsRover={0}, MarsRover={1}")
    @MethodSource("testCasesForFCommandInRoverTurbo")
    public void move_forward_in_the_direction_is_facing_if_F_is_passed_as_a_navigation_Turbo_command(RoverController rover, RoverController expectedRover) {
        rover.navigate("F");

        assertEquals(expectedRover, rover);
    }

    @Test
    public void move_twice_forward_when_FF_is_passed_as_navigation_command() {
        RoverController rover = new RoverController(new RoverNormal());
        RoverController expectedRover = new RoverController(new RoverNormal(0,2,'N'));

        rover.navigate("FF");

        assertEquals(expectedRover, rover);
    }

    private static Stream<Arguments> testCasesForRCommandInRoverTurbo() {
        return Stream.of(
                Arguments.of(new RoverController(new RoverTurbo()), new RoverController(new RoverTurbo(0, 0, 'E'))),
                Arguments.of(new RoverController(new RoverTurbo(0,0,'E')), new RoverController(new RoverTurbo(0, 0, 'S'))),
                Arguments.of(new RoverController(new RoverTurbo(0,0,'S')), new RoverController(new RoverTurbo(0, 0, 'W'))),
                Arguments.of(new RoverController(new RoverTurbo(0,0,'W')), new RoverController(new RoverTurbo(0, 0, 'N')))
                );
    }

    @ParameterizedTest(name = "{index} => MarsRover={0}, MarsRover={1}")
    @MethodSource("testCasesForRCommandInRoverTurbo")
    public void rotate_right_when_R_is_passed_as_command_in_Turbo_rover(RoverController rover, RoverController expectedRover) {
        rover.navigate("R");

        assertEquals(expectedRover, rover);
    }

    private static Stream<Arguments> testCasesForRCommandInRoverNormal() {
        return Stream.of(
            Arguments.of(new RoverController(new RoverNormal()), new RoverController(new RoverNormal(0, 0, 'E'))),
            Arguments.of(new RoverController(new RoverNormal(0,0,'E')), new RoverController(new RoverNormal(0, 0, 'S'))),
            Arguments.of(new RoverController(new RoverNormal(0,0,'S')), new RoverController(new RoverNormal(0, 0, 'W'))),
            Arguments.of(new RoverController(new RoverNormal(0,0,'W')), new RoverController(new RoverNormal(0, 0, 'N')))
            );
    }

    @ParameterizedTest(name = "{index} => MarsRover={0}, MarsRover={1}")
    @MethodSource("testCasesForRCommandInRoverNormal")
    public void rotate_right_when_R_is_passed_as_command_in_normal_rover(RoverController rover, RoverController expectedRover) {
        rover.navigate("R");

        assertEquals(expectedRover, rover);
    }

    @Test
    public void accept_various_F_and_R_commands_combined(){
        RoverController rover = new RoverController(new RoverNormal());
        RoverController expectedRover = new RoverController(new RoverNormal(1,2,'S'));

        rover.navigate("FFRFR");

        assertEquals(expectedRover, rover);
    }

    private static Stream<Arguments> testCasesForLCommandInNormalRover() {
        return Stream.of(
                Arguments.of(new RoverController(new RoverNormal()), new RoverController(new RoverNormal(0, 0, 'W'))),
                Arguments.of(new RoverController(new RoverNormal(0,0,'E')), new RoverController(new RoverNormal(0, 0, 'N'))),
                Arguments.of(new RoverController(new RoverNormal(0,0,'S')), new RoverController(new RoverNormal(0, 0, 'E'))),
                Arguments.of(new RoverController(new RoverNormal(0,0,'W')), new RoverController(new RoverNormal(0, 0, 'S')))
        );
    }

    @ParameterizedTest(name = "{index} => MarsRover={0}, MarsRover={1}")
    @MethodSource("testCasesForLCommandInNormalRover")
    public void rotate_left_when_L_is_passed_as_command_in_normal_rover(RoverController rover, RoverController expectedRover) {
        rover.navigate("L");

        assertEquals(expectedRover, rover);
    }

    private static Stream<Arguments> testCasesForLCommandInTurboRover() {
        return Stream.of(
            Arguments.of(new RoverController(new RoverTurbo()), new RoverController(new RoverTurbo(0, 0, 'W'))),
            Arguments.of(new RoverController(new RoverTurbo(0,0,'E')), new RoverController(new RoverTurbo(0, 0, 'N'))),
            Arguments.of(new RoverController(new RoverTurbo(0,0,'S')), new RoverController(new RoverTurbo(0, 0, 'E'))),
            Arguments.of(new RoverController(new RoverTurbo(0,0,'W')), new RoverController(new RoverTurbo(0, 0, 'S')))
        );
    }

    @ParameterizedTest(name = "{index} => MarsRover={0}, MarsRover={1}")
    @MethodSource("testCasesForLCommandInTurboRover")
    public void rotate_left_when_L_is_passed_as_command_in_turbo_rover(RoverController rover, RoverController expectedRover) {
        rover.navigate("L");

        assertEquals(expectedRover, rover);
    }

    private static Stream<Arguments> testCasesForBCommandInNormalRover() {
        return Stream.of(
                Arguments.of(new RoverController(new RoverNormal()), new RoverController(new RoverNormal(0, -1, 'N'))),
                Arguments.of(new RoverController(new RoverNormal(0, 1, 'N')), new RoverController(new RoverNormal(0, 0, 'N'))),
                Arguments.of(new RoverController(new RoverNormal(0, 1, 'E')), new RoverController(new RoverNormal(-1, 1, 'E'))),
                Arguments.of(new RoverController(new RoverNormal(0, 0, 'S')), new RoverController(new RoverNormal(0, 1, 'S'))),
                Arguments.of(new RoverController(new RoverNormal(0, 0, 'W')), new RoverController(new RoverNormal(1, 0, 'W')))
        );
    }

    @ParameterizedTest(name = "{index} => MarsRover={0}, MarsRover={1}")
    @MethodSource("testCasesForBCommandInNormalRover")
    public void move_backwards_in_the_direction_is_facing_if_B_is_passed_as_a_navigation_command_in_normal_rover(RoverController rover, RoverController expectedRover) {
        rover.navigate("B");

        assertEquals(expectedRover, rover);
    }

    private static Stream<Arguments> testCasesForBCommandInTurboRover() {
        return Stream.of(
            Arguments.of(new RoverController(new RoverTurbo()), new RoverController(new RoverTurbo(0, -2, 'N'))),
            Arguments.of(new RoverController(new RoverTurbo(0, 1, 'N')), new RoverController(new RoverTurbo(0, -1, 'N'))),
            Arguments.of(new RoverController(new RoverTurbo(0, 1, 'E')), new RoverController(new RoverTurbo(-2, 1, 'E'))),
            Arguments.of(new RoverController(new RoverTurbo(0, 0, 'S')), new RoverController(new RoverTurbo(0, 2, 'S'))),
            Arguments.of(new RoverController(new RoverTurbo(0, 0, 'W')), new RoverController(new RoverTurbo(2, 0, 'W')))
        );
    }

    @ParameterizedTest(name = "{index} => MarsRover={0}, MarsRover={1}")
    @MethodSource("testCasesForBCommandInTurboRover")
    public void move_backwards_in_the_direction_is_facing_if_B_is_passed_as_a_navigation_command_in_turbo_rover(RoverController rover, RoverController expectedRover) {
        rover.navigate("B");

        assertEquals(expectedRover, rover);
    }
}
