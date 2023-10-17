package com.cha102.diyla.sweetclass.teaService;

import com.cha102.diyla.sweetclass.teaModel.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
@Service
public abstract class TeacherServiceImpl implements TeacherService{
    @PersistenceContext
    private Session session;
    @Autowired
    private TeacherDAOImpl teaDao;
    @Autowired
    private SpecialityDAOImpl speDao;
    @Autowired
    private TeaSpecialityDAOImpl teaSpeDao;
    @Override
    public int addTeacher(Teacher teacher) {
        return teaDao.insert(teacher);
    }
    @Override
    public Teacher updateTeacher(Teacher teacher) {
        teaDao.update(teacher);
        return teaDao.selectById(teacher.getTeaId());
    }
    @Override
    public boolean deleteTeacher(Integer teaId) {
        Integer result = teaDao.deleteById(teaId);
        if(result == 1) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public Teacher getOneTeacher(Integer teaId) {
        return teaDao.selectById(teaId);
    }
    @Override
    public Teacher getOneTeacherByEmpId(Integer empId) {
        return teaDao.findTeaByEmpID(empId);
    }
    @Override
    public List<String> getTeacherSpeciality(Integer teaId) {
        final String hql = "SELECT ts.speciality.spe_Name FROM TeaSpeciality ts WHERE ts.tea_Id = :teaId";
        Query<String> query = session.createQuery(hql, String.class);
        return query.setParameter("tea_Id", teaId).getResultList();
    }
    @Override
    public List<Teacher> getAllTeacher() {
        return teaDao.selectAll();
    }
    @Override
    public boolean isEmpAlreadyTeacher(Integer empId){
        List<Teacher> allTeacher = teaDao.selectAll();
        boolean result = false;
        for(Teacher teacher: allTeacher) {
            if (empId == teacher.getEmpId()) {
                result = true;
            }
        }
        return result;
    }
    @Override
    public boolean verifyTeacherId(Integer teaId) {
        try{
            teaDao.selectById(teaId);
            return true;
        } catch (RuntimeException re) {
            return false;
        }
    }
    @Override
    public boolean updateTeaStatus(Integer teaId, Integer status) {
        Teacher teacher = getOneTeacher(teaId);
        teacher.setTeaStatus(status);
        Integer result = teaDao.update(teacher);
        if(result == 1) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public Speciality addSpeciality(String speName) {
        Speciality speciality = new Speciality();
        speciality.setSpeName(speName);
        speDao.insert(speciality);
        return speDao.findBySpeName(speName);
    }
    @Override
    public boolean deleteSpeciality(Integer speId) {
        Integer result = speDao.deleteById(speId);
        if(result == 1) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public Integer getOneSpecialityId(String speName) {
        return speDao.findBySpeName(speName).getSpeId();
    }
    @Override
    public String getTeacherSpecialityString(Integer teaId) {
        List<Speciality> speList = speDao.selectAll();
        List<Integer> teaSpeIDList = teaSpeDao.selectByTeaId(teaId);
        List<String> teacherSpecialities = new ArrayList<>();
        for(Speciality spe: speList) {
            if(teaSpeIDList.contains(spe.getSpeId())) {
                teacherSpecialities.add(spe.getSpeName());
            }
        }
        StringBuilder teacherSpeString = new StringBuilder();
        for (int i = 0; i < teacherSpecialities.size(); i++) {
            teacherSpeString.append(teacherSpecialities.get(i));
            if (i < teacherSpecialities.size() - 1) {
                teacherSpeString.append(", ");
            }
        }
        return teacherSpeString.toString();
    }
}
