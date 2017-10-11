package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.QueryHints;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.persistence.*;

@Entity (name="Person")
//@JsonIgnoreProperties(ignoreUnknown = true)
//@NamedQuery(name = "selectPerson", query = "SELECT a FROM person a",
//        hints = @QueryHint(name = QueryHints.COMMENT, value = "Bi custom SQL comment"))

public class Person implements Serializable {
        @Id
        //@GeneratedValue(strategy = GenerationType.SEQUENCE)
        @GeneratedValue(strategy =GenerationType.AUTO) // vezi si application.properties
        private int id;
        private String firstname;
        private String lastname;
        private String email;
        private String phone;
        private String addr;
        private String city;
        private String  myuser;
        private String password;
        private String salt;

        public Person(){}

    public Person(int id, String firstname, String lastname, String email, String phone, String addr, String city, String myuser, String password, String salt) {
        this.id=id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.addr = addr;
        this.city = city;
        this.myuser = myuser;
        this.password = password;
        this.salt = salt;
    }

        public void setId(int id){
            this.id=id;
        }
        public int getId(){
            return this.id;
        }
        public void setFirstname(String firstname){
            this.firstname=firstname;
        }
        public String getFirstname(){
            return this.firstname;
        }

        public void setLastname(String lastname){
            this.lastname=lastname;
        }
        public String getLastname(){
            return this.lastname;
        }

        public void setEmail(String email){
            this.email=email;
        }
        public String getEmail(){
            return this.email;
        }

        public void setPhone(String phone){
            this.phone=phone;
        }
        public String getPhone(){
            return this.phone;
        }

//        //@JsonIgnoreProperties("person")
//        @JsonIgnore
//        public  List<Person> getPerson(){
//            return Collections.singletonList(this);
//        }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getMyuser() {
                return myuser;
            }

            public void setMyuser(String myuser) {
                this.myuser = myuser;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getSalt() {
                return salt;
            }

            public void setSalt(String salt) {
                this.salt = salt;
            }

    @Override
        public String toString(){
            return "FirstName="+this.firstname+" "+"LastName="+this.lastname+" email:"+this.email;
        }
}

