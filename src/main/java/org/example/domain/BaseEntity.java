package org.example.domain;

import com.avaje.ebean.annotation.WhenCreated;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
public abstract class BaseEntity {

  @Id
  Long id;

//  @WhenCreated
//  Instant whenCreated;
//
//  @WhenCreated
//  Instant whenUpdated;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

//  public Instant getWhenCreated() {
//    return whenCreated;
//  }
//
//  public void setWhenCreated(Instant whenCreated) {
//    this.whenCreated = whenCreated;
//  }
//
//  public Instant getWhenUpdated() {
//    return whenUpdated;
//  }
//
//  public void setWhenUpdated(Instant whenUpdated) {
//    this.whenUpdated = whenUpdated;
//  }
}
