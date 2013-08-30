import java.util.ArrayList;
import java.util.Collections;

/**
 * This class provides an abstraction layer for all the circular shifts
 * of the input lines. It contains a number of functions that give access
 * to the circular shift information.
 *
 */
public class CircularShifter {
  private LineStorage lineStorage;
  private ArrayList<String> blacklist;
  private ArrayList<ArrayList<String>> shifts;

  public CircularShifter(LineStorage lineStorage, ArrayList<String> blacklist) {
    this.lineStorage = lineStorage;
    this.blacklist = blacklist;
    this.shifts = this.shiftsForLines(lineStorage.getWords());
  }

  /**
   * Get the first words of all the circular shifts.
   *
   * @return ArrayList of first words
   */
  public ArrayList<String> getFirstWords() {
    ArrayList<String> result = new ArrayList<String>();

    for (int i = 0; i < this.getSize(); i ++) {
      result.add(this.getShift(i).get(0));
    }

    return result;
  }

  /**
   * Get the shift stored at a given position
   *
   * @param position
   * @return ArrayList<String> representation of the desired shift
   */
  public ArrayList<String> getShift(int position) {
    return this.shifts.get(position);
  }

  public int getSize() {
    return this.shifts.size();
  }

  /**
   * Generate all the possible circular shifts for a given line containing a set of words.
   * The list of shifts excludes the ones with blacklisted first words.
   *
   * @param words
   * @return ArrayList<ArrayList<String>> representation of all shifts
   */
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

  /**
   * Generate all the possible circular shifts for a set of lines
   *
   * @param lines
   * @return ArrayList<ArrayList<String>> representation of all shifts
   */
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

  /**
   * Process the case of each word in a set of shifts.
   * If a word is blacklisted, it will be lowercase.
   * Otherwise, its first letter will be uppercase.
   *
   * @param words
   */
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

  /**
   * Check if a word is blacklisted.
   *
   * @param word
   * @return true if blacklisted, false otherwise
   */
  private boolean isBlackListed(String word) {
    for (int i = 0; i < this.blacklist.size(); i++) {
      if (this.blacklist.get(i).toLowerCase().equals(word)) {
        return true;
      }
    }

    return false;
  }
}
