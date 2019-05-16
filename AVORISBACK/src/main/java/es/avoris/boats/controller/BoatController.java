package es.avoris.boats.controller;

import es.avoris.boats.exception.ResourceNotFoundException;
import es.avoris.boats.model.Boat;
import es.avoris.boats.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BoatController {

	@Autowired
    BoatRepository boatRepository;
	
	// Get All Boats
	@GetMapping("/boats")
	public List<Boat> getAllBoats() {
	    return boatRepository.findAll();
	}
	
	// Create a new Boat
	@PostMapping("/boats")
	public Boat createBoat(@Valid @RequestBody Boat boat) {
	    return boatRepository.save(boat);
	}

	// Get a Boat
	@GetMapping("/boats/{id}")
	public Boat getBoatById(@PathVariable(value = "id") Long boatId) {
	    return boatRepository.findById(boatId)
	            .orElseThrow(() -> new ResourceNotFoundException("Boat", "id", boatId));
	}
	
	// Update a Boat
	@PutMapping("/boats/{id}")
	public Boat updateBoat(@PathVariable(value = "id") Long boatId,
	                                        @Valid @RequestBody Boat boatDetails) {

	    Boat boat = boatRepository.findById(boatId)
	            .orElseThrow(() -> new ResourceNotFoundException("Boat", "id", boatId));

	    boat.setName(boatDetails.getName());
	    boat.setType(boatDetails.getType());
	    boat.setLoa(boatDetails.getLoa());
	    boat.setBeam(boatDetails.getBeam());
	    boat.setDraft(boatDetails.getDraft());

	    Boat updatedBoat = boatRepository.save(boat);
	    return updatedBoat;
	}
	
	// Delete a Boat
	@DeleteMapping("/boats/{id}")
	public ResponseEntity<?> deleteBoat(@PathVariable(value = "id") Long boatId) {
	    Boat boat = boatRepository.findById(boatId)
	            .orElseThrow(() -> new ResourceNotFoundException("Boat", "id", boatId));

	    boatRepository.delete(boat);

	    return ResponseEntity.ok().build();
	}
}
