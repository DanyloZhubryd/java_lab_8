package ua.lviv.iot.zoo.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ua.lviv.iot.zoo.enums.FeedType;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@FieldDefaults(makeFinal = false, level = AccessLevel.PROTECTED)

public abstract class Bird extends Animal {
	@NonNull String animalType;
	boolean migratory;
	@NonNull Integer wingsSizeInCm;
	public Bird(final String species, final Integer massInKg, final Double feedPerDayInKg,
			final FeedType feedType, final Integer ageInYears, final String animalType,
			final Boolean isMigratory, final Integer wingsSizeInCm) {
        super(species, massInKg, feedPerDayInKg, feedType, ageInYears);
        this.animalType = animalType;
        this.migratory = isMigratory;
        this.wingsSizeInCm = wingsSizeInCm;
	}
	
	@Override
	public String getHeaders() {
		return super.getHeaders() + ",animalType,migratory,wingsSizeInCm";
	}
	
	@Override
	public String toCSV() {
		return super.toCSV() + "," + animalType + 
				"," + migratory + "," + wingsSizeInCm.toString();
	}
}
