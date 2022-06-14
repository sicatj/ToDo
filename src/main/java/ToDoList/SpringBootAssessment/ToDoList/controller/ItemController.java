package ToDoList.SpringBootAssessment.ToDoList.controller;

import ToDoList.SpringBootAssessment.ToDoList.repository.entity.Item;
import ToDoList.SpringBootAssessment.ToDoList.controller.dto.ItemDto;

import ToDoList.SpringBootAssessment.ToDoList.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/item")
public class ItemController {

    final ItemService itemService;

    public ItemController(@Autowired ItemService itemService) {
        this.itemService = itemService;
    }


    @CrossOrigin
    @GetMapping( "/all" )
    public Iterable<Item> getItems()
    {
        return itemService.all();
    }

    // 2. create endpoint for GET HTTP request form the client by ID
    @CrossOrigin
    @GetMapping( "/{id}" )
    public Item findItemById( @PathVariable Integer id )
    {
        return itemService.findById( id );
    }

    //3. create endpoint for DELETE HTTP request form the client by ID
    @CrossOrigin
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }

    //4. Create an API Endpoint for POST HTTP request from the client
    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="title", required = true) String title,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="date", required = true) String date) {
        ItemDto itemDto = new ItemDto(title, description, date);
        itemService.save(new Item(itemDto));
    }
}
