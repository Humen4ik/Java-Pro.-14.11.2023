package org.example.testcrud.repository;

import org.example.testcrud.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends CrudRepository<Order, Integer> {

    Page<Order> findAll(Pageable pageable);

}
