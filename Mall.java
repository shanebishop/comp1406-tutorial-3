public class Mall {
    public static final int MAX_STORES = 100;

    private String name;
    private Store[] stores;
    private int storeCount;

    public Mall(String n) {
        name = n;
        stores = new Store[MAX_STORES];
        storeCount = 0;
    }

    public void addStore(Store s) {
        if (storeCount < MAX_STORES) {
            stores[storeCount++] = s;
        }
    }

    public boolean shoppedAtSameStore(Customer c1, Customer c2) {
        Customer[] customers;
        Store c1Stores[] = new Store[3];
        Store c2Stores[] = new Store[3];
        int c1StoresVisited = 0;
        int c2StoresVisited = 0;

        for (int i = 0; i < storeCount; i++) {
            customers = stores[i].getCustomers();

            for (int j = 0; j < stores[i].customerCount; j++) {
                if (customers[j].equals(c1)) {
                    c1Stores[c1StoresVisited] = stores[i];
                    c1StoresVisited++;
                }
                else if (customers[j].equals(c2)) {
                    c2Stores[c2StoresVisited] = stores[i];
                    c2StoresVisited++;
                }
            }
        }

        for (int i = 0; i < c1Stores.length; i++) {
            for (int j = 0; i < c2Stores.length; j++) {
                if (c1Stores[i].equals(c2Stores[j])); {
                    return true;
                }
            }
        }

        return false;
    }

    public int uniqueCustomers() {
        Store currentStore;
        Customer[] currentCustomers;
        Customer[] uniqueCustomers = new Customer[500];
        int numUniqueCustomers = 0;

        for (int i = 0; i < storeCount; i++) {
            currentStore = stores[i];
            for (int j = 0; j < stores[i].customerCount; j++) {
                currentCustomers = currentStore.getCustomers();

                System.out.println(numUniqueCustomers);
                for (int k = 0; k < numUniqueCustomers+1; k++) {
                    //System.out.println(k);
                    if (!currentCustomers[j].equals(uniqueCustomers[k])) {
                        uniqueCustomers[numUniqueCustomers] = currentCustomers[j];
                        numUniqueCustomers++;
                    }
                }
            }
        }

        return numUniqueCustomers;
    }
}
