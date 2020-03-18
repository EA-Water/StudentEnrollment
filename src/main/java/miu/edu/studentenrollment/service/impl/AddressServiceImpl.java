package miu.edu.studentenrollment.service.impl;

import miu.edu.studentenrollment.domain.Address;
import miu.edu.studentenrollment.repository.AddressRepo;
import miu.edu.studentenrollment.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Override
    public List<Address> findAddress(String country, String city, String street, Integer postalCode) {
        return addressRepo.findByCountryAndCityAndStreetAndPostalCode(country,city,street,postalCode);
    }
}
