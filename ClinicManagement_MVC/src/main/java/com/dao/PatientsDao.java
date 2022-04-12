package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.beans.Patients;

public class PatientsDao {
JdbcTemplate template;

public void setTemplate(JdbcTemplate template){
	this.template = template;
}
public int save(Patients p) {
	String sql="insert into patients(fname,lname,age,gender,address,pNo) values('"+p.getFname()+"','"+p.getLname()+"','"+p.getAge()+"','"+p.getGender()+"','"+p.getAddress()+"','"+p.getpNo()+"')";
	return template.update(sql);
}
public int update(Patients p){  
    String sql="update patients set fname='"+p.getFname()+"', lname='"+p.getLname()+"',age='"+p.getAge()+"',gender='"+p.getGender()+"',pNo='"+p.getpNo()+"' where id="+p.getId()+"";  
    return template.update(sql);  
} 
public int delete(int id){  
    String sql="delete from patients where id="+id+"";  
    return template.update(sql);  
} 
@SuppressWarnings("deprecation")
public Patients getPatientsById(int id){  
    String sql="select * from patients where id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Patients>(Patients.class));  
} 
public List<Patients> getPatients(){  
    return template.query("select * from patients",new RowMapper<Patients>(){  
        public Patients mapRow(ResultSet rs, int row) throws SQLException {  
            Patients e=new Patients();  
            e.setId(rs.getInt(1));  
            e.setFname(rs.getString(2));  
            e.setLname(rs.getString(3));  
            e.setAge(rs.getInt(4));
            e.setGender(rs.getString(5));
            e.setAddress(rs.getString(6));
            e.setpNo(rs.getLong(7));
            return e;  
        }  
    });  
}  
}
