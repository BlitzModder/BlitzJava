package com.jirbo.adcolony;

import java.io.File;

class i
{
  public static boolean a(File paramFile)
  {
    if (paramFile.exists())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int i = 0;
      if (i < arrayOfFile.length)
      {
        if (arrayOfFile[i].isDirectory()) {
          a(arrayOfFile[i]);
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfFile[i].delete();
        }
      }
    }
    return paramFile.delete();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */