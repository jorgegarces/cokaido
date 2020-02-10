package orientation;

public abstract class Orientation {

    public static Orientation create(char cardinal) {
        if (cardinal == 'N') return new North();
        if (cardinal == 'E') return new East();
        if (cardinal == 'S') return new South();
        if (cardinal == 'W') return new West();
        return null;
    }

    public abstract Orientation rotateLeft();

    public abstract Orientation rotateRight();

}