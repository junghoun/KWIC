
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

//        String[] test = {"The Day after Tomorrow", "Fast and Furious"};
//        String[] blacklist = {"after", "and"};
        // Pass to Characters to process input
        Characters characters = new Characters(cli.getTitles());

//        Characters characters = new Characters(new ArrayList<String>(Arrays.asList(test)));

        // Pass to CircularShift to do shifting
//        CircularShifts circularShifts = new CircularShifts(characters.getWords(), new ArrayList<String>(Arrays.asList(blacklist)));
        CircularShifts circularShifts = new CircularShifts(characters.getWords(), cli.getIgnoredWords());
        circularShifts.getShifts();
        // Pass to AlphabeticalShift to do ordering
        //AlphabeticalShifts alphabeticalShifts = new AlphabeticalShifts(circularShifts.getShifts());

        // Display to output
    }
}