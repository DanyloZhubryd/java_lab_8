package ua.lviv.iot.zoo.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.zoo.models.Pelican;


@Repository
public interface PelicanRepository extends JpaRepository<Pelican, Integer> {
}
