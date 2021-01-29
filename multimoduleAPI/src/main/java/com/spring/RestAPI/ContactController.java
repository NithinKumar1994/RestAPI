package com.spring.RestAPI;

import com.spring.DTO.Contact;
import com.spring.service.ContactService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * Class where the business logic is Executed.
 */
@RestController
@NoArgsConstructor
public class ContactController {

    @Autowired
    private ContactService contactService;

    /**
     *Creating object to interact with Repository module
     */
    public ContactController(ContactService contactService){
       this.contactService=contactService;

    }

    /**
     * Method to get All contacts
     * @return Return list of all contacts present in the table ContactsDatabase.
     */
    @GetMapping("/all")
    public List<Contact> getAllContacts(){
        return contactService.getAllContacts();
    }

    /**
     * Method to find a contact using ID attribute.
     * @param id Attribute id used to find the contact.
     * @return Return the Contact object or throw a contactDoesntExistException.
     */
    @GetMapping("/contact/{id}")
    public Contact getContact(@Valid @PathVariable String id){
        return contactService.getContact(id);
    }

    /**
     * Method to delete contacts using ID attribute.
     * @param id Attribute ID used to find the contact which needs to be deleted.
     * @return Returning a String description of the action performed as a response.
     */
    @DeleteMapping("/contact/delete/{id}")
    public String deleteContact(@PathVariable String id){
        return contactService.deleteContact(id);

    }

    /**
     * Method used to update a contact using ID attribute.
     * @param updateContact The json object sent by the client.
     * @param id ID attribute used to find the contact.
     * @return The contact object
     */
    @PutMapping("/update/{id}")
    public void updateContact(@RequestBody Contact updateContact, @PathVariable String id){
        contactService.updateContact(updateContact,id);
    }

    @PostMapping("/create")
    public String createContact(@Valid @RequestBody Contact contact){
       return contactService.createContact(contact);
    }
}
