package com.nike.dto.localstorage.purpose_limitations.guest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PurposeLimitationsLevelsDTO {
    @JsonProperty("performance")
    private int performance;

    @JsonProperty("adtargeting_behavioralevents")
    private int adtargetingBehavioralevents;

    @JsonProperty("personalization_targeted_comms")
    private int personalizationTargetedComms;

    @JsonProperty("adtargeting_hashedmatch")
    private int adtargetingHashedmatch;
}
