package group.fcr.todo_api.service;

import group.fcr.todo_api.model.TodoItem;
import group.fcr.todo_api.model.dto.TodoItemResponse;
import group.fcr.todo_api.repository.TodoItemRepository;
import group.fcr.todo_api.service.mapper.TodoItemMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoItemService {

    private final TodoItemRepository repository;
    private final TodoItemMapper mapperService;

    public List<TodoItemResponse> findAllByName() {
        var item1 = TodoItem.builder()
                .itemName("Primeiro Item da Minha To-Do")
                .content("ABLUABLEUALDAUSKBLEUALBUA").isCompleted(true).build();

        var item2 = TodoItem.builder()
                .itemName("Segundo Item da Minha To-Do")
                .content("ABLUABLEUALDAUSKBLEUALBUA").isCompleted(false).build();


        repository.saveAll(List.of(item1, item2));

        return repository.findAllByName().stream().map(mapperService::mapToResponse).toList();
    }
}
