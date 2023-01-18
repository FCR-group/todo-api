package group.fcr.todo_api.service;

import group.fcr.todo_api.model.TodoListModel;
import group.fcr.todo_api.model.dto.TodoListResponseDTO;
import group.fcr.todo_api.model.dto.UpdateListNameDTO;
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

    public List<TodoListResponseDTO> create(String name) {
        repository.save(TodoListModel.builder().listName(name).listItems(Collections.emptyList()).isCompleted(false).build());
        return repository.findByName(name).stream().map(mapperService::mapToResponse).toList();
    }

    public List<TodoListResponseDTO> findAll() {
        return repository.findAll().stream().map(mapperService::mapToResponse).toList();
    }

    public List<TodoListResponseDTO> findAllByName(String name) {
        return repository.findAllByName(name).stream().map(mapperService::mapToResponse).toList();
    }

    public TodoListModel findById(UUID id) {
        return repository.findListById(id);
    }

    public ResponseEntity delete(TodoListModel todoListModel) {
        if (todoListModel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        repository.delete(todoListModel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity updateName(TodoListModel todoListModel, UpdateListNameDTO updateDTO) {
        if (todoListModel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        todoListModel.setListName(updateDTO.getNewName());

        repository.save(todoListModel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
