package com.koalmine.curriculumvitae.exceptions;

import lombok.Data;

@Data
public class FooterTypeException extends RuntimeException{

    private String pageName;

    public FooterTypeException(String pageName){
        this.pageName = pageName;
    }
}
