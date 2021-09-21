package domain.service;

import config.annotation.read.ReadDataBase;
import config.annotation.write.WriteDataBase;

import java.util.Collection;

public interface CustomerService {
    @WriteDataBase
    void addCustomer(String name);

    @ReadDataBase
    Collection<String> listAllCustomerName();

    @WriteDataBase
    void updateCustomerName(String id, String name);

    @WriteDataBase
    void deleteCustomer(String id);
}
