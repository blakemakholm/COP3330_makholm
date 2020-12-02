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
    public void editingItemDescriptionFailsWithInvalidIndex() throws Throwable{
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        int i = -1;
        assertThrows(IllegalArgumentException.class, () -> list.get(i).setTaskDescription("new desc"));
    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue() throws Throwable{
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        item.setTaskDescription("new desc");
        assertEquals("new desc", item.getTaskDescription());
    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue() throws Throwable{
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        item.setTaskDate("2020-12-04");
        assertEquals("2020-12-04", item.getTaskDate());
    }

    @Test
    public void editingItemTitleFailsWithEmptyString() throws Throwable{
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        assertThrows(InvalidNameException.class, () -> item.setTaskTitle(""));
    }

    @Test
    public void editingItemTitleFailsWithInvalidIndex() throws Throwable{
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        int i = -1;
        assertThrows(IllegalArgumentException.class, () -> list.get(i).setTaskTitle("new title"));
    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue() throws Throwable{
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        item.setTaskTitle("new title");
        assertEquals("new title", item.getTaskTitle());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat() throws Throwable{
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        assertThrows(InvalidNameException.class, () -> item.setTaskDate("2020-14-4"));
    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex() throws Throwable{
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        int i = -1;
        assertThrows(IllegalArgumentException.class, () -> list.get(i).getTaskDescription());
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex() throws Throwable{
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        int i = 0;
        assertEquals("desc", list.get(i).getTaskDescription());
    }

    @Test
    public void gettingItemDueDateFailsWithInvalidIndex() throws Throwable{
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        int i = -1;
        assertThrows(IllegalArgumentException.class, () -> list.get(i).getTaskDate());
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex() throws Throwable{
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        int i = 0;
        assertEquals("2020-11-16", list.get(i).getTaskDate());
    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex() throws Throwable{
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        int i = -1;
        assertThrows(IllegalArgumentException.class, () -> list.get(i).getTaskTitle());
    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex() throws Throwable{
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        int i = 0;
        assertEquals("title", list.get(i).getTaskTitle());
    }

    @Test
    public void newListIsEmpty() throws Throwable{
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskList list = new TaskList(arraylist);
        assertEquals(0, list.size());
    }

    @Test
    public void removingItemsDecreasesSize() throws Throwable{
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskItem item2 = new TaskItem("title2", "desc2", "2020-11-17", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        list.add(item2);
        assertEquals(2, list.size());
        list.remove(1);
        assertEquals(1, list.size());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() throws Throwable{
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskItem item = new TaskItem("title", "desc", "2020-11-16", false);
        TaskItem item2 = new TaskItem("title2", "desc2", "2020-11-17", false);
        TaskList list = new TaskList(arraylist);
        list.add(item);
        list.add(item2);
        assertEquals(2, list.size());
        int i = -1;
        assertThrows(IllegalArgumentException.class, () -> list.remove(i));
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
        list.loadList(list2, "tasklist.txt");
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