package org.skrymer.test.containers.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PER_PERSON")
public class Person {

  @Id
  private Long id;
}
