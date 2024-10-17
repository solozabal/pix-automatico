package com.solozabal.pixautomatico.pix_automatico.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.solozabal.pixautomatico.pix_automatico.model.Product;

@Service
public class FakeStoreAPIService {

    private static final Logger LOGGER = Logger.getLogger(FakeStoreAPIService.class.getName());
    private final RestTemplate restTemplate;

    public FakeStoreAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Método para buscar todos os produtos
    public List<Product> getAllProducts() {
        String url = "https://fakestoreapi.com/products";
        try {
            ResponseEntity<Product[]> response = restTemplate.getForEntity(url, Product[].class);
            return Arrays.asList(Optional.ofNullable(response.getBody()).orElse(new Product[0]));
        } catch (HttpClientErrorException e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar produtos: {0}", e.getMessage());
            throw new RuntimeException("Falha ao buscar produtos da API externa.");
        }
    }

    // Método para buscar um produto pelo ID
    public Product getProductById(Long id) {
        String url = UriComponentsBuilder.fromHttpUrl("https://fakestoreapi.com/products/{id}")
                .buildAndExpand(id)
                .toUriString();
        try {
            return restTemplate.getForObject(url, Product.class);
        } catch (HttpClientErrorException e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar produto com ID: {0} - {1}", new Object[]{id, e.getMessage()});
            throw new RuntimeException("Falha ao buscar o produto com ID " + id);
        }
    }

    // Método para criar um novo produto
    public Product createProduct(Product product) {
        String url = "https://fakestoreapi.com/products";
        try {
            return restTemplate.postForObject(url, product, Product.class);
        } catch (HttpClientErrorException e) {
            LOGGER.log(Level.SEVERE, "Erro ao criar produto: {0}", e.getMessage());
            throw new RuntimeException("Falha ao criar o produto.");
        }
    }

    // Método para atualizar um produto
    public void updateProduct(Long id, Product product) {
        String url = UriComponentsBuilder.fromHttpUrl("https://fakestoreapi.com/products/{id}")
                .buildAndExpand(id)
                .toUriString();
        try {
            restTemplate.put(url, product);
        } catch (HttpClientErrorException e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar produto com ID: {0} - {1}", new Object[]{id, e.getMessage()});
            throw new RuntimeException("Falha ao atualizar o produto com ID " + id);
        }
    }

    // Método para deletar um produto
    public void deleteProduct(Long id) {
        String url = UriComponentsBuilder.fromHttpUrl("https://fakestoreapi.com/products/{id}")
                .buildAndExpand(id)
                .toUriString();
        try {
            restTemplate.delete(url);
        } catch (HttpClientErrorException e) {
            LOGGER.log(Level.SEVERE, "Erro ao deletar produto com ID: {0} - {1}", new Object[]{id, e.getMessage()});
            throw new RuntimeException("Falha ao deletar o produto com ID " + id);
        }
    }
}