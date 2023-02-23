package group.fcr.todo_api.model.dto;

import java.util.UUID;

public record TodoItemResponseDTO(
        UUID parentListId,
        Long itemId,
        String itemName,
        Boolean isCompleted
) {
}
