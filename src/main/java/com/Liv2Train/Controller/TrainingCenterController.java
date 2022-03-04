package com.Liv2Train.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Liv2Train.Model.TrainingCenter;
import com.Liv2Train.Repository.TrainingCenterRepository;

@RestController
public class TrainingCenterController {

	@Autowired
	public TrainingCenterRepository trainingCenterRepo;
	
	@GetMapping(value="/allCenters")
	public ResponseEntity<?> getAllCenters(){
		
		List<TrainingCenter> allCenters = trainingCenterRepo.findAll();
		
		if (allCenters.size() >= 0) {
			return new ResponseEntity<>(allCenters, HttpStatus.OK);
		}

		else {
			return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/addNewCenter")
	public ResponseEntity<?> addNewCenter(@RequestBody TrainingCenter newCenterDetails) {
		try {
			newCenterDetails.setCreatedOn(new Date());
			trainingCenterRepo.save(newCenterDetails);
			return new ResponseEntity<>(newCenterDetails, HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/center/{centerCode}")
	public ResponseEntity<?>  getCenterByCenterCode(@PathVariable("centerCode") String centerCode) {
		Optional<TrainingCenter> foundCenter = trainingCenterRepo.findByCenterCode(centerCode);
		if (foundCenter.isPresent()) {
			return new ResponseEntity<>(foundCenter, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Sorry , This Center not exist!!", HttpStatus.NOT_FOUND);
		}

	}
}
