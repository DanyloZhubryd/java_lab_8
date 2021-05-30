package ua.lviv.iot.zoo.models;

import javax.persistence.MappedSuperclass;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ua.lviv.iot.zoo.enums.FeedType;

@MappedSuperclass
@Data
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PROTECTED)
@NoArgsConstructor
public abstract class Animal {
    String species;
    Integer massInKg;
    Double feedPerDayInKg;
    FeedType feedType;
    Integer ageInYears;
}
