package com.cha102.diyla.sweetclass.teaModel;

import com.cha102.diyla.sweetclass.core.dao.CoreDao;

import java.util.List;

public interface TeacherDAO extends CoreDao<Teacher, Integer>{

    Teacher findTeaByEmpID(Integer empID);
}
