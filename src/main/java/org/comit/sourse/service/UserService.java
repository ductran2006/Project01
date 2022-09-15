package org.comit.sourse.service;

import org.comit.sourse.bean.User;
import java.util.List;

import org.comit.sourse.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public List<User> listUsers(){

		List<User> users = userDao.listUsers();
		return users;
	}
	
	public User findUser(int idUser) {

		return userDao.findUser(idUser);
	}
	
	public void createUser(User user) {
		
		this.validateUser(user);
        userDao.createUser(user);
	}

    public void modifyUser(User user) {

    	this.validateUser(user);
    	userDao.modifyUser(user);
    }

    public void deleteUser(int idUser) {

    	userDao.deleteUser(idUser);
    }

    private void validateUser(User user) {

    	if (user.getFirstName().isEmpty() ||
    		user.getLastName().isEmpty() ||
    		user.getUserName().isEmpty()) {
    		throw new RuntimeException("Invalid User Data " + user);
    	}
    }
}
