package com.immersion.hapticmediasdk.controllers;

import com.immersion.content.HapticHeaderUtils;
import com.immersion.content.HeaderUtils;
import com.immersion.hapticmediasdk.utils.FileManager;
import com.immersion.hapticmediasdk.utils.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public class FileReaderFactory
{
  private static final String a = "FileReaderFactory";
  
  private static int a(String paramString, FileManager paramFileManager)
  {
    int k = 0;
    int j = 0;
    Object localObject = null;
    if (paramFileManager != null) {
      i = j;
    }
    for (;;)
    {
      try
      {
        paramString = paramFileManager.getHapticStorageFile(paramString);
        i = j;
        if (paramString.length() != 0L) {
          break;
        }
        return -1;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return i;
      }
      i = k;
      if (paramString == null) {
        return i;
      }
      i = j;
      paramString = new File(paramString);
    }
    paramFileManager = (FileManager)localObject;
    if (0 == 0)
    {
      i = j;
      paramFileManager = new RandomAccessFile(paramString, "r").getChannel();
    }
    int i = k;
    if (paramFileManager != null)
    {
      i = j;
      j = a(paramFileManager);
      i = j;
      paramFileManager.close();
      i = j;
    }
    return i;
  }
  
  private static int a(FileChannel paramFileChannel)
  {
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.position(0);
      if (paramFileChannel.read(localByteBuffer, 16L) != 4) {
        return 0;
      }
      localByteBuffer.flip();
      int i = localByteBuffer.getInt();
      int j = i + 28;
      localByteBuffer = ByteBuffer.allocate(j);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      if (paramFileChannel.read(localByteBuffer, 0L) == j)
      {
        localByteBuffer.position(4);
        localByteBuffer.getInt();
        localByteBuffer.position(20);
        paramFileChannel = new HapticHeaderUtils();
        paramFileChannel.setEncryptedHSI(localByteBuffer, i);
        i = paramFileChannel.getMajorVersionNumber();
        return i;
      }
    }
    catch (IOException paramFileChannel)
    {
      paramFileChannel.printStackTrace();
    }
    return 0;
  }
  
  public static IHapticFileReader getHapticFileReaderInstance(String paramString, FileManager paramFileManager)
  {
    for (;;)
    {
      try
      {
        switch (a(paramString, paramFileManager))
        {
        case 0: 
          Log.e("FileReaderFactory", "Unsupported HAPT file version");
          return null;
        }
      }
      catch (Error paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      Log.i("FileReaderFactory", "Can't retrieve Major version! Not enough bytes available yet.");
      return null;
      return new MemoryMappedFileReader(paramString, paramFileManager);
      return new MemoryAlignedFileReader(paramString, paramFileManager, 2);
      paramString = new MemoryAlignedFileReader(paramString, paramFileManager, 3);
      return paramString;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/immersion/hapticmediasdk/controllers/FileReaderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */