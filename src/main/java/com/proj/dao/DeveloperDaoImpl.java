package com.proj.dao;

import com.proj.model.Developer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DeveloperDaoImpl implements DeveloperDao {

    private JdbcTemplate jdbcTemp;

    public DeveloperDaoImpl(DataSource dataSource) {
        jdbcTemp = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Developer> devList() {
        List<Developer> list = jdbcTemp.query("SELECT * FROM DEVELOPER", new RowMapper<Developer>() {

            @Override
            public Developer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Developer dev = new Developer();

                dev.setFname(rs.getString("fname"));
                dev.setLname(rs.getString("lname"));
                dev.setTitle(rs.getString("title"));
                dev.setSalary(rs.getInt("salary"));
                dev.setLocation(rs.getString("location"));

                return dev;
            }
        });
        return list;
    }
}
