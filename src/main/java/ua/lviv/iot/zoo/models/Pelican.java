package ua.lviv.iot.zoo.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import ua.lviv.iot.zoo.enums.FeedType;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor

public final class Pelican extends Bird {
	public Pelican(final String species, final Integer massInKg, final Double feedPerDayInKg,
			final FeedType feedType, final Integer ageInYears, final String animalType,
			final Boolean isMigratory, final Integer wingsSizeInCm) {
		super(species, massInKg, feedPerDayInKg, feedType, 
			  ageInYears, animalType, isMigratory,wingsSizeInCm);
	}
	private Integer id;
}
