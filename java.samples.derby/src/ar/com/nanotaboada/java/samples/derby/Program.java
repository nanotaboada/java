/** MIT-LICENSE 
 * Copyright (c) 2011 Nano Taboada, http://openid.nanotaboada.com.ar
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE. 
 **/

package ar.com.nanotaboada.java.samples.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;

public class Program
{
  // INFO: Performing Read for simplicity but could be any CRUD operation.
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
	    // TODO: Implement Create, Update and Delete methods.
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
