package br.com.contact;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.BeansException;

public interface ContactService {
    public void createContact(Contact contact);
    public void removeContact(Long id);
    public void updateContact(Long id, Contact contact) throws BeansException;
    public Contact getContactByName(String name);
    public Contact getByName(String name);
    public List<Contact> getAllContacts();
}
