package com.balaur.chamberlain.repository;

import com.balaur.chamberlain.dao.tables.daos.OrderServiceDao;
import com.balaur.chamberlain.dao.tables.pojos.OrderService;
import org.jooq.impl.DefaultDSLContext;

import java.util.List;

import static com.balaur.chamberlain.dao.tables.OrderService.ORDER_SERVICE;

public class OrderRepository extends OrderServiceDao {

  private final DefaultDSLContext dsl;

  public OrderRepository(final DefaultDSLContext dsl) {

    super(dsl.configuration());
    this.dsl = dsl;
  }

  public List<OrderService> findAllNotFinalized() {

    return dsl.select()
              .from(ORDER_SERVICE)
              .where(ORDER_SERVICE.IS_FINALIZED.eq(false))
              .fetchInto(OrderService.class);
  }

  public Long insertIntoReturningId(final OrderService serviceOrder) {

    return dsl.insertInto(ORDER_SERVICE)
              .set(dsl.newRecord(ORDER_SERVICE, serviceOrder))
              .returning(ORDER_SERVICE.ID)
              .fetchOne()
              .into(OrderService.class)
              .getId();
  }

  public void finalizeOrder(final long id, final String deliveryProblem) {

    dsl.update(ORDER_SERVICE)
       .set(ORDER_SERVICE.IS_FINALIZED, true)
       .set(ORDER_SERVICE.DELIVERY_PROBLEM, deliveryProblem)
       .where(ORDER_SERVICE.ID.eq(id))
       .execute();
  }
}
