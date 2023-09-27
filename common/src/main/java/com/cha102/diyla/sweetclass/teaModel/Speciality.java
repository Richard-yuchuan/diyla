package com.cha102.diyla.sweetclass.teaModel;

import com.cha102.diyla.sweetclass.core.pojo.Core;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Repository
@NoArgsConstructor
@AllArgsConstructor
public class Speciality extends Core {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private int speId;
    @Column(name = "SPE_NAME")
    private String speName;
}
