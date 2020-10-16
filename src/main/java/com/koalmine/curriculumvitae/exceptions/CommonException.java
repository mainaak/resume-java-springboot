package com.koalmine.curriculumvitae.exceptions;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class CommonException {
    private final String status;
    private final String cause;
    private final ZonedDateTime timestamp;
    private final Throwable throwable;
}
