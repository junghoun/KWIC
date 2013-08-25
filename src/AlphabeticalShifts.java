import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: ryandao
 * Date: 8/25/13
 * Time: 3:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class AlphabeticalShifts {
    ArrayList <ArrayList <String>> shifts;

    public AlphabeticalShifts(ArrayList <ArrayList <String>> shifts) {
        this.shifts = shifts;
    }

    public ArrayList <ArrayList<String>> getOrderedShifts() {
        Collections.sort(this.shifts, new Comparator<ArrayList<String>>() {
          @Override
          public int compare(ArrayList<String> s1, ArrayList<String> s2) {
            return (s1.get(0).compareTo(s2.get(0)));
          }
        });

        return this.shifts;
    }
}
