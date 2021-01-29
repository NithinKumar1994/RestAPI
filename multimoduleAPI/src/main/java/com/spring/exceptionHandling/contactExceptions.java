package com.spring.exceptionHandling;

/**
 * Custom Exception class for Contacts
 * Used to deal with errors where ID is not found,Id already exists etc.
 */
public class contactExceptions extends RuntimeException {

    public contactExceptions(String id){
        super("Id:"+id+" does'nt exist in database");

    }

    public contactExceptions(String id,String msg){
        super("Id:"+id+"\n"+ msg);

    }

    public contactExceptions(String id, Throwable cause ){
        super(id,cause);
    }

}
