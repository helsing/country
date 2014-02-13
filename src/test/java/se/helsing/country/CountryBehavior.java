package se.helsing.country;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.google.common.testing.*;

public class CountryBehavior {

	@Test
	public void shouldCreateValidCountries() {
		new Country("SE");
		new Country("GB");
	}
	
	@Test
	public void shouldReportCorrectCountryCode() {
		assertThat(new Country("SE").getCode(), equalTo("SE"));
	}
	
	@Test
	public void shouldReportCorrectCountryName() {
		assertThat(new Country("US").toString(), containsString("United States"));
		assertThat(new Country("GB").toString(), containsString("United Kingdom"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void shouldRejectCreationOfInvalidCountry() {
		new Country("ZX");
	}
	
	@Test
	public void shouldImplementEquality() {
		new EqualsTester()
			.addEqualityGroup(new Country("DM"), new Country("DM") )
			.addEqualityGroup(new Country("SL"), new Country("SL"))
			.addEqualityGroup(new Country("SE"), new Country("SE"))
			.testEquals();
	}
	
	
}
