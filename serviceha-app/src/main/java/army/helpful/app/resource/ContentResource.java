package army.helpful.app.resource;

import army.helpful.app.model.Content;
import army.helpful.app.model.Content;
import army.helpful.app.repository.ContentRepository;
import army.helpful.app.repository.TitleRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"Content Service"})
@RestController
@RequestMapping(value = "/content")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContentResource {

    @Autowired
    ContentRepository contentRepository;




}
