package orientation;

import orientation.North;
import orientation.Orientation;
import orientation.South;

public class West extends Orientation {
    @Override
    public Orientation rotateLeft() {
        return new South();
    }

    @Override
    public Orientation rotateRight() {
         return new North();
     }

}
