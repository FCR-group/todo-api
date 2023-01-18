package group.fcr.todo_api.service.mapper;

import group.fcr.todo_api.model.TodoListModel;
import group.fcr.todo_api.model.dto.TodoListResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class TodoListMapper {

    public TodoListResponseDTO mapToResponse(TodoListModel todoListModel) {
        return new TodoListResponseDTO(
                todoListModel.getId(),
                todoListModel.getListName(),
                todoListModel.getListItems(),
                todoListModel.getIsCompleted()
        );
    }
}
