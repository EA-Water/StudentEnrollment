package miu.edu.studentenrollment.service;

import miu.edu.studentenrollment.domain.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAddress(String country, String city, String street, Integer postalCode);
}
