package hibernate.one.Controllers;

import hibernate.one.actions.sendMailWithErrorsLogs;
import model.Person;
import Repositories.myPersonRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


/**
 * @author Bianca Culea
 */


@RestController
public class myController01 {
    private static final Logger logger = LogManager.getLogger(myController01.class);

    @Autowired
    private myPersonRepo myPersonRepo;

    // http://localhost:8091/my01/bianca_culea@yahoo.com/
    @RequestMapping("/my01/{email}/")
    public List<Person> find01(@PathVariable String email){
        List<Person> l1 = myPersonRepo.findByEmail(email);
        return l1;
    }

    @Autowired
    sendMailWithErrorsLogs sender;


    @RequestMapping(value="/myPost", method= RequestMethod.POST)
    public ResponseEntity<String> myPostForAll(@RequestBody List<Person> listEntity) {
        //listEntity.stream().map(x->!(myPersonRepo.findByEmail(x.getEmail()).isEmpty()) ? " se regaseste in BD: "+x.toString():" nu se regaseste in BD cu email:"+x.getEmail()).forEach(System.out::println);
        //listEntity.stream().filter(x->!(myPersonRepo.findByEmail(x.getEmail()).isEmpty())).forEach(System.out::println);

        try {
            //listEntity.stream().filter(x->myPersonRepo.findByEmail(x.getEmail()).isEmpty()).forEach(x -> myPersonRepo.save(x));
            listEntity.stream().forEach(x -> myPersonRepo.save(x));
        }catch(Exception e2){
            logger.error("eroare la inacrcare date "+e2.toString());
            String entity1 = "incarcare ratata "+e2.toString();

            sender.sendMail(e2);

            ResponseEntity<String> responseEntity1 = ResponseEntity
                    .status(HttpStatus.OK)
                    .body(entity1);
            return responseEntity1;
        }
        //listEntity.stream().forEach(x->logger.info("raspuns"+x.toString()));

        String headerName = "My-Custom-Header";
        String headerValue1 = "HeaderValue1";
        String headerValue2 = "HeaderValue2";
        String entity1 = "incarcare ok";

        ResponseEntity<String> responseEntity1 = ResponseEntity
                .status(HttpStatus.OK)
                .header(headerName, headerValue1, headerValue2)
                .body(entity1);
        return responseEntity1;
    }

    // http://localhost:8091/my02/bianca
    @RequestMapping("/my02/{firstname}")
    public List<Person> find02(@PathVariable String firstname){
        List<Person> l1 = myPersonRepo.findByFirstname(firstname);
        return l1;
    }

    // http://localhost:8091/my03?lastname=culea
    @RequestMapping("/my03")
    public List<Person> find03(@RequestParam String lastname){
        List<Person> l1 = myPersonRepo.findPersonByLastname(lastname);
        return l1;
    }

    //http://localhost:8091/my04?lastname=culea
    @RequestMapping("/my04")
    public List<Person> find04(@RequestParam String lastname){
        List<Person> l1 = myPersonRepo.findFirst2ByLastname(lastname);
        return l1;
    }

   // You're trying to execute a streaming query method without a surrounding transaction that
   // keeps the connection open so that the Stream can actually be consumed.
   // Make sure the code consuming the stream uses @Transactional or any other way of declaring
   // a (read-only) transaction.


    // http://localhost:8091/my05/culea/
    @RequestMapping("/my05/{lastname}/")
    @Transactional
    public List<Person> find05(@PathVariable String lastname){
        try(Stream<Person> st1 = myPersonRepo.findByLastnameReturnStream(lastname)) {
          //st1.forEach(System.out::println);
            List<Person> l1= st1.collect(Collectors.toList());
            logger.info("my05 - test log in file !");
            return l1;
        }
    }

    //http://localhost:8091/my055/culea/
    @RequestMapping("/my055/{lastname}/")
    @Transactional
    public Stream<Person> find055(@PathVariable String lastname){
//        try(Stream<Person> st1 = myPersonRepo.findByLastnameReturnStream(lastname)) {
//            return st1;
//        }
        return myPersonRepo.findByLastnameReturnStream(lastname);
    }

    // http://localhost:8091/my06culea/
    @RequestMapping("/my06/{lastname}")
    public List<Person> find06(@PathVariable String lastname){
        List<Person> l1 = myPersonRepo.findByLastnameOrderByFirstnameAscLastnameDesc(lastname, orderBy());
            return l1;
    }

    private Sort orderBy() {
        return new Sort(Sort.Direction.DESC, "lastname")
                .and(new Sort(Sort.Direction.ASC, "firstname"));
    }


}

