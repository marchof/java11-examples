package java11.language;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

/**
 * Local variables can now be declared with "var".
 * 
 * See http://openjdk.java.net/projects/amber/LVTIstyle.html
 */
public class LocalVariableTypeInference {

	// TODO: replace local variable declarations where possible

	String example1() {
		List<String> ids = new ArrayList<>();
		ids.add("aaa");
		ids.add("bbb");
		ids.add("ccc");
		return ids.toString();
	}
	
	int example2(int a, int b) {
		return a + b;
	}
	
	byte[] example3(String filename) throws IOException {
		try (FileInputStream in = new FileInputStream(filename)) {
			return in.readAllBytes();
		}
	}

	List<String> example4() {
		List<String> ids = new ArrayList<>();
		ids.add("aaa");
		ids.add("bbb");
		ids.add("ccc");
		return ids;
	}

	int example5() {
		int x;
		x = 42;
		return x;
	}

	Object example6() {
		Object none = null;
		return none;
	}

	DayOfWeek example7() {
		final DayOfWeek day = DayOfWeek.WEDNESDAY;
		return day;
	}

	int example8() {
		class Holder {
		 int a;
		 int b;
		}
		Holder h = new Holder();
		h.a = 17;
		h.b = 25;
		return h.a + h.b;
	}

	void example9() throws Exception {
		Object object = getIntersectionType();
		((CharSequence) object).charAt(5);
		((AutoCloseable) object).close();
	}

	<T extends CharSequence & AutoCloseable> T getIntersectionType() {
		return null;
	}

}
