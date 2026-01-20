package com.doctorconsult.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.doctorconsult.model.Doctor;
import com.doctorconsult.utility.DBConnection;

public class DoctorRegisterDaoImpl implements DoctorRegisterDao {
	
	public int insertDoctor(Doctor obj) {
		
		try {
			Connection con = DBConnection.getConnection();
			String query = "insert into doctors(first_name, last_name, email, phone_number, medical_license, specialization, experience, hospital_affiliation, password) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, obj.getFname());
			pstmt.setString(2, obj.getLname());
			pstmt.setString(3, obj.getEmail());
			pstmt.setString(4, obj.getPhone());
			pstmt.setString(5, obj.getLicense());
			pstmt.setString(6, obj.getSpecialization());
			pstmt.setInt(7, obj.getExpreience());
			pstmt.setString(8, obj.getAffilation());
			pstmt.setString(9, obj.getPassword());
			
			int insert = pstmt.executeUpdate();
			if(insert>0) {
				return insert;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Doctor checkLogin(String email, String password) {
		// TODO Auto-generated method stub
		Doctor d = null;
		
		try {
			Connection con = DBConnection.getConnection();
			String query = "select * from doctors where email=? and password=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				d = new Doctor();
				
				d.setFname(rs.getString(1));
				d.setLname(rs.getString(2));
				d.setEmail(email);
				d.setPassword(password);
				
				return d;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
}
