const repository = require('../data/messageRepository');

async function listMessages() {
    return await repository.getAllMessages();
}

async function createMessage(text) {
    if (!text || typeof text !== 'string') {
        throw new Error('Invalid text parameter');
    }
    if (text.length > 250) {
        throw new Error('Text exceeds maximum length of 250 characters');
    }
    return await repository.saveMessage(text);
}

module.exports = {
    listMessages,
    createMessage
};
