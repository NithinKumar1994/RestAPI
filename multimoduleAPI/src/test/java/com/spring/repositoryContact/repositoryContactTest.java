package com.spring.repositoryContact;

import com.spring.DTO.Contact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Nithin Kumar Pechetti, np2598
 * repository unit test cases.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class repositoryContactTest {

        @Autowired
        contactRepository contactRep;
        Contact c;
        public repositoryContactTest(){
        c=new Contact("20","Naruto","8885780090");
    }

    /**
     * Test that verifies if Repository is working
     */
      @Test
      public void testRepository_insert_returnsTrue(){


          contactRep.insert(c);
          assertEquals(true,contactRep.findById(c.getId()).isPresent());

    }

    @Test
    public void testRepository_delete_returnsTrue(){

        contactRep.delete(c);
        assertEquals(false,contactRep.findById(c.getId()).isPresent());

    }


}
