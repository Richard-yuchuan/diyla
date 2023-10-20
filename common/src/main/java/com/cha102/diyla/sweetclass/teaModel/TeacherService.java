package com.cha102.diyla.sweetclass.teaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class TeacherService {
    private SpecialityDAO speDAO;
    private TeaSpecialityDAO teaSpeDAO;
    @Autowired
    private TeacherSpringDAOImpl teaDAO;

    public TeacherService() {
        speDAO = new SpecialityDAOImpl();
        teaSpeDAO = new TeaSpecialityDAOImpl();
    }

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
        int pk = teaDAO.insert(teacher);

        return pk;
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
    public SpecialityVO addSpeciality(String speName) throws RuntimeException{
        SpecialityVO specialityVO = new SpecialityVO();
        specialityVO.setSpeName(speName);
        speDAO.insert(specialityVO);
        return specialityVO;
    }
    public SpecialityVO updateSpeciality(String speName){
        SpecialityVO specialityVO = new SpecialityVO();
        specialityVO.setSpeName(speName);
        speDAO.update(specialityVO);
        return specialityVO;
    }
    public void delSpeciality(Integer speID) {
        speDAO.delete(speID);
    }

    public Integer getOneSpecialityID(String speName) {
        return speDAO.findBySpeName(speName);
    }
    public String getTeacherSpecialityString(Integer teaID){
        TeacherDAO teacherDAO = new TeacherDAOImpl();
        List<String> teacherSpecialities = teacherDAO.getTeacherSpeciality(teaID);
        StringBuilder teacherSpeString = new StringBuilder();
        for (int i = 0; i < teacherSpecialities.size(); i++) {
            teacherSpeString.append(teacherSpecialities.get(i));
            if (i < teacherSpecialities.size() - 1) {
                teacherSpeString.append(", ");
            }
        }
        return teacherSpeString.toString();
    }
    public List<SpecialityVO> getAllSpeciality(){
        return speDAO.getAll();
    }
    public TeaSpecialityVO addTeaSpeciality(Integer teaID, Integer speID) throws RuntimeException{
        TeaSpecialityVO teaSpecialityVO = new TeaSpecialityVO();
        teaSpecialityVO.setTeaId(teaID);
        teaSpecialityVO.setSpeId(speID);
        teaSpeDAO.insert(teaSpecialityVO);
        return teaSpecialityVO;
    }
    public TeaSpecialityVO updateTeaSpeciality(Integer teaID, Integer speID){
        TeaSpecialityVO teaSpecialityVO = new TeaSpecialityVO();
        teaSpecialityVO.setTeaId(teaID);
        teaSpecialityVO.setSpeId(speID);
        teaSpeDAO.update(teaSpecialityVO);
        return teaSpecialityVO;
    }
    public void delTeaSpeciality(Integer teaID) {
        teaSpeDAO.delete(teaID);
    }
    public List<String> getOneTeaSpecialityStringList(Integer teaID){
        List<Integer> speIdArray = teaSpeDAO.findByTeaId(teaID);
        List<String> speNameArray = new ArrayList<String>();
        for(int i = 0; i < speIdArray.size(); i++) {
            speNameArray.add(speDAO.findBySpeId(speIdArray.get(i)));
        }
        return speNameArray;
    }
    public List<TeaSpecialityVO> getAllTeaSpeciality(){
        return teaSpeDAO.getAll();
    }
}
