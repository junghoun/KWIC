/**
 * Created with IntelliJ IDEA.
 * User: ryandao
 * Date: 8/25/13
 * Time: 3:00 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class LineStorage {
  private ArrayList<String> lines;
  private ArrayList<ArrayList<String>> words;

  public LineStorage() {
    this.lines = new ArrayList<String>();
    this.words = new ArrayList<ArrayList<String>>();
  }

  public LineStorage(ArrayList <String> lines) {
    this.lines = lines;
    this.words = this.splitLines(lines);
  }

  public ArrayList <ArrayList <String>> getWords() {
    return words;
  }

  public void addLine(String line) {
    this.lines.add(line);
    this.words.add(this.splitLine(line));
  }

  /**
   * Split the given array of lines into a 2-D array of words.
   * For example: ["The Day after Tomorrow", "Fast and Furious"] will become
   * [["The", "Day", "after", "Tomorrow"], ["Fast", "and", "Furious"]].
   *
   * @return the 2-D ArrayList of words.
   */
  private ArrayList<ArrayList<String>> splitLines(ArrayList<String> lines) {
    ArrayList <ArrayList <String>> result = new ArrayList <ArrayList<String>>();

    for (int i = 0; i < lines.size(); i ++) {
      result.add(this.splitLine(lines.get(i)));
    }

    return result;
  }

  /**
   * Split the given string into an ArrayList of words
   *
   * @param line
   * @return the ArrayList of words
   */
  private ArrayList<String> splitLine(String line) {
    return new ArrayList<String>(Arrays.asList(line.split(" ")));
  }
}
