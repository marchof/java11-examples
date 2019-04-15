package java11.processes;

/**
 * Print my PID.
 * 
 * @see ProcessHandle#current()
 * @see ProcessHandle#pid()
 */
public class MyPid {

	public static void main(String[] args) {
		// %[// TODO: Add solution here
		System.out.println(ProcessHandle.current().pid());
		// ]%
	}

}
