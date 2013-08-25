/**
 * Created with IntelliJ IDEA.
 * User: ryandao
 * Date: 8/25/13
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class CLI {
    // Read input
    public void readInput(){
    	while (true) {
	        printMainMenu();
	        choice = readSelection();   //
	        switch (choice) {
	            case 0: exit();
	            case 1: foo();
	            case 2: bar();
	            default: print("Wrong choice");
	        }
	    }
    }

    public int readSelection(){
    	public int selection;
    	return selection;
    }
}
