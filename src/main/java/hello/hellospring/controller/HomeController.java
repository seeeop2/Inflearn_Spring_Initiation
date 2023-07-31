package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")    //우선순위는 컨트롤러 부터임. 우선 순위: 컨트롤러에서 getmapping한 "/" > index.html
    public String home(){
        return "home";
    }
}
