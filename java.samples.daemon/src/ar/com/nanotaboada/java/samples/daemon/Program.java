/** MIT-LICENSE 
 * Copyright (c) 2012 Nano Taboada, http://openid.nanotaboada.com.ar
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

package ar.com.nanotaboada.java.samples.daemon;

import org.apache.commons.daemon.*;

public class Program implements Daemon
{
  static final String _msg = "The quick brown fox jumps over the lazy dog.";

  public static void main(String[] args) {}

  @Override
  public void init(DaemonContext ctx) throws DaemonInitException, Exception {}

  @Override
  public void start() throws Exception
  {
    System.out.println("[STARTED] Apache Commons Daemon.");
    System.out.println("[MESSAGE] " + _msg);    
  }

  @Override
  public void stop() throws Exception
  {
    System.out.println("[STOPPED] Apache Commons Daemon.");
  }
  
  @Override
  public void destroy() {}
}
