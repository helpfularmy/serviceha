package army.helpful.app.resource;

import army.helpful.app.model.Content;
import army.helpful.app.model.Title;
import army.helpful.app.repository.ContentRepository;
import army.helpful.app.repository.TitleRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import java.util.ArrayList;
import java.util.List;

@Api(tags = {"Title Service"})
@RestController
@RequestMapping(value = "/title")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TitleResource {

    @Autowired
    TitleRepository titleRepository;
    @Autowired
    ContentRepository contentRepository;

    @GetMapping(value = "/all")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation successful"),
            @ApiResponse(code = 400, message = "Input validation error"),
            @ApiResponse(code = 500, message = "Technical error!")})
    @ApiOperation("Get All Titles")
    public List<Title> getAll() {
        return titleRepository.findAll();
    }


    public TitleRepository getTitleRepository() {
        return titleRepository;
    }

    public void setTitleRepository(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    @GetMapping(value = "/contents/{name}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation successful"),
            @ApiResponse(code = 400, message = "Input validation error"),
            @ApiResponse(code = 500, message = "Technical error!")})
    @ApiOperation("Get Contents By Title")
    public List<Content> getContentsByTitle(@PathVariable String name) {
        Title title= titleRepository.findByName(name);

        return title.getContents();
    }


    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation successful"),
            @ApiResponse(code = 400, message = "Input validation error"),
            @ApiResponse(code = 500, message = "Technical error!")})
    @ApiOperation("Create a new title")
    public boolean createTitle(@RequestBody Content content) {
            Title title= titleRepository.findByName(content.getTitle().getName());

            if(title==null){
                title= titleRepository.save(content.getTitle());
            }

            content.setTitle(title);

            content= contentRepository.save(content);
      return true;
    }

}
