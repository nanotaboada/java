package ar.com.nanotaboada.java.samples.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;

public class Program
{
  //INFO: Performing Read for simplicity but could be any CRUD operation.
  private static Properties _pro = System.getProperties();
  private static final String _dir = _pro.getProperty("user.dir");
  private static StringBuilder _url = new StringBuilder();
  private static StringBuilder _out = new StringBuilder();
  private static final String _sql = "SELECT * FROM books ORDER BY published";
  public static void main(String[] args)
  {
  	_pro.setProperty("derby.system.home", _dir);
  	_pro.setProperty("derby.stream.error.file", _dir+"/log/derby.log");
	  _url.append("jdbc:derby:");
  	_url.append(_dir+"/res/catalog.db");
    _url.append(";create=true");
  	try {
	    Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
	    Connection connection = DriverManager.getConnection(_url.toString());
	    Statement statement = connection.createStatement();
	    //TODO: Implement Create, Update and Delete methods.
	    ResultSet resultSet = statement.executeQuery(_sql);
	    _out.append(String.format("%-35s %-25s %-10s %-5s",
	                              "Title",
	                              "Author",
	                              "Published",
	                              "Pages"
	                             ));
	    _out.append(System.getProperty("line.separator"));
	    _out.append(String.format("%-35s %-25s %-10s %-5s",
	                              "-----------------------------------",
	                              "-------------------------",
	                              "----------",
	                              "-----"
	                             ));
	    _out.append(System.getProperty("line.separator"));
	
	    // INFO: Given that Date getters are mostly deprecated we will
	    //       instead use getString() on "Published" for simplicity.
	    while (resultSet.next()) {
	      _out.append(String.format("%-35s %-25s %-10s %5d",
	                                resultSet.getString("Title"),
	                                resultSet.getString("Author"),
	                                resultSet.getString("Published"),
	                                resultSet.getInt("Pages")
	                               ));
	      _out.append(System.getProperty("line.separator"));
      }
      System.out.println(_out.toString());
    } catch (Exception err) {
      System.out.println(err.getMessage());
    }
  }
}
