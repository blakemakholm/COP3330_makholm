import org.junit.jupiter.api.Test;
import javax.naming.InvalidNameException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void constructorFailsWithInvalidDueDate() throws Throwable{
        assertThrows(InvalidNameException.class, () -> new TaskItem("title", "desc", "", false));
    }

    @Test
    public void constructorFailsWithInvalidTitle() throws Throwable{
        assertThrows(InvalidNameException.class, () -> new TaskItem("", "desc", "2020-12-2", false));
    }

    @Test
    public void constructorSucceedsWithValidDueDate() throws Throwable{
        TaskItem task = new TaskItem("title", "desc", "2020-12-02", false);
        assertEquals(task.getTaskDate(), "2020-12-02");
    }

    @Test
    public void constructorSucceedsWithValidTitle() throws Throwable{
        TaskItem task = new TaskItem("title", "desc", "2020-12-02", false);
        assertEquals(task.getTaskTitle(), "title");
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue() throws Throwable{
        TaskItem task = new TaskItem("title", "desc", "2020-12-02", false);
        task.setTaskDescription("new desc");
        assertEquals(task.getTaskDescription(), "new desc");
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat() throws Throwable{
        TaskItem task = new TaskItem("title", "desc", "2020-12-02", false);
        assertThrows(InvalidNameException.class, () -> task.setTaskDate("2020-14-2"));
    }

    @Test
    public void editingDueDateFailsWithInvalidYYYMMDD() throws Throwable{
        TaskItem task = new TaskItem("title", "desc", "2020-12-02", false);
        assertThrows(InvalidNameException.class, () -> task.setTaskDate("202-14-2"));
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue() throws Throwable{
        TaskItem task = new TaskItem("title", "desc", "2020-12-02", false);
        task.setTaskDate("2020-12-04");
        assertEquals(task.getTaskDate(), "2020-12-04");
    }

    @Test
    public void editingTitleFailsWithEmptyString() throws Throwable{
        TaskItem task = new TaskItem("title", "desc", "2020-12-02", false);
        assertThrows(InvalidNameException.class, () -> task.setTaskTitle(""));
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue() throws Throwable{
        TaskItem task = new TaskItem("title", "desc", "2020-12-02", false);
        task.setTaskTitle("new title");
        assertEquals(task.getTaskTitle(), "new title");
    }

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

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() throws InvalidNameException {
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        item.setTaskTitle("newValidTitle");
        assertEquals("newValidTitle", item.getTaskTitle());
    }
}