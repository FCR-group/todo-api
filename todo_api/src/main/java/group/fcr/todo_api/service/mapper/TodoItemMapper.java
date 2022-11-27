package group.fcr.todo_api.service.mapper;

import group.fcr.todo_api.model.TodoItem;
import group.fcr.todo_api.model.dto.TodoItemResponse;
import org.springframework.stereotype.Service;

@Service
public class TodoItemMapper {
    public TodoItemResponse mapToResponse(TodoItem todoItem) {
        return new TodoItemResponse(
                todoItem.getItemName(),
                todoItem.getContent(),
                todoItem.getIsCompleted()
        );
    }
}
