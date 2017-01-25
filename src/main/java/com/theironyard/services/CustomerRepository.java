package com.theironyard.services;

import com.theironyard.entities.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ryankielty on 1/21/17.
 */
public interface CustomerRepository extends CrudRepository <Customer, Integer> {
}
