package no.kristiania.pgr301_10021.controller;



import no.kristiania.pgr301_10021.model.Ninja;
import no.kristiania.pgr301_10021.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Logger;

@RestController

public class NinjaController {

    private static final Logger LOG = Logger.getLogger(NinjaController.class.getName());

    @Autowired
    private NinjaRepository ninjaRepository;

    @RequestMapping("/")
    public String homepage(){
        LOG.info("Home page was opened");
        return "WELCOME TO NINJA TEMPLE";
    }

    //Read
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/ninjas")
    public List<Ninja> getNinjas() {
        Iterable<Ninja> iterableNinja = ninjaRepository.findAll();
        List<Ninja> ninjaList = new ArrayList<>();
        iterableNinja.forEach(a -> ninjaList.add(a));
        LOG.info("Ninja list was requested");
        return ninjaList;
    }

//
    @GetMapping(value = "/ninja/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ninja> getNinjaById(@PathVariable(value = "id") Long ninjaId) {
        Iterable<Ninja> iterableNinja = ninjaRepository.findNinjaById(ninjaId);
        List<Ninja> ninjaList = new ArrayList<>();
        iterableNinja.forEach(a -> ninjaList.add(a));
        LOG.info(String.format("Ninja requested with id %d", ninjaId));
        return ninjaList;
    }

    // Create
    @PostMapping("/ninja")
    public Ninja createNinja(@RequestBody Ninja ninja){
        return ninjaRepository.save(ninja);
    }
/*
    // Update
    @PutMapping("/ninja/{id}")
    public ResponseEntity <Ninja> updateNinja(@PathVariable(value = "id") Long ninjaId,
                                              @RequestBody Ninja ninjadetails) throws ResourceNotFoundException{
        Ninja ninja = ninjaRepository.findById(ninjaId)
                .orElseThrow(() -> new ResourceNotFoundException("Ninja with this id not found :: " + ninjaId));

        ninja.setName(ninjadetails.getName());
        ninja.setKatana(ninjadetails.getKatana());
        final Ninja updatedNinja = ninjaRepository.save(ninja);
        return ResponseEntity.ok(updatedNinja);
    }

    // Delete
    @DeleteMapping("/ninja/{id}")
    public Map<String, Boolean> deleteNinja(@PathVariable(value = "id") Long ninjaId)
        throws ResourceNotFoundException {
            Ninja ninja = ninjaRepository.findById(ninjaId)
                    .orElseThrow(() -> new ResourceNotFoundException("Ninja with this id not found :: " + ninjaId));

            ninjaRepository.delete(ninja);
            Map <String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
    }

 */

}
