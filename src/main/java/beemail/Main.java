package beemail;

public class Main {
    public static void main(String[] args) {
        MessageMediator messenger = Messenger.getInstance();

        User charlie = new User("123", "Charlie");
        User violet = new User("456", "Violet");
        User mike = new User("789", "Mike");

        messenger.login(charlie);
        messenger.login(violet);
        messenger.login(mike);

        charlie.sendMessage("456", "Hello Violet");

        violet.readMessage(0);

        violet.sendMessage("123", "Hey Charlie, nice to meet you.");
        charlie.readMessage(0);

        messenger.getUsers().forEach(System.out::println);
    }
}
