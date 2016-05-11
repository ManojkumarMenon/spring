package Spring.com.spring.manoj.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import Spring.com.spring.manoj.bean.Spittles;
import Spring.com.spring.manoj.bean.User;

@Repository
public class SpittlesRepository {

	private Logger logger = Logger.getLogger("SpittleRepository.class");

	private JdbcTemplate jdbcTemplate;

	public SpittlesRepository() {
		logger.info("in default constructor");
	}

	public SpittlesRepository(JdbcTemplate jdbcTemplate) {

		logger.info("in parametrized constructor");
		System.out.println(jdbcTemplate);
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public List<User> checkuser(String username, String password) {
		String sql = "select firstname, secondname, username , password from user_details where username = '"
				+ username + "' and password = '" + password + "'";
		List<User> userlst = jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User usr = new User();
				usr.setFirstname(rs.getString("firstname"));
				usr.setSecondname(rs.getString("secondname"));
				usr.setUsername(rs.getString("username"));
				usr.setPassword(rs.getString("password"));
				System.out.println(usr.getFirstname() + "   "
						+ usr.getSecondname());
				return usr;

			}

		});

		return userlst;
	}

	public List<Spittles> getSpittles(int startvalue, int endvalue) {
		logger.info("In getspittle method");

		String sql = "SELECT spittleid, message , userid , entrydate FROM SPITTLES where spittleid between "
				+ startvalue + "  and " + endvalue;
		List<Spittles> values = jdbcTemplate.query(sql,
				new RowMapper<Spittles>() {

					@Override
					public Spittles mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Spittles spittle = new Spittles();
						spittle.setId(rs.getInt("spittleid"));
						spittle.setMessage(rs.getString("message"));
						spittle.setId(rs.getInt("userid"));
						spittle.setEntrydate(rs.getDate("entrydate"));
						return spittle;

					}

				});
		logger.info("size of list :-" + values.size());
		return values;
	}

	public boolean createUser(User user) {
		String str = "INSERT INTO user_details VALUES (USER_SEQ.nextval ,'"
				+ user.getUsername() + "' ,'" + user.getPassword() + "' ,'"
				+ user.getFirstname() + "' ,'" + user.getSecondname() + "')";
		jdbcTemplate.update(str);
		return true;
	}

	public List<Spittles> getUserSpittles(String username) {
		logger.info("In getspittle method");

		String sql = "select s.spittleid as spittleid ,s.message as message, s.entrydate as entrydate from spittles s, user_details u where s.userid =u.userid and u.username ='"
				+ username + "'";
		List<Spittles> values = jdbcTemplate.query(sql,
				new RowMapper<Spittles>() {

					@Override
					public Spittles mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Spittles spittle = new Spittles();
						spittle.setId(rs.getInt("spittleid"));
						spittle.setMessage(rs.getString("message"));
						spittle.setEntrydate(rs.getDate("entrydate"));
						return spittle;

					}

				});
		logger.info("size of list :-" + values.size());
		return values;
	}

	private static void makeconnection() {

		try {
			DBConnection dbCon = new DBConnection();
			Connection con = dbCon.getConnection();
			Statement stmt = con.createStatement();
			boolean bool = stmt
					.execute("Insert into  user_details values (user_seq.nextval , 'Sudeep' ,'Sudeep' , 'Sudeep' , 'Ojha')");
			System.out.println("Returned a val:-" + bool);
			dbCon.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
