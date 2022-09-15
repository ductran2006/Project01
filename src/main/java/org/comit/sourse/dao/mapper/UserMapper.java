package org.comit.sourse.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.comit.sourse.bean.User;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user=new User();
		
		user.setIdUser(rs.getInt("IDUSER"));
		user.setFirstName(rs.getString("FIRSTNAME"));
		user.setLastName(rs.getString("LASTNAME"));
		user.setUserName(rs.getString("USERNAME"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setEmail(rs.getString("EMAIL"));
		user.setBoxName(rs.getString("BOXNAME"));
		user.setBoxType(rs.getString("BOXTYPE"));
		user.setDateRent(rs.getDate("DATERENT"));
		user.setParcel(rs.getInt("PARCEL"));
		
		return user;
	}

}
