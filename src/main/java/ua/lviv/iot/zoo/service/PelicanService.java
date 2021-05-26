package ua.lviv.iot.zoo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import lombok.Getter;
import ua.lviv.iot.zoo.models.Pelican;

@Service
@ApplicationScope
public class PelicanService {
	
	private AtomicInteger id = new AtomicInteger(0);
	
	@Getter
	private Map<Integer, Pelican> pelicansMap = new HashMap<Integer, Pelican>();
	
	public List<Pelican> getPelicans() {
        return pelicansMap.values().stream().collect(Collectors.toList());
    }
	
    public Pelican getPelican(final Integer id) {
    	return pelicansMap.get(id);
    }

    public Pelican addPelican(final Pelican pelican) {
        pelican.setId(id.incrementAndGet());
        pelicansMap.put(pelican.getId(), pelican);
        return pelican;
    }

    public Pelican updatePelican(final Integer id, final Pelican pelican) {
        pelican.setId(id);
        return pelicansMap.put(id, pelican);
    }

    public Pelican deletePelican(final Integer id) {
        return pelicansMap.remove(id);
    }
}
