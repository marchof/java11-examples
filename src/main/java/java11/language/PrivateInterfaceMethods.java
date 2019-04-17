package java11.language;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Interfaces can now contain private methods to share common code in default
 * methods.
 */
public class PrivateInterfaceMethods {

	interface Controller {
		
		// TODO extract common code

		default void start() {
			String ts = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
			System.out.println("started at " + ts);
		}

		default void stop() {
			String ts = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
			System.out.println("stopped at " + ts);
		}
		
	}

	public static void main(String[] args) {
		Controller controller = new Controller() {
		};
		
		controller.start();
		controller.stop();
	}

}
