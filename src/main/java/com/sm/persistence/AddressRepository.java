package com.sm.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.sm.model.Address;

@Repository
public interface AddressRepository extends MongoRepository<Address, String>, QuerydslPredicateExecutor<Address> {

}
