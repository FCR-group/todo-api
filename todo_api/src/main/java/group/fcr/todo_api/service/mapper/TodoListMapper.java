package group.fcr.todo_api.service.mapper;

import group.fcr.todo_api.model.TodoList;
import group.fcr.todo_api.model.dto.TodoListResponse;
import org.springframework.stereotype.Service;

@Service
public class TodoListMapper {

    public TodoListResponse mapToResponse(TodoList todoList) {
        return new TodoListResponse(
                todoList.getId(),
                todoList.getListName(),
                todoList.getListItems(),
                todoList.getIsCompleted()
        );
    }
}
