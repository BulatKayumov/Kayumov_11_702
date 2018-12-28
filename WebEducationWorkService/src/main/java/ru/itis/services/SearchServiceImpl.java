package ru.itis.services;

import ru.itis.models.Product;
import ru.itis.repositories.ProductRepository;

import java.util.List;

public class SearchServiceImpl implements SearchService{
    private ProductRepository productRepository;

    public SearchServiceImpl(ProductRepository productsRepository) {
        this.productRepository = productsRepository;
    }

    @Override
    public List<Product> search(String name) {
        return productRepository.findAllByNameSearch(name);
    }
}
