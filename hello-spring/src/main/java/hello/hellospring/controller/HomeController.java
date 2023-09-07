package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    //컨트롤러가 우선순위가 더 높아서 먼저 찾고 없으면 static에서 찾음
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
