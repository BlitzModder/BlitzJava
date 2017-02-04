package com.dava.framework;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;

public class LocalFileDescriptor
{
  private FileDescriptor descriptor = null;
  private FileInputStream inputStream = null;
  private long length = 0L;
  private long startOffset = 0L;
  
  public LocalFileDescriptor(String paramString)
    throws IOException
  {
    if (IsLocal(paramString))
    {
      paramString = new File(paramString);
      this.inputStream = new FileInputStream(paramString);
      this.descriptor = this.inputStream.getFD();
      this.startOffset = 0L;
      this.length = paramString.length();
      return;
    }
    paramString = JNIActivity.GetActivity().getAssets().openFd(paramString);
    this.descriptor = paramString.getFileDescriptor();
    this.startOffset = paramString.getStartOffset();
    this.length = paramString.getLength();
  }
  
  public static boolean IsLocal(String paramString)
  {
    return paramString.startsWith("/");
  }
  
  public FileDescriptor GetDescriptor()
  {
    return this.descriptor;
  }
  
  public long GetLength()
  {
    return this.length;
  }
  
  public long GetStartOffset()
  {
    return this.startOffset;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/LocalFileDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */