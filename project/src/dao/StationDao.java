package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Vo.Co2;

public class StationDao {


	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/pentakill";

	static final String USERNAME = "root";
	static final String PASSWORD = "pentakill";

	
	public void insert(){
	    try{
	    	String StationName=null;
	    	int MetroNum=3;
	    	int StartTime=3;
	    	
	    	
	    	
            Connection con = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
   
            PreparedStatement pstmt;
            int cnt;
            
            //PreparedStatement record input
            String insertQuery = "insert into Station(Station_name,Metro_Num,Start_Time) values(?,?,?)";
          
            pstmt = con.prepareStatement(insertQuery);
          
            
     /**/   pstmt.setString(1, "JEONGWANG");
            pstmt.setInt(2, 3);
            pstmt.setString(3, null);
            
            
            
            cnt = pstmt.executeUpdate();
           // System.out.println(cnt); // 1 (inserting record result 1!!)
            
           
          
            
         
            
            pstmt.close();
            con.close();
        }catch(Exception e){                                      //����ó���� Ư��Ŭ�������� ó���Ҽ������� 
            e.printStackTrace();                                  //�׷��� �ʰ� try catch ���п����߻��ϴ�
        }                                                         //���ܸ� �����ؼ� ������ִ� �޼������...
                
    
		
		
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
			
			
			
		/**/	sql = "SELECT * from station";
			
			
			
			
			
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				
				
				
				
		/**/	String StationName = rs.getString("Station_name");
				int 	MetroNum = rs.getInt("Metro_Num");
				String StartTime  = rs.getString("Start_Time");
			
				
				
				
				
				System.out.println(" stationName : " + StationName);
				System.out.println("  metroNum   : " + MetroNum);
				System.out.println(" timestamp   : " + StartTime );
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
