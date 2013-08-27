import java.util.ArrayList;


public class Input implements LineAddedListener, IgnoredWordAddedListener {
  private ArrayList<String> titles;
  private ArrayList<String> ignoredWords;

  public Input() {
    titles = new ArrayList<String>();
    ignoredWords = new ArrayList<String>();
  }

  @Override
  public void handleLineAddedEvent(String line) {
    addTitle(line);
  }

  @Override
  public void handleIgnoreWordAddedEvent(String word) {
    addWordsToIgnore(word);
  }

  public void addTitle(String title){
    titles.add(title);
  }

  public void addWordsToIgnore(String word){
    ignoredWords.add(word);
  }

  public ArrayList<String> getTitles(){
    return titles;
  }

  public ArrayList<String> getIgnoredWords(){
    return ignoredWords;
  }


}
