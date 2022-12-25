package group.fcr.todo_api.service.mapper;

import group.fcr.todo_api.model.TodoList;
import group.fcr.todo_api.model.dto.TodoListResponse;

public class TodoListMapper {

    public TodoListResponse mapToResponse(TodoList todoList) {
        return new TodoListResponse(todoList.getListName(), todoList.getListItems(), todoList.getIsCompleted());
    }
}
