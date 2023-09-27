package com.cha102.diyla.sweetclass.teaModel;


import com.cha102.diyla.sweetclass.core.dao.CoreDao;

import java.util.List;

public interface SpecialityDAO extends CoreDao<Speciality, Integer> {

    Speciality findBySpeName(String speName);

}
