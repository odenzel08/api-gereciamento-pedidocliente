package com.projetosestudos.primeiro_projeto_spring.config;

import com.projetosestudos.primeiro_projeto_spring.models.Category;
import com.projetosestudos.primeiro_projeto_spring.models.Order;
import com.projetosestudos.primeiro_projeto_spring.models.Product;
import com.projetosestudos.primeiro_projeto_spring.models.User;
import com.projetosestudos.primeiro_projeto_spring.models.enums.OrderStatus;
import com.projetosestudos.primeiro_projeto_spring.repositories.CategoryRepository;
import com.projetosestudos.primeiro_projeto_spring.repositories.OrderRepository;
import com.projetosestudos.primeiro_projeto_spring.repositories.ProductRepository;
import com.projetosestudos.primeiro_projeto_spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Electronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));

        Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

        product1.getCategories().add(category2);
        product2.getCategories().add(category1);
        product2.getCategories().add(category3);
        product3.getCategories().add(category3);
        product4.getCategories().add(category3);
        product5.getCategories().add(category2);
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

        User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User user2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order order1 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2025-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order order3 = new Order(null, Instant.parse("2025-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }
}
