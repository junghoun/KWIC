import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * This class handles sorting the circular shifts and provides
 * abstracted access to the sorted shifts.
 *
 */
public class Alphabetizer {
  private CircularShifter circularShifter;
  private Integer[] orderedIndices;

  public Alphabetizer(CircularShifter circularShifter) {
    this.circularShifter = circularShifter;
    this.orderedIndices = this.alphabetize(circularShifter.getFirstWords());
  }

  /**
   * Get the ordered shifts based on the sorted indices.
   *
   * @return ArrayList<ArrayList<String>> representation of the ordered shifts.
   */
  public ArrayList<ArrayList<String>> getOrderedShifts() {
    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

    for (Integer i : orderedIndices) {
      result.add(circularShifter.getShift(i));
    }

    return result;
  }

  /**
   * Sort a given set of words and return an array of sorted indices
   *
   * @param words
   * @return array of sorted indices
   */
  private Integer[] alphabetize(ArrayList<String> words) {
    Integer[] indexArray = new Integer[words.size()];

    for (int i = 0; i < words.size(); i ++) {
      indexArray[i] = i;
    }

    Arrays.sort(indexArray, new ArrayIndexComparator(words));

    return indexArray;
  }

  /**
   * Helper comparator that compares integers based on the values
   * of the items in a string array that have the integers as keys.
   *
   */
  class ArrayIndexComparator implements Comparator<Integer> {
    ArrayList<String> array;

    public ArrayIndexComparator(ArrayList<String> array) {
      this.array = array;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
      return array.get(o1).compareTo(array.get(o2));
    }
  }
}
