package com.spring.service;

import com.spring.DTO.Contact;
import com.spring.exceptionHandling.contactExceptions;
import com.spring.repositoryContact.contactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactService {
    @Autowired
    private contactRepository contactRep;

    /**
     *Creating object to interact with Repository module
     */
    public ContactService(contactRepository contactRep) throws contactExceptions{
        this.contactRep=contactRep;

    }

    /**
     * Method to get All contacts
     * @return Return list of all contacts present in the table ContactsDatabase.
     */
    public List<Contact> getAllContacts() throws contactExceptions{

        return contactRep.findAll();
    }

    /**
     * Method to find a contact using ID attribute.
     * @param id Attribute id used to find the contact.
     * @return Return the Contact object or throw a contactDoesntExistException.
     */
    public Contact getContact(String id) throws contactExceptions{
        return contactRep.findById(id)
                .orElseThrow(() -> new contactExceptions(id));
    }

    /**
     * Method to delete contacts using ID attribute.
     * @param id Attribute ID used to find the contact which needs to be deleted.
     * @return Returning a String description of the action performed as a response.
     */
    public String deleteContact(String id) throws contactExceptions{
        if(!contactRep.findById(id).isPresent())
            return "Id does'nt exist.";
        else {
            String response = contactRep.findById(id).get() + " exists.";
            contactRep.deleteById(id);
            return response + "Delete successful";
        }

    }

    /**
     * Method used to update a contact using ID attribute.
     * @param updateContact The json object sent by the client.
     * @param id ID attribute used to find the contact.
     * @return The contact object
     */
    public void updateContact(Contact updateContact,String id) throws contactExceptions{
        if(!contactRep.findById(id).isPresent()){
            throw new contactExceptions(id);
        }

        contactRep.findById(id).map(contact ->{
            contact.setName(updateContact.getName());
            contact.setPhone(updateContact.getPhone());
            contactRep.save(contact);
            return "Update successful";
        });
    }

    public String createContact( Contact contact){
        //Checking if Numbers are only present
        if(!contact.getId().matches("[0-9]+")){
            throw new contactExceptions(contact.getId(),"Please enter only numbers");
        }

        //checking if Id is already present and raising an exception
        if(contactRep.findById(contact.getId()).isPresent()){
            throw new contactExceptions("ID:"+contact.getId() +" already exists in database",new Throwable());
        }
        Contact insertContact= contactRep.insert(contact);
        return "Contact created " + insertContact.getName();
    }
}

