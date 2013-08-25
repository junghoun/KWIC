/**
 * Created with IntelliJ IDEA.
 * User: ryandao
 * Date: 8/25/13
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.util.Scanner;
public class CLI {

	private ArrayList<String> titles;
	private ArrayList<String> ignoredWords;

	public CLI(){
		titles = new ArrayList<String>();
		ignoredWords = new ArrayList<String>();
	}

    public void readInput(){
    	int choice = -1;
    	while (choice != 3) {
    		printMainMenu();
	        choice = readSelection();
	        switch (choice) {
	            case 1: enterTitle();
	            		break;
	            case 2: enterWordsToIgnore();
	            		break;
	            case 3: goodbyeMessage();
	            		break;
	            default: errorMessage();
	            		break;
	        }
	    }
    }

    public void errorMessage(){
    	System.out.println("Choice must be between 1 and 3");
    }

    public void goodbyeMessage(){
    	System.out.println("Waiting for result...");
    }

    public void printMainMenu(){
    	System.out.println("Welcome to KWIC");
    	System.out.println("1. Add a new title");
    	System.out.println("2. Add a new word to ignore");
    	System.out.println("3. Show result");
    	System.out.print("Please enter your choice: ");
    }

    public int readSelection(){
    	int selection = -1;
    	Scanner input = new Scanner(System.in);
    	selection = input.nextInt();

    	return selection;
    }

    public void enterTitle(){
    	String title = "";
    	while(!title.equalsIgnoreCase("q")){
    		System.out.print("Please enter the new title (press q to go back): ");
        	Scanner input = new Scanner(System.in);
        	title = input.nextLine();
        	if (!title.equalsIgnoreCase("q")) addTitle(title);
    	}
    }

	  public void enterWordsToIgnore(){
  		String word = "";
  		while (!word.equalsIgnoreCase("q")){
	    	System.out.print("Please enter the new word to ignore (press q to go back): ");
	    	Scanner input = new Scanner(System.in);
	    	word = input.nextLine();
	    	if (!word.equalsIgnoreCase("q")) addWordsToIgnore(word);
  		}
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

    public void displayOutput(ArrayList <ArrayList<String>> result){
    	for (int i = 0; i < result.size(); i++) {
    	  String title = "";
    	  for (int j = 0; j < result.get(i).size(); j++) {
    	    title += result.get(i).get(j) + " ";
    	  }

    	  System.out.println(title);
    	}
    }
}