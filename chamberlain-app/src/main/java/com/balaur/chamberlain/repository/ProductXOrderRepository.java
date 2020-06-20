package com.balaur.chamberlain.repository;

import com.balaur.chamberlain.dao.tables.daos.ProductXOrderDao;
import org.jooq.DSLContext;
import org.jooq.impl.DefaultDSLContext;

public class ProductXOrderRepository extends ProductXOrderDao {

  private final DSLContext dsl;

  public ProductXOrderRepository(final DefaultDSLContext dsl) {

    super(dsl.configuration());
    this.dsl = dsl;
  }
}
