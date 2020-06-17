package com.balaur.chamberlain.repository;

import com.balaur.chamberlain.dao.chamberlain.tables.daos.ProductDao;
import com.balaur.chamberlain.model.ProductWithType;
import org.jooq.DSLContext;
import org.jooq.impl.DefaultDSLContext;

import java.util.List;

import static com.balaur.chamberlain.dao.chamberlain.tables.Product.PRODUCT;
import static com.balaur.chamberlain.dao.chamberlain.tables.ProductType.PRODUCT_TYPE;

public class ProductRepository extends ProductDao {

  private final DSLContext dsl;

  public ProductRepository(final DefaultDSLContext dsl) {

    super(dsl.configuration());
    this.dsl = dsl;
  }

  public List<ProductWithType> findAllWithType() {

    return dsl.select(PRODUCT.ID, PRODUCT.NAME, PRODUCT.PRICE, PRODUCT.AMOUNT, PRODUCT.MEASURETYPE, PRODUCT.DESCRIPTION, PRODUCT_TYPE.NAME.as("type"))
              .from(PRODUCT)
              .join(PRODUCT_TYPE)
              .on(PRODUCT_TYPE.ID.eq(PRODUCT.TYPE_ID))
              .fetchInto(ProductWithType.class);
  }
}
