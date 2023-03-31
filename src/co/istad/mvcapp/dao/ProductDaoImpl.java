package co.istad.mvcapp.dao;

import co.istad.mvcapp.datasource.StaticDataSource;
import co.istad.mvcapp.dto.CreateProductDto;
import co.istad.mvcapp.dto.ProductDto;
import co.istad.mvcapp.mapper.CreateProductDtoMapper;
import co.istad.mvcapp.mapper.ProductDtoMapper;
import co.istad.mvcapp.model.Product;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductDaoImpl implements ProductDao {

    private final StaticDataSource staticDataSource;
    private final CreateProductDtoMapper createProductDtoMapper;
    private final ProductDtoMapper productDtoMapper;

    public ProductDaoImpl() {
        staticDataSource = new StaticDataSource();
        createProductDtoMapper = new CreateProductDtoMapper();
        productDtoMapper = new ProductDtoMapper();
    }

    @Override
    public List<ProductDto> select() {
        return staticDataSource.getProducts()
                .stream()
                .map(productDtoMapper::apply)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto insert(CreateProductDto createProductDto) {

        Product productForInsert = createProductDtoMapper.apply(createProductDto);

        staticDataSource.getProducts().add(productForInsert);

        return productDtoMapper.apply(productForInsert);
    }

    @Override
    public void removeByUUID(UUID uuid) {
        List<Product> newProducts = staticDataSource.getProducts()
                .stream()
                .filter(product -> !product.getUuid().equals(uuid))
                .collect(Collectors.toList());
        staticDataSource.setProducts(newProducts);
    }
}
