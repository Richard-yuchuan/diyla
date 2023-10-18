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
public class TeaSpecialityDAOImpl implements TeaSpecialityDAO {
    private final TeaSpecialityJPAREPO teaSpecialityJPAREPO;
    public TeaSpecialityDAOImpl(TeaSpecialityJPAREPO teaSpecialityJPAREPO) {
        this.teaSpecialityJPAREPO = teaSpecialityJPAREPO;
    }
    @Override
    public int insert(TeaSpeciality teaSpeciality){
        teaSpecialityJPAREPO.save(teaSpeciality);
        return 1;
    }

    @Override
    public int update(TeaSpeciality teaSpeciality) {
        teaSpecialityJPAREPO.save(teaSpeciality);
        return 1;
    }

    @Override
    public int deleteById(Integer teaId) {
        teaSpecialityJPAREPO.deleteById(teaId);
        return 1;
    }


    @Override
    public TeaSpeciality selectById(Integer teaId) {
        return teaSpecialityJPAREPO.findById(teaId).orElse(null);
    }
    @Override
    public List<Integer> selectByTeaId(Integer teaId) {
        List<TeaSpeciality> resultList = teaSpecialityJPAREPO.findByTea_TeaId(teaId);
        List<Integer> teaSpeIdList = new ArrayList<>();
        for(TeaSpeciality teaSpeciality : resultList) {
            teaSpeIdList.add(teaSpeciality.getSpeId());
        }
        return teaSpeIdList;
    }
    @Override
    public List<TeaSpeciality> selectAll() {
        return teaSpecialityJPAREPO.findAll();
    }
}
