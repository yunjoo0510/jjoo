package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import Vo.Co2;

public class ImageDao {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/pentakill";

	static final String USERNAME = "root";
	static final String PASSWORD = "pentakill";

	
	public void insert(){
	    try{
	    	int ImageValue=2;
	    	int StartTime=2;
	    	
	    	
            Connection con = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
   
            PreparedStatement pstmt;
            int cnt;
            
            //PreparedStatement record input
            String insertQuery = "insert into Image(Metro_Num,Start_Time) values(?,?)";
          
            pstmt = con.prepareStatement(insertQuery);
          
            
     /**/   pstmt.setInt(1, 3);
            pstmt.setString(2, null);
            
            
            
            cnt = pstmt.executeUpdate();
           // System.out.println(cnt); // 1 (inserting record result 1!!)
            
           
          
            
         
            
            pstmt.close();
            con.close();
        }catch(Exception e){                                      //예외처리를 특정클래스별로 처리할수있지만 
            e.printStackTrace();                                  //그렇지 않고 try catch 구분에서발생하는
        }                                                         //예외를 추적해서 출력해주는 메서드란다...
                
    
		
		
	}
	
	
	public Co2 select() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			System.out.println("\n- MySQL Connection");
			stmt = conn.createStatement();

			String sql;
			
			
			
		/**/	sql = "SELECT * from image";
			
			
			
			
			
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				
				
				
				
		/**/	String StartTime = rs.getString("Start_Time");
				int ImageValue = rs.getInt("Image_Value");
				int metroNum= rs.getInt("Metro_Num");
			
				
				
				
				
				System.out.println(" timestamp : " + StartTime);
				System.out.println(" ImageValue: " + ImageValue);
				System.out.println("  metroNum:  "+ metroNum );
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se1) {
			se1.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("\n\n- MySQL Connection Close");

		return null;
	}
	
	
}
