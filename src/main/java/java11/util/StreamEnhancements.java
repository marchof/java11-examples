package java11.util;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StreamEnhancements {

	public static List<String> filterBlankItems(List<String> items) {
		return items.stream() //
				// TODO: Replace with method reference
				.filter(s -> !s.isBlank()) //
				.collect(toList());
	}

	public static int getTotalPower(List<String> formation) {
		return formation.stream() //
				.map(StreamEnhancements::getPowerKW) //
				// TODO: Replace with flatMap()
				.filter(Optional::isPresent) //
				.mapToInt(Optional::get) //
				.sum();
	}

	private static Optional<Integer> getPowerKW(String type) {
		return Optional.ofNullable(POWER_KW.get(type));
	}

	private static final Map<String, Integer> POWER_KW = Map.of("RE420", 3700, "RE460", 6100, "RE620", 7237);

}
