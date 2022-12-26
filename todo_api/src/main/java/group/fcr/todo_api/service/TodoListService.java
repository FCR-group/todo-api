package group.fcr.todo_api.service;

import group.fcr.todo_api.model.TodoList;
import group.fcr.todo_api.model.dto.TodoListResponse;
import group.fcr.todo_api.repository.TodoListRepository;
import group.fcr.todo_api.service.mapper.TodoListMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoListService {

    private final TodoListRepository repository;
    private final TodoListMapper mapperService;

    public List<TodoListResponse> create(String name) {
        repository.save(TodoList.builder().listName(name).isCompleted(false).build());
        return repository.findByName(name).stream().map(mapperService::mapToResponse).toList();
    }

    public List<TodoListResponse> findAll() {
        return repository.findAll().stream().map(mapperService::mapToResponse).toList();
    }

    public List<TodoListResponse> findAllByName(String name) {
        return repository.findAllByName(name).stream().map(mapperService::mapToResponse).toList();
    }
}
