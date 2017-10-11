package hibernate.one;

import hibernate.one.Controllers.myController01;
import hibernate.one.Controllers.myMailSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class myController01MailTests {
    @Autowired
    myMailSender myMS;

    @Test
    public void contextLoads() {
        assertThat(myMS).isNotNull();
    }


//    @Test
//    void ShouldSendMailTo(){
//        assertThat(myController).isNotNull();
//    }
}
