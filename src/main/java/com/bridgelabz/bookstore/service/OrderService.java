package com.bridgelabz.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookstore.dto.OrderDTO;
import com.bridgelabz.bookstore.exceptions.BookStoreCustomException;
import com.bridgelabz.bookstore.model.BookData;
import com.bridgelabz.bookstore.model.OrderData;
import com.bridgelabz.bookstore.model.UserRegistrationData;
import com.bridgelabz.bookstore.repository.OrderRepository;

@Service
public class OrderService implements IOrderService{

	@Autowired
    private OrderRepository orderRepository;

    @Autowired
    private IUserRegistrationService iUserRegistrationService;

    @Autowired
    private IBookService iBookService;

    @Override
    public OrderData placeOrder(OrderDTO orderDTO) {
        UserRegistrationData userRegistrationData = iUserRegistrationService.getUserRegistrationDataByUserId(orderDTO.getUserId());
        BookData bookData = iBookService.getBookById(orderDTO.getBookId());
        OrderData orderData = new OrderData(userRegistrationData, bookData, orderDTO);
        return orderRepository.save(orderData);
    }

    @Override
    public List<OrderData> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderData getOrderById(int orderId) {
        return orderRepository.findById(orderId)
                              .orElseThrow(() -> new BookStoreCustomException("Order with id " + orderId + " not found"));
    }

    @Override
    public OrderData cancelOrder(int orderId) {
        OrderData orderData = this.getOrderById(orderId);
        orderData.setCancel(true);
        return orderRepository.save(orderData);
    }
    
}
