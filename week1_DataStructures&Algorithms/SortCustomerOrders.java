/*
 * Exercise 3: Sorting Customer Orders
Scenario: 
You are tasked with sorting customer orders by their total price on an e-commerce platform. This helps in prioritizing high-value orders.
Steps:
1.	Understand Sorting Algorithms:
o	Explain different sorting algorithms (Bubble Sort, Insertion Sort, Quick Sort, Merge Sort).
2.	Setup:
o	Create a class Order with attributes like orderId, customerName, and totalPrice.
3.	Implementation:
o	Implement Bubble Sort to sort orders by totalPrice.
o	Implement Quick Sort to sort orders by totalPrice.
4.	Analysis:
o	Compare the performance (time complexity) of Bubble Sort and Quick Sort.
o	Discuss why Quick Sort is generally preferred over Bubble Sort.

 */


 /*
Understand Sorting Algorithms:
Bubble Sort: Simple but inefficient for large datasets (O(n^2)).
Insertion Sort: Efficient for small or nearly sorted datasets (O(n^2)).
Quick Sort: Efficient for large datasets (average O(n log n)).
Merge Sort: Consistent O(n log n) time complexity.


  */

  class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
}

class SortCustomerOrders {
    public void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        SortCustomerOrders sco = new SortCustomerOrders();
        Order[] orders = {
            new Order(1, "Customer1", 200.0),
            new Order(2, "Customer2", 100.0),
            new Order(3, "Customer3", 300.0)
        };
        sco.bubbleSort(orders);
        for (Order order : orders) {
            System.out.println(order.totalPrice);
        }
        sco.quickSort(orders, 0, orders.length - 1);
        for (Order order : orders) {
            System.out.println(order.totalPrice);
        }
    }
}

/*
 * 4. Analysis:
Time Complexity:
Bubble Sort: O(n^2)
Quick Sort: Average O(n log n), Worst O(n^2)
Preference: Quick Sort is generally preferred due to its average-case efficiency and better performance on large datasets.
 */

