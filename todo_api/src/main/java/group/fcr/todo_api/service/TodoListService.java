package group.fcr.todo_api.service;

import group.fcr.todo_api.model.TodoList;
import group.fcr.todo_api.model.dto.TodoListResponse;
import group.fcr.todo_api.repository.TodoListRepository;
import group.fcr.todo_api.service.mapper.TodoListMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TodoListService {

    private final TodoListRepository repository;
    private final TodoListMapper mapperService;

    public List<TodoListResponse> create(String name) {
        repository.save(TodoList.builder().listName(name).listItems(Collections.emptyList()).isCompleted(false).build());
        return repository.findByName(name).stream().map(mapperService::mapToResponse).toList();
    }

    public List<TodoListResponse> findAll() {
        return repository.findAll().stream().map(mapperService::mapToResponse).toList();
    }

    public List<TodoListResponse> findAllByName(String name) {
        return repository.findAllByName(name).stream().map(mapperService::mapToResponse).toList();
    }

    public TodoList findById(UUID id) {
        return repository.findListById(id);
    }

    public ResponseEntity delete(TodoList todoList) {
        if (todoList == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        repository.delete(todoList);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
