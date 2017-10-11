package Repositories;
import model.Person;

import org.hibernate.criterion.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public interface myPersonRepo extends JpaRepository<Person,Integer> {
  List<Person> findByEmail(String email);
  List<Person> findByFirstname(String firstname);
  List<Person> findPersonByLastname(String lastname);
  List<Person> findFirst2ByLastname(String lastname);

  @Query("select p from Person p where p.lastname=:lastname")
  Stream<Person> findByLastnameReturnStream(@Param("lastname") String lastname);

//  @Query("");
//  Integer nrInreg = UpdateByList(List<Person>);

  List<Person > findByLastnameOrderByFirstnameAscLastnameDesc(String firstname, Sort sort);





}

