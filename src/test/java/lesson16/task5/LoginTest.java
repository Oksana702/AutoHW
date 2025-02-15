package lesson16.task5;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

    public class LoginTest {

        @Test
        @Parameters({"username", "password"})
        public void testLogin(String username, String password) {
            System.out.println("Testing login with Username: " + username + ", Password: " + password);

        }
    }
