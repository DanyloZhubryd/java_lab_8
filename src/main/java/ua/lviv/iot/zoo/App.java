package ua.lviv.iot.zoo;

import enums.FeedType;
import managers.BirdManager;
import models.Parrot;
import models.Pelican;


public class App {
    public static void main(String[] args) {
    	Parrot amogus = new Parrot("AMOGUS", 5, 10.0, FeedType.CORN, 12, "amogusgus", true, 15);
    	Parrot aboba = new Parrot("Aboba", 6, 15.0, FeedType.VEGETABLES, 17, "adoda", false, 9);
    	Pelican ze = new Pelican("ze", 3, 7.0, FeedType.MEAT, 20, "zeze", true, 13);
    	BirdManager zoo = BirdManager.builder()
    			.allBird(ze).allBird(amogus).allBird(aboba)
    			.build();
    	zoo.searchByMigratory(false, true).forEach(
    			(bird) -> System.out.println(bird.isMigratory() + " " 
    										+ bird.getMassInKg() + " " 
    										+ bird.getFeedPerDayInKg()));
    }
}
