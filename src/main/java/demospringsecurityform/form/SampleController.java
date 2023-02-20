package demospringsecurityform.form;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Spring security 의존성을 추가하면 로그인이 필요한 경우 -> 로그인 페이지를 보여준다.
 * 아이디, 비밀번호는 콘솔에서 확인이 가능하다.
 * @author user
 *
 */
@Controller
public class SampleController {
	@GetMapping("/")
	public String index(Model model, Principal principal) {
		if(principal == null) {
			//로그인 안한 경우
			model.addAttribute("message", "Hello Spring Security");
		}else {
			//로그인 한 경우
			model.addAttribute("message", "Hello "+principal.getName());
		}
		return "index";
	}
	
	@GetMapping("/info")
	public String info(Model model) {
		model.addAttribute("message", "info");
		return "info";
	}

	
	@GetMapping("/dashboard")
	public String dashboard(Model model, Principal principal) {
		//principal이 없어서 null이 들어온다.
		model.addAttribute("message", "Hello dashboard "+principal.getName());
		return "dashboard";
	}
	
	@GetMapping("/admin")
	public String admin(Model model, Principal principal) {
		//principal이 없어서 null이 들어온다.
		model.addAttribute("message", "Hello admin "+principal.getName());
		return "admin";
	}


}
