/**
 * Created with IntelliJ IDEA.
 * User: ryandao
 * Date: 8/25/13
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
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
    CircularShifter circularShifts = new CircularShifter(lineStorage, input.getIgnoredWords());

    // Pass to AlphabeticalShift to do ordering
    AlphabeticalShifts alphabeticalShifts = new AlphabeticalShifts(circularShifts.getShifts());

    // Display to output
    cli.displayOutput(alphabeticalShifts.getOrderedShifts());
  }
}