package dev.struchkov.example.database.domain.entity;

import dev.struchkov.example.database.domain.TaskStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@Table(name = "task")
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Task extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TaskStatus status;

}
