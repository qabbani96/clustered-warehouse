package com.warehouse.clustereddata.repository;

import com.warehouse.clustereddata.model.Deal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DealsRepository extends MongoRepository<Deal,String> {
    Optional<Deal> findByUniqueDealId(String uniqueDealId);
    List<Deal> findAll();

}
