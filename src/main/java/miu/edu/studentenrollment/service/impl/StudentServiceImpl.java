package miu.edu.studentenrollment.service.impl;

import miu.edu.studentenrollment.domain.Address;
import miu.edu.studentenrollment.domain.Enrollment;
import miu.edu.studentenrollment.domain.Entry;
import miu.edu.studentenrollment.domain.Student;
import miu.edu.studentenrollment.repository.AddressRepo;
import miu.edu.studentenrollment.repository.StudentRepo;
import miu.edu.studentenrollment.service.AddressService;
import miu.edu.studentenrollment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressRepo addressRepo;

    @Override
    public Student createStudent(Student student) {
        if (addressRepo.findAll().size() != 0) {
            if (this.addressExists(student.getHomeAddress().getCountry(), student.getHomeAddress().getCity(), student.getHomeAddress().getStreet(), student.getHomeAddress().getPostalCode())) {
                student.setHomeAddress(addressService.findAddress(student.getHomeAddress().getCountry(), student.getHomeAddress().getCity(), student.getHomeAddress().getStreet(), student.getHomeAddress().getPostalCode()).get(0));
            }

            if (this.addressExists(student.getMailingAddress().getCountry(), student.getMailingAddress().getCity(), student.getMailingAddress().getStreet(), student.getMailingAddress().getPostalCode())) {
                student.setMailingAddress(addressService.findAddress(student.getMailingAddress().getCountry(), student.getMailingAddress().getCity(), student.getMailingAddress().getStreet(), student.getMailingAddress().getPostalCode()).get(0));
            }
        }

        return studentRepo.save(student);
    }

    @Override
    public void removeStudent(Long studentID) {
        studentRepo.deleteById(studentID);
    }

    @Override
    public Student getStudent(Long studentID) {
        return studentRepo.getOne(studentID);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Long countStudents() {
        return studentRepo.count();
    }

    @Override
    public Address getMailingAddress(Long studentID) {
        return studentRepo.findById(studentID).get().getMailingAddress();
    }

    @Override
    public Address getHomeAddress(Long studentID) {
        return studentRepo.findById(studentID).get().getHomeAddress();
    }

    @Override
    public Entry getEntry(Long studentID) {
        return studentRepo.findById(studentID).get().getEntry();
    }

    @Override
    public List<Enrollment> getAllEnrollments(Long studentID) {
        return studentRepo.findById(studentID).get().getEnrollments();
    }

    public boolean addressExists(String country, String city, String street, Integer postalCode) {
        return addressService.findAddress(country, city, street, postalCode).size() == 0 ? false : true;
    }
}
