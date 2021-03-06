package co.sabit.schedulerapplicationspringboot.controller;

import co.sabit.adapter.TaskCommand;
import co.sabit.adapter.TaskQuery;
import co.sabit.adapter.input.model.TaskDto;
import co.sabit.adapter.input.model.TaskIdentifierDto;
import co.sabit.adapter.input.model.TaskSummaryDto;
import co.sabit.core.domain.error.BusinessError;
import co.sabit.core.error.ServiceError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    private final TaskQuery taskQuery;
    private final TaskCommand taskCommand;

    @Autowired
    public TaskController(TaskQuery taskQuery, TaskCommand taskCommand) {
        this.taskQuery = taskQuery;
        this.taskCommand = taskCommand;
    }

    @PostMapping
    public ResponseEntity<TaskIdentifierDto> createTask(@RequestBody TaskDto taskDto) {
        try {
            TaskIdentifierDto response = taskCommand.createTask(taskDto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        } catch (BusinessError businessError) {
            LOGGER.error(businessError.getValue());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        } catch (ServiceError serviceError) {
            LOGGER.error(serviceError.getValue());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            LOGGER.error("ERROR:", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<TaskSummaryDto>> retrieveAll() {
        try {
            LOGGER.warn("TaskController.retrieveAll");
            return ResponseEntity.ok(taskQuery.retrieveAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
