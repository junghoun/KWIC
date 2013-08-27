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
      if ( ! this.isBlackListed(sentence.get(0))) {
        result.add(sentence) ;
      }

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

    this.caseProcessing(result);
    return result;
  }

  private void caseProcessing(ArrayList<ArrayList<String>> words) {
    for (int i = 0; i < words.size(); i++) {
      for (int j = 0; j < words.get(i).size(); j ++) {
        String word = words.get(i).get(j);
        if (this.isBlackListed(word)) {
          // Convert blacklisted word to lowercase
          String lowerCase = word.toLowerCase();
          words.get(i).set(j, lowerCase);
        } else {
          // Convert key word to uppercase first letter
          String upperCase = word.substring(0, 1).toUpperCase() + word.substring(1);
          words.get(i).set(j, upperCase);
        }
      }
    }
  }

  private boolean isBlackListed(String word) {
    for (int i = 0; i < this.blacklist.size(); i++) {
      if (this.blacklist.get(i).toLowerCase().equals(word)) {
        return true;
      }
    }

    return false;
  }
}
