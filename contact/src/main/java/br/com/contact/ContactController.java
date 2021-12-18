package br.com.contact;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> get(){
        return this.contactService.getAllContacts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createContact(@RequestBody Contact contact){
        this.contactService.createContact(contact);
    }
    
    @PutMapping(value = "/{id}")
    private void updateContact(@PathVariable("id") long id, @RequestBody Contact contact) {
        this.contactService.updateContact(id, contact);
    }


    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable("id") Long id){
        this.contactService.removeContact(id);

    }

    @GetMapping("/find-by-name")
    @ResponseStatus(HttpStatus.OK)
    public Contact getContactByName(@RequestParam String name){
        return this.contactService.getContactByName(name);
    }
}
