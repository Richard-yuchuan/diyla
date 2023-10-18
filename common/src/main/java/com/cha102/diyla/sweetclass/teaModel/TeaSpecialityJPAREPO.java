package com.cha102.diyla.sweetclass.teaModel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeaSpecialityJPAREPO extends JpaRepository<TeaSpeciality, Integer> {
    TeaSpeciality findByTeacherId(Integer teaId);
    List<TeaSpeciality> findByTea_TeaId(Integer teaId);
}
