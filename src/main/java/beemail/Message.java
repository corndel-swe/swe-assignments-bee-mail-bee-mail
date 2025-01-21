package beemail;

import java.time.LocalDate;
import java.util.UUID;

public class Message {

    private String id = UUID.randomUUID().toString();
    private LocalDate timestamp = LocalDate.now();
    private String content;
    private User from;
    private User to;
    private boolean delivered = false;
    private boolean read = false;

    public Message(String content, User from, User to) {
        this.content = content;
        this.from = from;
        this.to = to;
    }

    public void log() {
        String format = "| %-15s | %-30s |%n";
        System.out.format("+-----------------+--------------------------------+%n");
        System.out.format("| Field           | Value                          |%n");
        System.out.format("+-----------------+--------------------------------+%n");
        System.out.format(format, "Created", timestamp);
        System.out.format(format, "From", from.getUserName());
        System.out.format(format, "To", to.getUserName());
        System.out.format(format, "Content", content);
        System.out.format(format, "Delivered", delivered);
        System.out.format(format, "Read", read);
        System.out.format("+-----------------+--------------------------------+%n");
    }

    public void markDelivered() {
        delivered = true;
    }

    public Message markRead() {
        read = true;
        return this;
    }
}
