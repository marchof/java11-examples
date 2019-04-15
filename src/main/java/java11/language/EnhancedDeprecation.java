package java11.language;

/**
 * Deprecated APIs can now be timestamped and marked for removal.
 */
public class EnhancedDeprecation {

	// TODO this API is deprecated since 3.12 and marked for removal
	@Deprecated
	public static void wasAnMistakeAtTheTime() {
	}
	
	// TODO find usage of deprecated APIs with jdeprscan
	@SuppressWarnings("removal")
	public static void usesDeprecatedMethod() {
		Thread.currentThread().countStackFrames();
	}
	
}
