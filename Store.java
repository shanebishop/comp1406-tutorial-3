public class Store {
    public static final int MAX_CUSTOMERS = 500;

    String name;
    Customer[] customers;
    int customerCount;

    public Store(String n) {
        name = n;
        customers = new Customer[MAX_CUSTOMERS];
        customerCount = 0;
    }

    public Customer[] getCustomers() { return customers; }
    public int getCustomerCount() { return customerCount; }

    public void addCustomer(Customer c) {
        if (customerCount < MAX_CUSTOMERS) {
            c.setId(Customer.LATEST_ID++);
            customers[customerCount++] = c;
        }
    }

    public void listCustomers() {
        for (int i = 0; i < customerCount; i++) {
            System.out.println(customers[i]);
        }
    }

    public int averageCustomerAge() {
        int sum = 0;

        for (int i = 0; i < customerCount; i++) {
            sum += customers[i].getAge();
        }

        return sum / customerCount;
    }

    public char mostPopularGender() {
        int females = 0;
        int males   = 0;

        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getGender() == 'F') {
                females++;
            }
            else {
                males++;
            }
        }

        if (females >= males) {
            return 'F';
        }
        else {
            return 'M';
        }
    }

    public Customer richestCustomer() {
        Customer richest = customers[0];
        Customer current;

        for (int i = 0; i < customerCount; i++) {
            current = customers[i];

            if (current.hasMoreMoneyThan(richest)) {
                richest = current;
            }
        }

        return richest;
    }

    public Customer[] getCustomersWithGender(char g) {
        int sum = 0;

        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getGender() == g) {
                sum++;
            }
        }

        Customer[] retval = new Customer[sum];
        int customersAdded = 0;

        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getGender() == g) {
                retval[customersAdded] = customers[i];
                customersAdded++;
            }
        }

        return retval;
    }

    public Customer[] friendsFor(Customer lonelyCustomer) {
        Customer[] customersWithSameGender = getCustomersWithGender(lonelyCustomer.getGender());
        Customer[] retval = new Customer[4];
        int customersAdded = 0;

        for (int i = 0; i < customersWithSameGender.length; i++) {
            Customer current = customersWithSameGender[i];
            if ((current.getAge() >= (lonelyCustomer.getAge() - 3)) &&
                    (current.getAge() <= (lonelyCustomer.getAge() + 3))) {
                retval[customersAdded] = current;
                customersAdded++;
            }
        }

        return retval;
    }
}
