package com.cha102.diyla.sweetclass.teaModel;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherSpringDAOImpl {
    private final TeacherJPAREPO teacherJPAREPO;
    public TeacherSpringDAOImpl(TeacherJPAREPO teacherJPAREPO) {
        this.teacherJPAREPO = teacherJPAREPO;
    }

    public int insert(Teacher teacher) {
        teacherJPAREPO.save(teacher);
        return 1;
    }


    public int update(Teacher teacher) {
        teacherJPAREPO.save(teacher);
        return 1;
    }


    public int deleteById(Integer teaId) {
        teacherJPAREPO.deleteById(teaId);
        return 1;
    }


    public Teacher selectById(Integer teaId) {
        return teacherJPAREPO.findById(teaId).orElse(null);
    }


    public List<Teacher> selectAll() {
        final String hql = "FROM TEACHER ORDER BY TEA_ID";
        return teacherJPAREPO.findAll();
    }

    public Teacher findTeaByEmpID(Integer empId) {
        return teacherJPAREPO.findByEmpId(empId);
    }
}
