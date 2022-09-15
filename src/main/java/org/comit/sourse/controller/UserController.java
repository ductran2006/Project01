package org.comit.sourse.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.comit.sourse.bean.User;
import org.comit.sourse.service.UserService;
import org.comit.sourse.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping({ "/", "/index" })
	public String index() {
		System.out.println("Show index page");

		return "index";
	}

	@GetMapping("/listUsers")
	public ModelAndView listUsers() {
		System.out.println("Show List Users");

		List<User> users = this.userService.listUsers();

		return new ModelAndView("listUsers", "users", users);
	}

	@GetMapping("/createUser")
	public String showCreate() {
		System.out.println("Show Create User");
		return "createUser";
	}

	@PostMapping("/createUser")
	public String createUser(HttpServletRequest request) {
		System.out.println("Create User");

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		String dString = date.toString();

		String first = request.getParameter("first");
		String last = request.getParameter("last");
		String userName = request.getParameter("userName");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String boxName = request.getParameter("boxName");
		String boxType = request.getParameter("boxType");

		User user = this.createUser(0, first, last, userName, pass, email, boxName, boxType, dString, 0);

		this.userService.createUser(user);

		return "redirect:/listUsers";
	}

	@GetMapping("/updateUser/{id}")
	public ModelAndView showUpdate(@PathVariable("id") int id) {

		System.out.println("Show Update");

		User user = this.userService.findUser(id);

		return new ModelAndView("updateUser", "user", user);
	}

	@PostMapping("/updateUser")
	public String updateUser(HttpServletRequest request) {
		System.out.println("Update User");

		String id = request.getParameter("id");
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		String userName = request.getParameter("userName");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String boxName = request.getParameter("boxName");
		String boxType = request.getParameter("boxType");
		String dateRent = request.getParameter("dateRent");
		String parcel = request.getParameter("parcel");

		User user = this.createUser(Util.parseInt(id), first, last, userName, pass, email, boxName, boxType, dateRent,
				Util.parseInt(parcel));

		this.userService.modifyUser(user);

		return "redirect:/listUsers";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") int id) {

		System.out.println("Delete User");

		this.userService.deleteUser(id);

		return "redirect:/listUsers";
	}

	private User createUser(int i, String first, String last, String userName, String pass, String email,
			String boxName, String boxType, String date, int j) {

		User user = new User(i, first.trim(), last.trim(), userName.trim(), pass.trim(), email.trim(), boxName.trim(),
				boxType.trim(), Util.parseDate(date), 0);
		return user;
	}
	// same comit_02

	@GetMapping("userScreen")
	public String showScreenUser() {
		System.out.println("Show userScreen page");
		return "userScreen";
	}

}
