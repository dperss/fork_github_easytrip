package com.easytrip.easytrip.domain;

import io.swagger.v3.oas.annotations.media.Schema;


public class ErrorObject {

    @Schema(
            description = "HTTP status error code",
            example = "400"
    )
    private String errorCode;

    @Schema(
            description = "Error description and details",
            example = "Member not exists in DB"
    )
    private String errorDescription;

}
