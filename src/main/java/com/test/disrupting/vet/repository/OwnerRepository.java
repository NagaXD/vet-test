package com.test.disrupting.vet.repository;

import com.test.disrupting.vet.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
