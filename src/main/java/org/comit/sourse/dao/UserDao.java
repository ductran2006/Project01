package org.comit.sourse.dao;

import java.util.List;

import org.comit.sourse.bean.User;
import org.comit.sourse.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	List<User> users;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<User> listUsers() {

		String sql = "select * from user";

		return jdbcTemplate.query(sql, new UserMapper());
	}

	public User findUser(int idUser) {

		String sql = "SELECT * FROM USER WHERE IDUSER=?";

		return jdbcTemplate.queryForObject(sql, new UserMapper(), idUser);
	}

	public User findByUserName(String username) {

		String sql = "SELECT * FROM USER WHERE USERNAME=?";
		List<User> users = jdbcTemplate.query(sql, new UserMapper(), username);

		return users.isEmpty() ? null : users.get(0);
	}

	public void createUser(User user) {

		String sql = "INSERT USER(FIRSTNAME,LASTNAME,USERNAME,PASSWORD,EMAIL,BOXNAME, BOXTYPE, DATERENT, PARCEL) "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";

		jdbcTemplate.update(sql,new Object[] { user.getFirstName(), user.getLastName(), user.getUserName(), user.getPassword(),
						user.getEmail(), user.getBoxName(), user.getBoxType(), user.getDateRent(), user.getParcel() });

	}

	public void modifyUser(User user) {

		String sql = "UPDATE USER SET FISRTNAME = ?, LASTNAME = ?, USERNAME = ?, PASSWORD = ?, "
				+ "EMAIL =? ,BOXNAME=?, BOXTYPE=?, DATERENT=?, PARCEL=? WHERE IDUSER = ?";

		jdbcTemplate.update(sql, new Object[] {user.getFirstName(), user.getLastName(), user.getUserName(),
				user.getPassword(), user.getEmail(), user.getBoxName(), user.getBoxType(), user.getDateRent(), user.getParcel()  });
	}

	public void deleteUser(int idUser) {

		String sql = "DELETE FROM USER WHERE IDUSER = ?";
		jdbcTemplate.update(sql, new Object[] { idUser });
	}

}
