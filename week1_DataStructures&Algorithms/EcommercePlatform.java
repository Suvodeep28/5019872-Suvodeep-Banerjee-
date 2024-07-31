// Exercise 2: E-commerce Platform Search Function
// Scenario: 
// You are working on the search functionality of an e-commerce platform. The search needs to be optimized for fast performance.
// Steps:
// 1.	Understand Asymptotic Notation:
// o	Explain Big O notation and how it helps in analyzing algorithms.
// o	Describe the best, average, and worst-case scenarios for search operations.
// 2.	Setup:
// o	Create a class Product with attributes for searching, such as productId, productName, and category.
// 3.	Implementation:
// o	Implement linear search and binary search algorithms.
// o	Store products in an array for linear search and a sorted array for binary search.
// 4.	Analysis:
// o	Compare the time complexity of linear and binary search algorithms.
// o	Discuss which algorithm is more suitable for your platform and why.


/*Big O Notation: Describes the upper limit of an algorithm's time complexity, providing a worst-case scenario.
Best, Average, and Worst Cases:
Best: The scenario with the least time complexity.
Average: The scenario with the average time complexity.
Worst: The scenario with the highest time complexity. */

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // Getters and Setters
}

class EcommercePlatformSearch {
    public Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.productName.equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public Product binarySearch(Product[] products, String productName) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].productName.compareTo(productName);
            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        EcommercePlatformSearch eps = new EcommercePlatformSearch();
        Product[] products = {
            new Product(1, "Product1", "Category1"),
            new Product(2, "Product2", "Category2"),
            new Product(3, "Product3", "Category3")
        };
        System.out.println(eps.linearSearch(products, "Product2").productName);
        System.out.println(eps.binarySearch(products, "Product3").productName);
    }
}


/*4. Analysis:
Time Complexity:
Linear Search: O(n)
Binary Search: O(log n)
 */