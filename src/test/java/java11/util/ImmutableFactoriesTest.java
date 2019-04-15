package java11.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ImmutableFactoriesTest {

	@Test
	void contant_list_should_be_immutable() {
		assertThrows(UnsupportedOperationException.class, () -> ImmutableFactories.IC2000_TRAIN.add("RE420"));
	}

	@Test
	void contant_set_should_be_immutable() {
		assertThrows(UnsupportedOperationException.class, () -> ImmutableFactories.SERVICE_TYPES.add("Airplain"));
	}

	@Test
	void contant_map_should_be_immutable() {
		assertThrows(UnsupportedOperationException.class, () -> ImmutableFactories.POWER_KW.put("Horse", 1));
	}

	@Test
	void setFormation_should_create_copy() {
		ImmutableFactories f = new ImmutableFactories();
		List<String> value = new ArrayList<>();
		value.add("A");
		value.add("B");
		value.add("C");

		f.setFormation(value);
		
		value.add("D");
		assertEquals(List.of("A", "B", "C"), f.getFormation());
	}
	
	@Test
	void getFormation_should_return_immutable_list() {
		ImmutableFactories f = new ImmutableFactories();
		List<String> value = new ArrayList<>();
		value.add("A");
		f.setFormation(value);
		
		assertThrows(UnsupportedOperationException.class, () -> f.getFormation().add("B"));
	}

}
