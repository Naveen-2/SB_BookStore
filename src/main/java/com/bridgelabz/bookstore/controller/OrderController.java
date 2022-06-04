package com.bridgelabz.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookstore.dto.OrderDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.model.OrderData;
import com.bridgelabz.bookstore.service.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
    private IOrderService iOrderService;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<ResponseDTO> getAllOrders() {
        List<OrderData> orderDataList = iOrderService.getAllOrders();
        ResponseDTO responseDTO = new ResponseDTO("Getting all orders", orderDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get_by_id/{orderId}")
    public ResponseEntity<ResponseDTO> getOrderById(@PathVariable("orderId") int orderId) {
        OrderData orderData = iOrderService.getOrderById(orderId);
        ResponseDTO responseDTO = new ResponseDTO("Get order for id", orderData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/place_order")
    public ResponseEntity<ResponseDTO> placeOrder(@RequestBody OrderDTO orderDTO) {
        OrderData orderData = iOrderService.placeOrder(orderDTO);
        ResponseDTO responseDTO = new ResponseDTO("Order placed successfully", orderData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/cancel_order/{orderId}")
    public ResponseEntity<ResponseDTO> cancelOrder(@PathVariable("orderId") int orderId) {
        iOrderService.cancelOrder(orderId);
        ResponseDTO responseDTO = new ResponseDTO("Order canceled successfully", "Order id " + orderId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
	
}
