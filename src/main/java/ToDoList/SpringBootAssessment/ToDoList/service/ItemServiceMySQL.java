package ToDoList.SpringBootAssessment.ToDoList.service;

import ToDoList.SpringBootAssessment.ToDoList.repository.ItemRepository;
import ToDoList.SpringBootAssessment.ToDoList.repository.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.*;


@Service
public class ItemServiceMySQL implements ItemService {

    private final ItemRepository itemRepository;


    public ItemServiceMySQL(@Autowired ItemRepository itemRepository) {

        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void delete(int itemId) {
        itemRepository.deleteById(itemId);
    }

    @Override
    public List<Item> all() {
        List<Item> result = new ArrayList<>();
        itemRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Item findById(int itemId) { //update product infor and delete a product
        //item is an object
        Optional<Item> item = itemRepository.findById(itemId);
        Item itemResponse = item.get();
        return itemResponse;

    }
}