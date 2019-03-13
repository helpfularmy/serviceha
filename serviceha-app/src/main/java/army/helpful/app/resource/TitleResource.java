package army.helpful.app.resource;

import army.helpful.app.actions.ProblemActionGeneratorUtil;
import army.helpful.app.actions.EnumActionTypes;
import army.helpful.app.actions.ProblemAction;
import army.helpful.app.model.Content;
import army.helpful.app.model.Title;
import army.helpful.app.repository.ContentRepository;
import army.helpful.app.repository.TitleRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static army.helpful.app.actions.EnumActionTypes.CONTENT_ADD_SUCCESS;

@Api(tags = {"Title Service"})
@RestController
@RequestMapping(value = "/title")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TitleResource {

    @Autowired
    TitleRepository titleRepository;
    @Autowired
    ContentRepository contentRepository;

    @GetMapping(value = "/all/{amount}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation successful"),
            @ApiResponse(code = 400, message = "Input validation error"),
            @ApiResponse(code = 500, message = "Technical error!")})
    @ApiOperation("Get All Titles")
    public List<Title> getAll(@PathVariable int amount) {
        Pageable pageWithAmountofElements = PageRequest.of(0, amount);

        return titleRepository.getAllWithAmount(pageWithAmountofElements);
    }


    public TitleRepository getTitleRepository() {
        return titleRepository;
    }

    public void setTitleRepository(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    @GetMapping(value = "/contents/{name}/{amount}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation successful"),
            @ApiResponse(code = 400, message = "Input validation error"),
            @ApiResponse(code = 500, message = "Technical error!")})
    @ApiOperation("Get Contents By Title")
    public List<Content> getContentsByTitle(@PathVariable String name, @PathVariable int amount) {
        Pageable pageWithAmountofElements = PageRequest.of(amount/10, 10);
        List<Content> contentList=  contentRepository.findByTitleWithAmount(name, pageWithAmountofElements);
        return contentList;
    }


    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation successful"),
            @ApiResponse(code = 400, message = "Input validation error"),
            @ApiResponse(code = 500, message = "Technical error!")})
    @ApiOperation("Create a new title")
    public ProblemAction createTitle(@RequestBody Content content) {

        Title title= titleRepository.findByName(content.getTitle().getName());

            String description="";

            if(title==null){
                title=content.getTitle();

                title= titleRepository.save(title);
                description="success";
            }else{
                description="title_exists";
            }

            content.setTitle(title);

            content= contentRepository.save(content);

        EnumActionTypes type= CONTENT_ADD_SUCCESS;
        type.setDescription(description);

        ProblemActionGeneratorUtil problemActionGeneratorUtil= new ProblemActionGeneratorUtil();

        return problemActionGeneratorUtil.generateProblemAction(content
                                                              , type);
    }

}
