package ToDoList.SpringBootAssessment.ToDoList.security;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.*;



@Configuration
public class MvcConfig implements WebMvcConfigurer {



    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("ToDos");
        registry.addViewController("/ToDos").setViewName("ToDos");
        registry.addViewController("/addToDo").setViewName("addToDo");


    }



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(0);
    }

}



