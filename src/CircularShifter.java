import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: ryandao
 * Date: 8/25/13
 * Time: 3:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class CircularShifter {
  private LineStorage lineStorage;
  private ArrayList<String> blacklist;
  private ArrayList<ArrayList<String>> shifts;

  public CircularShifter(LineStorage lineStorage, ArrayList <String> blacklist) {
    this.lineStorage = lineStorage;
    this.blacklist = blacklist;
    this.shifts = this.shiftsForLines(lineStorage.getWords());
  }

  public ArrayList<ArrayList<String>> getShifts() {
    return this.shifts;
  }

  private ArrayList<ArrayList<String>> shiftsForLine(ArrayList<String> words) {
    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

    // Add the original line if it's not blacklisted
    if ( ! this.isBlackListed(words.get(0))) {
      result.add(words) ;
    }

    for (int j = 1; j < words.size(); j ++) {
      // Shifting
      ArrayList <String> clone = new ArrayList<String>(words);
      Collections.rotate(clone, -1);

      // Add the shift if it's not blacklisted
      if (! this.isBlackListed(clone.get(0))) {
        result.add(clone);
      }

      words = clone;
    }

    this.caseProcessing(result);
    return result;
  }

  private ArrayList<ArrayList<String>> shiftsForLines(ArrayList<ArrayList<String>> lines) {
    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

    for (int i = 0; i < lines.size(); i ++) {
      ArrayList<String> words = lines.get(i);
      for (ArrayList<String> shift : this.shiftsForLine(words)) {
        result.add(shift);
      }
    }

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