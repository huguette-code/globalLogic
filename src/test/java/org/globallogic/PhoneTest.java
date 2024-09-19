package org.globallogic;

import org.globallogic.beans.others.Phone;
import org.globallogic.beans.resquest.LoginRequest;
import org.globallogic.constant.Constant;
import org.globallogic.dao.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PhoneTest {
    @Test
    void phonesTest() throws Exception {
        List<Phone> phones = getPhonesForTest();
        Phone phone1 = phones.get(0);
        assertNotNull(phone1);
        assertNotEquals(phone1.hashCode(),0);
        assertEquals(phone1, phones.get(1));
        assertNotEquals(phone1.toString(),"");

    }

    private List<Phone> getPhonesForTest() {
        Phone phone = new Phone("946644558","1","57");
        Phone phone1 = new Phone("946644558","1","57");
        List<Phone> phones = new ArrayList<>();
        phones.add(phone);
        phones.add(phone1);

        return phones;
    }

}
