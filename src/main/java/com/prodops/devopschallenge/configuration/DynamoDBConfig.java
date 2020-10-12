package com.prodops.devopschallenge.configuration;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.prodops.devopschallenge.repository")
@ComponentScan(basePackages = "com.prodops.devopschallenge")
public class DynamoDBConfig {

  @Value("${amazon.aws.accesskey}")
  private String amazonAWSAccessKey;

  @Value("${amazon.aws.secretkey}")
  private String amazonAWSSecretKey;

  @Value("${amazon.aws.region}")
  private String amazonAWSRegion;

  @Bean
  public AmazonDynamoDB amazonDynamoDB() {

    AmazonDynamoDBClient amazonDynamoDBClient = new AmazonDynamoDBClient(getAmazonAWSCredentials());
    amazonDynamoDBClient.setRegion(Region.getRegion(getRegion()));

    return amazonDynamoDBClient;
  }

  @Bean
  public AWSCredentials getAmazonAWSCredentials() {
    return new BasicAWSCredentials(
            amazonAWSAccessKey, amazonAWSSecretKey);
  }

  @Bean
  public Regions getRegion() {
    return Regions.fromName(amazonAWSRegion);
  }

}
