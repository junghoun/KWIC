
public class MasterControl {
  public static void main(String[] args) {
    // Initialization
    LineStorage lineStorage = new LineStorage();
    CLI cli = new CLI();

    // Set up input listeners
    Input input = new Input(lineStorage);
    cli.addLineAddedListener(input);
    cli.addIgnoredWordListener(input);

    // Start the UI
    cli.start();

    // Pass to CircularShifter to do shifting
    CircularShifter circularShifter = new CircularShifter(lineStorage, input.getIgnoredWords());

    // Pass to AlphabeticalShift to do ordering
    Alphabetizer alphabetizer = new Alphabetizer(circularShifter);

    // Display to output
    cli.displayOutput(alphabetizer.getOrderedShifts());
  }
}