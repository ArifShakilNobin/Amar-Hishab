package bits.current_savings_service.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeResource extends BaseResource {

    @GetMapping
    public String index() {
        return "Brac IT Service Ltd.- Current Savings service is running...!";
    }

}
