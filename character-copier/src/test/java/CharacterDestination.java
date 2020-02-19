public class CharacterDestination implements IDestination {

    public char charCopy;

    public char getCharCopy() {
        return charCopy;
    }

    @Override
    public void setChar(char character) {
        charCopy = character;
    }
}
