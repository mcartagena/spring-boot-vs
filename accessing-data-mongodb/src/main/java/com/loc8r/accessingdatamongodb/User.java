package com.loc8r.accessingdatamongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User {
  
  @Id
  public String id;

  public String name;
  public String email;

  public User() {}

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }

  @Override
  public String toString() {
    return "User [email=" + email + ", id=" + id + ", name=" + name + "]";
  }

}
