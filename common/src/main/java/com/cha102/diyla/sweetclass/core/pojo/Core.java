package com.cha102.diyla.sweetclass.core.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Core implements Serializable {
    private static final long serialVersionUID = 5731748901476646415L;
    private boolean successful;
    private String message;

    public Core() {

    }
    public Core(boolean successful, String message) {
        this.message = message;
        this.successful = successful;
    }
}
