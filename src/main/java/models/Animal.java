package models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import lombok.experimental.FieldDefaults;

import enums.FeedType;

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
}
