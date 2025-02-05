import { v4 as uuidv4 } from 'uuid';

// Message class
class Message {
    constructor(from, to, content) {
        this.id = uuidv4();
        this.datetime = new Date();
        this.content = content;
        this.from = from;
        this.to = to;
        this.delivered = false;
        this.read = false;
    }

    log() {
        console.log(`Message ID: ${this.id}, From: ${this.from.username}, To: ${this.to.username}, Sent: ${this.datetime}, Content: ${this.content}, Delivered: ${this.delivered}, Read: ${this.read}`);
    }

    markDelivered() {
        this.delivered = true;
    }

    markRead() {
        this.read = true;
    }
}

export default Message;