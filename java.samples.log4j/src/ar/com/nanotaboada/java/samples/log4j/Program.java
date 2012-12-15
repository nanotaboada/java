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

package ar.com.nanotaboada.java.samples.log4j;

import java.io.File;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

class Program
{
  private static final Logger _log = Logger.getLogger(Program.class);
  private static final File _cfg = new File("cfg/log4j.xml");
  private static final String _dbg = "log4j.xml configuration successfully loaded.";
  private static final String _msg = "The quick brown fox jumps over the lazy dog.";  
  public static void main(String[] args)
  {
    if (_cfg.exists()) {
      DOMConfigurator.configureAndWatch(_cfg.getPath());
      if (_log.isEnabledFor(Level.DEBUG)) _log.debug(_dbg);
    } else {
      BasicConfigurator.configure();
    }
    try {
      if (_log.isEnabledFor(Level.DEBUG)) _log.debug(_msg);
      if (_log.isEnabledFor(Level.INFO)) _log.info(_msg);
      if (_log.isEnabledFor(Level.WARN)) _log.warn(_msg);
      if (_log.isEnabledFor(Level.ERROR)) _log.error(_msg);
      if (_log.isEnabledFor(Level.FATAL)) _log.fatal(_msg);            
    } catch (Exception err) {
      System.out.println(err.getMessage());
    }
  }
}
