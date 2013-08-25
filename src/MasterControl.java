/**
 * Created with IntelliJ IDEA.
 * User: ryandao
 * Date: 8/25/13
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class MasterControl {
  public static void main(String[] args) {
    // Read input
    CLI cli = new CLI();
    cli.readInput();

    // Pass to Characters to process input
    Characters characters = new Characters(cli.getTitles());

    // Pass to CircularShift to do shifting
    CircularShifts circularShifts = new CircularShifts(characters.getWords(), cli.getIgnoredWords());

    // Pass to AlphabeticalShift to do ordering
    AlphabeticalShifts alphabeticalShifts = new AlphabeticalShifts(circularShifts.getShifts());

    // Display to output
    cli.displayOutput(alphabeticalShifts.getOrderedShifts());
  }
}