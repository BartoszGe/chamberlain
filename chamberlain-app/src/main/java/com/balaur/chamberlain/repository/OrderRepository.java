package com.balaur.chamberlain.repository;

import com.balaur.chamberlain.dao.tables.daos.OrderServiceDao;
import com.balaur.chamberlain.dao.tables.pojos.OrderService;
import org.jooq.impl.DefaultDSLContext;

import static com.balaur.chamberlain.dao.tables.OrderService.ORDER_SERVICE;

public class OrderRepository extends OrderServiceDao {

  private final DefaultDSLContext dsl;

  public OrderRepository(final DefaultDSLContext dsl) {

    super(dsl.configuration());
    this.dsl = dsl;
  }

  public Long insertIntoReturningId(final OrderService serviceOrder) {

    return dsl.insertInto(ORDER_SERVICE)
              .set(dsl.newRecord(ORDER_SERVICE, serviceOrder))
              .returning(ORDER_SERVICE.ID)
              .fetchOne()
              .into(OrderService.class)
              .getId();
  }
}
