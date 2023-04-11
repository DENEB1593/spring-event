package io.study.deneb.event;

import io.study.deneb.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener {

  private static final Logger log = LoggerFactory.getLogger(UserEventListener.class);

  @Async
  @EventListener
  public void listen(UserEvent event) {
    User user = event.getUser();
    log.info("[listener] user : {}", user);
  }

}
