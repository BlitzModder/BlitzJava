package com.dava.framework;

import android.content.res.AssetManager;
import android.content.res.AssetManager.AssetInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JNIFileList
{
  public static Object[] GetFileList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    int j;
    int i;
    String str;
    Object localObject2;
    if (LocalFileDescriptor.IsLocal(paramString))
    {
      localObject1 = new File(paramString).list();
      if (localObject1 != null)
      {
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          str = localObject1[i];
          localObject2 = new File(paramString + File.separator + str);
          localArrayList.add(new FileListDescriptor(str, ((File)localObject2).isDirectory(), ((File)localObject2).length()));
          i += 1;
        }
      }
    }
    else
    {
      localObject2 = JNIActivity.GetActivity().getAssets();
      localObject1 = paramString;
      for (;;)
      {
        try
        {
          if (paramString.length() > 0)
          {
            localObject1 = paramString;
            if (paramString.charAt(paramString.length() - 1) == '/') {
              localObject1 = paramString.substring(0, paramString.length() - 1);
            }
          }
          String[] arrayOfString = ((AssetManager)localObject2).list((String)localObject1);
          j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            str = arrayOfString[i];
            if (!((String)localObject1).isEmpty())
            {
              paramString = (String)localObject1 + File.separator + str;
              bool1 = true;
              bool2 = true;
              l2 = 0L;
              l1 = l2;
            }
          }
        }
        catch (IOException paramString)
        {
          boolean bool1;
          boolean bool2;
          long l2;
          long l1;
          paramString.printStackTrace();
        }
        try
        {
          paramString = (AssetManager.AssetInputStream)((AssetManager)localObject2).open(paramString);
          bool1 = bool2;
          l1 = l2;
          if (paramString != null)
          {
            boolean bool3 = false;
            bool2 = false;
            bool1 = bool3;
            l1 = l2;
            l2 = paramString.available();
            bool1 = bool3;
            l1 = l2;
            paramString.close();
            l1 = l2;
            bool1 = bool2;
          }
        }
        catch (IOException paramString)
        {
          continue;
        }
        localArrayList.add(new FileListDescriptor(str, bool1, l1));
        i += 1;
        continue;
        paramString = str;
      }
    }
    return localArrayList.toArray();
  }
  
  public static class FileListDescriptor
  {
    public boolean isDirectory;
    public String name;
    public long size;
    
    public FileListDescriptor(String paramString, boolean paramBoolean, long paramLong)
    {
      this.name = paramString;
      this.isDirectory = paramBoolean;
      this.size = paramLong;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNIFileList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */