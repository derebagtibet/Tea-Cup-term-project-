const express = require('express');
const path = require('path');
const messageService = require('../application/messageservice');

const app = express();
const PORT = 3000;

app.use(express.json());
app.use(express.static('presentation'));

app.get('/api/messages', async (req, res) => {
    try {
        const messages = await messageService.listMessages();
        res.json(messages);
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

app.post('/api/messages', async (req, res) => {
    try {
        const { message } = req.body;
        if (!message || typeof message !== 'string') {
            return res.status(400).json({ error: 'Invalid message parameter' });
        }
        if (message.length > 250) {
            return res.status(400).json({ error: 'Text exceeds maximum length of 250 characters' });
        }
        await messageService.createMessage(message);
        res.status(201).json({ success: true });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});

