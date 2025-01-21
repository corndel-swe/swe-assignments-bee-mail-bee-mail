package beemail;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String id;
    private String userName;
    private List<Message> inbox = new ArrayList<>();
    private MessageMediator mediator;

    public User(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public void sendMessage(String recipient, String content) {
        mediator.deliver(this, recipient, content);
    }

    public void receiveMessage(Message message) {
        inbox.add(message);

    }

    public void readMessage(int index) {
        inbox.get(index).markRead().log();
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setMediator(MessageMediator mediator) {
        this.mediator = mediator;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", inbox=" + inbox +
                ", mediator=" + mediator +
                '}';
    }
}

