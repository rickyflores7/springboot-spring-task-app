package com.bootcamp.springbootspringtaskapp.repository.task;

import com.bootcamp.springbootspringtaskapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
