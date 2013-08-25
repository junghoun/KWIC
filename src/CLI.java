/**
 * Created with IntelliJ IDEA.
 * User: ryandao
 * Date: 8/25/13
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.Scanner;
public class CLI {
    
	private ArrayList<String> titles;
	private ArrayList<String> ignoredWords;

	public CLI(){
		titles = new ArrayList<String>;
		ignoredWords = new ArrayList<String>;
	}

    public void readInput(){
    	while (true) {
	        printMainMenu();
	        choice = readSelection(); 
	        switch (choice) {
	            case 1: enterTitle();
	            		break;
	            case 2: enterWordsToIgnore();
	            		break;
	            case 3: makeList();
	            		break;
	            default: errorMessage();
	            		break;
	        }
	    }
    }

    public void errorMessage(){
    	System.out.println("Choice must be between 1 and 3");
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

    public void addTitle(title){
    	titles.add(title);
    }

    public void addWordsToIgnore(word){
    	ignoredWords.add(word);
    }

    public void getTitles(){
    	return titles;
    }

    public void getIgnoredWords(){
    	return ignoredWords;
    }

}















