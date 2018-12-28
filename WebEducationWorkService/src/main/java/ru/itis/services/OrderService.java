package ru.itis.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.forms.OrderForm;
import ru.itis.models.Order;
import ru.itis.models.Product;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.CartRepository;
import ru.itis.repositories.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private PasswordEncoder encoder;

    private OrderRepository orderRepository;
    private AuthRepository authRepository;

    public OrderService(OrderRepository orderRepository, AuthRepository authRepository) {
        this.orderRepository = orderRepository;
        this.authRepository = authRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    public void add(OrderForm form){
        orderRepository.add(form.getUserId(), form.getProductId(), form.getName(), form.getPhoto(), form.getTheme(), form.getComment(), form.getPeriod_of_execution(), form.getMin_pages_count(), form.getMax_pages_count(), form.getCost());
    }

    public List<Order> getAllByUserId(Long userId){
        return orderRepository.getAllByUserId(userId);
    }
}
