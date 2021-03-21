import java.util.Arrays;

/**
 * Array based storage for Employees
 */
public class ArrayStorage {
    private int iterator;
    private Employee employee;
    Employee[] storage = new Employee[10000];

    ArrayStorage (){
        iterator = 0;
        employee = null;
    }

    void clear() {
        for (int i = size(); i > 0 ; i--) {
            storage[i] = employee;
        }
        iterator = 0;
    }

    void save(Employee employee) {
        if(size() == storage.length){
            System.out.println("Array length exceeded");
        } else if ( employee == null){
            System.out.println("Its not null");
        } else {
            storage[iterator] = employee;
            iterator++;
        }
    }

    Employee get(String uuid) {
        for (int i = 0; i < iterator; i++) {
            if (uuid.equals(storage[i].uuid) ) {
                return storage[i];
            }
        }
        System.out.println("Uuid " + uuid + " is not found");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < iterator; i++) {
            if (uuid.equals(storage[i].uuid)) {
                iterator--;
                storage[i] = storage[iterator];
                storage[iterator] = null;
                return;
            }
        }
        System.out.println("Cant delete, uuid " + uuid + " not found");
    }

    /**
     * @return array, contains only Employees in storage (without null)
     */
    Employee[] getAll() {
        return Arrays.copyOfRange(storage, 0, size());
    }

    int size() {
        return iterator;
    }
}
