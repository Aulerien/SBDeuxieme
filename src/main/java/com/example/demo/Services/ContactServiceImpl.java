package com.example.demo.Services;

import com.example.demo.Model.Contact;
import com.example.demo.Repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Optional<Contact> getContact(Long id) {
         return contactRepository.findById(id);
    }

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
