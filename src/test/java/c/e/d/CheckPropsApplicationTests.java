package c.e.d;

import c.e.d.p.Message;
import c.e.d.p.MessageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CheckPropsApplicationTests {

    @Autowired
    MessageRepository repository;

    @Value("${my.message}")
    private String message;

    @Test
    public void TestProfile() {
        assertEquals( "test profile activated", message);

    }

    @Test
    public void testDbConfig() {
        Message m = new Message();
        m.setMessage("qwett1");
        repository.save(m);
        Message m1 = repository.findDistinctByMessage("qwett1");

        assertEquals( m, m1);

    }



}
