package co.istad.mvcapp.datasource;

import co.istad.mvcapp.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StaticDataSource {
    private List<Product> products;

    public StaticDataSource() {
        products = new ArrayList<>();
        products.add(new Product(UUID.randomUUID(), 10099, "Mouse", 20.0));
        products.add(new Product(UUID.randomUUID(), 10100, "Keyboard Mechanic", 55.0));
        products.add(new Product(UUID.randomUUID(), 10101, "Speaker", 18.0));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
