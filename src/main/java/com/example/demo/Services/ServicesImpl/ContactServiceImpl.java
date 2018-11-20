package com.example.demo.Services.ServicesImpl;

import com.example.demo.Model.Contact;
import com.example.demo.Repositories.ContactRepository;
import com.example.demo.Services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact getContact(Long id) { return contactRepository.getOne(id); }

    @Override
    public Contact editContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }

    @Override
    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }
}
