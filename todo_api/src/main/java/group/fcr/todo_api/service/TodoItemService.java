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
public class TodoItemService {

    private final TodoListRepository repository;
    private final TodoListMapper mapperService;

    public List<TodoListResponse> findAllByName(String name) {
        var item1 = TodoList.builder()
                .listName(name).build();


        repository.save(item1);

        return repository.findAllByName().stream().map(mapperService::mapToResponse).toList();
    }
}
