package java11.tools;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Simple utility to filter all sections from sources files marked with
 * 
 * <pre>
 * // %[
 * filteredContent();
 * // ]%
 * </pre>
 */
public class FilterSolutions {

	private static final Path SRC_DIR = Path.of("src/main/java");
	private static final Path DEST_DIR = Path.of("target/filtered/main/java");

	private static final Set<String> SRC_EXTENSIONS = Set.of(".java");

	private static final Charset SRC_ENCODING = StandardCharsets.UTF_8;

	private static final Pattern SOLUTION_START = Pattern.compile("(\\s*)// %\\[(.*)");
	private static final Pattern SOLUTION_END = Pattern.compile("(\\s*)// \\]%(.*)");

	public static void main(String[] args) throws IOException {
		Files.walk(SRC_DIR) //
				.filter(Files::isRegularFile) //
				.filter(FilterSolutions::isSourceFile) //
				.forEach(FilterSolutions::filter);
	}

	private static boolean isSourceFile(Path file) {
		return SRC_EXTENSIONS.stream().anyMatch(ext -> file.toString().endsWith(ext));
	}

	private static void filter(Path source) {
		File dest = DEST_DIR.resolve(SRC_DIR.relativize(source)).toFile();
		dest.getParentFile().mkdirs();
		try (PrintWriter out = new PrintWriter(dest)) {
			boolean mute = false;
			for (String line : Files.readAllLines(source, SRC_ENCODING)) {
				if (matchMarker(SOLUTION_START, line, out)) {
					mute = true;
					continue;
				}
				if (matchMarker(SOLUTION_END, line, out)) {
					mute = false;
					continue;
				}
				if (!mute) {
					out.println(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean matchMarker(Pattern pattern, String line, PrintWriter out) {
		Matcher matcher = pattern.matcher(line);
		if (matcher.matches()) {
			line = matcher.group(1) + matcher.group(2);
			if (!line.isBlank()) {
				out.println(line);
			}
			return true;
		}
		return false;
	}

}
