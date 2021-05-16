package managers;

import models.Bird;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

import java.util.List;
import java.util.LinkedList;
import java.util.Comparator;

@Data
@AllArgsConstructor
@ToString
@Builder

public final class BirdManager {
	@Singular @NonNull private List<Bird> allBirds;

	public List<Bird> sortByMass(final List<Bird> birds, final Boolean isReversed){
		if (isReversed){
			birds.sort(Comparator.comparing(Bird::getMassInKg).reversed());
		}else {
			birds.sort(Comparator.comparing(Bird::getMassInKg));
		}
		return birds;
	}
	public List<Bird> sortByMass(final Boolean isReversed){
		return sortByMass(this.allBirds, isReversed);
	}

	public List<Bird> sortByFeed(final List<Bird> birds, final Boolean isReversed){
		if (isReversed){
			birds.sort(Comparator.comparing(Bird::getFeedPerDayInKg).reversed());
		}else {
			birds.sort(Comparator.comparing(Bird::getFeedPerDayInKg));
		}
		return birds;
	}
	public List<Bird> sortByFeed(final Boolean isReversed){
		return sortByFeed(this.allBirds, isReversed);
	}

	public List<Bird> searchByMigratory(final List<Bird> birds, 
			final Boolean isSortByMass, final Boolean ascSort){
		LinkedList<Bird> searchResults = new LinkedList<Bird>();
		for (Bird i: birds) {
			if (i.getIsMigratory()) {
				searchResults.add(i);
			}
		}
		if (isSortByMass) {
			sortByMass(searchResults, ascSort);
		}else {
			sortByFeed(searchResults, ascSort);
		}
		return searchResults;
	}
	public List<Bird> searchByMigratory(final Boolean isSortByMass, final Boolean ascSort){
		return searchByMigratory(this.allBirds, isSortByMass, ascSort);
	}
}
