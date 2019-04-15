package java11.processes;

import java.lang.ProcessHandle.Info;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Print the tree of local processes.
 *
 * @see ProcessHandle#allProcesses()
 * @see ProcessHandle#children()
 */
public class PS {

	public static void main(String[] args) {
		// %[// TODO: Add solution here
		Set<ProcessHandle> all = ProcessHandle.allProcesses().collect(Collectors.toSet());

		Set<ProcessHandle> roots = new HashSet<>(all);
		all.forEach(p -> p.children().forEach(roots::remove));

		roots.stream().sorted().forEach(p -> print(p, ""));
		// ]%
	}

	// %[
	static void print(ProcessHandle p, String indent) {
		Info info = p.info();
		System.out.printf("%s%s %s %s%n", indent, p.pid(), toString(info.user()), toString(info.command()));
		p.children().sorted().forEach(c -> print(c, indent + "  "));
	}

	static String toString(Optional<String> optional) {
		return String.valueOf(optional.orElse("-"));
	}

	// ]%
}
