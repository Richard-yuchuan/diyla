package com.cha102.diyla.sweetclass.teaModel;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PersistenceContext;
import java.util.*;

public class TeacherService {

    @Autowired
    private SpecialityDAOImpl speDAO;
    @Autowired
    private TeaSpecialityDAOImpl teaSpeDAO;
    @Autowired
    private TeacherDAOImpl teaDAO;


    public int addTeacher(Integer empID, String teaName, Integer teaGender, String teaPhone,
                                String teaIntro, byte[] teaPic, String teaEmail, int teaStatus){
        Teacher teacher = new Teacher();
        teacher.setEmpId(empID);
        teacher.setTeaName(teaName);
        teacher.setTeaGender(teaGender);
        teacher.setTeaPhone(teaPhone);
        teacher.setTeaIntro(teaIntro);
        teacher.setTeaPic(teaPic);
        teacher.setTeaEmail(teaEmail);
        teacher.setTeaStatus(teaStatus);
        int result = teaDAO.insert(teacher);

        return result;
    }
    public Teacher updateTeacher(Integer teaID, Integer empID, String teaName, Integer teaGender, String teaPhone,
                                   String teaIntro, byte[] teaPic, String teaEmail, int teaStatus){
        Teacher teacher = new Teacher();
        teacher.setTeaId(teaID);
        teacher.setEmpId(empID);
        teacher.setTeaName(teaName);
        teacher.setTeaGender(teaGender);
        teacher.setTeaPhone(teaPhone);
        teacher.setTeaIntro(teaIntro);
        teacher.setTeaPic(teaPic);
        teacher.setTeaEmail(teaEmail);
        teacher.setTeaStatus(teaStatus);
        teaDAO.update(teacher);

        return teacher;
    }

    public void delTeacher(Integer teaID){
        teaDAO.deleteById(teaID);
    }
    public Teacher getOneTeacher(Integer teaID) {
        return teaDAO.selectById(teaID);
    }
    public Teacher getOneTeacherByEmpId (Integer empID) {
        return teaDAO.findTeaByEmpID(empID);
    }
    public boolean verifyTeacherId(Integer teaID) {
        try{
            teaDAO.selectById(teaID);
            return true;
        } catch (RuntimeException re) {
            return false;
        }
    }

    public List<Teacher> getAllTeacher(){

        return teaDAO.selectAll();
    }
    public boolean isEmpAlreadyTeacher(Integer empId) {
        List<Teacher> allTeacher = teaDAO.selectAll();
        boolean result = false;
        for(Teacher teacher: allTeacher) {
            if (empId == teacher.getEmpId()) {
                result = true;
            }
        }
        return result;
    }
    public boolean updateTeaStatus(Integer teaId, Integer status){
        Teacher teacher = teaDAO.selectById(teaId);
        teacher.setTeaStatus(status);
        try {
            teaDAO.update(teacher);
            return true;
        } catch (RuntimeException re) {
            re.printStackTrace();
            return false;
        }
    }
    public Speciality addSpeciality(String speName) throws RuntimeException{
        Speciality speciality = new Speciality();
        speciality.setSpeName(speName);
        speDAO.insert(speciality);
        return speciality;
    }
    public Speciality updateSpeciality(String speName){
        Speciality speciality = new Speciality();
        speciality.setSpeName(speName);
        speDAO.update(speciality);
        return speciality;
    }
    public void delSpeciality(Integer speID) {
        speDAO.deleteById(speID);
    }

    public Integer getOneSpecialityID(String speName) {
        return speDAO.findBySpeName(speName).getSpeId();
    }
    public String getTeacherSpecialityString(Integer teaID){
        List<Speciality> speList = speDAO.selectAll();
        List<Integer> teaSpeIDList = teaSpeDAO.selectByTeaId(teaID);
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
    public List<Speciality> getAllSpeciality(){
        return speDAO.selectAll();
    }
    public TeaSpeciality addTeaSpeciality(Integer teaID, Integer speID) throws RuntimeException{
        TeaSpeciality teaSpeciality = new TeaSpeciality();
        teaSpeciality.setTeaId(teaID);
        teaSpeciality.setSpeId(speID);
        teaSpeDAO.insert(teaSpeciality);
        return teaSpeciality;
    }
    public TeaSpeciality updateTeaSpeciality(Integer teaID, Integer speID){
        TeaSpeciality teaSpeciality = new TeaSpeciality();
        teaSpeciality.setTeaId(teaID);
        teaSpeciality.setSpeId(speID);
        teaSpeDAO.update(teaSpeciality);
        return teaSpeciality;
    }
    public void delTeaSpeciality(Integer teaID) {
        teaSpeDAO.deleteById(teaID);
    }
    public List<String> getOneTeaSpecialityStringList(Integer teaID){
        List<Integer> speIdArray = teaSpeDAO.selectByTeaId(teaID);
        List<String> speNameArray = new ArrayList<String>();
        for(int i = 0; i < speIdArray.size(); i++) {
            speNameArray.add(speDAO.selectById(speIdArray.get(i)).getSpeName());
        }
        return speNameArray;
    }
    public List<TeaSpeciality> getAllTeaSpeciality(){
        return teaSpeDAO.selectAll();
    }
}
