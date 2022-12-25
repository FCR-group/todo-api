package group.fcr.todo_api.repository;


import group.fcr.todo_api.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {
    @Query("FROM TodoList list WHERE list.listName LIKE '%Primeiro%'")
    List<TodoList> findAllByName();

}
