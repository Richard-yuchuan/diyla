package com.cha102.diyla.sweetclass.teaModel;

import com.cha102.diyla.sweetclass.core.pojo.Core;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Repository
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TEACHER")
public class Teacher extends Core {
    private static final long serialVersionUID = -7667717749228046818L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEA_ID")
    private int teaId;
    @Column(name = "EMP_ID")
    private int empId;
    @Column(name = "TEA_NAME")
    private String teaName;
    @Column(name = "TEA_GENDER")
    private int teaGender;
    @Column(name = "TEA_PHONE")
    private String teaPhone;
    @Column(name = "TEA_INTRO")
    private String teaIntro;
    @Column(name = "TEA_PIC")
    private byte[] teaPic;
    @Column(name = "TEA_EMAIL")
    private String teaEmail;
    @Column(name = "TEA_STATUS")
    private int teaStatus;

}
