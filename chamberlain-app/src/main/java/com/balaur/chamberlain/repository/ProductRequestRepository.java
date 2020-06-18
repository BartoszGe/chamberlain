package com.balaur.chamberlain.repository;

import com.balaur.chamberlain.dao.chamberlain.tables.daos.ProductRequestDao;
import org.jooq.DSLContext;
import org.jooq.impl.DefaultDSLContext;

import static com.balaur.chamberlain.dao.chamberlain.tables.ProductRequest.PRODUCT_REQUEST;

public class ProductRequestRepository extends ProductRequestDao {

  private final DSLContext dsl;

  public ProductRequestRepository(final DefaultDSLContext dsl) {

    super(dsl.configuration());
    this.dsl = dsl;
  }

  public Long insertIntoReturningId(final String productName) {

    return dsl.insertInto(PRODUCT_REQUEST,
                          PRODUCT_REQUEST.PRODUCT_NAME)
              .values(productName)
              .returning(PRODUCT_REQUEST.ID)
              .fetchOne()
              .getId();
  }
}
