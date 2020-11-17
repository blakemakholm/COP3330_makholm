import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import javax.naming.InvalidNameException;

class TaskListTest {
    @Test
    public void addingTaskItemsIncreasesSize() throws InvalidNameException {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        assertEquals(1, list.size());
    }

    @Test
    public void completingTaskItemChangesStatus() throws InvalidNameException {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        list.markItemComplete(0);
        assertEquals("*** 2020-11-16", item.getTaskDate());
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() throws InvalidNameException{
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        int i = -1;
        assertThrows(IllegalArgumentException.class, () -> list.markItemComplete(i));
    }

    @Test
    public void editingTaskItemChangesValues() throws InvalidNameException {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        int i = 0;
        list.get(i).setTaskTitle("newTitle");
        assertEquals("newTitle", item.getTaskTitle());
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() throws InvalidNameException {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        int i = 0;
        list.get(i).setTaskDescription("newDescription");
        assertEquals("newDescription", item.getTaskDescription());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() throws InvalidNameException {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        int i = -1;
        assertThrows(IllegalArgumentException.class, () -> list.get(i).setTaskDescription("newDescription"));
    }

    @Test
    public void editingTaskItemDueDateChangesValue() throws InvalidNameException {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        int i = 0;
        list.get(i).setTaskDate("2020-11-17");
        assertEquals("2020-11-17", item.getTaskDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() throws InvalidNameException {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        int i = -1;
        assertThrows(IllegalArgumentException.class, () -> list.get(i).setTaskDate("2020-11-17"));
    }

    @Test
    public void editingTaskItemTitleChangesValue() throws InvalidNameException {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        int i = 0;
        list.get(i).setTaskTitle("new Title");
        assertEquals("new Title", item.getTaskTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() throws InvalidNameException {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        int i = -1;
        assertThrows(IllegalArgumentException.class, () -> list.get(i).setTaskTitle("title 2"));
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() throws InvalidNameException {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        int i = -1;
        assertThrows(IllegalArgumentException.class, () -> list.get(i).setTaskDescription("2020-11-17"));
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() throws InvalidNameException {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        int i = 0;
        assertEquals("desc", list.get(i).getTaskDescription());
    }


    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() throws InvalidNameException {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        int i = -1;
        assertThrows(IllegalArgumentException.class, () -> list.get(i).setTaskDate("2020-11-17"));
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() throws InvalidNameException {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        int i = 0;
        assertEquals("2020-11-16", list.get(i).getTaskDate());
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() throws InvalidNameException {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        int i = -1;
        assertThrows(IllegalArgumentException.class, () -> list.get(i).setTaskTitle("new title"));
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() throws InvalidNameException {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        int i = 0;
        assertEquals("title", list.get(i).getTaskTitle());
    }

    @Test
    public void newTaskListIsEmpty(){
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskList list = new TaskList(arraylist);
        assertEquals(0, list.size());
    }

    @Test
    public void removingTaskItemsDecreasesSize() throws InvalidNameException {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        int startSize = list.size();
        list.remove(0);
        assertEquals(startSize - 1, list.size());
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() throws InvalidNameException {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        assertThrows(IllegalArgumentException.class, () -> list.remove(-1));
    }

    @Test
    public void savedTaskListCanBeLoaded() throws Throwable {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        list.saveList();
        ArrayList<TaskItem> arraylist2 = new ArrayList<>();
        TaskList list2 = new TaskList(arraylist2);
        list.loadList(list2, "list.txt");
        assertEquals("title", list2.get(0).getTaskTitle());
    }

    @Test
    public void uncompletingTaskItemChangesStatus() throws InvalidNameException {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", true);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        list.markItemIncomplete(0);
        assertEquals("2020-11-16", item.getTaskDate());
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() throws InvalidNameException {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", true);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        list.markItemIncomplete(0);
        int i = -1;
        assertThrows(IllegalArgumentException.class, () -> list.get(i).setTaskDate("2020-11-17"));
    }
}