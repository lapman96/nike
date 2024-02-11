package com.nike.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nike.dto.localstorage.purpose_limitations.guest.GuestDTO;
import lombok.SneakyThrows;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CookiesSettingsManager {
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    public CookiesSettingsManager(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    public void acceptAllPrivacyAndCookiePolicies() {
        driver.get("https://www.nike.com/hu/en/guest/settings/privacy");
        acceptAllPrivacyAndCookiePoliciesInCookies();
        acceptAllPurposeLimitationsInLocalStorage();
        driver.navigate().refresh();
    }

    private void acceptAllPrivacyAndCookiePoliciesInCookies() {
        List<Cookie> cookieList = List.of(
                new Cookie("ni_c", "1PA=0|BEAD=1|PERF=1|PERS=1",".nike.com", "/", null),
                new Cookie("sq", "3",".nike.com", "/", null)
        );

        cookieList.forEach(cookie -> driver.manage().addCookie(cookie));
    }

    @SneakyThrows
    private void acceptAllPurposeLimitationsInLocalStorage() {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(getValueFromLocalStorageByKey("persist:purposeLimitations"));
        JsonNode guestNode = rootNode.get("guest");

        GuestDTO guestDTO = mapper.readValue(guestNode.asText(), GuestDTO.class);
        guestDTO.enableAllPurposeLimitations();

        JsonNode updatedGuestNode = mapper.valueToTree(guestDTO);
        ((ObjectNode) rootNode).put("guest", updatedGuestNode.toString());

        String updatedRootNode = mapper.writeValueAsString(rootNode);
        updatedRootNode = updatedRootNode.replace("\"", "\\\"");

        setValueToLocalStorageByKey("persist:purposeLimitations", updatedRootNode);
    }

    private String getValueFromLocalStorageByKey (String key) {
        return (String) jsExecutor.executeScript(String.format("return localStorage.getItem('%s');", key));
    }

    private void setValueToLocalStorageByKey (String key, String value) {
        jsExecutor.executeScript(String.format("localStorage.setItem('%s','%s');",key,value));
    }
}
