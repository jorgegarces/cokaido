public class South extends Orientation {
    @Override
    Orientation rotateLeft() {
        return new East();
    }

    @Override
    Orientation rotateRight() {
         return new West();
     }
}
