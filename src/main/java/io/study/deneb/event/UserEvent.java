package io.study.deneb.event;

import io.study.deneb.model.User;
import org.springframework.context.ApplicationEvent;

public class UserEvent extends ApplicationEvent {

  private final User user;

  public UserEvent(Object source, User user) {
    super(source);
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  @Override
  public String toString() {
    return "UserEvent{" +
        "user=" + user +
        ", source=" + source +
        '}';
  }
}
