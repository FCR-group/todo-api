package group.fcr.todo_api.repository;


import group.fcr.todo_api.model.TodoListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TodoListRepository extends JpaRepository<TodoListModel, UUID> {


    @Query("FROM TodoListModel list")
    List<TodoListModel> findAll();

    @Query("FROM TodoListModel list WHERE list.listName like :name")
    List<TodoListModel> findAllByName(@Param("name") String name);

    @Query("FROM TodoListModel list where list.listName=:name ")
    List<TodoListModel> findByName(@Param("name") String name);

    @Query("FROM TodoListModel list where list.id=:id")
    TodoListModel findListById(@Param("id") UUID id);
}
