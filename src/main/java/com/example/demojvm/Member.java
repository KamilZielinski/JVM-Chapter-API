package com.example.demojvm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Member {

  @Id
  @GeneratedValue
  private Integer id;
  private String name;
  private String surname;

  @JsonProperty(access = Access.WRITE_ONLY)
  private String password;
}
