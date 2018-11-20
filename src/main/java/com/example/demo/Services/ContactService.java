package com.example.demo.Services;

import com.example.demo.Model.Contact;

import java.util.List;

public interface ContactService {

    Contact createContact(Contact contact);
    Contact getContact(Long id);
    Contact editContact(Contact contact);
    void deleteContact(Contact contact);
    List<Contact> getAllContact();

}
