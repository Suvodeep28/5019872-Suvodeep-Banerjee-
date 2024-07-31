/*
 * Exercise 6: Library Management System
Scenario: 
You are developing a library management system where users can search for books by title or author.
Steps:
1.	Understand Search Algorithms:
o	Explain linear search and binary search algorithms.
2.	Setup:
o	Create a class Book with attributes like bookId, title, and author.
3.	Implementation:
o	Implement linear search to find books by title.
o	Implement binary search to find books by title (assuming the list is sorted).
4.	Analysis:
o	Compare the time complexity of linear and binary search.
o	Discuss when to use each algorithm based on the data set size and order.

 */



 /*
  * 1. Understand Search Algorithms:
Linear Search: Scans each element sequentially (O(n)).
Binary Search: Divides the search space in half each time (O(log n)).
  */

 class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    
}

class LibraryManagementSystem {
    public Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                return book;
            }
        }
        return null;
    }

    public Book binarySearch(Book[] books, String title) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].title.compareTo(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        Book[] books = {
            new Book(1, "Title1", "Author1"),
            new Book(2, "Title2", "Author2"),
            new Book(3, "Title3", "Author3")
        };
        System.out.println(lms.linearSearch(books, "Title2").title);
        System.out.println(lms.binarySearch(books, "Title3").title);
    }
}


/*4. Analysis:
Time Complexity:
Linear Search: O(n)
Binary Search: O(log n)
When to Use:
Linear Search: Small or unsorted datasets.
Binary Search: Large, sorted datasets. */