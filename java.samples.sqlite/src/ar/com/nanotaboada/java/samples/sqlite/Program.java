/** MIT-LICENSE 
 * Copyright (c) 2013 Nano Taboada, http://openid.nanotaboada.com.ar
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

package ar.com.nanotaboada.java.samples.sqlite;

import java.sql.*;

public class Program
{
  // INFO: Performing Read for simplicity but could be any CRUD operation.
  private static final String _str = "jdbc:sqlite:res/catalog.sqlite";
  private static final String _sql = "SELECT * FROM books;";
  private static StringBuilder _txt = new StringBuilder();
  
  public static void main(String[] args)
  {
    try {
      Class.forName("org.sqlite.JDBC");
      Connection connection = DriverManager.getConnection(_str);
      Statement statement = connection.createStatement();
      // TODO: Implement Create, Update and Delete methods.
      ResultSet resultSet = statement.executeQuery(_sql);
      _txt.append(String.format("%-35s %-25s %-10s %-5s",
                                "Title",
                                "Author",
                                "Published",
                                "Pages"
                               ));
      _txt.append(System.getProperty("line.separator"));
      _txt.append(String.format("%-35s %-25s %-10s %-5s",
                                "-----------------------------------",
                                "-------------------------",
                                "----------",
                                "-----"
                               ));
      _txt.append(System.getProperty("line.separator"));
      
      // INFO: Given that Date getters are mostly deprecated we will
      //       instead use getString() on "Published" for simplicity.
      while (resultSet.next()) {
        _txt.append(String.format("%-35s %-25s %-10s %5d",
                                  resultSet.getString("Title"),
                                  resultSet.getString("Author"),
                                  resultSet.getString("Published"),
                                  resultSet.getInt("Pages")
                                 ));
        _txt.append(System.getProperty("line.separator"));
      }
      System.out.println(_txt.toString());
    } catch (Exception err) {
      System.out.println(err.getMessage());
    }
  }
}