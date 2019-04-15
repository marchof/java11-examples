package java11.language;

/**
 * Deprecated APIs can now be timestamped and marked for removal.
 */
public class EnhancedDeprecation {

	// %[// TODO this API is deprecated since 3.12 and marked for removal
	// %[@Deprecated
	@Deprecated(forRemoval=true, since="3.14")
	// ]%
	public static void wasAnMistakeAtTheTime() {
	}
	
	// %[// TODO find usage of deprecated APIs with jdeprscan
	// jdeprscan ./target/classes
	// ]%
	public static void usesDeprecatedMethod() {
		Thread.currentThread().countStackFrames();
	}
	
}
