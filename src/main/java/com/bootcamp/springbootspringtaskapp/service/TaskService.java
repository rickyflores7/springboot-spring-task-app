package com.bootcamp.springbootspringtaskapp.service;

import com.bootcamp.springbootspringtaskapp.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    Task saveTask(Task task);

    Task getTaskId(Long id);

    Task editTask(Task task);

    void deleteTaskById(Long id);
}
