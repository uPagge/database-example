package dev.struchkov.example.database.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "epic")
@PrimaryKeyJoinColumn(name = "id")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Epic extends Task {

    @Column(name = "goal")
    private String goal;

    @JoinTable
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Subtask> subtasks = new ArrayList<>();

    @CollectionTable(
            name = "epic_subtasks",
            joinColumns = @JoinColumn(name = "epic_id")
    )
    @Column(name = "subtasks_id")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Long> subtaskIds = new HashSet<>();

    public void addSubtask(@NonNull Subtask subtask) {
        subtasks.add(subtask);
    }

}
