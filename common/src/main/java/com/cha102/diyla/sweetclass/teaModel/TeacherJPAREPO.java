package com.cha102.diyla.sweetclass.teaModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherJPAREPO extends JpaRepository<Teacher, Integer> {
    Teacher findByEmpId(Integer empId);

}
