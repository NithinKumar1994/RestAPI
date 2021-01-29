package com.spring.RestAPI;


import com.spring.DTO.Contact;
import com.spring.service.ContactService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ContactController.class)
class ContactControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactService contactService;
    private Contact mockContact=new Contact("36","Nithin6","99996");;
    private ContactController cct;

    public ContactControllerTest() {
        cct = new ContactController(contactService);
    }
    @Test
    void getContact() throws Exception {
        Mockito.when(contactService.getContact(Mockito.anyString())).thenReturn(mockContact);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contact/5").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());
        String expected = "{\"id\":\"36\",\"name\":\"Nithin6\",\"phone\":\"99996\"}";
        System.out.println(result.getResponse().getContentAsString());
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }
    @Test
    void getAllContacts() throws Exception {
        Mockito.when(contactService.getContact(Mockito.anyString())).thenReturn(mockContact);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/all").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedStatus = "200";
        JSONAssert.assertEquals(expectedStatus, String.valueOf(result.getResponse().getStatus()), false);
    }


    @Test
    void deleteContact() throws Exception {
     Mockito.when(contactService.getContact(Mockito.anyString())).thenReturn(mockContact);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/contact/delete/36").accept(MediaType.APPLICATION_JSON);
    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    String expectedStatus = "200";

    JSONAssert.assertEquals(expectedStatus, String.valueOf(result.getResponse().getStatus()), false);
    }

//    @Test
//    void updateContact() throws Exception {
//
//    RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/update/36").accept(MediaType.APPLICATION_JSON);
//    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//    String expectedStatus = "200";
//        System.out.println(result.getResponse().getContentAsString());
//
//    JSONAssert.assertEquals(expectedStatus, String.valueOf(result.getResponse().getStatus()), false);
//    }


}

