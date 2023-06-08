import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.NotFoundException;
import ru.netology.Product;
import ru.netology.ShopRepository;

public class ShopRepositoryTest {

    ShopRepository repository = new ShopRepository();
    Product product1 = new Product(13, "хлеб", 20);
    Product product2 = new Product(25, "молоко", 35);
    Product product3 = new Product(37, "огурец", 12);

    @BeforeEach
    public void setUp() {
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
    }

    @Test
    public void shouldRemoveByIdIfExist() {
        repository.removeById(13);
        Product[] expected = {product2, product3};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfNotExist() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(29);
        });
    }

}