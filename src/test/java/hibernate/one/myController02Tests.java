package hibernate.one;

import hibernate.one.Controllers.myController02;
import model.Address;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =WebEnvironment.RANDOM_PORT)
public class myController02Tests {

    @Autowired
    private myController02 controller02;
    @Test
    public void contextLoads() {
        assertThat(controller02).isNotNull();
    }




}
