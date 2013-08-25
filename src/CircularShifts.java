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
    ArrayList <String> blacklist;

    public CircularShifts(ArrayList <ArrayList <String>> words, ArrayList <String> blacklist) {
        this.words = words;
        this.blacklist = blacklist;
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
              if (! this.isBlackListed(clone.get(0))) {
                result.add(clone);
              }
              sentence = clone;
          }
        }

        return result;
    }

    public boolean isBlackListed(String word) {
      for (int i = 0; i < this.blacklist.size(); i++) {
        if (this.blacklist.get(i).toLowerCase().equals(word)) {
          return true;
        }
      }

      return false;
    }
}
