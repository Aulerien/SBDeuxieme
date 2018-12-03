package com.example.demo.Services;


import com.example.demo.Model.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {

    Message createMessage(Message message);
    Message getMessage(Long id);
    Message editMessage(Message message);
    void deleteMessage(Message message);
    List<Message> getAllMessage();
    
}
