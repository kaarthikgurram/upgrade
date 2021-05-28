package com.upgrade.apitest;

import com.upgrade.apitest.client.UpgradeApiClient;
import com.upgrade.apitest.fixtures.UpgradeRequestContext;
import com.upgrade.apitest.validations.UpgradeApiValidation;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UpgradeCodingChallengeApiTests {

  @Autowired
  UpgradeApiClient upgradeApiClient;

  UpgradeRequestContext upgradeRequestContext;

  @Autowired
  UpgradeApiValidation upgardeApiValidation;

  @BeforeEach
  public void beforeEach() {
    upgradeApiClient = new UpgradeApiClient();
    upgardeApiValidation = new UpgradeApiValidation();
    upgradeRequestContext = new UpgradeRequestContext();
  }

  @Test
  public void upgradeApi_happyPath_acceptedResponse() throws JSONException {

    Response apiResponse = upgradeApiClient.upgradeApiPost(upgradeRequestContext);
    upgardeApiValidation.validateApprovedApiResponse(apiResponse);
  }

//  @Test
//  public void upgradeApi_wrongPassword_declineWithError() {
//
//    Response apiResponse = upgradeApiClient.upgradeApiPost(upgradeRequestContext.password("wrongPassword"));
//    upgardeApiValidation.validateErrorResponse(apiResponse);
//  }
//
//  @Test
//  public void upgradeApi_wrongUsername_declineWithError() {
//
//    Response apiResponse = upgradeApiClient.upgradeApiPost(upgradeRequestContext.username("wrongUserName"));
//    upgardeApiValidation.validateErrorResponse(apiResponse);
//  }
}
