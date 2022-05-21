package dev.struchkov.example.database.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "subtask")
@PrimaryKeyJoinColumn(name = "id")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Subtask extends Task {

}
