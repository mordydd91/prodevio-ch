package com.prodops.devopschallenge.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Health {

  private String status;

  @Value("${container.hub.link:container}")
  private String container;

  @Value("${project.link:git}")
  private String project;

  public Health() {
    this.status = "healthy";
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getContainer() {
    return container;
  }

  public void setContainer(String container) {
    this.container = container;
  }

  public String getProject() {
    return project;
  }

  public void setProject(String project) {
    this.project = project;
  }
}
