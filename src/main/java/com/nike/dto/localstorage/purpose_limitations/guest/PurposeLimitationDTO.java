package com.nike.dto.localstorage.purpose_limitations.guest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class PurposeLimitationDTO {
    @JsonProperty("category")
    private String category;

    @JsonProperty("userLicenses")
    private List<UserLicenseDTO> userLicenses;

    @JsonProperty("isEnabled")
    private boolean isEnabled;

    @JsonProperty("isDefault")
    private boolean isDefault;

    void enablePurposeLimitation() {
        isEnabled = true;
        isDefault = false;
        userLicenses.forEach(UserLicenseDTO::enableUserLicense);
    }
}
