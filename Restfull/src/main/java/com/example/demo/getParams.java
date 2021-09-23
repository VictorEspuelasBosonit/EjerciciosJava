package com.example.demo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class getParams {
    @Value("${url: no hay valor}")
    String url;
    @Value("${password: no hay valor}")
    String password;
    @GetMapping("/leerParams")
    public void leerParams()
    {
        System.out.println(url);
        System.out.println(password);
    }
}
