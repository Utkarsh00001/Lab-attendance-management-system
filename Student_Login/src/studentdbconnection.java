
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author utkar
 */
public class studentdbconnection {
    static Connection con;
    
    public static Connection getConnection(){
        try{
            //Class.forName("com.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://192.168.225.162:3307/mydb?zeroDateTimeBehavior=convertToNull","root","");
                //localhost connectin
              //con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb?zeroDateTimeBehavior=convertToNull","root","");
            
            
        }catch (Exception ex){
            System.out.println(""+ex);
        }
        return con;
    }
    
}
