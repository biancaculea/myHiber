package hibernate.one.Controllers;

import model.Address;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Repositories.MyAddressRepo;
/**
 * @author Bianca Culea
 */

@RestController
public class myController02 {

    @Autowired
    MyAddressRepo myAddressRepo;

    @RequestMapping(value="/address/{street}")
    public List<Address> getAddressBy(@PathVariable("street") String street ){
        return  myAddressRepo.getAddressByStreet(street);
    }


}
