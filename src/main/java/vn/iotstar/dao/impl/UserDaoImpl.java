package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import vn.iotstar.configs.DBConnectSQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl extends DBConnectSQL implements IUserDao {
	public static void main(String[] args) {
		UserDaoImpl uD = new UserDaoImpl();
		
		System.out.println(uD.findByUserName("test"));
		
		List<UserModel> list = uD.finalAll();
//		for(UserModel u: list) {
//			System.out.println(u);
//		}
	}

    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public List<UserModel> finalAll() {
        String sql = " select * from Users";

        List<UserModel> list = new ArrayList<>();
        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new UserModel(
                    rs.getInt("id"),
                     rs.getString("username"),
                     rs.getString("password"),
                     rs.getString("email"),
                     rs.getString("fullname"),
                     rs.getString("images")
                        ));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public UserModel findById(int id) {
    	
        return null;
    }

    @Override
    public void insert(UserModel user) {
    	String sql = "insert into Users(username, password, email,images, fullname) values(?,?,?,?,?)";
    	try {
			conn =super.getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getImages());
			ps.setString(5, user.getFullname());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	@Override
	public UserModel findByUserName(String username) {
		String sql = "Select * from Users where username = ?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setImages(rs.getString("images"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
