package group.fcr.todo_api.controller;

import group.fcr.todo_api.model.dto.TodoItemResponse;
import group.fcr.todo_api.service.TodoItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/controller")
public class TodoController {
    private final TodoItemService service;

    /**
     * Constructor Injection
     */
//    public TodoController(TodoItemRepository repository) {
//        this.repository = repository;
//    }
    @GetMapping("/items")
    public List<TodoItemResponse> findAllByName() {
        return service.findAllByName();
    }
}
