package ToDoList.SpringBootAssessment.ToDoList.repository;

import ToDoList.SpringBootAssessment.ToDoList.repository.entity.Item;
import org.springframework.data.repository.*;
public interface ItemRepository extends CrudRepository<Item, Integer>
{
}
