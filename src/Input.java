import java.util.ArrayList;


public class Input implements LineAddedListener, IgnoredWordAddedListener {
  private LineStorage lineStorage;
  private ArrayList<String> ignoredWords;

  public Input(LineStorage lineStorage) {
    this.lineStorage = lineStorage;
    ignoredWords = new ArrayList<String>();
  }

  @Override
  public void handleLineAddedEvent(String line) {
    lineStorage.addLine(line);
  }

  @Override
  public void handleIgnoreWordAddedEvent(String word) {
    this.addWordsToIgnore(word);
  }

  public ArrayList<String> getIgnoredWords(){
    return ignoredWords;
  }

  private void addWordsToIgnore(String word){
    ignoredWords.add(word);
  }
}
