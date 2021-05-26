package ua.lviv.iot.zoo.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import ua.lviv.iot.zoo.enums.FeedType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PROTECTED)

public abstract class Animal {
    String species;
    Integer massInKg;
    Double feedPerDayInKg;
    FeedType feedType;
    Integer ageInYears;
}
