package com.bootcamp.springbootspringtaskapp.controller;

import com.bootcamp.springbootspringtaskapp.entity.Task;
import com.bootcamp.springbootspringtaskapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    public TaskController(TaskService taskService){
        super();
        this.taskService = taskService;
    }

    //view list of students
    @GetMapping("/tasks")
    public String listTasks(Model model){
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks";
    }

    @GetMapping("/tasks/new")
    public String createTask(Model model){

        //create task object to hold task data
        Task task = new Task();
        model.addAttribute("task", task);
        return "create_task";
    }

    @PostMapping("/tasks")
    public String saveTask(@ModelAttribute("task")Task task){
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/edit/{id}")
    public String editTask(@PathVariable Long id, Model model){    //get the id by binding
        model.addAttribute("task", taskService.getTaskId(id));
        return "update_task";
    }

    @PostMapping("/tasks/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute("task") Task task, Model model){

        //get student from database by id
        Task existingTask = taskService.getTaskId(id);
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setCompleted(task.getCompleted());

        //save updated student object
        taskService.editTask(existingTask);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTaskById(id);
        return "redirect:/tasks";
    }
}
