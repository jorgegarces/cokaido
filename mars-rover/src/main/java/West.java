public class West extends Orientation {
    @Override
    Orientation rotateLeft() {
        return new South();
    }

    @Override
    Orientation rotateRight() {
         return new North();
     }

}
