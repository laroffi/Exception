package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book first = new Book(1, "Fight Club", 520, "C.Palahniuk", 315, 2000);
    private Book second = new Book (2, "The lord of the flies", 700, "W.Golding", 250, 2015);
    private TShirt third = new TShirt(3, "Friends", 1500, "White", "M");
    private TShirt fourth = new TShirt(4, "Rammstein", 1500, "Black", "XXL");

    @Test
    public void shouldSaveOneItem() {
        repository.save(first);

        Product[] expected = new Product[]{first};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        repository.removeById(2);
        Product[] expected = new Product[]{first, third, fourth};
        Product[] actual = repository.findAll();
    }

    @Test
    public void shouldThrowException() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        repository.removeById(5);
        Product[] expected = new Product[]{first, second, third, fourth};
        Product[] actual = repository.findAll();
    }
    }
