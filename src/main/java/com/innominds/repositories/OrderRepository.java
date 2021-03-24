package com.innominds.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//import com.innominds.document.OrderDocument;
import com.innominds.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order,String>{

}
