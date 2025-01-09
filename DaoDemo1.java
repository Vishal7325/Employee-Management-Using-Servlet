package Dao1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model1.ModelDemo1;



public class DaoDemo1 {

	// database connection method
		public static Connection getConnection() {
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Vishal@123");
			} catch (ClassNotFoundException e) {
		        System.out.println("JDBC Driver not found: " + e.getMessage());
		    } catch (SQLException e) {
		        System.out.println("SQL Exception: " + e.getMessage());
		    } catch (Exception e) {
		        System.out.println("Error: " + e.getMessage());
		    }
			
			return con;
		}

		// insert data into database using preparedstatement
		public static int save(ModelDemo1 e) {

			int status = 0;
			try {
				Connection con = DaoDemo1.getConnection();
				PreparedStatement ps = con
						.prepareStatement("insert into std_data2(name,contact_no,email,country) values (?,?,?,?)");
				ps.setString(1, e.getName());
				ps.setString(2, e.getContactNo());
				ps.setString(3, e.getEmail());
				ps.setString(4, e.getCountry());

				status = ps.executeUpdate();

				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			return status;
		}

		
		//update data into databases using prepared statement
		public static int update(ModelDemo1 e) {
			int status = 0;//false
			try {
				Connection con = DaoDemo1.getConnection();
				PreparedStatement ps = con.prepareStatement("update emp set name=?,contact_no=?,email=?,country=? where id=?");
				ps.setString(1, e.getName());
				ps.setString(2, e.getContactNo());
				ps.setString(3, e.getEmail());
				ps.setString(4, e.getCountry());

				ps.setInt(5, e.getId());

				status = ps.executeUpdate();

				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			return status;
		}

		//delete data into databases using prepared statement
		public static int delete(int id) {
			int status = 0;
			try {
				Connection con = DaoDemo1.getConnection();
				PreparedStatement ps = con.prepareStatement("delete from emp where id=?");

				ps.setInt(1, id);
				status = ps.executeUpdate();

				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			return status;
		}

		//get emp by id  into databases using prepared statement
		public static ModelDemo1 getEmployeeById(int id) {
			ModelDemo1 e = new ModelDemo1();

			try {
				Connection con = DaoDemo1.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from emp where id=?");

				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					e.setId(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setContactNo(rs.getString(3));
					e.setEmail(rs.getString(4));
					e.setCountry(rs.getString(5));
				}
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			return e;
		}
		

		//show all  data of databases using prepared statement
		public static List<ModelDemo1> getAllEmployees() {
			List<ModelDemo1> list = new ArrayList<ModelDemo1>();

			try {
				Connection con = DaoDemo1.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from std_data2");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					ModelDemo1 e = new ModelDemo1();
					e.setId(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setContactNo(rs.getString(3));
					e.setEmail(rs.getString(4));
					e.setCountry(rs.getString(5));
					
					list.add(e);
				}
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			return list;
		}

		//public static List<ModelDemo1> getAllEmployees() {
			// TODO Auto-generated method stub
			//return null;
		//}
		
}
