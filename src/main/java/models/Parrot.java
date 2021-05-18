package models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import enums.FeedType;
import lombok.AccessLevel;

@EqualsAndHashCode(callSuper = false)
@Data
@ToString(callSuper = true)
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)

public final class Parrot extends Bird{
	public Parrot(final String species, final Integer massInKg, final Double feedPerDayInKg,
			final FeedType feedType, final Integer ageInYears, final String animalType,
			final Boolean isMigratory, final Integer wingsSizeInCm) {
		super(species, massInKg, feedPerDayInKg, feedType, 
			  ageInYears, animalType, isMigratory,wingsSizeInCm);
	}
	public void talk(final String speech) {
		System.out.printf("Parrot says:%s", speech);
	}
	
}
