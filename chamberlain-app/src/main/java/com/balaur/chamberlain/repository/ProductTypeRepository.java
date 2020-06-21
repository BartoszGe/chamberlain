package com.balaur.chamberlain.repository;

import com.balaur.chamberlain.dao.ProductTypeEnum;
import com.balaur.chamberlain.dao.tables.daos.ProductTypeDao;
import org.jooq.DSLContext;
import org.jooq.impl.DefaultDSLContext;

import static com.balaur.chamberlain.dao.tables.ProductType.PRODUCT_TYPE;

public class ProductTypeRepository extends ProductTypeDao {

  private final DSLContext dsl;

  public ProductTypeRepository(final DefaultDSLContext dsl) {

    super(dsl.configuration());
    this.dsl = dsl;
  }

  public Long getIdByType(final ProductTypeEnum type) {

    return dsl.select(PRODUCT_TYPE.ID)
              .from(PRODUCT_TYPE)
              .where(PRODUCT_TYPE.NAME.eq(type))
              .fetchOneInto(Long.class);
  }
}
