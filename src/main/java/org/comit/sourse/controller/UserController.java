package org.comit.sourse.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.comit.sourse.bean.User;
import org.comit.sourse.service.UserService;
import org.comit.sourse.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	public static final int maxBox = 100;

	@GetMapping({ "/", "/index" })
	public String index() {
		System.out.println("Show index page");

		return "index";
	}

	@GetMapping("/listUsers")
	public ModelAndView listUsers() {
		System.out.println("Show List Users");

		List<User> users = this.userService.listUsers();

		System.out.println("Box vacancy: " + listBoxVacancy().toString());

		return new ModelAndView("listUsers", "users", users);
	}

	@GetMapping("/createUser")
	public String showCreate() {
		System.out.println("Show Create User");
		return "createUser";
	}

	@PostMapping("/createUser")
	public String createUser(HttpServletRequest request, Model model) {
		System.out.println("Create User");

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		String dateRent = date.toString();

		model.addAttribute("boxVacancy", this.listBoxVacancy());

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String boxName = request.getParameter("boxName");
		String boxType = request.getParameter("boxType");

		User user = this.createUser(null, firstName, lastName, userName, password, email, boxName, boxType, dateRent,
				null);

		this.userService.createUser(user);

		return "redirect:/listUsers";
	}

	@GetMapping("/updateUser/{id}")
	public ModelAndView showUpdate(@PathVariable("id") int id, Model model) {

		System.out.println("Show Update");

		User user = this.userService.findUser(id);

		return new ModelAndView("updateUser", "user", user);
	}

	@PostMapping("/updateUser")
	public String updateUser(HttpServletRequest request) {
		System.out.println("Update User");

		String idUser = request.getParameter("idUser");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String boxName = request.getParameter("boxName");
		String boxType = request.getParameter("boxType");
		String dateRent = request.getParameter("dateRent");
		String parcel = request.getParameter("parcel");

		User user = this.createUser(idUser, firstName, lastName, userName, password, email, boxName, boxType, dateRent,
				parcel);

		this.userService.modifyUser(user);

		return "redirect:/listUsers";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") int id) {

		System.out.println("Delete User");

		this.userService.deleteUser(id);

		return "redirect:/listUsers";
	}

	private User createUser(String i, String first, String last, String userName, String pass, String email,
			String boxName, String boxType, String date, String j) {

		User user = new User(Util.parseInt(i), first.trim(), last.trim(), userName.trim(), pass.trim(), email.trim(),
				boxName.trim(), boxType.trim(), Util.parseDate(date), Util.parseInt(j));
		return user;
	}
	// same comit_02

	@GetMapping("userScreen")
	public String showScreenUser() {
		System.out.println("Show userScreen page");
		return "userScreen";
	}

	public List<String> listBoxVacancy() {
		List<String> listVacancy = new ArrayList<String>();
		int vipNum = maxBox / 10;
		int normalNum = maxBox - vipNum;

		for (int i = 0; i < vipNum; i++) {
			listVacancy.add("Vip" + (i + 1));
		}

		for (int i = 0; i < normalNum; i++) {
			listVacancy.add("Box" + (i + 1));
		}

		List<User> users = this.userService.listUsers();

		for (User user : users) {
			listVacancy.remove(user.getBoxName());
		}
		return listVacancy;
	}
}
