package ua.lviv.iot.zoo.managers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;
import ua.lviv.iot.zoo.models.Bird;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

@Data
@AllArgsConstructor
@ToString
@Builder

public final class BirdManager {
	@Singular @NonNull private List<Bird> allBirds;

	public List<Bird> sortByMass(final List<Bird> birds, final Boolean isReversed) {
		if (isReversed){
			birds.sort(Comparator.comparing(Bird::getMass).reversed());
		}
		else {
			birds.sort(Comparator.comparing(Bird::getMass));
		}
		return birds;
	}
	public List<Bird> sortByMass(final Boolean isReversed) {
		return sortByMass(this.allBirds, isReversed);
	}
}
