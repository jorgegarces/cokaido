public class East extends Orientation {
    @Override
    Orientation rotateLeft() {
       return new North();
    }

    @Override
    Orientation rotateRight() {
        return new South();
     }
}
