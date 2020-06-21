package com.balaur.chamberlain.service;

import com.balaur.chamberlain.dao.UserSimple;
import com.balaur.chamberlain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(final UserRepository userRepository) {

    this.userRepository = userRepository;
  }

  public UserSimple findByCredential(final String login) {

    return userRepository.findByCredential(login);

  }
}
