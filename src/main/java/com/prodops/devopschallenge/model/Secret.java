package com.prodops.devopschallenge.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonIgnore;

@DynamoDBTable(tableName = "devops-challenge")
public class Secret {

  private String codeName;
  private String secretCode;

  public Secret() {
  }

  @DynamoDBHashKey(attributeName="code_name")
  @JsonIgnore
  public String getCodeName() {
    return codeName;
  }

  public void setCodeName(String codeName) {
    this.codeName = codeName;
  }

  @DynamoDBAttribute(attributeName="secret_code")

  public String getSecretCode() {
    return secretCode;
  }

  public void setSecretCode(String secretCode) {
    this.secretCode = secretCode;
  }

}
