import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class MarsRoverShould {
    @Test
    public void default_to_00N_as_initial_position() {
        MarsRover marsRover = new MarsRover();
        MarsRover expected = new MarsRover(0, 0, 'N');

        assertEquals(expected, marsRover);
    }

    private static Stream<Arguments> testCasesForFCommand() {
        return Stream.of(
                Arguments.of(new MarsRover(), new MarsRover(0, 1, 'N')),
                Arguments.of(new MarsRover(0, 1, 'N'), new MarsRover(0, 2, 'N')),
                Arguments.of(new MarsRover(0, 1, 'E'), new MarsRover(1, 1, 'E')),
                Arguments.of(new MarsRover(0, 0, 'S'), new MarsRover(0, -1, 'S')),
                Arguments.of(new MarsRover(0, 0, 'W'), new MarsRover(-1, 0, 'W'))
        );
    }

    @ParameterizedTest(name = "{index} => MarsRover={0}, MarsRover={1}")
    @MethodSource("testCasesForFCommand")
    public void move_forward_in_the_direction_is_facing_if_F_is_passed_as_a_navigation_command(MarsRover rover, MarsRover expectedRover) {
        rover.navigate("F");

        assertEquals(expectedRover, rover);
    }
    @Test
    public void move_twice_forward_when_FF_is_passed_as_navigation_command() {
        MarsRover rover = new MarsRover();
        MarsRover expectedRover = new MarsRover(0,2,'N');

        rover.navigate("FF");

        assertEquals(expectedRover, rover);
    }

}
