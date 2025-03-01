package com.boii.backendecommerce.repository;

import com.boii.backendecommerce.model.Category;
import com.boii.backendecommerce.model.Product;
import com.boii.backendecommerce.repository.projections.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product); // create

    List<Product> findAll();

    Product getProductByIdAndTitle(Long id, String title);

    // Hibernate query language  example .
    // pros : 1.Flexibility 2.Visibility of Query  3. Query is DB independent
    @Query("select p from Product p where p.id =:id and p.title=:title")
    Product getProductFromIdAndTitle(@Param("id") Long id);

    // working -by me
    @Query("SELECT p FROM Product p WHERE p.title LIKE %:searchText%")
    List<Product> findProductsByTitleContaining(@Param("searchText") String searchText);

    @Query("SELECT p.id, p.title, p.price from Product p where p.id =:id")
    ProductProjection getTitleAndPriceProductFromId(@Param("id") Long id);

    @Query("SELECT p.id,  p.price as price from Product p where p.title =:title")
    List<ProductProjection> getTitleAndPriceProductFromTitle(@Param("title") String title);

    @Query("SELECT p FROM Product p WHERE p.is_Deleted = false")
    List<Product> findBy_DeletedFalse();

    @Query("SELECT p FROM Product p WHERE p.id = :id AND p.is_Deleted = false")
    Optional<Product> findByIdAnd_DeletedFalse(@Param("id") Long id);


    @Query("SELECT p.id FROM Product p WHERE p.is_Deleted = false")
    List<Long> findActiveProductIds();

    /*
      Pagination Way 1
      - Create  own HQL query which supports Pagination
      Pagination Way 2
      - Make use of existing Library
      - this already supported
      Page<T> findAll(Pageable pageable);
      by Jpa Repository

    * */





    Product findProductById(Long id);

    List<Product> findByPriceGreaterThan(Double price);

    List<Product> findByPriceLessThan(Double price);

    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);



}

