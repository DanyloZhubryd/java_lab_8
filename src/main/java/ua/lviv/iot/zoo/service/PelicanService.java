package ua.lviv.iot.zoo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import ua.lviv.iot.zoo.dal.PelicanRepository;
import ua.lviv.iot.zoo.models.Pelican;

@Service
@ApplicationScope
public class PelicanService {

	private PelicanRepository repository;
	
	@Autowired
	public PelicanService(PelicanRepository repository) {
		this.repository = repository;
	}
	
	public List<Pelican> getPelicans() {
        return repository.findAll();
    }
	
    public Pelican getPelican(final Integer id) {
    	if (repository.existsById(id)) {
    		return repository.findById(id).get();
    	}
    	throw new NoSuchElementException(
    			"NOT FOUND: Cannot find pelican with id: " + id +" in the system"
    	);
    }

    public Pelican addPelican(final Pelican pelican) {
        return repository.save(pelican);
    }

    public Pelican updatePelican(final Pelican pelican, final Integer id) {
    	if (repository.existsById(id)) {
    		Pelican previousPelican = repository.findById(id).get();
    		pelican.setId(id);
    		repository.save(pelican);
    		return previousPelican;
    	}
    	throw new NoSuchElementException(
                "NOT FOUND: Cannot find pelican with id:" + pelican.getId() + "in the system"
        );
    }

    public Pelican deletePelican(final Integer id) {
        Pelican deletedPelican = getPelican(id);
        repository.deleteById(id);
        return deletedPelican;
    }
}
