package ua.lviv.iot.zoo.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import ua.lviv.iot.zoo.enums.FeedType;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@FieldDefaults(makeFinal = false, level = AccessLevel.PROTECTED)
@AllArgsConstructor
@NoArgsConstructor

public abstract class Bird extends Animal {
	String animalType;
	boolean migratory;
	Integer wingsSizeInCm;
	public Bird(final String species, final Integer massInKg, final Double feedPerDayInKg,
			final FeedType feedType, final Integer ageInYears, final String animalType,
			final Boolean isMigratory, final Integer wingsSizeInCm) {
        super(species, massInKg, feedPerDayInKg, feedType, ageInYears);
        this.animalType = animalType;
        this.migratory = isMigratory;
        this.wingsSizeInCm = wingsSizeInCm;
	}
}
