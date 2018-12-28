package ru.itis.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.models.Product;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.CartRepository;

import java.util.ArrayList;
import java.util.List;

public class CartService {

    private PasswordEncoder encoder;

    private CartRepository cartRepository;
    private AuthRepository authRepository;

    public CartService(CartRepository cartRepository, AuthRepository authRepository) {
        this.cartRepository = cartRepository;
        this.authRepository = authRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    public void add(Long userId, Long productId){
        cartRepository.add(userId, productId);
    }
    public void delete(Long userId, Long productId){
        cartRepository.delete(userId, productId);
    }
    public List<Product> getAllWithCountByUserId(Long userId) {
        List<Product> products = cartRepository.getAllByUserId(userId);
        List<Product> productsWithCount = new ArrayList<Product>();
        boolean flag;
        for (Product product : products){
            flag = true;
            for(Product productWithCount : productsWithCount){
                if(product.getName().equals(productWithCount.getName())){
                    productWithCount.setCount(productWithCount.getCount() + 1);
                    flag = false;
                }
            }
            if(flag){
                product.setCount(1);
                productsWithCount.add(product);
            }
        }
        return productsWithCount;
    }
    public List<Product> getAllByUserId(Long userId){
        return cartRepository.getAllByUserId(userId);
    }
}
