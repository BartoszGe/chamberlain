package com.balaur.chamberlain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserSimple {

  private final String name;

  private final String surname;

  private final String permissionType;
}
