const db = require('./database');

async function saveMessage(text) {
    return new Promise((resolve, reject) => {
        db.run('INSERT INTO messages (text) VALUES (?)', [text], function(err) {
            if (err) {
                reject(err);
            } else {
                resolve({ id: this.lastID, text: text });
            }
        });
    });
}

async function getAllMessages() {
    return new Promise((resolve, reject) => {
        db.all('SELECT * FROM messages ORDER BY timestamp DESC', [], (err, rows) => {
            if (err) {
                reject(err);
            } else {
                resolve(rows);
            }
        });
    });
}

module.exports = {
    saveMessage,
    getAllMessages
};

