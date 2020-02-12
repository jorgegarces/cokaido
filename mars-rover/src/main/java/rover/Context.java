package rover;

public class Context {
    RoverState state;

    public Context() {
        this.state = new Ground();
    }

    public void setState(RoverState newState) {
        this.state = newState;
    }

    public RoverState getState() {
        return state;
    }
}
