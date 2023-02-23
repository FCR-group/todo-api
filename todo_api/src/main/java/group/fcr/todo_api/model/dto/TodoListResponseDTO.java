package group.fcr.todo_api.model.dto;

import group.fcr.todo_api.model.TodoItemModel;

import java.util.List;

public record TodoListResponseDTO(
        java.util.UUID id,
        String listName,
        List<TodoItemModel> listItems,
        Boolean isCompleted
) {
}
