// Customer.java
class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// CustomerRepository.java
interface CustomerRepository {
    Customer findCustomerById(int id);
}

// CustomerRepositoryImpl.java
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        return new Customer(id, "John Doe");
    }
}

// CustomerService.java
class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);

        Customer customer = customerService.getCustomerById(1);
        System.out.println("Customer ID: " + customer.getId() + ", Customer Name: " + customer.getName());
    }
}
