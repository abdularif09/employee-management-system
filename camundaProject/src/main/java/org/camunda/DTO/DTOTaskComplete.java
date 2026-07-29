package org.camunda.DTO;

import lombok.Data;

@Data
public class DTOTaskComplete {
    private String taskId;

    private String decision;

    private String remarks;

    private String status;
}
