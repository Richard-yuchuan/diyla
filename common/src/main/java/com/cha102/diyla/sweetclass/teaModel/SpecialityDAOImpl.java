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
    @PersistenceContext
    private Session session;

    @Override
    public int insert(Speciality speciality) {
        session.persist(speciality);
        return 1;
    }

    @Override
    public int update(Speciality speciality) {
        session.update(speciality);
        return 1;
    }

    @Override
    public int deleteById(Integer speId) {
        Speciality speciality = session.load(Speciality.class, speId);
        session.remove(speciality);
        return 1;
    }

    @Override
    public Speciality selectById(Integer speId) {
        return session.get(Speciality.class, speId);
    }
    @Override
    public Speciality findBySpeName(String speName){
        final String hql = "FROM Speciality WHERE spe_Name = :speName";
        return session.createQuery(hql, Speciality.class).setParameter("speName", speName).uniqueResult();
    }
    @Override
    public List<Speciality> selectAll() {
        final String hql = "FROM Speciality ORDER BY spe_id";
        return session.createQuery(hql, Speciality.class).getResultList();
    }
}
