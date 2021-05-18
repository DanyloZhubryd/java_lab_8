package models;

import enums.FeedType;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@FieldDefaults(makeFinal = false, level = AccessLevel.PROTECTED)

public abstract class Bird extends Animal {
	@NonNull String animalType;
	@NonNull Boolean isMigratory;
	@NonNull Integer wingsSizeInCm;
	public Bird(final String species, final Integer massInKg, final Double feedPerDayInKg,
			final FeedType feedType, final Integer ageInYears, final String animalType,
			final Boolean isMigratory, final Integer wingsSizeInCm) {
        super(species, massInKg, feedPerDayInKg, feedType, ageInYears);
        this.animalType = animalType;
        this.isMigratory = isMigratory;
        this.wingsSizeInCm = wingsSizeInCm;
	}
}