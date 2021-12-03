package ua.lviv.iot.zoo.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ua.lviv.iot.zoo.models.Pelican;
import ua.lviv.iot.zoo.service.PelicanService;

@CrossOrigin
@RestController
@RequestMapping(path = "/bird")
public final class PelicanController {
	
	private static final Logger LOGGER =  Logger.getLogger("ua/lviv/iot/zoo/controllers/PelicanController");
	
	@Autowired
	private PelicanService pelicanService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<Pelican> getPelican(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(pelicanService.getPelican(id), HttpStatus.OK);
		}
		catch (NoSuchElementException exception) {
			LOGGER.severe(exception.toString());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@GetMapping
	public ResponseEntity<List<Pelican>> getPelicans(@RequestParam(required = false) String name,
													 @RequestParam(required = false) String type,
													 @RequestParam(required = false) Integer age) {
		List<Pelican> listToFilter = pelicanService.getPelicans();
		if (name != null){
			listToFilter = listToFilter.stream()
					.filter(pelican -> (pelican.getName().contains(name)))
					.collect(Collectors.toList());
		}
		if (type != null){
			listToFilter = listToFilter.stream()
					.filter(pelican -> (pelican.getAnimalType().contains(type)))
					.collect(Collectors.toList());
		}
		if (age != null){
			listToFilter = listToFilter.stream()
					.filter(pelican -> (pelican.getAge() == age))
					.collect(Collectors.toList());
		}
		return new ResponseEntity<>(listToFilter, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Pelican> createPelican(@RequestBody final Pelican pelican) {
		if (pelican.getId() != null) {
			LOGGER.severe("BAD REQUEST: trying to set created object`s id externally");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(pelicanService.addPelican(pelican), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Pelican> updatePelican(@RequestBody final Pelican pelican, 
												@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(pelicanService.updatePelican(pelican, id), HttpStatus.OK);
		}
		catch (NoSuchElementException exception) {
			LOGGER.severe(exception.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
	
	@DeleteMapping(path = "/{id}")
    public ResponseEntity<Pelican> deletePelican(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(pelicanService.deletePelican(id), HttpStatus.OK);
        }
        catch (NoSuchElementException exception) {
        	LOGGER.severe(exception.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
