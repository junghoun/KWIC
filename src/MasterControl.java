import java.util.ArrayList;


public class MasterControl implements InputListener {
  private CLI cli;
  private ArrayList<String> wordsToIgnore;
  private LineStorage lineStorage;
  private CircularShifter circularShifter;
  private Alphabetizer alphabetizer;

  public MasterControl() {
    this.lineStorage = new LineStorage();
    this.cli = new CLI();
    this.wordsToIgnore = new ArrayList<String>();
  }

  public void start() {
    // Add input listener
    cli.addInputListener(this);

    // Start the UI
    cli.start();
  }

  @Override
  public void handleLineAddedEvent(String line) {
    lineStorage.addLine(line);
  }

  @Override
  public void handleIgnoreWordAddedEvent(String word) {
    wordsToIgnore.add(word);
  }

  @Override
  public void handleInputFinishedEvent() {
    // Pass to CircularShifter to do shifting
    circularShifter = new CircularShifter(lineStorage, wordsToIgnore);

    // Pass to AlphabeticalShift to do ordering
    alphabetizer = new Alphabetizer(circularShifter);

    // Display to output
    cli.displayOutput(alphabetizer.getOrderedShifts());
  }
}