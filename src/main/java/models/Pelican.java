package models;

import enums.FeedType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@Data
@ToString(callSuper = true)
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
@NoArgsConstructor

public final class Pelican extends Bird {
	public Pelican(final String species, final Integer massInKg, final Double feedPerDayInKg,
			final FeedType feedType, final Integer ageInYears, final String animalType,
			final Boolean isMigratory, final Integer wingsSizeInCm) {
		super(species, massInKg, feedPerDayInKg, feedType, 
			  ageInYears, animalType, isMigratory,wingsSizeInCm);
	}
}
