import Message from "./message.js";
import User from "./user.js";

// Singleton App class
class App {
    constructor() {
        if (App.instance) {
            return App.instance;
        }
        this.users = [];
        App.instance = this;
    }

    addUser(user) {
        this.users.push(user);
    }

    findUser(userId) {
        return this.users.find(user => user.id === userId);
    }

    deliverMessage(senderId, recipientId, content) {
        const recipient = this.findUser(recipientId);
        if (recipient) {
            const message = new Message(senderId, recipient, content);
            recipient.receiveMessage(message);
        }
    }
}

const app = new App();
const user1 = new User('1', 'Alice');
const user2 = new User('2', 'Bob');

user1.login(app);
user2.login(app);

user1.sendMessage('2', 'Hello Bob!');
user2.readMessage(0);