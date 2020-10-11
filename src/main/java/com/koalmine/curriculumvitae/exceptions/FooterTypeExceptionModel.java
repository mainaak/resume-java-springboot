package com.koalmine.curriculumvitae.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FooterTypeExceptionModel {
    @JsonProperty("Page Name")
    private final String pageName;

    @JsonProperty("Error")
    private final String error;

    @JsonProperty("Timestamp")
    private final String timestamp;
}
