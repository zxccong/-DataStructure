package zxc.datastructure.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/get")
    public String get(){
        System.out.println("get");
        return "200";
    }

    @PostMapping("/post")
    public String post(HttpServletRequest request){
        System.out.println("post");
//        System.out.println("request = " + key);
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println(parameterMap);
        String key1 = request.getParameter("key");
        System.out.println("key1 = " + key1);
        return "200";
    }
}
