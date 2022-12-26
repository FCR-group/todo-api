package group.fcr.todo_api.repository;


import group.fcr.todo_api.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {


    @Query("FROM TodoList list")
    List<TodoList> findAll();

    @Query("FROM TodoList list WHERE list.listName like :name")
    List<TodoList> findAllByName(@Param("name") String name);

    @Query("FROM TodoList list where list.listName=:name ")
    List<TodoList> findByName(@Param("name") String name);

    @Query("FROM TodoList list where list.id=:id")
    TodoList findListById(@Param("id") UUID id);
}
