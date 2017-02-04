package com.immersion.hapticmediasdk.controllers;

import com.immersion.hapticmediasdk.models.HapticFileInformation;
import com.immersion.hapticmediasdk.models.HapticFileInformation.Builder;
import com.immersion.hapticmediasdk.models.NotEnoughHapticBytesAvailableException;
import com.immersion.hapticmediasdk.utils.FileManager;
import com.immersion.hapticmediasdk.utils.Log;
import com.immersion.hapticmediasdk.utils.Profiler;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import rrrrrr.ccrrrr;

public class MemoryMappedFileReader
  implements IHapticFileReader
{
  private static final String a = "MemoryMappedFileReader";
  private static int g = 40;
  private static int h = 0;
  private static final int j = 4096;
  private static final int k = 12288;
  private File b;
  private FileChannel c;
  private ccrrrr d;
  private ccrrrr e;
  private int f;
  private HapticFileInformation i;
  private String l;
  private final Profiler m = new Profiler();
  private FileManager n;
  
  public MemoryMappedFileReader(String paramString, FileManager paramFileManager)
  {
    this.l = paramString;
    this.n = paramFileManager;
  }
  
  private int a(ccrrrr paramccrrrr, int paramInt)
  {
    return (paramInt - paramccrrrr.mHapticDataOffset) % paramccrrrr.mMappedByteBuffer.capacity();
  }
  
  private boolean a()
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    try
    {
      if (this.i != null) {
        return true;
      }
      localObject1 = localObject3;
      if (!a(12288))
      {
        localObject1 = localObject3;
        if (this.b == null)
        {
          localObject1 = localObject3;
          this.b = this.n.getHapticStorageFile(this.l);
        }
        localObject1 = localObject3;
        if (this.c == null)
        {
          localObject1 = localObject3;
          localObject2 = new RandomAccessFile(this.b, "r");
        }
      }
      boolean bool;
      return false;
    }
    catch (FileNotFoundException localFileNotFoundException2)
    {
      try
      {
        this.c = ((RandomAccessFile)localObject2).getChannel();
        localObject1 = localObject2;
        if (this.c == null) {
          break label159;
        }
        localObject1 = localObject2;
        bool = b();
        return bool;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        for (;;) {}
      }
      localFileNotFoundException2 = localFileNotFoundException2;
      localObject2 = localObject1;
      localObject1 = localFileNotFoundException2;
      Log.e("MemoryMappedFileReader", ((FileNotFoundException)localObject1).getMessage());
      this.n.closeCloseable((Closeable)localObject2);
      this.n.closeCloseable(this.c);
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return false;
    }
  }
  
  private boolean a(int paramInt)
  {
    return this.f >= paramInt;
  }
  
  private int b(int paramInt)
  {
    int i2 = paramInt / (1000 / this.i.getSampleHertz());
    paramInt = this.i.getBitsPerSample();
    int i1 = this.i.getNumberOfChannels();
    float f1 = paramInt * i1 / 8.0F;
    float f2 = paramInt * i1 / 8;
    i1 = (int)f2;
    paramInt = i1;
    if (f1 > f2) {
      paramInt = i1 + 1;
    }
    return paramInt * i2;
  }
  
  private boolean b()
  {
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.position(0);
      if (this.c.read(localByteBuffer, 16L) != 4) {
        return false;
      }
      localByteBuffer.flip();
      int i1 = localByteBuffer.getInt() + 28;
      localByteBuffer = ByteBuffer.allocate(i1);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      if (this.c.read(localByteBuffer, 0L) == i1)
      {
        localByteBuffer.flip();
        HapticFileInformation.Builder localBuilder = new HapticFileInformation.Builder();
        localBuilder.setFilePath(this.b.getAbsolutePath());
        localByteBuffer.position(4);
        localBuilder.setTotalFileLength(localByteBuffer.getInt() + 8);
        localByteBuffer.position(20);
        localBuilder.setMajorVersion(localByteBuffer.get());
        localBuilder.setMinorVersion(localByteBuffer.get());
        localBuilder.setEncoding(localByteBuffer.get());
        localByteBuffer.position(24);
        localBuilder.setSampleHertz(localByteBuffer.getInt());
        localBuilder.setBitsPerSample(localByteBuffer.get() | localByteBuffer.get() << 8);
        int i2 = localByteBuffer.get();
        localBuilder.setNumberOfChannels(i2);
        int[] arrayOfInt = new int[i2];
        i1 = 0;
        while (i1 < i2)
        {
          arrayOfInt[i1] = localByteBuffer.get();
          i1 += 1;
        }
        localBuilder.setActuatorArray(arrayOfInt);
        localBuilder.setCompressionScheme(localByteBuffer.get());
        localByteBuffer.position(localByteBuffer.position() + 4);
        localBuilder.setHapticDataLength(localByteBuffer.getInt());
        localBuilder.setHapticDataStartByteOffset(localByteBuffer.position());
        this.i = localBuilder.build();
        h = g * this.i.getSampleHertz() / 1000 * this.i.getBitsPerSample() * this.i.getNumberOfChannels() / 8;
        return true;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return false;
  }
  
  private static boolean b(ccrrrr paramccrrrr, int paramInt)
  {
    return paramInt < paramccrrrr.mHapticDataOffset;
  }
  
  private int c(int paramInt)
  {
    return this.i.getHapticDataStartByteOffset() + b(paramInt);
  }
  
  private void c()
    throws NotEnoughHapticBytesAvailableException, IOException
  {
    if (this.e == null) {
      return;
    }
    int i1 = this.e.mHapticDataOffset;
    this.d = this.e;
    this.e = d(i1 + 4096);
  }
  
  private static boolean c(ccrrrr paramccrrrr, int paramInt)
  {
    return paramInt >= paramccrrrr.mHapticDataOffset + paramccrrrr.mMappedByteBuffer.capacity();
  }
  
  private ccrrrr d(int paramInt)
    throws IOException, NotEnoughHapticBytesAvailableException
  {
    this.m.startTiming();
    if (paramInt < this.i.getHapticDataLength())
    {
      int i2 = this.i.getHapticDataStartByteOffset();
      if (paramInt + 4096 <= this.i.getHapticDataLength()) {}
      for (int i1 = 4096; paramInt + i1 > this.f; i1 = this.i.getHapticDataLength() - paramInt) {
        throw new NotEnoughHapticBytesAvailableException("Not enough bytes available yet.");
      }
      MappedByteBuffer localMappedByteBuffer = this.c.map(FileChannel.MapMode.READ_ONLY, i2 + paramInt, i1);
      if (localMappedByteBuffer != null)
      {
        localMappedByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        ccrrrr localccrrrr = new ccrrrr(null);
        localccrrrr.mMappedByteBuffer = localMappedByteBuffer;
        localccrrrr.mHapticDataOffset = paramInt;
        return localccrrrr;
      }
    }
    return null;
  }
  
  private void d()
  {
    Log.d("MemoryMappedFileReader", "%%%%%%%%%%% logBufferState %%%%%%%%%%%");
    if (this.d != null)
    {
      Log.d("MemoryMappedFileReader", "mCurrentMMW capacity = " + this.d.mMappedByteBuffer.capacity());
      Log.d("MemoryMappedFileReader", "mCurrentMMW position = " + this.d.mMappedByteBuffer.position());
      Log.d("MemoryMappedFileReader", "mCurrentMMW remaining = " + this.d.mMappedByteBuffer.remaining());
      Log.d("MemoryMappedFileReader", "mCurrentMMW mHapticDataOffset = " + this.d.mHapticDataOffset);
      Log.d("MemoryMappedFileReader", "mCurrentMMW mHapticDataOffset + position = " + (this.d.mHapticDataOffset + this.d.mMappedByteBuffer.position()));
      Log.d("MemoryMappedFileReader", "--------------------------------------");
      if (this.e == null) {
        break label400;
      }
      Log.d("MemoryMappedFileReader", "mNextMMW capacity = " + this.e.mMappedByteBuffer.capacity());
      Log.d("MemoryMappedFileReader", "mNextMMW position = " + this.e.mMappedByteBuffer.position());
      Log.d("MemoryMappedFileReader", "mNextMMW remaining = " + this.e.mMappedByteBuffer.remaining());
      Log.d("MemoryMappedFileReader", "mNextMMW mHapticDataOffset = " + this.e.mHapticDataOffset);
      Log.d("MemoryMappedFileReader", "mNextMMW mHapticDataOffset + position = " + (this.e.mHapticDataOffset + this.e.mMappedByteBuffer.position()));
    }
    for (;;)
    {
      Log.d("MemoryMappedFileReader", "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
      return;
      Log.d("MemoryMappedFileReader", "mCurrentMMW is null");
      break;
      label400:
      Log.d("MemoryMappedFileReader", "mNextMMW is null");
    }
  }
  
  private static boolean d(ccrrrr paramccrrrr, int paramInt)
  {
    return (b(paramccrrrr, paramInt)) || (c(paramccrrrr, paramInt));
  }
  
  private static boolean e(ccrrrr paramccrrrr, int paramInt)
  {
    return c(paramccrrrr, h + paramInt);
  }
  
  public boolean bufferAtPlaybackPosition(int paramInt)
  {
    if (!a()) {
      return false;
    }
    paramInt = b(paramInt);
    if ((this.d == null) || (d(this.d, paramInt))) {}
    try
    {
      if ((this.e == null) || (d(this.e, paramInt)) || (e(this.e, paramInt)))
      {
        if ((this.d == null) || (this.d.mHapticDataOffset != paramInt)) {
          this.d = d(paramInt);
        }
        if ((this.e == null) || (this.e.mHapticDataOffset != paramInt + 4096)) {
          this.e = d(paramInt + 4096);
        }
      }
      else
      {
        c();
        if (this.d != null) {
          this.d.mMappedByteBuffer.position(a(this.d, paramInt));
        }
        return true;
      }
    }
    catch (NotEnoughHapticBytesAvailableException localNotEnoughHapticBytesAvailableException)
    {
      Log.w("MemoryMappedFileReader", localNotEnoughHapticBytesAvailableException.getMessage());
      return false;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return false;
    }
    return true;
  }
  
  public void close()
  {
    this.n.closeCloseable(this.c);
  }
  
  public long getBlockOffset(long paramLong)
  {
    return 0L;
  }
  
  public int getBlockSizeMS()
  {
    return g;
  }
  
  public byte[] getBufferForPlaybackPosition(int paramInt)
    throws NotEnoughHapticBytesAvailableException
  {
    if (this.d == null) {}
    while (this.d.mHapticDataOffset + this.d.mMappedByteBuffer.position() >= this.i.getHapticDataLength()) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = new byte[h];
      if (h >= this.d.mMappedByteBuffer.remaining())
      {
        int i1 = this.d.mMappedByteBuffer.remaining();
        paramInt = h - i1;
        this.d.mMappedByteBuffer.get(arrayOfByte, 0, i1);
        if ((paramInt > 0) && (this.e != null)) {
          if (this.e.mMappedByteBuffer.remaining() < paramInt) {
            break label136;
          }
        }
        for (;;)
        {
          this.e.mMappedByteBuffer.get(arrayOfByte, i1, paramInt);
          c();
          break;
          label136:
          paramInt = this.e.mMappedByteBuffer.remaining();
        }
      }
      this.d.mMappedByteBuffer.get(arrayOfByte, 0, h);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    return localException;
  }
  
  public byte[] getEncryptedHapticHeader()
  {
    return new byte[0];
  }
  
  public int getHapticBlockIndex(long paramLong)
  {
    return 0;
  }
  
  public HapticFileInformation getHapticFileInformation()
  {
    return this.i;
  }
  
  public void setBlockSizeMS(int paramInt)
  {
    g = paramInt;
  }
  
  public void setBytesAvailable(int paramInt)
  {
    this.f = paramInt;
    a();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/immersion/hapticmediasdk/controllers/MemoryMappedFileReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */