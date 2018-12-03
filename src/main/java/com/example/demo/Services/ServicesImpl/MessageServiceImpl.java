package com.example.demo.Services.ServicesImpl;

import com.example.demo.Model.Message;
import com.example.demo.Repositories.MessageRepository;
import com.example.demo.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message getMessage(Long id) {
        return messageRepository.getOne(id);
    }


    @Override
    public Message editMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void deleteMessage(Message message) {
        messageRepository.delete(message);
    }

    @Override
    public List<Message> getAllMessage() {

        return messageRepository.findAll();
    }
}
