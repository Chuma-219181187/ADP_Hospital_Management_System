/*
DoctorService
Name: Chante Lee Davids
Student number: 220246688
Date: 13 August 2022
 */

package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Repository.IDoctorRepository;
import za.ac.cput.Service.Interfaces.IDoctorService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DoctorService implements IDoctorService {

    private final IDoctorRepository repository;

    @Autowired
    public DoctorService(IDoctorRepository iDoctorRepository){
        this.repository = iDoctorRepository;
    }

    @Override
    public Doctor save(Doctor doctor) {
        return repository.save(doctor);
    }

    @Override
    public Doctor read(String doctorId) {
        return repository.findById(doctorId).orElse(null);
    }

    @Override
    public boolean delete(String doctorId) {
        if(this.repository.existsById(doctorId)){
            repository.deleteById(doctorId);
            return true;
        }
        return false;
    }

    @Override
    public Set<Doctor> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}