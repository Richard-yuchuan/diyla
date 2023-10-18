package com.cha102.diyla.sweetclass.teaModel;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class SpecialityDAOImpl implements SpecialityDAO {

    private final SpecialityJPAREPO specialityJPAREPO;
    public SpecialityDAOImpl(SpecialityJPAREPO specialityJPAREPO) {
        this.specialityJPAREPO = specialityJPAREPO;
    }

    @Override
    public int insert(Speciality speciality) {
        specialityJPAREPO.save(speciality);
        return 1;
    }

    @Override
    public int update(Speciality speciality) {
        specialityJPAREPO.save(speciality);
        return 1;
    }

    @Override
    public int deleteById(Integer speId) {
        specialityJPAREPO.deleteById(speId);
        return 1;
    }

    @Override
    public Speciality selectById(Integer speId) {
        return specialityJPAREPO.findById(speId).orElse(null);
    }
    @Override
    public Speciality findBySpeName(String speName){
        return specialityJPAREPO.findBySpeName(speName);
    }
    @Override
    public List<Speciality> selectAll() {
        return specialityJPAREPO.findAll();
    }
}
