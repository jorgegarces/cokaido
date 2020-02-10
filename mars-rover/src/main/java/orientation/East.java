package orientation;

import orientation.Orientation;

public class East extends Orientation {
    @Override
    public Orientation rotateLeft() {
       return new North();
    }

    @Override
    public Orientation rotateRight() {
        return new South();
     }
}
