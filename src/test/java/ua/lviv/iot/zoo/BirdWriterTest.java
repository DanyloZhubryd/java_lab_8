package ua.lviv.iot.zoo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.zoo.enums.FeedType;
import ua.lviv.iot.zoo.managers.BirdWriter;
import ua.lviv.iot.zoo.models.Bird;
import ua.lviv.iot.zoo.models.Parrot;
import ua.lviv.iot.zoo.models.Pelican;


public class BirdWriterTest {
	
	@Test
	void test_ConvertToCsv_NotEmptyListProvided() {
		ArrayList<Bird> birds = new ArrayList<>();
		birds.add(new Pelican("boba", 4, 8.0, FeedType.CORN, 18, "phett", false, 15));
    	birds.add(new Parrot("giga", 5, 10.0, FeedType.CORN, 12, "byte", true, 15));
    	birds.add(new Parrot("meme", 6, 15.0, FeedType.VEGETABLES, 17, "generator", false, 9));
    	birds.add(new Pelican("zero", 3, 7.0, FeedType.MEAT, 20, "zerro", true, 13));
    	BirdWriter.writeToFile(birds, "src/test/resources/BIRDS.csv");
    	File actualResult = new File("src/test/resources/BIRDS.csv");
    	File expectedResult = new File("src/test/resources/BIRDS_EXPECTED.csv");
    	try {
            assertEquals(true, FileUtils.contentEquals(expectedResult, actualResult));
        } catch (IOException e){
            e.printStackTrace();
        }
	}
	
	@Test
	void test_ConvertToCsv_EmptyListProvided() {
		File expectedResult = new File("src/test/resources/NO_BIRDS.csv");
		ArrayList<Bird> birds = new ArrayList<>();
		BirdWriter.writeToFile(birds, "src/test/resources/NO_BIRDS.csv");
		File actualResult = new File("src/test/resources/NO_BIRDS.csv");
		try {
			assertEquals(true, FileUtils.contentEquals(actualResult, expectedResult));
		} catch (IOException e){
            e.printStackTrace();
        }
		
	}
	
	
}
