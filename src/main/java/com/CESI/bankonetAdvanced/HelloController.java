package main.java.com.CESI.bankonetAdvanced;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/toto")
    public String toto() {
        return "toto";
    }

}