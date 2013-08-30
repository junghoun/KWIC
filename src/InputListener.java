/**
 * Interface for input listeners. The list of events includes:
 *   * Line added
 *   * Ignored word added
 *   * Input finished
 *
 */
public interface InputListener {
  public void handleLineAddedEvent(String line);

  public void handleIgnoreWordAddedEvent(String word);

  public void handleInputFinishedEvent();
}
