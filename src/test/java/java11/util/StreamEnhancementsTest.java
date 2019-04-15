package java11.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class StreamEnhancementsTest {
	
	@Test
	void filterBlankItems_should_filter_blank_items() {
		var result = StreamEnhancements.filterBlankItems(List.of("a", " ", "b", "", "      ", "c"));
		assertEquals(List.of("a", "b", "c"), result);
	}

	@Test
	void getTotalPower_should_ignore_unkown_types() {
		assertEquals(9800, StreamEnhancements.getTotalPower(List.of("RE460", "RE420", "A", "B")));
	}
	
}
