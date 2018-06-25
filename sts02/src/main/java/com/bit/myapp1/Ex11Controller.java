package com.bit.myapp1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex11Controller {

	@RequestMapping("/ex11")
	public String ex11() {
		return "index";
	}
}
