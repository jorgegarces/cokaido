import java.util.HashMap;
import java.util.Map;

public class Grid {

    private Map<Integer,String> grid;

    public Grid() {
        grid = new HashMap<Integer,String>() {{
            put(0, ".");
            put(1, ".");
            put(2, ".");
            put(3, ".");
            put(4, "V");
            put(5, ".");
            put(6, ".");
            put(7, ".");
            put(8, ".");
        }};
    }
}
