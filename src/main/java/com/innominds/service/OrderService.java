package com.innominds.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.innominds.model.Order;
import com.innominds.model.Payment;
import com.innominds.model.TransactionRequest;
import com.innominds.model.TransactionResponse;
import com.innominds.repositories.OrderRepository;

@Service
@RefreshScope
public class OrderService {

	@Autowired
	OrderRepository orderrepository;
	
	@Autowired
	@Lazy
	RestTemplate restTemplate;
	
	/*public boolean addOrder(Order order) {
		Optional<Order> orderdocument=orderrepository.findById(order.getId());
		if(!orderdocument.isPresent()) {
			Order orderdoc=new Order();
		if(order.getId()!=null) 
			orderdoc.setId(order.getId());
		if(order.getName()!=null)
			orderdoc.setName(order.getName());
		if(order.getQuantity()!=null)
			orderdoc.setQuantity(order.getQuantity());
		if(order.getPrice()!=null)
			orderdoc.setPrice(order.getPrice());
		orderrepository.save(orderdoc);
		return true;
		}
		return false;
	}*/
	@Value("${microservice.payment-service.endpoints.endpoint.uri}")
	private String ENDPOINT_URL;

	public TransactionRequest addOrder(TransactionRequest request) {
		Order order=request.getOrder();
		Payment payment=request.getPayment();
		payment.setId(order.getId());
		payment.setPrice(order.getPrice());
		//Payment p=restTemplate.postForObject("http://localhost:9091/payments", payment, Payment.class);
//		Payment p=restTemplate.postForObject("http://PAYMENT-SERVICE/payments", payment, Payment.class);
		Payment p=restTemplate.postForObject(ENDPOINT_URL, payment, Payment.class);


		orderrepository.save(order);
		return new TransactionRequest(request.getOrder(),request.getPayment());

		//return false;
	}
	/*public TransactionResponse addOrder(TransactionRequest request) {
		String response="";
		Order order=request.getOrder();
		Payment payment=request.getPayment();
		payment.setId(order.getId());
		payment.setPrice(order.getPrice());
		Payment p=restTemplate.postForObject("http://localhost:9091/payments", payment, Payment.class);
		response=p.getPaymentStatus().equals("success")?"payment processing successfull" : "there is a failure in payment api , order added to cart";
		orderrepository.save(order);
		return new TransactionResponse(order,p.getPaymentThrough(),p.getPrice(),response);

		//return false;
	}*/

	public List<Order> getAllOrder() {
		List<Order> all=orderrepository.findAll();
		List<Order> order=new ArrayList<>(all);
		return order;
	}

	

}
