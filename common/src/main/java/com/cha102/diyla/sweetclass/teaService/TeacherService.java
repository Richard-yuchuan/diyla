package com.cha102.diyla.sweetclass.teaService;

import com.cha102.diyla.sweetclass.teaModel.Speciality;
import com.cha102.diyla.sweetclass.teaModel.TeaSpeciality;
import com.cha102.diyla.sweetclass.teaModel.TeaSpecialityVO;
import com.cha102.diyla.sweetclass.teaModel.Teacher;

import java.util.List;

public interface TeacherService{
    int addTeacher(Teacher teacher);
    Teacher updateTeacher(Teacher teacher);
    boolean deleteTeacher(Integer teaId);
    Teacher getOneTeacher(Integer teaId);
    Teacher getOneTeacherByEmpId(Integer empId);
    List<String> getTeacherSpeciality(Integer teaId);
    List<Teacher> getAllTeacher();
    boolean isEmpAlreadyTeacher(Integer empId);
    boolean verifyTeacherId(Integer teaId);
    boolean updateTeaStatus(Integer teaId, Integer status);
    Speciality addSpeciality(String speName);
    boolean deleteSpeciality(Integer speId);
    Integer getOneSpecialityId(String speName);
    String getTeacherSpecialityString(Integer teaId);
    TeaSpeciality addTeaSpeciality(Integer teaId, Integer speId);
    TeaSpeciality updateTeaSpeciality(Integer teaID, Integer speID);
    boolean delTeaSpeciality(Integer teaID);
    List<String> getOneTeaSpecialityStringList(Integer teaID);
    List<TeaSpeciality> getAllTeaSpeciality();
}
