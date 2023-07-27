package com.test.disrupting.vet.repository;

import com.test.disrupting.vet.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

    List<Appointment> findByPatientId(Integer patientId);

    List<Appointment> findByDoctorId(Integer doctorId);
}
