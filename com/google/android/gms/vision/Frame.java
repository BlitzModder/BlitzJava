package com.google.android.gms.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.nio.ByteBuffer;

public class Frame
{
  public static final int ROTATION_0 = 0;
  public static final int ROTATION_180 = 2;
  public static final int ROTATION_270 = 3;
  public static final int ROTATION_90 = 1;
  private Bitmap mBitmap = null;
  private Metadata zzbic = new Metadata();
  private ByteBuffer zzbid = null;
  
  private ByteBuffer zzGj()
  {
    int i = 0;
    int j = this.mBitmap.getWidth();
    int k = this.mBitmap.getHeight();
    int[] arrayOfInt = new int[j * k];
    this.mBitmap.getPixels(arrayOfInt, 0, j, 0, 0, j, k);
    byte[] arrayOfByte = new byte[j * k];
    while (i < arrayOfInt.length)
    {
      arrayOfByte[i] = ((byte)(int)(Color.red(arrayOfInt[i]) * 0.299F + Color.green(arrayOfInt[i]) * 0.587F + Color.blue(arrayOfInt[i]) * 0.114F));
      i += 1;
    }
    return ByteBuffer.wrap(arrayOfByte);
  }
  
  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public ByteBuffer getGrayscaleImageData()
  {
    if (this.mBitmap != null) {
      return zzGj();
    }
    return this.zzbid;
  }
  
  public Metadata getMetadata()
  {
    return this.zzbic;
  }
  
  public static class Builder
  {
    private Frame zzbie = new Frame(null);
    
    public Frame build()
    {
      if ((Frame.zza(this.zzbie) == null) && (Frame.zzb(this.zzbie) == null)) {
        throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
      }
      return this.zzbie;
    }
    
    public Builder setBitmap(Bitmap paramBitmap)
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      Frame.zza(this.zzbie, paramBitmap);
      paramBitmap = this.zzbie.getMetadata();
      Frame.Metadata.zza(paramBitmap, i);
      Frame.Metadata.zzb(paramBitmap, j);
      return this;
    }
    
    public Builder setId(int paramInt)
    {
      Frame.Metadata.zzc(this.zzbie.getMetadata(), paramInt);
      return this;
    }
    
    public Builder setImageData(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramByteBuffer == null) {
        throw new IllegalArgumentException("Null image data supplied.");
      }
      if (paramByteBuffer.capacity() < paramInt1 * paramInt2) {
        throw new IllegalArgumentException("Invalid image data size.");
      }
      switch (paramInt3)
      {
      default: 
        throw new IllegalArgumentException("Unsupported image format: " + paramInt3);
      }
      Frame.zza(this.zzbie, paramByteBuffer);
      paramByteBuffer = this.zzbie.getMetadata();
      Frame.Metadata.zza(paramByteBuffer, paramInt1);
      Frame.Metadata.zzb(paramByteBuffer, paramInt2);
      return this;
    }
    
    public Builder setRotation(int paramInt)
    {
      Frame.Metadata.zzd(this.zzbie.getMetadata(), paramInt);
      return this;
    }
    
    public Builder setTimestampMillis(long paramLong)
    {
      Frame.Metadata.zza(this.zzbie.getMetadata(), paramLong);
      return this;
    }
  }
  
  public static class Metadata
  {
    private int mId;
    private int zzCE;
    private long zzaGy;
    private int zzov;
    private int zzow;
    
    public Metadata() {}
    
    public Metadata(Metadata paramMetadata)
    {
      this.zzov = paramMetadata.getWidth();
      this.zzow = paramMetadata.getHeight();
      this.mId = paramMetadata.getId();
      this.zzaGy = paramMetadata.getTimestampMillis();
      this.zzCE = paramMetadata.getRotation();
    }
    
    public int getHeight()
    {
      return this.zzow;
    }
    
    public int getId()
    {
      return this.mId;
    }
    
    public int getRotation()
    {
      return this.zzCE;
    }
    
    public long getTimestampMillis()
    {
      return this.zzaGy;
    }
    
    public int getWidth()
    {
      return this.zzov;
    }
    
    public void zzGk()
    {
      if (this.zzCE % 2 != 0)
      {
        int i = this.zzov;
        this.zzov = this.zzow;
        this.zzow = i;
      }
      this.zzCE = 0;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/vision/Frame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */