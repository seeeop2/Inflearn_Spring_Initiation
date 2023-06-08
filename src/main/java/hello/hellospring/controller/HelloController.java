package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; /*  resources:templates/ + viewName + .html
                            ㄴ resources:templates/hello.html          */
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name" , required = false) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name, Model model){
        return "hello " + name; //hello spring
                                //html태그 같은 것 없이 데이터 그대로 body에 넣어준다.
    }

    @GetMapping("hello-api")
    @ResponseBody   //api를 다룰 때 많이 사용되는 @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){

        Hello hello = new Hello();
        hello.setName(name);

        return hello;   // 결과 : {"name":"nanananan"}
                        // @ResponseBody 어노테이션을 붙이고, 객체를 반환하면 Json 방식으로 반환이 된다.
                        //"@ResponseBody 어노테이션이 있고, 객체를 반환하는 것이면, Json 방식으로 반환하겠다"가 기본값

                        /*
                        @ResponseBody 어노테이션이 있다면, ViewResolver가 작동하는 것이 아닌
                        HttpMessageConverter(JsonConverter/StringConverter)이 작동한다.

                        @ResponseBody 어노테이션이 있고 단순 문자 반환 : StringConverter 작동
                        @ResponseBody 어노테이션이 있고 객체를 반환 : JsonConverter 작동
                        */
    }



    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}


