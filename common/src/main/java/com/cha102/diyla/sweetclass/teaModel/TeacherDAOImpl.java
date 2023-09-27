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
public class TeacherDAOImpl implements TeacherDAO {
    @PersistenceContext
    private Session session;

    @Override
    public int insert(Teacher teacher) {
        session.persist(teacher);
        return 1;
    }

    @Override
    public int update(Teacher teacher) {
        session.update(teacher);
        return 1;
    }

    @Override
    public int deleteById(Integer teaId) {
        Teacher teacher = session.load(Teacher.class, teaId);
        session.remove(teacher);
        return 1;
    }

    @Override
    public Teacher selectById(Integer teaId) {
        return session.get(Teacher.class, teaId);
    }

    @Override
    public List<Teacher> selectAll() {
        final String hql = "FROM TEACHER ORDER BY TEA_ID";
        return session.createQuery(hql, Teacher.class).getResultList();
    }
    public Teacher findTeaByEmpID(Integer empId) {
        final String hql = "FROM TEACHER WHERE empId = :empId";
        return session.createQuery(hql,Teacher.class).setParameter("empId", empId).uniqueResult();
    }
}
