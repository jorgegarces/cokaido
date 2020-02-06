public class Position {

    int positionX;
    int positionY;
    char orientation;

    public Position(int positionX, int positionY, char orientation) {

        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    void rotateLeft() {
        if (orientation == 'N') orientation = 'W';
        else if (orientation == 'E') orientation = 'N';
        else if (orientation == 'S') orientation = 'E';
        else if (orientation == 'W') orientation = 'S';
    }

    void rotateRight() {
        if (orientation == 'N') orientation = 'E';
        else if (orientation == 'E') orientation = 'S';
        else if (orientation == 'S') orientation = 'W';
        else if (orientation == 'W') orientation = 'N';
    }

    void moveForward() {
        if (orientation == 'N') positionY = positionY + 1;
        if (orientation == 'E') positionX = positionX + 1;
        if (orientation == 'S') positionY = positionY - 1;
        if (orientation == 'W') positionX = positionX - 1;
    }

    void moveBackwards() {
        if (orientation == 'N') positionY = positionY - 1;
        if (orientation == 'E') positionX = positionX - 1;
        if (orientation == 'S') positionY = positionY + 1;
        if (orientation == 'W') positionX = positionX + 1;
    }
}