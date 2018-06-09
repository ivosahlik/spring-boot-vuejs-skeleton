package cz.ivosahlik.service;

import cz.ivosahlik.model.Message;
import cz.ivosahlik.repository.BackendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Intellij Idea
 * Created by ivosahlik on 09/06/2018
 */
@Service
public class BackendService {

    @Autowired
    private BackendRepository backendRepository;

    public void saveMessage() {
        Message message = new Message();
        message.setId(1);
        message.setDescription("java spring framework developer");
        message.setUsername("ivo");
        message.setDate(new Date());
        backendRepository.save(message);
    }

    public List<Message> listMessages() {
        return backendRepository.findAll();
    }

}
