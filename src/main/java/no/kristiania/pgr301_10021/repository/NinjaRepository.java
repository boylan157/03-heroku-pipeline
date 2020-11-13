package no.kristiania.pgr301_10021.repository;


import no.kristiania.pgr301_10021.model.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {

    public List<Ninja> findByName(String name);
}
