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

package ar.com.nanotaboada.java.samples.guice;

import ar.com.nanotaboada.java.samples.guice.artists.Painter;
import ar.com.nanotaboada.java.samples.guice.modules.PainterModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Program
{
  private static final Injector _injector = Guice.createInjector(new PainterModule());
  private static final Painter _painter = _injector.getInstance(Painter.class);
  
  public static void main(String[] args)
  {
    _painter.name = "Peter Gibbons";
    System.out.println(_painter.name + _painter.paint());
  }
}
