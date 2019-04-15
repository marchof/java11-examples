package java11.processes;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Kills the processes with the provided PIDs.
 * 
 * @see ProcessHandle#of(long)
 * @see ProcessHandle#destroyForcibly()
 */
public class Kill {

	public static void main(String[] args) {
		// %[// TODO: Add solution here
		Stream.of(args) //
				.mapToLong(Long::valueOf) //
				.mapToObj(ProcessHandle::of) //
				.flatMap(Optional::stream) //
				.forEach(ProcessHandle::destroyForcibly);
		// ]%
	}

}
