/*
 * Exercise 5: Task Management System
Scenario: 
You are developing a task management system where tasks need to be added, deleted, and traversed efficiently.
Steps:
1.	Understand Linked Lists:
o	Explain the different types of linked lists (Singly Linked List, Doubly Linked List).
2.	Setup:
o	Create a class Task with attributes like taskId, taskName, and status.
3.	Implementation:
o	Implement a singly linked list to manage tasks.
o	Implement methods to add, search, traverse, and delete tasks in the linked list.
4.	Analysis:
o	Analyze the time complexity of each operation.
o	Discuss the advantages of linked lists over arrays for dynamic data.

 */


//  Singly Linked List: Each node points to the next node.
// Doubly Linked List: Each node points to both the next and previous nodes.

class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    // Getters and Setters
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class TaskManagementSystem {
    private Node head;

    public TaskManagementSystem() {
        head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void deleteTask(int taskId) {
        if (head == null) return;
        if (head.task.taskId == taskId) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.task.taskId != taskId) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task.taskName);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();
        Task t1 = new Task(1, "Task1", "Pending");
        tms.addTask(t1);
        tms.traverseTasks();
        System.out.println(tms.searchTask(1).taskName);
        tms.deleteTask(1);
    }
}

/*
 * 
 * 4. Analysis:
Time Complexity:
Add: O(n) (or O(1) with tail pointer)
Search: O(n)
Traverse: O(n)
Delete: O(n)
Advantages: Dynamic size, efficient for frequent insertions and deletions.
 */