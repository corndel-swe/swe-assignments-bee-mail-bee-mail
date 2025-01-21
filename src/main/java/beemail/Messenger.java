package beemail;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Messenger implements MessageMediator {

    private static Messenger messenger = null;

    public static Messenger getInstance() {
        if (messenger == null) {
            messenger = new Messenger();
        }
        return messenger;
    }

    private Messenger() {
    }

    private final List<User> users = new ArrayList<>();

    private Optional<User> findUserById(String id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void login(User user) {
        users.add(user);
        user.setMediator(this);
    }

    @Override
    public void deliver(User sender, String recipientId, String content) {
        Optional<User> recipient = findUserById(recipientId);
        if (recipient.isEmpty()) {
            // SHOULD DO SOMETHING HERE
            return;
        }
        Message message = new Message(content, sender, recipient.get());
        recipient.get().receiveMessage(message);
        message.markDelivered();
    }
}
