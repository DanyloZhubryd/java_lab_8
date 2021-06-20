package ua.lviv.iot.zoo.managers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.zoo.models.Bird;

public class BirdWriter {
	public static void writeToFile(final List<Bird> birds, final String path) {
		try {
			File csvFile = new File(path);
			if (csvFile.createNewFile()) {
				System.out.println("File " + path + " successfully created");
			} else {
				System.out.println("File " + path + " already exists");
			}
		} catch (IOException ioException) {
			System.out.println("Error occurred. Couldn't create a file in " + path);
			ioException.printStackTrace();
		}
		if (!birds.isEmpty()) {
			try (FileWriter csvFileWriter = new FileWriter(path)) {
				System.out.println("Writing to " + path);
				birds.sort(Comparator
						.comparing(bird -> bird.getClass().getSimpleName()));
				String currentHeaders = birds.get(0).getHeaders();
				String currentClass = birds.get(0).getClass().getSimpleName();
				csvFileWriter.write(currentClass + '\n');
				csvFileWriter.write(currentHeaders + '\n');
				for (Bird bird : birds) {
					try {
						if (!bird.getClass().getSimpleName().equals(currentClass)) {
							currentClass = bird.getClass().getSimpleName();
							currentHeaders = bird.getHeaders();
							csvFileWriter.write(currentClass + '\n');
							csvFileWriter.write(currentHeaders + '\n');
						}
						csvFileWriter.write(bird.toCSV() + '\n');
					} catch (IOException ioexception) {
						System.out.println("Error occurred. Couldn't write to " + path);
						ioexception.printStackTrace();
					}
				}
				csvFileWriter.close();
				System.out.println("File " + path + " was successfully written");
			} catch (IOException ioexception) {
			System.out.println("Error occurred. Couldn't create FileWriter for " + path);
			ioexception.printStackTrace();
			}
		} else {
			System.out.println("The List is empty. Nothing to write in file");
		}
	}
}
