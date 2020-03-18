package miu.edu.studentenrollment.repository;

import miu.edu.studentenrollment.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
   List<Address> findByCountryAndCityAndStreetAndPostalCode(String country, String city, String street, Integer postalCode);
}
