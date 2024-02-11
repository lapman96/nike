package com.nike.dto.localstorage.purpose_limitations.guest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class GuestDTO {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("purposeLimitations")
    private List<PurposeLimitationDTO> purposeLimitations;

    @JsonProperty("purposeLimitationsLevels")
    private PurposeLimitationsLevelsDTO purposeLimitationsLevels;

    @JsonProperty("loading")
    private boolean loading;

    @JsonProperty("error")
    private Object error;

    @JsonProperty("lastUpdatedTimestamp")
    private long lastUpdatedTimestamp;

    public void enableAllPurposeLimitations() {
        purposeLimitations.forEach(PurposeLimitationDTO::enablePurposeLimitation);
    }
}
