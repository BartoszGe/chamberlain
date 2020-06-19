package com.balaur.chamberlain.repository;

import com.balaur.chamberlain.dao.chamberlain.tables.daos.UserDao;
import com.balaur.chamberlain.model.UserSimple;
import org.jooq.DSLContext;
import org.jooq.impl.DefaultDSLContext;

import static com.balaur.chamberlain.dao.chamberlain.Tables.PERMISSION;
import static com.balaur.chamberlain.dao.chamberlain.Tables.USER;

public class UserRepository extends UserDao {

  private final DSLContext dsl;

  public UserRepository(final DefaultDSLContext dsl) {

    super(dsl.configuration());
    this.dsl = dsl;
  }

  public UserSimple findByCredential(final String login) {

    return dsl.select(USER.NAME, USER.SURNAME, PERMISSION.TYPE.as("permissionType"))
              .from(USER)
              .join(PERMISSION)
              .on(PERMISSION.ID.eq(USER.PERMISSION_ID))
              .where(USER.LOGIN.eq(login))
              .fetchOneInto(UserSimple.class);
  }
}
