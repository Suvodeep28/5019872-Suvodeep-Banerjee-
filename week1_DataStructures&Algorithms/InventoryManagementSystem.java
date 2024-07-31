/*Exercise 1: Inventory Management System
Scenario: 
You are developing an inventory management system for a warehouse. Efficient data storage and retrieval are crucial.
Steps:
1.	Understand the Problem:
o	Explain why data structures and algorithms are essential in handling large inventories.
o	Discuss the types of data structures suitable for this problem.
2.	Setup:
o	Create a new project for the inventory management system.
3.	Implementation:
o	Define a class Product with attributes like productId, productName, quantity, and price.
o	Choose an appropriate data structure to store the products (e.g., ArrayList, HashMap).
o	Implement methods to add, update, and delete products from the inventory.
4.	Analysis:
o	Analyze the time complexity of each operation (add, update, delete) in your chosen data structure.
o	Discuss how you can optimize these operations.
 */

/*
 * 
 * 
Importance of Data Structures and Algorithms: Efficient data structures and algorithms are crucial in handling large inventories because they ensure quick data retrieval, updates, and management. This leads to faster processing times and better performance, which is essential in managing a large number of products.
Suitable Data Structures: For this problem, suitable data structures include:
ArrayList: Allows dynamic resizing and random access.
HashMap: Provides fast access, insertion, and deletion (average O(1) time complexity).


 */

 import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    
}

class InventoryManagementSystem {
    private HashMap<Integer, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.productId, product);
    }

    public void updateProduct(Product product) {
        inventory.put(product.productId, product);
    }

    public void deleteProduct(int productId) {
        inventory.remove(productId);
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Product p1 = new Product(1, "Product1", 10, 100.0);
        ims.addProduct(p1);
        ims.updateProduct(new Product(1, "Product1 Updated", 20, 200.0));
        ims.deleteProduct(1);
    }
}

/*
Analysis:
Time Complexity:
Add: O(1)
Update: O(1)
Delete: O(1)
 */