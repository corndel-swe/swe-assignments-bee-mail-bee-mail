package beemail;

import java.util.List;

public interface MessageMediator {
    void login(User user);

    void deliver(User sender, String recipientId, String content);

    List<User> getUsers();
}
