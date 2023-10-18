package com.cha102.diyla.sweetclass.teaModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherJPAREPO extends JpaRepository<Teacher, Integer> {
    Teacher findByTeacherId(Integer teaId);
    Teacher findByEmpId(Integer empId);

}
