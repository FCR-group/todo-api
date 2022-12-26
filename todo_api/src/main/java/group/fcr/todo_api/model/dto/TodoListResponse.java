package group.fcr.todo_api.model.dto;

import group.fcr.todo_api.model.TodoItem;

import java.util.List;

public record TodoListResponse(
        java.util.UUID id,
        String listName,
        List<TodoItem> todoItems,
        Boolean isCompleted
) {
}
