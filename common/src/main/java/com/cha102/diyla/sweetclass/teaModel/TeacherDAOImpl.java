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
    private final TeacherJPAREPO teacherJPAREPO;
    public TeacherDAOImpl(TeacherJPAREPO teacherJPAREPO) {
        this.teacherJPAREPO = teacherJPAREPO;
    }
    @Override
    public int insert(Teacher teacher) {
        teacherJPAREPO.save(teacher);
        return 1;
    }

    @Override
    public int update(Teacher teacher) {
        teacherJPAREPO.save(teacher);
        return 1;
    }

    @Override
    public int deleteById(Integer teaId) {
        teacherJPAREPO.deleteById(teaId);
        return 1;
    }

    @Override
    public Teacher selectById(Integer teaId) {
        return teacherJPAREPO.findById(teaId).orElse(null);
    }

    @Override
    public List<Teacher> selectAll() {
        final String hql = "FROM TEACHER ORDER BY TEA_ID";
        return teacherJPAREPO.findAll();
    }
    @Override
    public Teacher findTeaByEmpID(Integer empId) {
        return teacherJPAREPO.findByEmpId(empId);
    }
}
