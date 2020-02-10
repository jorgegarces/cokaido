package orientation;

import orientation.East;
import orientation.Orientation;

public class North extends Orientation {
    @Override
    public Orientation rotateLeft() {
        return new West();
    }

    @Override
    public Orientation rotateRight() {
       return new East();
     }
}
