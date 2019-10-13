package com.atguigu.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Student get(Integer sid) {
		String sql = "select sid, sname , gender from student where sid = ?";
		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
		Student s = jdbcTemplate.queryForObject(sql, rowMapper, sid);
		System.out.println("Student: " + s);
		return s;
	}
}
