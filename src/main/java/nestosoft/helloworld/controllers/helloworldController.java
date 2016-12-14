package nestosoft.helloworld.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import nestosoft.helloworld.models.ReturnClass;
import org.springframework.web.bind.annotation.RequestMapping;

public class helloworldController {

    @RequestMapping(path = "/", method = GET, produces = APPLICATION_JSON_UTF8_VALUE)
    public ReturnClass helloworld(){
        return new ReturnClass("Hello Temi");
    }
}
