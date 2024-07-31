/*
 * Exercise 4: Employee Management System
Scenario: 
You are developing an employee management system for a company. Efficiently managing employee records is crucial.
Steps:
1.	Understand Array Representation:
o	Explain how arrays are represented in memory and their advantages.
2.	Setup:
o	Create a class Employee with attributes like employeeId, name, position, and salary.
3.	Implementation:
o	Use an array to store employee records.
o	Implement methods to add, search, traverse, and delete employees in the array.
4.	Analysis:
o	Analyze the time complexity of each operation (add, search, traverse, delete).
o	Discuss the limitations of arrays and when to use them.


 */



 /*
  * Arrays in Memory: Arrays are contiguous blocks of memory with fixed size, allowing constant-time access (O(1)).
  */

  class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    // Getters and Setters
}

class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        }
    }

    public Employee searchEmployee(int employeeId) {
        for (Employee employee : employees) {
            if (employee != null && employee.employeeId == employeeId) {
                return employee;
            }
        }
        return null;
    }

    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i] != null && employees[i].employeeId == employeeId) {
                employees[i] = employees[--size];
                employees[size] = null;
                break;
            }
        }
    }

    public void traverseEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.name);
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);
        Employee e1 = new Employee(1, "Alice", "Developer", 50000);
        ems.addEmployee(e1);
        ems.traverseEmployees();
        System.out.println(ems.searchEmployee(1).name);
        ems.deleteEmployee(1);
    }
}


/*4. Analysis:
Time Complexity:
Add: O(1)
Search: O(n)
Traverse: O(n)
Delete: O(1) */