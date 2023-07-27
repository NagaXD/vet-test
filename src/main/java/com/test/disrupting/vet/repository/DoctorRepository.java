package com.test.disrupting.vet.repository;

import com.test.disrupting.vet.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
}
