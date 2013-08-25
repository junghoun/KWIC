/**
 * Created with IntelliJ IDEA.
 * User: ryandao
 * Date: 8/25/13
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.Scanner;
public class CLI {
    // Read input
    public void readInput(){
    	while (true) {
	        printMainMenu();
	        choice = readSelection(); 
	        switch (choice) {
	            case 1: addSentence();
	            		break;
	            case 2: addWordsToIgnore();
	            		break;
	            case 3: makeList();
	            		break;
	            default: print("Choice must be between 1 and 3");
	            		break;
	        }
	    }
    }

    public int readSelection(){    	
    	int selection = -1;
    	Scanner input = new Scanner(System.in);		
		selection = input.nextInt();
    	return selection;
    }

}
