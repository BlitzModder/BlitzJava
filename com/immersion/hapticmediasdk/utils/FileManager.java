package com.immersion.hapticmediasdk.utils;

import android.content.Context;
import android.os.Process;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

public class FileManager
{
  public static final String HAPTIC_STORAGE_FILENAME = "dat.hapt";
  public static final String TAG = "FileManager";
  Context a;
  private int b = 0;
  
  public FileManager(Context paramContext)
  {
    this.a = paramContext;
    this.b = Process.myTid();
  }
  
  public void closeCloseable(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      paramCloseable.printStackTrace();
    }
  }
  
  public void deleteHapticStorage()
  {
    File[] arrayOfFile = new File(getInternalHapticPath()).listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.getName().endsWith(this.b + "dat.hapt")) {
          localFile.delete();
        }
        i += 1;
      }
    }
  }
  
  public File getHapticStorageFile(String paramString)
  {
    return new File(this.a.getFilesDir().getPath(), getUniqueFileName(paramString) + "dat.hapt");
  }
  
  public String getInternalHapticPath()
  {
    return this.a.getFilesDir().getAbsolutePath();
  }
  
  public String getUniqueFileName(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.reset();
      localMessageDigest.update(paramString.getBytes(), 0, paramString.length());
      paramString = String.format("%032x_%d", new Object[] { new BigInteger(1, localMessageDigest.digest()), Integer.valueOf(this.b) });
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public BufferedOutputStream makeOutputStream(String paramString, java.io.BufferedInputStream paramBufferedInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: sipush 1024
    //   6: newarray <illegal type>
    //   8: astore 5
    //   10: aload_0
    //   11: getfield 24	com/immersion/hapticmediasdk/utils/FileManager:a	Landroid/content/Context;
    //   14: aload_1
    //   15: iconst_0
    //   16: invokevirtual 155	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   19: astore_1
    //   20: aload_2
    //   21: invokevirtual 160	java/io/BufferedInputStream:available	()I
    //   24: istore_3
    //   25: iload_3
    //   26: ifle +24 -> 50
    //   29: aload_1
    //   30: aload 5
    //   32: iconst_0
    //   33: aload_2
    //   34: aload 5
    //   36: invokevirtual 164	java/io/BufferedInputStream:read	([B)I
    //   39: invokevirtual 169	java/io/FileOutputStream:write	([BII)V
    //   42: aload_2
    //   43: invokevirtual 160	java/io/BufferedInputStream:available	()I
    //   46: istore_3
    //   47: goto -22 -> 25
    //   50: aload_2
    //   51: invokevirtual 170	java/io/BufferedInputStream:close	()V
    //   54: aload 4
    //   56: astore_2
    //   57: aload_1
    //   58: ifnull +12 -> 70
    //   61: new 172	java/io/BufferedOutputStream
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 175	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   69: astore_2
    //   70: aload_2
    //   71: areturn
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_2
    //   76: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   79: goto -25 -> 54
    //   82: astore_2
    //   83: goto -8 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	FileManager
    //   0	86	1	paramString	String
    //   0	86	2	paramBufferedInputStream	java.io.BufferedInputStream
    //   24	23	3	i	int
    //   1	54	4	localObject	Object
    //   8	27	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   10	20	72	java/lang/Exception
    //   20	25	82	java/lang/Exception
    //   29	47	82	java/lang/Exception
    //   50	54	82	java/lang/Exception
  }
  
  public BufferedOutputStream makeOutputStreamForStreaming(String paramString)
  {
    try
    {
      paramString = this.a.openFileOutput(paramString, 0);
      return new BufferedOutputStream(paramString);
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/immersion/hapticmediasdk/utils/FileManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */