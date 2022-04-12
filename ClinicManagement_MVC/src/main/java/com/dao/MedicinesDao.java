package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.beans.Medicines;

public class MedicinesDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template){
		this.template = template;
	}
	public int msave(Medicines m) {
		String sql="insert into medicines(name,price) values('"+m.getName()+"','"+m.getPrice()+"')";
		return template.update(sql);
	}
	public int mupdate(Medicines m){  
	    String sql="update medicines set name='"+m.getName()+"', price='"+m.getPrice()+"' where id="+m.getId()+"";  
	    return template.update(sql);  
	} 
	public int mdelete(int id){  
	    String sql="delete from medicines where id="+id+"";  
	    return template.update(sql);  
	} 
	@SuppressWarnings("deprecation")
	public Medicines mgetMedicinesById(int id){  
	    String sql="select * from medicines where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Medicines>(Medicines.class));  
	} 
	public List<Medicines> mgetMedicines(){  
	    return template.query("select * from medicines",new RowMapper<Medicines>(){  
	        public Medicines mapRow(ResultSet rs, int row) throws SQLException {  
	            Medicines m=new Medicines();  
	            m.setId(rs.getInt(1));  
	            m.setName(rs.getString(2));  
	            m.setPrice(rs.getInt(3));  
	            return m;  
	        }  
	    });  
	}  
}
