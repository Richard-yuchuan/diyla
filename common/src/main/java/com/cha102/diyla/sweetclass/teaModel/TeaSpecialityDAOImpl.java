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
    @PersistenceContext
    private Session session;
    @Override
    public int insert(TeaSpeciality teaSpeciality){
        session.persist(teaSpeciality);
        return 1;
    }

    @Override
    public int update(TeaSpeciality teaSpeciality) {
        session.update(teaSpeciality);
        return 1;
    }

    @Override
    public int deleteById(Integer teaId) {
        TeaSpeciality teaSpeciality = session.load(TeaSpeciality.class, teaId);
        return 1;
    }


    @Override
    public TeaSpeciality selectById(Integer teaId) {
        final String hql = "FROM TeaSpeciality WHERE tea_Id = :teaId";
        return session.createQuery(hql, TeaSpeciality.class).setParameter("teaId", teaId).uniqueResult();
    }
    @Override
    public List<Integer> selectByTeaId(Integer teaId) {
        final String hql = "FROM TeaSpeciality WHERE tea_Id = :teaId";
        List<TeaSpeciality> resultList = session.createQuery(hql, TeaSpeciality.class).setParameter("teaId", teaId).getResultList();
        List<Integer> teaSpeIdList = new ArrayList<>();
        for(TeaSpeciality teaSpeciality : resultList) {
            teaSpeIdList.add(teaSpeciality.getSpeId());
        }
        return teaSpeIdList;
    }
    @Override
    public List<TeaSpeciality> selectAll() {
        final String hql = "FROM TeaSpeciality ORDER BY TEA_ID";
        return session.createQuery(hql, TeaSpeciality.class).getResultList();
    }
}
