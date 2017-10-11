package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Address;

import java.util.List;


public interface MyAddressRepo extends JpaRepository<Address,Integer> {
    List<Address> getAddressByStreet(String street);
}
