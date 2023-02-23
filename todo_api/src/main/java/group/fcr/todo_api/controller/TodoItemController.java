package group.fcr.todo_api.controller;

import group.fcr.todo_api.service.TodoItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class TodoItemController {
    private final TodoItemService todoItemService;


}
