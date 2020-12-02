import org.junit.jupiter.api.Test;
import javax.naming.InvalidNameException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
    @Test
    public void addingItemsIncreasesSize() throws Throwable {
        ArrayList<ContactItem> arraylist = new ArrayList<>();
        ContactItem item = new ContactItem("first", "last", "123-456-7890", "abc@xyz.co");
        ContactList list = new ContactList(arraylist);
        list.add(item);
        assertEquals(1, list.size());
    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){
        ArrayList<ContactItem> arraylist = new ArrayList<>();
        assertThrows(InvalidNameException.class, () -> new ContactItem("", "", "", ""));
    }

    @Test
    public void editingItemsFailsWithInvalidIndex() throws Throwable {
        ArrayList<ContactItem> arraylist = new ArrayList<>();
        ContactItem item = new ContactItem("first", "last", "123-456-7890", "abc@xyz.co");
        ContactList list = new ContactList(arraylist);
        list.add(item);
        int i = -1;
        assertThrows(IndexOutOfBoundsException.class, () -> list.replace(i, item));
    }

    @Test
    public void editingSucceedsWithBlankFirstName() throws Throwable {
        ArrayList<ContactItem> arraylist = new ArrayList<>();
        ContactItem item = new ContactItem("first", "last", "123-456-7890", "abc@xyz.co");
        ContactList list = new ContactList(arraylist);
        list.add(item);
        item.setFirstName("");
        assertEquals("", item.getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankLastName() throws Throwable {
        ArrayList<ContactItem> arraylist = new ArrayList<>();
        ContactItem item = new ContactItem("first", "last", "123-456-7890", "abc@xyz.co");
        ContactList list = new ContactList(arraylist);
        list.add(item);
        item.setLastName("");
        assertEquals("", item.getLastName());
    }

    @Test
    public void editingSucceedsWithBlankPhone() throws Throwable {
        ArrayList<ContactItem> arraylist = new ArrayList<>();
        ContactItem item = new ContactItem("first", "last", "123-456-7890", "abc@xyz.co");
        ContactList list = new ContactList(arraylist);
        list.add(item);
        item.setPhoneNum("");
        assertEquals("", item.getPhoneNum());
    }

    @Test
    public void editingSucceedsWithNonBlankValues() throws Throwable {
        ArrayList<ContactItem> arraylist = new ArrayList<>();
        ContactItem item = new ContactItem("first", "last", "123-456-7890", "abc@xyz.co");
        ContactList list = new ContactList(arraylist);
        list.add(item);
        item.setPhoneNum("456-123-7890");
        assertEquals("456-123-7890", item.getPhoneNum());
    }

    @Test
    public void newListIsEmpty(){
        ArrayList<ContactItem> arraylist = new ArrayList<>();
        ContactList list = new ContactList(arraylist);
        assertEquals(0, list.size());
    }

    @Test
    public void removingItemsDecreasesSize() throws Throwable {
        ArrayList<ContactItem> arraylist = new ArrayList<>();
        ContactItem item = new ContactItem("first", "last", "123-456-7890", "abc@xyz.co");
        ContactItem item1 = new ContactItem("john", "smith", "321-654-0987", "john.smith@ucf.edu");
        ContactList list = new ContactList(arraylist);
        list.add(item);
        list.add(item1);
        assertEquals(2, list.size());
        list.remove(1);
        assertEquals(1, list.size());
    }


    @Test
    public void removingItemsFailsWithInvalidIndex() throws Throwable {
        ArrayList<ContactItem> arraylist = new ArrayList<>();
        ContactItem item = new ContactItem("first", "last", "123-456-7890", "abc@xyz.co");
        ContactList list = new ContactList(arraylist);
        list.add(item);
        assertThrows(IllegalArgumentException.class, () -> list.remove(-1));
    }

    @Test
    public void savedContactListCanBeLoaded() throws Throwable {
        ArrayList<ContactItem> arraylist = new ArrayList<>();
        ContactItem item = new ContactItem("first", "last", "123-456-7890", "abc@xyz.co");
        ContactList list = new ContactList(arraylist);
        list.add(item);
        list.saveList();
        ArrayList<ContactItem> arraylist2 = new ArrayList<>();
        ContactList list2 = new ContactList(arraylist2);
        list.loadList(list2, "contactlist.txt");
        assertEquals("first", list2.get(0).getFirstName());
    }

}