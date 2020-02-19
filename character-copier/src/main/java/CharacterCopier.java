public class CharacterCopier {

    private final ISource source;
    private final IDestination destination;

    public CharacterCopier(ISource source, IDestination destination) {
        this.source = source;
        this.destination = destination;
    }

    public void copy() {
        destination.setChar(source.getChar());
    }
}
