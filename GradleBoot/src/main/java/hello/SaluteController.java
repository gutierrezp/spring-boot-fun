package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SaluteController {

    private final GreetingService service;

    public SaluteController(GreetingService service) {
        this.service = service;
    }

    @RequestMapping("/salute")
    public @ResponseBody String greeting() {
        return service.greet();
    }

}