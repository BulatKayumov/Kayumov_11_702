package ru.itis.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.models.Product;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.ProductRepository;

import java.util.List;

public class ProductService implements ProductsService {

    private PasswordEncoder encoder;

    private ProductRepository productRepository;
    private AuthRepository authRepository;

    public ProductService(ProductRepository productRepository, AuthRepository authRepository) {
        this.productRepository = productRepository;
        this.authRepository = authRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    public String get(Long productId) {
        return productRepository.get(productId);
    }

    public Product find(Long productId) {
        return productRepository.find(productId);
    }

    @Override
    public List<Product> addProductToUserBasket(String cookieValue, Long productId) {
        return null;
    }
}
