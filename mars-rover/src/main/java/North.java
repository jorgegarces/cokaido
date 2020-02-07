public class North extends Orientation {
    @Override
    Orientation rotateLeft() {
        return new West();
    }

    @Override
    Orientation rotateRight() {
       return new East();
     }
}
