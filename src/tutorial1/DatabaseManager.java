/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Electel
 */
public class DatabaseManager {
     /**
     */
    public int id=0;
    
    /**
     *
     * @throws Exception
     */
    public DatabaseManager() throws Exception {
        // TODO code application logic here
        //Function works
        //getConnection();
        
        //problem with the mySQL sytax
        //dropTable();
        //createTable();
        
        //functions works as expected
        
      // post();
        get();
    }
    
    /**
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            //String url = "jdbc:mysql://127.0.0.1:3306/db1?useTimezone=true&serverTimezone=UTC";
            String url = "jdbc:mysql://b99cd178db3229:3597ad76@us-cdbr-iron-east-02.cleardb.net/heroku_b4ffa00b1d9cde9?reconnect=true";
            //String username = "root";
            //String password = "";
            String username = "b99cd178db3229";
            String password = "3597ad76";
            
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connected");
            return con;
        }catch(Exception e){System.out.println(e);}
        return null;
    }
    
    /**
     *
     * @throws Exception
     */
    public static void createUsrTable() throws Exception{
        try{
            Connection con = getConnection();
            //Problem in the mySQL Syntax
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS users(id INT NOT NULL AUTO_INCREMENT, username varchar(50),password varchar(50), PRIMARY KEY(id))");
            create.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
        finally{
            System.out.println("Function complete");
        };
    }
    
    /**
     *
     * @throws Exception
     */
    public static void createLevelTable() throws Exception{
        try{
            Connection con = getConnection();
            //Problem in the mySQL Syntax
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS scores(scoreID INT NOT NULL AUTO_INCREMENT, level1 int,level2 int,level3 int,level4 int,level5 int,level6 int,usrID int FOREIGN KEY REFERENCES users(id), PRIMARY KEY(id))");
            create.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
        finally{
            System.out.println("Function complete");
        };
    }
        
    /**
     *
     * @throws Exception
     */
    public static void dropTable() throws Exception{
        try{
            Connection con = getConnection();
            //Problem in the mySQL Syntax
            PreparedStatement create = con.prepareStatement("DROP TABLE usuarios");
            create.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
        finally{
            System.out.println("Function complete");
        };
    } 
       
    /**
     *
     * @throws Exception
     */
    public static void Usr() throws Exception{
        final String var1 = "Gerardo";
        final String var2 = "pa55w0rd";
        try{
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO users (username, password)VALUES('"+var1+"','"+var2+"')");
            posted.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
        finally{
            System.out.println("Inset completed");
        }
    }
    
    /**
     *
     * @param u
     * @param p
     * @throws Exception
     */
    public static void postUsr(String u, String p) throws Exception{
        final String var1 = u;
        final String var2 = p;
        try{
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO usuarios (username, password)VALUES('"+var1+"','"+var2+"')");
            posted.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
        finally{
            System.out.println("Inset completed");
        }
    }
        
    /**
     *
     * @param usrID
     * @param level
     * @param score
     * updates the level score in a row depending on the rows user id
     */
    public void updateScore(int usrID, String level,int score) {
        final int var1 = usrID;
        final String var2 = level;
        final int var3 = score;
        try{
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement("UPDATE scores SET " +var2+" = "+var3+"WHERE usrID = "+var1);
            posted.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
        finally{
            System.out.println("Inset completed");
        }
    }
    
    /**
     *
     * @return
     * @throws Exception
     * prints the user table
     */
    public static ArrayList<String> get() throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM usuarios ");
            
            ResultSet result = statement.executeQuery();
            ArrayList<String> array = new ArrayList<String>();
            while(result.next()){
                System.out.print(result.getString("id"));
                System.out.print("\t");
                System.out.print(result.getString("username"));
                System.out.print("\t");
                System.out.print(result.getString("password"));   
                System.out.println(" ");
                
                array.add(result.getString("username"));
                
            }
            System.out.println("All records have been selected!");
            return array;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    /**
     *
     * @param u //user
     * @param p//password
     * @return
     * @throws Exception
     * returns the user id depending on the username and password
     */
    public static int getUsrID(String u, String p) throws Exception{
        try{
            Connection con = getConnection();
            final String var1 = u;
            final String var2 = p;
            
            PreparedStatement statement = con.prepareStatement("SELECT id FROM usuarios WHERE username = '"+var1+"' AND password = '"+var2+"'");
            
            ResultSet result = statement.executeQuery();
            long countLong = result.getLong(1);
            int uid =(int)countLong;    
            System.out.println("User id found!");
            return uid;
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }
    
    //adds a row in the score table with the user id
        public static void addScoreRow(int u) throws Exception{
        final int var1 = u;//userid
        try{
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO scores (usrID)VALUES('"+var1+"')");
            posted.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
        finally{
            System.out.println("Inset completed");
        }
    }
            
}
