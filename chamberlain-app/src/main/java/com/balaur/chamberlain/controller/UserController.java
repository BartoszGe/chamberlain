package com.balaur.chamberlain.controller;

import com.balaur.chamberlain.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "rest")
public class UserController {

  private final UserService userService;

  public UserController(final UserService userService) {

    this.userService = userService;
  }

  @GetMapping("/user")
  public ResponseEntity<?> getUser(@RequestParam(required = true) final String login) {

    return ResponseEntity.ok(userService.findByCredential(login));
  }

}
