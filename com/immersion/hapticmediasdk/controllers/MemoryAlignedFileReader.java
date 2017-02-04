package com.immersion.hapticmediasdk.controllers;

import com.immersion.content.HapticHeaderUtils;
import com.immersion.content.HeaderUtils;
import com.immersion.hapticmediasdk.models.HapticFileInformation;
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
import rrrrrr.rcrcrr;

public class MemoryAlignedFileReader
  implements IHapticFileReader
{
  private static final String a = "MemoryAlignedFileReader";
  private static int h = 80;
  private static int i = 0;
  private static final int k = 1024;
  private static final int l = 3072;
  private static final int t = 16;
  private File b;
  private FileChannel c;
  private rcrcrr d;
  private rcrcrr e;
  private int f = 0;
  private int g;
  private HapticFileInformation j;
  private String m = null;
  private FileManager n = null;
  private HeaderUtils o;
  private byte[] p = null;
  private final Profiler q = new Profiler();
  private int r;
  private int s;
  
  public MemoryAlignedFileReader(String paramString, HeaderUtils paramHeaderUtils)
  {
    this.m = paramString;
    this.o = paramHeaderUtils;
  }
  
  public MemoryAlignedFileReader(String paramString, FileManager paramFileManager, int paramInt)
  {
    this.m = paramString;
    this.n = paramFileManager;
    this.o = new HapticHeaderUtils();
    this.f = paramInt;
  }
  
  private int a(rcrcrr paramrcrcrr, int paramInt)
  {
    return (paramInt - paramrcrcrr.mHapticDataOffset) % paramrcrcrr.mMappedByteBuffer.capacity();
  }
  
  private boolean a()
  {
    Object localObject2 = null;
    RandomAccessFile localRandomAccessFile = null;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (this.j != null) {
          return true;
        }
        localObject1 = localObject2;
        if (this.b == null)
        {
          localObject1 = localObject2;
          if (this.n != null)
          {
            localObject1 = localObject2;
            this.b = this.n.getHapticStorageFile(this.m);
          }
        }
        else
        {
          localObject1 = localObject2;
          if (this.c == null)
          {
            localObject1 = localObject2;
            localRandomAccessFile = new RandomAccessFile(this.b, "r");
          }
        }
      }
      catch (FileNotFoundException localFileNotFoundException3)
      {
        Log.e("MemoryAlignedFileReader", "FileNotFoundException");
        this.n.closeCloseable((Closeable)localObject1);
        this.n.closeCloseable(this.c);
        return false;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      try
      {
        this.c = localRandomAccessFile.getChannel();
        localObject1 = localRandomAccessFile;
        if (this.c == null) {
          break label170;
        }
        localObject1 = localRandomAccessFile;
        return b();
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        FileNotFoundException localFileNotFoundException2 = localFileNotFoundException3;
        continue;
      }
      localObject1 = localObject2;
      if (this.m == null) {
        break label170;
      }
      localObject1 = localObject2;
      this.b = new File(this.m);
    }
    label170:
    return false;
  }
  
  private boolean a(int paramInt)
  {
    return this.g >= paramInt;
  }
  
  private int b(int paramInt)
  {
    if (this.o != null) {
      return this.o.calculateByteOffsetIntoHapticData(paramInt);
    }
    return 0;
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
      int i1 = localByteBuffer.getInt();
      int i2 = i1 + 28;
      localByteBuffer = ByteBuffer.allocate(i2);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      if (this.c.read(localByteBuffer, 0L) == i2)
      {
        localByteBuffer.position(4);
        this.r = (localByteBuffer.getInt() + 8 - i2);
        this.s = i2;
        localByteBuffer.position(20);
        this.p = new byte[i1];
        localByteBuffer.duplicate().get(this.p, 0, i1);
        this.o.setEncryptedHSI(localByteBuffer, i1);
        i1 = this.o.calculateBlockSize();
        if (i1 > 0)
        {
          i = i1 * 2;
          i1 = this.o.calculateBlockRate();
          if (i1 > 0)
          {
            h = i1;
            return true;
          }
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return false;
  }
  
  private static boolean b(rcrcrr paramrcrcrr, int paramInt)
  {
    return paramInt < paramrcrcrr.mHapticDataOffset;
  }
  
  private int c(int paramInt)
  {
    return this.s + b(paramInt);
  }
  
  private void c()
    throws NotEnoughHapticBytesAvailableException, IOException
  {
    if (this.e == null) {
      return;
    }
    int i1 = this.e.mHapticDataOffset;
    this.d = this.e;
    this.e = d(i1 + 1024 - i / 2);
  }
  
  private static boolean c(rcrcrr paramrcrcrr, int paramInt)
  {
    return paramInt >= paramrcrcrr.mHapticDataOffset + paramrcrcrr.mMappedByteBuffer.capacity();
  }
  
  private int d()
  {
    if (this.o != null) {
      return this.o.getNumChannels();
    }
    return 0;
  }
  
  private rcrcrr d(int paramInt)
    throws IOException, NotEnoughHapticBytesAvailableException
  {
    this.q.startTiming();
    if (paramInt < this.r)
    {
      int i2 = this.s;
      int i1 = f();
      if (paramInt + 1024 + i1 <= this.r) {
        i1 += 1024;
      }
      while (paramInt + i1 > this.g)
      {
        throw new NotEnoughHapticBytesAvailableException("Not enough bytes available yet.");
        i1 = this.r - paramInt;
      }
      MappedByteBuffer localMappedByteBuffer = this.c.map(FileChannel.MapMode.READ_ONLY, i2 + paramInt, i1);
      if (localMappedByteBuffer != null)
      {
        localMappedByteBuffer.order(ByteOrder.BIG_ENDIAN);
        rcrcrr localrcrcrr = new rcrcrr(null);
        localrcrcrr.mMappedByteBuffer = localMappedByteBuffer;
        localrcrcrr.mHapticDataOffset = paramInt;
        return localrcrcrr;
      }
    }
    return null;
  }
  
  private static boolean d(rcrcrr paramrcrcrr, int paramInt)
  {
    return (b(paramrcrcrr, paramInt)) || (c(paramrcrcrr, paramInt));
  }
  
  private void e()
  {
    Log.d("MemoryAlignedFileReader", "%%%%%%%%%%% logBufferState %%%%%%%%%%%");
    if (this.d != null)
    {
      Log.d("MemoryAlignedFileReader", "mCurrentMMW capacity = " + this.d.mMappedByteBuffer.capacity());
      Log.d("MemoryAlignedFileReader", "mCurrentMMW position = " + this.d.mMappedByteBuffer.position());
      Log.d("MemoryAlignedFileReader", "mCurrentMMW remaining = " + this.d.mMappedByteBuffer.remaining());
      Log.d("MemoryAlignedFileReader", "mCurrentMMW mHapticDataOffset = " + this.d.mHapticDataOffset);
      Log.d("MemoryAlignedFileReader", "mCurrentMMW mHapticDataOffset + position = " + (this.d.mHapticDataOffset + this.d.mMappedByteBuffer.position()));
      Log.d("MemoryAlignedFileReader", "--------------------------------------");
      if (this.e == null) {
        break label400;
      }
      Log.d("MemoryAlignedFileReader", "mNextMMW capacity = " + this.e.mMappedByteBuffer.capacity());
      Log.d("MemoryAlignedFileReader", "mNextMMW position = " + this.e.mMappedByteBuffer.position());
      Log.d("MemoryAlignedFileReader", "mNextMMW remaining = " + this.e.mMappedByteBuffer.remaining());
      Log.d("MemoryAlignedFileReader", "mNextMMW mHapticDataOffset = " + this.e.mHapticDataOffset);
      Log.d("MemoryAlignedFileReader", "mNextMMW mHapticDataOffset + position = " + (this.e.mHapticDataOffset + this.e.mMappedByteBuffer.position()));
    }
    for (;;)
    {
      Log.d("MemoryAlignedFileReader", "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
      return;
      Log.d("MemoryAlignedFileReader", "mCurrentMMW is null");
      break;
      label400:
      Log.d("MemoryAlignedFileReader", "mNextMMW is null");
    }
  }
  
  private static boolean e(rcrcrr paramrcrcrr, int paramInt)
  {
    return c(paramrcrcrr, i + paramInt);
  }
  
  private int f()
  {
    int i1 = 0;
    while ((i1 + 1024) % (i / 2) != 0) {
      i1 += 16;
    }
    return i1;
  }
  
  public boolean bufferAtPlaybackPosition(int paramInt)
  {
    if (!a()) {}
    do
    {
      return false;
      paramInt = b(paramInt);
    } while (paramInt >= this.r);
    if ((this.d == null) || (d(this.d, paramInt))) {}
    try
    {
      if ((this.e == null) || (d(this.e, paramInt)) || (e(this.e, paramInt)))
      {
        if ((this.d == null) || (this.d.mHapticDataOffset != paramInt)) {
          this.d = d(paramInt);
        }
        if ((this.e == null) || (this.e.mHapticDataOffset != paramInt + 1024 - i / 2)) {
          this.e = d(paramInt + 1024 - i / 2);
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
    catch (IOException localIOException)
    {
      return false;
    }
    catch (NotEnoughHapticBytesAvailableException localNotEnoughHapticBytesAvailableException)
    {
      return false;
    }
    return true;
  }
  
  public void close()
  {
    this.n.closeCloseable(this.c);
    this.o.dispose();
  }
  
  public long getBlockOffset(long paramLong)
  {
    return paramLong % h * 16L / h;
  }
  
  public int getBlockSizeMS()
  {
    return h;
  }
  
  public byte[] getBufferForPlaybackPosition(int paramInt)
    throws NotEnoughHapticBytesAvailableException
  {
    int i1 = 0;
    if (this.d == null) {}
    do
    {
      return null;
      paramInt = b(paramInt);
    } while (paramInt >= this.r - i);
    try
    {
      byte[] arrayOfByte = new byte[i];
      if (this.d.mMappedByteBuffer.remaining() < i) {
        c();
      }
      int i2 = this.d.mMappedByteBuffer.position() + this.d.mHapticDataOffset;
      if ((i2 < paramInt) || (i2 > paramInt))
      {
        paramInt = paramInt - i2 + this.d.mMappedByteBuffer.position();
        if (paramInt >= 0) {
          break label185;
        }
        paramInt = i1;
      }
      for (;;)
      {
        this.d.mMappedByteBuffer.position(paramInt);
        paramInt = this.d.mMappedByteBuffer.remaining();
        MappedByteBuffer localMappedByteBuffer = this.d.mMappedByteBuffer;
        if (paramInt < i) {}
        for (;;)
        {
          localMappedByteBuffer.get(arrayOfByte, 0, paramInt);
          this.d.mMappedByteBuffer.position(this.d.mMappedByteBuffer.position() - i / 2);
          return arrayOfByte;
          label185:
          if (this.d.mMappedByteBuffer.limit() >= paramInt) {
            break label231;
          }
          paramInt = this.d.mMappedByteBuffer.limit() - 1;
          break;
          paramInt = i;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
  }
  
  public byte[] getEncryptedHapticHeader()
  {
    return this.p;
  }
  
  public int getHapticBlockIndex(long paramLong)
  {
    int i1 = b((int)paramLong);
    if (this.f == 2) {
      return i1 / 16;
    }
    if (this.f >= 3) {
      return i1 / (d() * 16);
    }
    return 0;
  }
  
  public HapticFileInformation getHapticFileInformation()
  {
    return this.j;
  }
  
  public void setBlockSizeMS(int paramInt)
  {
    h = paramInt;
  }
  
  public void setBytesAvailable(int paramInt)
  {
    this.g = paramInt;
    if (this.g <= 0)
    {
      this.g = paramInt;
      a();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/immersion/hapticmediasdk/controllers/MemoryAlignedFileReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */