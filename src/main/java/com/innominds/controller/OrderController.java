package com.innominds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innominds.model.Order;
import com.innominds.model.Payment;
import com.innominds.model.TransactionRequest;
import com.innominds.model.TransactionResponse;
import com.innominds.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderservice;
	
	/*@PostMapping("/order")
	ResponseEntity<Void> addOrder(@RequestBody Order order){
		boolean added=orderservice.addOrder(order);
		if(added) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
			else
				return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
		}*/
	@PostMapping("/orders")
	ResponseEntity<TransactionRequest> addOrder(@RequestBody TransactionRequest request){
		return new ResponseEntity<TransactionRequest>(orderservice.addOrder(request),HttpStatus.OK);
		
	}	
	@GetMapping("/orders")

	ResponseEntity<List<Order>> getAllOrder(){
		return new ResponseEntity<List<Order>>(orderservice.getAllOrder(),HttpStatus.OK);
	}
	
	/*@PostMapping("/orders")
	ResponseEntity<TransactionResponse> addOrder(@RequestBody TransactionRequest request){
		return new ResponseEntity<TransactionResponse>(orderservice.addOrder(request),HttpStatus.OK);
		
	}	*/
}


