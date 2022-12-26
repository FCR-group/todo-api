package group.fcr.todo_api.controller;

import group.fcr.todo_api.model.dto.TodoListResponse;
import group.fcr.todo_api.service.TodoListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/controller")
public class TodoController {
    private final TodoListService service;

    /**
     * Constructor Injection
     */
//    public TodoController(TodoItemRepository repository) {
//        this.repository = repository;
//    }
    @GetMapping("/list/create")
    public List<TodoListResponse> create(@RequestParam String name) {
        return service.create(name);
    }

    @GetMapping("/list")
    public List<TodoListResponse> findAllByName(@RequestParam String name) {
        return service.findAllByName(name);
    }

    @GetMapping("/lists")
    public List<TodoListResponse> findAll() {
        return service.findAll();
    }

}
