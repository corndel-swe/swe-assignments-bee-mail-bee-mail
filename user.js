// User class
class User {
    constructor(id, username) {
        this.id = id;
        this.username = username;
        this.inbox = [];
        this.app = null;
    }

    login(app) {
        this.app = app;
        app.addUser(this);
    }

    sendMessage(recipientId, content) {
        if (this.app) {
            this.app.deliverMessage(this, recipientId, content);
        }
    }

    receiveMessage(message) {
        message.markDelivered();
        this.inbox.push(message);
    }

    readMessage(idx) {
        if (idx >= 0 && idx < this.inbox.length) {
            const message = this.inbox[idx];
            message.markRead();
            message.log();
        }
    }
}

export default User;