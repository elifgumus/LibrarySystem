package DAL;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.ResultSetMetaData;

import java.sql.SQLException;

import java.sql.Statement;

import org.sqlite.*;

public class DataAccess {

                //SQL Connection OBjects

                Connection con = null;
                Statement st = null;
                ResultSet rs=null;
                String url ="jdbc:sqlite:sqlite_database_file_path";
                public DataAccess() throws Exception
                {
                               Class.forName("org.sqlite.JDBC");
                               con = DriverManager.getConnection(url);
                               st = con.createStatement();                      
                }
                
                public DataAccess(String url, String username, String password) throws Exception
                {
                               con = DriverManager.getConnection(url, username, password);
                               Statement st = con.createStatement();                
                }

                public ResultSet ExecuteQuery(String sql) throws Exception
                {
                                           return st.executeQuery(sql);
                }

                public int ExecuteUpdate(String sql) throws Exception
                {
                               return st.executeUpdate(sql);
                }

}