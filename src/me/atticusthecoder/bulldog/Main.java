package me.atticusthecoder.bulldog;

public class Main {
	public static Bulldog bulldog;
	public static boolean DEBUG_MODE = false;
	public static void main(String[] args) {
		
		if(args == null || args.length == 0) {
			System.out.println("Required Arguments: Discord Bot Token");
			System.exit(1);
		}
		
		// Then start the program
		bulldog = new Bulldog();
		bulldog.start(args[0]);
	}
	
	public static Bulldog getBot() {
		return bulldog;
	}
}
