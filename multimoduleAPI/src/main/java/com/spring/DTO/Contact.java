package com.spring.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Contact class used for creating contact objects which are stored in Database
 * Using Lombok to manage getter,setters.
 */
@Getter
@Setter
@NoArgsConstructor
@Document(collection="contacts")
public class Contact {

    @NotNull
    private String id;
    @NotNull
    @Size(min=2, message="Name should have at least 3 characters")
    private String name;
    @NotNull
    @Size(min=10, max=10, message="Phone should have 10 characters")
    private String phone;

    public Contact(String id,String name,String phone){
        super();
        this.id=id;
        this.name=name;
        this.phone= phone;

    }

//    public String toString(){
//
//        return "ID:"+this.id+" Name of the contact:"+ this.name + " PhoneNumber:"+this.phone;
//    }


}
