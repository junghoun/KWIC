import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: ryandao
 * Date: 8/25/13
 * Time: 3:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class CircularShifts {
    ArrayList <ArrayList <String>> words;

    public CircularShifts(ArrayList <ArrayList <String>> words) {
        this.words = words;
    }

    public ArrayList <ArrayList<String>> getShifts() {
        ArrayList <ArrayList<String>> result = new ArrayList <ArrayList<String>>();

        for (int i = 0; i < this.words.size(); i ++) {
          ArrayList <String> sentence = this.words.get(i);
          result.add(sentence);

          for (int j = 1; j < sentence.size(); j ++) {
              ArrayList <String> clone = new ArrayList<String>(sentence);
              Collections.rotate(clone, -1);

              // Check if the first word is not a blacklisted word

              result.add(clone);
              sentence = clone;
            }
        }

        return result;
    }
}
