package orientation;

import orientation.East;
import orientation.Orientation;

public class South extends Orientation {
    @Override
    public Orientation rotateLeft() {
        return new East();
    }

    @Override
    public Orientation rotateRight() {
         return new West();
     }
}
