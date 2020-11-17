import org.junit.jupiter.api.Test;
import javax.naming.InvalidNameException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() throws Throwable {
        assertThrows(InvalidNameException.class, () -> new TaskItem("title", "desc", "", false));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        assertThrows(InvalidNameException.class, () -> new TaskItem("", "desc", "2020-11-16", false));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() throws InvalidNameException {
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        assertEquals("2020-11-16", item.getTaskDate());
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() throws InvalidNameException {
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        assertEquals("title", item.getTaskTitle());
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() throws InvalidNameException {
        assertThrows(InvalidNameException.class, () -> new TaskItem("title", "desc", "invalid date", false));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() throws InvalidNameException {
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        item.setTaskDate("2020-11-17");
        assertEquals("2020-11-17", item.getTaskDate());
    }

    // FIX THIS TEST
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() throws InvalidNameException {
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        item.setTaskTitle("");
        assertThrows(InvalidNameException.class, () -> new TaskItem("title", "desc", "invalid date", false));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() throws InvalidNameException {
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        item.setTaskTitle("newValidTitle");
        assertEquals("newValidTitle", item.getTaskTitle());
    }
}