package designpatternscommand.abstractions;

public interface Command {
    
    public void execute();
    public void undo();
}
