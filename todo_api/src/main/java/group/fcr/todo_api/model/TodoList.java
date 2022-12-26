package group.fcr.todo_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.GenerationType.UUID;

@Entity
@Table(name = "todo_list")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TodoList {

    @Id
    @GeneratedValue(strategy = UUID)
    private java.util.UUID id;

    @Column(nullable = false, length = 25)
    private String listName;

    @Column(nullable = false)
    private Boolean isCompleted;

    @OneToMany(mappedBy = "todoList", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<TodoItem> listItems;

}
