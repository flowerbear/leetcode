package com.orlando.java.rest;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

  private int id;

  private String name;

  public User() {
  }

  public User(int id, String name) {
    this.id = id;
    this.name = name;
  }
}
