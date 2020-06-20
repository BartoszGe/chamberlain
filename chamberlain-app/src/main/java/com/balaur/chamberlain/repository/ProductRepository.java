package com.balaur.chamberlain.repository;

import com.balaur.chamberlain.dao.ProductWithType;
import com.balaur.chamberlain.dao.tables.daos.ProductDao;
import com.balaur.chamberlain.dao.tables.pojos.Product;
import org.jooq.DSLContext;
import org.jooq.impl.DefaultDSLContext;

import java.util.List;

import static com.balaur.chamberlain.dao.tables.Product.PRODUCT;
import static com.balaur.chamberlain.dao.tables.ProductType.PRODUCT_TYPE;
import static com.balaur.chamberlain.dao.tables.ProductXOrder.PRODUCT_X_ORDER;

public class ProductRepository extends ProductDao {

  private final DSLContext dsl;

  public ProductRepository(final DefaultDSLContext dsl) {

    super(dsl.configuration());
    this.dsl = dsl;
  }

  public List<ProductWithType> findAllWithType() {

    return dsl.select(PRODUCT.ID, PRODUCT.NAME, PRODUCT.PRICE, PRODUCT.AMOUNT, PRODUCT.MEASURE_TYPE, PRODUCT.DESCRIPTION, PRODUCT_TYPE.NAME.as("type"))
              .from(PRODUCT)
              .join(PRODUCT_TYPE)
              .on(PRODUCT_TYPE.ID.eq(PRODUCT.TYPE_ID))
              .fetchInto(ProductWithType.class);
  }

  public List<Product> getByOrderId(final Long id) {

    return dsl.select()
        .from(PRODUCT)
        .join(PRODUCT_X_ORDER)
        .on(PRODUCT_X_ORDER.PRODUCT_ID.eq(PRODUCT.ID))
        .where(PRODUCT_X_ORDER.ORDER_SERVICE_ID.eq(id))
        .fetchInto(Product.class);
  }

  public Long insertIntoReturningId(final Product product) {

    return dsl.insertInto(PRODUCT)
              .set(dsl.newRecord(PRODUCT, product))
              .returning(PRODUCT.ID)
              .fetchOne()
              .into(Product.class)
              .getId();
  }

}
