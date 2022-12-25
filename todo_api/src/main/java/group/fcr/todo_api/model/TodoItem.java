package group.fcr.todo_api.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "todo_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TodoItem {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "parent_list_id")
    private TodoList todoList;

    @Column(nullable = false, length = 35)
    private String itemName;

    @Column(nullable = false)
    private Boolean isCompleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TodoItem todoItem = (TodoItem) o;
        return id != null && Objects.equals(id, todoItem.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "itemName = " + itemName + ", " +
                "isCompleted = " + isCompleted + ")";
    }
}

