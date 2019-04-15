package java11.util;

// %[import java.util.ArrayList;
// %[import java.util.Collections;
// %[import java.util.HashMap;
// %[import java.util.HashSet;
// ]%
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Create immutable Sets, Lists and Maps.
 * 
 * @see java.util.Set#of();
 * @see java.util.List#of();
 * @see java.util.Map#of();
 * @see java.util.List#copyOf(java.util.Collection);
 */
public class ImmutableFactories {

	// %[// TODO: Replace with new factory method
	// %[public static final List<String> IC2000_TRAIN;
	// %[static {
	// %[ List<String> tmp = new ArrayList<>();
	// %[ tmp.add("RE460");
	// %[ tmp.add("A");
	// %[ tmp.add("A");
	// %[ tmp.add("BR");
	// %[ tmp.add("B");
	// %[ tmp.add("B");
	// %[ tmp.add("B");
	// %[ tmp.add("Bt");
	// %[ IC2000_TRAIN = Collections.unmodifiableList(tmp);
	// %[}
	public static final List<String> IC2000_TRAIN = List.of("RE460", "A", "A", "BR", "B", "B", "B", "Bt");
	// ]%

	// %[// TODO: Replace with new factory method
	// %[public static final Set<String> SERVICE_TYPES;
	// %[static {
	// %[ Set<String> tmp = new HashSet<>();
	// %[ tmp.add("IC");
	// %[ tmp.add("RE");
	// %[ tmp.add("S");
	// %[ tmp.add("Tram");
	// %[ tmp.add("Bus");
	// %[ tmp.add("Ship");
	// %[ SERVICE_TYPES = Collections.unmodifiableSet(tmp);
	// %[}
	public static final Set<String> SERVICE_TYPES = Set.of("IC", "RE", "S", "Tram", "Bus", "Ship");
	// ]%

	// %[// TODO: Replace with new factory method
	// %[public static final Map<String, Integer> POWER_KW;
	// %[static {
	// %[ Map<String, Integer> tmp = new HashMap<>();
	// %[ tmp.put("RE420", 3700);
	// %[ tmp.put("RE460", 6100);
	// %[ tmp.put("RE620", 7237);
	// %[ POWER_KW = Collections.unmodifiableMap(tmp);
	// %[}
	public static final Map<String, Integer> POWER_KW = Map.of("RE420", 3700, "RE460", 6100, "RE620", 7237);
	// ]%
	
	
	private List<String> formation;
	
	public void setFormation(List<String> formation) {
		// %[// TODO: Use new factory method
		// %[this.formation = Collections.unmodifiableList(new ArrayList<String>(formation));
		this.formation = List.copyOf(formation);
		// ]%
	}
	
	public List<String> getFormation() {
		return this.formation;
	}

}
