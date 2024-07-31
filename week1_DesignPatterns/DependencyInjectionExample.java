// DependencyInjectionExample.java

// Step 2: Define Repository Interface

// Create an interface CustomerRepository with methods like findCustomerById()
interface CustomerRepository {
    Customer findCustomerById(int id);
}

// Step 3: Implement Concrete Repository

// Create a class CustomerRepositoryImpl that implements CustomerRepository
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        // In a real application, this method would query a database.
        // Here we just return a dummy customer for demonstration.
        if (id == 1) {
            return new Customer(1, "Alice", "alice@example.com");
        } else {
            return null;
        }
    }
}

// Define a Customer class to represent customer details
class Customer {
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}

// Step 4: Define Service Class

// Create a class CustomerService that depends on CustomerRepository
class CustomerService {
    private CustomerRepository customerRepository;

    // Step 5: Implement Dependency Injection via constructor
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }
}

// Step 6: Test the Dependency Injection Implementation

// Main class to demonstrate creating a CustomerService with CustomerRepositoryImpl
// and using it to find a customer
public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Create a CustomerRepositoryImpl object
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the CustomerRepository into CustomerService using constructor injection
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the CustomerService to find a customer
        Customer customer = customerService.getCustomerById(1);
        
        if (customer != null) {
            System.out.println("Customer found: " + customer);
        } else {
            System.out.println("Customer not found.");
        }
    }
}
