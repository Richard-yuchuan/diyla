package com.cha102.diyla.sweetclass.teaModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityJPAREPO extends JpaRepository<Speciality, Integer> {
    Speciality findBySpeName(String speName);

}
