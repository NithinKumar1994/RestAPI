package com.spring.DTO;
import static org.junit.Assert.*;

import com.spring.DTO.Contact;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Nithin Kumar Pechetti, np2598
 * repository unit test cases.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class contactTest {
    private Contact c;

    public contactTest(){
        c=new Contact("21","Saskue","9999999999");
    }

    @Test
    public void contactTest_returnsContactDetails(){


        assertEquals("21",c.getId());
        assertEquals("Saskue",c.getName());
        assertEquals("9999999999",c.getPhone());


    }
}
