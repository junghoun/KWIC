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
    	while (choice != 4) {
	        printMainMenu();
	        choice = readSelection();
	        switch (choice) {
	            case 1: enterTitle();
	            		break;
	            case 2: enterWordsToIgnore();
	            		break;
	            case 3: makeList();
	            		break;
	            case 4: goodbyeMessage();
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
    	System.out.println("See you again");
    }

    public void printMainMenu(){
    	System.out.println("Welcome to KWIC");
    	System.out.println("1. Add a new title");
    	System.out.println("2. Add a new word to ignore");
    	System.out.println("3. Show the shorted list");
    	System.out.println("4. Exit");
    	System.out.print("Please enter your choice: ");
    }

    public int readSelection(){
    	int selection = -1;
    	Scanner input = new Scanner(System.in);
		selection = input.nextInt();
    	return selection;
    }

    public void enterTitle(){
    	System.out.print("Please enter the new title: ");
    	Scanner input = new Scanner(System.in);
    	String title = input.nextLine();
    	addTitle(title);
    }

	  public void enterWordsToIgnore(){
    	System.out.print("Please enter the new word to ignore: ");
    	Scanner input = new Scanner(System.in);
    	String word = input.nextLine();
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

    public void makeList(){
    	//Show the shorted list
    }

}