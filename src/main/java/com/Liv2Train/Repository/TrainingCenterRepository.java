package com.Liv2Train.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Liv2Train.Model.TrainingCenter;

public interface TrainingCenterRepository extends MongoRepository<TrainingCenter,String>{

	Optional<TrainingCenter> findByCenterCode(String centerCode);

}
