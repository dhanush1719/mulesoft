
import java.sql.*;


public class DBConnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    public DBConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            st=con.createStatement();
            
        }catch(Exception ex){
            System.out.println("Error:"+ex);
        }
    }
    public void getData()
    {
        try{
            String query="select * from persons";
            rs=st.executeQuery(query);
            System.out.println("Records from database");
            while(rs.next()){
                String id=rs.getString("id");
                String name=rs.getString("name");
                String age= rs.getString("age");
                
                System.out.println("ID:" +id+ "  Name: "+name+"   "+"Age: "+age);
                
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}

    
