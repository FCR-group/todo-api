package group.fcr.todo_api.repository;


import group.fcr.todo_api.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    @Query("FROM TodoItem item WHERE item.itemName LIKE '%Primeiro%'")
    List<TodoItem> findAllByName();

}
