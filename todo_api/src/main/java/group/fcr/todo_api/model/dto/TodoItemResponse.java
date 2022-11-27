package group.fcr.todo_api.model.dto;

public record TodoItemResponse(
        String itemName,
        String content,
        Boolean isCompleted
) {
}
