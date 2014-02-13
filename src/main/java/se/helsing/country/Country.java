package se.helsing.country;

import java.util.*;

import org.apache.commons.lang3.builder.*;

/**
 * Represents a country as defined by ISO 3166-1.
 * 
 * @author Patrik
 *
 */
public class Country {

	// Global constant
	private static final Set<String> ISO_COUNTRIES = new HashSet<>(Arrays.asList(Locale.getISOCountries()));

	// Member
	private final String code;
	
	public Country(String code) {
		if (!ISO_COUNTRIES.contains(code)) {
			throw new IllegalArgumentException(code + " is not a valid ISO 3166-1 country code");
		}
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(code)
			.append("(")
			.append(new Locale("", code).getDisplayCountry(Locale.US))
			.append(")");
		return sb.toString();
	}
}
