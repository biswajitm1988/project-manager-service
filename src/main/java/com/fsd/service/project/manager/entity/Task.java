package com.fsd.service.project.manager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name = "TASKS")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "TASK_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "TASK_ID")
    private Long taskId;

    @Column(name = "TASK_STATUS")
    @JsonProperty("isTaskDone")
    private String status;

}
