package com.balaur.chamberlain.repository;

import com.balaur.chamberlain.dao.chamberlain.tables.daos.ServiceOrderDao;
import com.balaur.chamberlain.dao.chamberlain.tables.pojos.ServiceOrder;
import org.jooq.DSLContext;
import org.jooq.impl.DefaultDSLContext;

import static com.balaur.chamberlain.dao.chamberlain.tables.ServiceOrder.SERVICE_ORDER;

public class OrderRepository extends ServiceOrderDao {

  private final DSLContext dsl;

  public OrderRepository(final DefaultDSLContext dsl) {

    super(dsl.configuration());
    this.dsl = dsl;
  }

  public Long insertIntoReturningId(final ServiceOrder serviceOrder) {

    return dsl.insertInto(SERVICE_ORDER)
              .set(dsl.newRecord(SERVICE_ORDER, serviceOrder))
              .returning(SERVICE_ORDER.ID)
              .fetchOne()
              .into(ServiceOrder.class)
              .getId();
  }
}
