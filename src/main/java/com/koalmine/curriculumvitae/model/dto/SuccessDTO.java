package com.koalmine.curriculumvitae.model.dto;

import lombok.Getter;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
public class SuccessDTO {
    private final String status;
    private final String message;
    private final ZonedDateTime timestamp;

    public SuccessDTO(String status, String message){
        this.status = status;
        this.message = message;
        this.timestamp = ZonedDateTime.now(ZoneId.of("Z"));
    }
}
