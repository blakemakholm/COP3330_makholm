import org.junit.jupiter.api.Test;
import javax.naming.InvalidNameException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues() throws Throwable {
        assertThrows(InvalidNameException.class, () -> new ContactItem("", "", "", ""));
    }

    @Test
    public void creationSucceedsWithBlankEmail() throws Throwable {
        ContactItem item = new ContactItem("first", "last", "123-456-7890", "");
        assertEquals("first", item.getFirstName());
    }

    @Test
    public void creationSucceedsWithBlankFirstName() throws Throwable {
        ContactItem item = new ContactItem("", "last", "123-456-7890", "abc@xyz.co");
        assertEquals("last", item.getLastName());
    }

    @Test
    public void creationSucceedsWithBlankLastName() throws Throwable {
        ContactItem item = new ContactItem("first", "", "123-456-7890", "abc@xyz.co");
        assertEquals("first", item.getFirstName());
    }

    @Test
    public void creationSucceedsWithBlankPhone() throws Throwable {
        ContactItem item = new ContactItem("first", "last", "", "abc@xyz.co");
        assertEquals("first", item.getFirstName());
    }

    @Test
    public void creationSucceedsWithNonBlankValues() throws Throwable {
        ContactItem item = new ContactItem("first", "last", "123-456-7890", "abc@xyz.co");
        assertEquals("first", item.getFirstName());
        assertEquals("last", item.getLastName());
        assertEquals("123-456-7890", item.getPhoneNum());
        assertEquals("abc@xyz.co", item.getEmail());
    }

    @Test
    public void editingFailsWithAllBlankValues() throws Throwable {
        assertThrows(InvalidNameException.class, () -> new ContactItem("", "", "", ""));
    }

    @Test
    public void editingSucceedsWithBlankEmail() throws Throwable {
        ContactItem item = new ContactItem("first", "last", "123-456-7890", "");
        assertEquals("", item.getEmail());
    }

    @Test
    public void editingSucceedsWithBlankFirstName() throws Throwable {
        ContactItem item = new ContactItem("", "last", "123-456-7890", "abc@xyz.com");
        assertEquals("", item.getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankLastName() throws Throwable {
        ContactItem item = new ContactItem("first", "", "123-456-7890", "abc@xyz.com");
        assertEquals("", item.getLastName());
    }

    @Test
    public void editingSucceedsWithBlankPhone() throws Throwable {
        ContactItem item = new ContactItem("first", "last", "", "abc@xyz.com");
        assertEquals("", item.getPhoneNum());
    }

    @Test
    public void editingSucceedsWithNonBlankValues() throws Throwable {
        ContactItem item = new ContactItem("first", "last", "123-456-7890", "abc@xyz.com");
        item.setFirstName("first2");
        assertEquals("first2", item.getFirstName());
    }

    @Test
    public void testToString() throws Throwable {
        ContactItem item = new ContactItem("first", "last", "123-456-7890", "abc@xyz.com");
        String response = item.toString();
        assertEquals(response, "ContactItem{ firstName=first, lastName=last, phoneNum=123-456-7890, email=abc@xyz.com}");
    }

}