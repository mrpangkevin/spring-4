package com.atguigu.spring.jdbc;

//import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JDBCTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//		
//	}
	
	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;
	private StudentDao studentDao;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
		studentDao = (StudentDao)ctx.getBean(StudentDao.class);
	}

	
//	@Test
	public void testDataSource() {
		DataSource dataSource = ctx.getBean(DataSource.class);
//		System.out.println(dataSource.getConnection());
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	@Test
	public void testUpdate() {
		String sql = "update student set gender = ? where sid = ?";
		jdbcTemplate.update(sql, "male", 2);
		
		String sql_1 = "Insert into student (sid, sname, gender) values(? , ? , ?);";
		jdbcTemplate.update(sql_1, 4, "Jerry", "male");
		String sql_2 = "Insert into mark ( mid, sid, cid , score ) value ( ? , ?, ?, ?);";
		for ( int i=10,j=1; i<13; i++,j++) {
			jdbcTemplate.update(sql_2, i, 4, j, 80+j);
		}
	}
	
//	@Test
	public void testBatchUpdate() {
		
	}
	
//	@Test
	public void testQueryForObject() {
		String sql = "select sid, sname , gender from student where sid = ?";
		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
		Student s = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println("Student: " + s);
	}
//	@Test
	public void testQueryForList() {
		String sql = "select sid, sname , gender from student where sid > ?";
		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
		List<Student> s = jdbcTemplate.query(sql, rowMapper, 1);
		System.out.println("Student: " + s);
	}
//	@Test
	public void testQueryForObject2() {
		String sql = "select count(sid) from student";
//		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println("Student: " + count);
	}
	
	@Test
	public void testStudentDao() {
		System.out.println(studentDao.get(1));
	}

}
