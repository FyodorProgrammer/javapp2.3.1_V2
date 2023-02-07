package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.Service;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@GetMapping("/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}
	@GetMapping("/car")
	public String printCarPage(ModelMap model, @RequestParam(value = "count", required = false) Integer count) {

		List<Car> cars = new ArrayList<>();
		cars.add(new Car("manufacturer1", "model1", 111));
		cars.add(new Car("manufacturer2", "model2", 222));
		cars.add(new Car("manufacturer3", "model3", 333));
		cars.add(new Car("manufacturer4", "model4", 444));
		cars.add(new Car("manufacturer5", "model5", 555));

		cars = Service.getCarList(cars, count);

		model.addAttribute("cars", cars);
		return "car";
	}
	
}