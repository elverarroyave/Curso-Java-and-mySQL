
package model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    private final String base = "tiendita";
    private final String user = "root";
    private final String password = "Gauss11235";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    
    private Connection con = null;
    
    
    public Connection getConexion(){
        
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user,this.password);
            
        }catch(Exception e){
            
            System.err.println(e);
            
        }
        
        
        return con;
        
    }
    
    
    
}
