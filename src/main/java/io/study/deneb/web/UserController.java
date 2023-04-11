package io.study.deneb.web;

import io.study.deneb.event.UserEvent;
import io.study.deneb.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("api/users")
public class UserController {

  private static final Logger log = LoggerFactory.getLogger(UserController.class);

  private final ApplicationEventPublisher event;

  public UserController(ApplicationEventPublisher event) {
    this.event = event;
  }


  @PostMapping
  public User signUp(@RequestBody  SignUpRequest request) {
    User user = new User(
        ThreadLocalRandom.current().nextLong(),
        request.name(),
        LocalDateTime.now()
    );

    // signUp
    event.publishEvent(new UserEvent(this, user));

    return user;
  }


}
