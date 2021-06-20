package ua.lviv.iot.zoo.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import lombok.experimental.FieldDefaults;
import ua.lviv.iot.zoo.enums.FeedType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PROTECTED)

public abstract class Animal {
    @NonNull String species;
    @NonNull Integer massInKg;
    @NonNull Double feedPerDayInKg;
    @NonNull FeedType feedType;
    @NonNull Integer ageInYears;
    
    public String getHeaders() {
    	return "species,massInKg,feedPerDayInKg,feedType,ageInYears";
    }
    
    public String toCSV() {
    	return species + "," + massInKg.toString() + "," + feedPerDayInKg.toString() + ","
    			+ feedType.toString() + "," + ageInYears.toString();
    }
}
