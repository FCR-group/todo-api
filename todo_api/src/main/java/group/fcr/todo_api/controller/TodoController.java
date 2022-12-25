package group.fcr.todo_api.controller;

import group.fcr.todo_api.model.dto.TodoListResponse;
import group.fcr.todo_api.service.TodoItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public List<TodoListResponse> findAllByName(@RequestParam String name) {
        return service.findAllByName(name);
    }
}
