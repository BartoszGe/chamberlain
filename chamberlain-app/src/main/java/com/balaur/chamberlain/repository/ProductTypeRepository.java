package com.balaur.chamberlain.repository;

import com.balaur.chamberlain.dao.chamberlain.tables.daos.ProductTypeDao;
import org.jooq.DSLContext;
import org.jooq.impl.DefaultDSLContext;

public class ProductTypeRepository extends ProductTypeDao {

  private final DSLContext dsl;

  public ProductTypeRepository(final DefaultDSLContext dsl) {

    super(dsl.configuration());
    this.dsl = dsl;
  }

}
