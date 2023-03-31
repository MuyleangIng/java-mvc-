package co.istad.mvcapp.dao;

import co.istad.mvcapp.dto.CreateProductDto;
import co.istad.mvcapp.dto.ProductDto;
import co.istad.mvcapp.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductDao {
    List<ProductDto> select();
    ProductDto insert(CreateProductDto createProductDto);
    void removeByUUID(UUID uuid);
}
