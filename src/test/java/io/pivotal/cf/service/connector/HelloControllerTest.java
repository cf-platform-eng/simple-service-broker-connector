package io.pivotal.cf.service.connector;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
public class HelloControllerTest {

    @Autowired
    private HelloController helloController;

    @Test
    public void testIt()  {
        String greeting = helloController.greeting();
        assertNotNull(greeting);
        assertEquals("Sorry, I don't think we've met.", greeting);

        String in = null;
        try {
            in = helloController.login("fjgkj", "jhvk");
        } catch (Exception e) {
           //expected
        }

        try {
            in = helloController.login("foo", "bar");
        } catch (Exception e) {
            fail("creds should have been accepted.");
        }

        assertNotNull(in);
        assertEquals("user logged in.", in);

        greeting = helloController.greeting();
        assertNotNull(greeting);
        assertEquals("Hello, foo!", greeting);

        String out = helloController.logout();
        assertNotNull(out);
        assertEquals("User logged out.", out);

        greeting = helloController.greeting();
        assertNotNull(greeting);
        assertEquals("Sorry, I don't think we've met.", greeting);
    }
}