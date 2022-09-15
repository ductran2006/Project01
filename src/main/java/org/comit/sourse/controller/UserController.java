package org.comit.sourse.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.comit.sourse.bean.User;
import org.comit.sourse.service.UserService;
import org.comit.sourse.util.PO_Util;
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
	public String createUser1(HttpServletRequest request) {
		System.out.println("Create User");

		String first = request.getParameter("first");
		String last = request.getParameter("last");
		String userName = request.getParameter("userName");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String boxName = request.getParameter("boxName");
		String boxType = request.getParameter("boxType");
		String dateRent = request.getParameter("dateRent");
		String parcel = request.getParameter("parcel");

		User user = this.createUser(null, first, last, userName, pass, email, boxName, boxType, dateRent, parcel);

		this.userService.createUser(user);

		return "redirect:/list";
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String boxName = request.getParameter("boxName");
		String boxType = request.getParameter("boxType");
		String dateRent = request.getParameter("dateRent");
		String parcel = request.getParameter("parcel");

		User user = this.createUser(id, first, last, username, password, email, boxName, boxType, dateRent, parcel);

		this.userService.modifyUser(user);

		return "redirect:/listUsers";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		
		System.out.println("Delete User");

		this.userService.deleteUser(id);

		return "redirect:/listUsers";
	}

	private User createUser(String id, String first, String last, String userName, String pass, String email,
			String boxName, String boxType, String dateRent, String parcel) {

		User user = new User(PO_Util.parseInt(id), first.trim(), last.trim(), userName.trim(), pass.trim(),
				email.trim(),boxName.trim(),boxType.trim(),PO_Util.parseDate(dateRent),PO_Util.parseInt(parcel));
		return user;
	}
	//same comit_02
	
	@GetMapping("userScreen")
	public String showScreenUser() {
		System.out.println("Show userScreen page");
		return "userScreen";
	}

}
