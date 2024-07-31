// MVCPatternExample.java

// Step 2: Define Model Class

// Create a class Student with attributes like name, id, and grade
class Student {
    private String name;
    private int id;
    private String grade;

    public Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

// Step 3: Define View Class

// Create a class StudentView with a method displayStudentDetails()
class StudentView {
    public void displayStudentDetails(String studentName, int studentId, String studentGrade) {
        System.out.println("Student Details:");
        System.out.println("Name: " + studentName);
        System.out.println("ID: " + studentId);
        System.out.println("Grade: " + studentGrade);
    }
}

// Step 4: Define Controller Class

// Create a class StudentController that handles the communication between the model and the view
class StudentController {
    private Student student;
    private StudentView studentView;

    public StudentController(Student student, StudentView studentView) {
        this.student = student;
        this.studentView = studentView;
    }

    public String getStudentName() {
        return student.getName();
    }

    public void setStudentName(String name) {
        student.setName(name);
    }

    public int getStudentId() {
        return student.getId();
    }

    public void setStudentId(int id) {
        student.setId(id);
    }

    public String getStudentGrade() {
        return student.getGrade();
    }

    public void setStudentGrade(String grade) {
        student.setGrade(grade);
    }

    public void updateView() {
        studentView.displayStudentDetails(student.getName(), student.getId(), student.getGrade());
    }
}

// Step 5: Test the MVC Implementation

// Main class to demonstrate creating a Student, updating its details using StudentController,
// and displaying them using StudentView
public class MVCPatternExample {
    public static void main(String[] args) {
        // Create a Student object
        Student student = new Student("John Doe", 1, "A");

        // Create a StudentView object
        StudentView studentView = new StudentView();

        // Create a StudentController object
        StudentController studentController = new StudentController(student, studentView);

        // Display student details using the view
        studentController.updateView();

        // Update student details
        studentController.setStudentName("Jane Smith");
        studentController.setStudentId(2);
        studentController.setStudentGrade("B");

        // Display updated student details using the view
        studentController.updateView();
    }
}
