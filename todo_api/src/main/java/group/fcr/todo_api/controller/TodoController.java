package group.fcr.todo_api.controller;

import group.fcr.todo_api.model.dto.TodoListResponse;
import group.fcr.todo_api.service.TodoListService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

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

    @GetMapping("/list/delete")
    @ResponseStatus
    public ResponseEntity delete(@RequestParam String id) {
        Pattern UUID_REGEX =
                Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");

        if (!UUID_REGEX.matcher(id).matches()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        UUID uuid = UUID.fromString(id);
        return service.delete(service.findById(uuid));
    }

}
