package group.fcr.todo_api.controller;

import group.fcr.todo_api.model.dto.TodoListResponseDTO;
import group.fcr.todo_api.model.dto.UpdateListNameDTO;
import group.fcr.todo_api.service.TodoListService;
import group.fcr.todo_api.service.UtilsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class TodoListController {
    private final TodoListService todoListService;
    private final UtilsService utils;

    /**
     * Constructor Injection
     */
//    public TodoController(TodoItemRepository repository) {
//        this.repository = repository;
//    }
    @PostMapping("/list/create")
    public List<TodoListResponseDTO> create(@RequestParam String name) {
        return todoListService.create(name);
    }

    @GetMapping("/list")
    public List<TodoListResponseDTO> findAllByName(@RequestParam String name) {
        return todoListService.findAllByName(name);
    }

    @GetMapping("/lists")
    public List<TodoListResponseDTO> findAll() {
        return todoListService.findAll();
    }

    @PostMapping("/list/delete")
    @ResponseStatus
    public ResponseEntity delete(@RequestParam String id) {

        return utils.isUuidValid(id) ?
                todoListService.delete(todoListService.findById(UUID.fromString(id))) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @PostMapping("/list/update")
    @ResponseStatus
    public ResponseEntity update(@RequestParam String id, @RequestBody UpdateListNameDTO updateDTO) {

        return utils.isUuidValid(id) ?
                todoListService.updateName(todoListService.findById(UUID.fromString(id)), updateDTO) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
