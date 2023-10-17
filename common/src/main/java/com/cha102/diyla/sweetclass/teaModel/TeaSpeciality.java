package com.cha102.diyla.sweetclass.teaModel;

import com.cha102.diyla.sweetclass.core.pojo.Core;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tea_speciality")
public class TeaSpeciality extends Core {

    private static final long serialVersionUID = 2720667267623891630L;
    @Id
    @Column(name = "TEA_ID")
    private int teaId;
    @Id
    @ManyToOne
    @JoinColumn(name = "SPE_ID")
    private int speId;
}


