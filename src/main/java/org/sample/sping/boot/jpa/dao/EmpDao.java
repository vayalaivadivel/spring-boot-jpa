package org.sample.sping.boot.jpa.dao;

import org.sample.sping.boot.jpa.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpDao extends JpaRepository<Emp, Integer> {

}
