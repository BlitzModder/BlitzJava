package com.immersion.hapticmediasdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import rrrrrr.rrrcrr;

public class HapticFileInformation
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new rrrcrr();
  private String a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int[] i;
  private int j;
  private int k;
  private int l;
  
  public HapticFileInformation() {}
  
  public HapticFileInformation(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = new int[this.h];
    int m = 0;
    while (m < this.h)
    {
      this.i[m] = paramParcel.readInt();
      m += 1;
    }
    this.j = paramParcel.readInt();
    this.k = paramParcel.readInt();
    this.l = paramParcel.readInt();
  }
  
  private HapticFileInformation(Builder paramBuilder)
  {
    this.a = Builder.bЧЧЧ0427Ч0427(paramBuilder);
    this.b = Builder.b0427ЧЧ0427Ч0427(paramBuilder);
    this.c = Builder.bЧ0427Ч0427Ч0427(paramBuilder);
    this.d = Builder.b04270427Ч0427Ч0427(paramBuilder);
    this.e = Builder.bЧЧ04270427Ч0427(paramBuilder);
    this.f = Builder.b0427Ч04270427Ч0427(paramBuilder);
    this.g = Builder.bЧ042704270427Ч0427(paramBuilder);
    this.h = Builder.b0427042704270427Ч0427(paramBuilder);
    this.i = Builder.bЧЧЧЧ04270427(paramBuilder);
    this.j = Builder.b0427ЧЧЧ04270427(paramBuilder);
    this.k = Builder.bЧ0427ЧЧ04270427(paramBuilder);
    this.l = Builder.b04270427ЧЧ04270427(paramBuilder);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int[] getActuatorArray()
  {
    return this.i;
  }
  
  public int getBitsPerSample()
  {
    return this.g;
  }
  
  public int getCompressionScheme()
  {
    return this.j;
  }
  
  public int getEncoding()
  {
    return this.e;
  }
  
  public int getFileLength()
  {
    return this.b;
  }
  
  public String getFilePath()
  {
    return this.a;
  }
  
  public int getHapticDataLength()
  {
    return this.k;
  }
  
  public int getHapticDataStartByteOffset()
  {
    return this.l;
  }
  
  public int getMajorVersion()
  {
    return this.c;
  }
  
  public int getMinorVersion()
  {
    return this.d;
  }
  
  public int getNumberOfChannels()
  {
    return this.h;
  }
  
  public int getSampleHertz()
  {
    return this.f;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramInt = 0;
    while (paramInt < this.h)
    {
      paramParcel.writeInt(this.i[paramInt]);
      paramInt += 1;
    }
    paramParcel.writeInt(this.j);
    paramParcel.writeInt(this.k);
    paramParcel.writeInt(this.l);
  }
  
  public static class Builder
  {
    private String a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int[] i;
    private int j;
    private int k;
    private int l;
    
    public HapticFileInformation build()
    {
      return new HapticFileInformation(this, null);
    }
    
    public Builder setActuatorArray(int[] paramArrayOfInt)
    {
      this.i = paramArrayOfInt;
      return this;
    }
    
    public Builder setBitsPerSample(int paramInt)
    {
      this.g = paramInt;
      return this;
    }
    
    public Builder setCompressionScheme(int paramInt)
    {
      this.j = paramInt;
      return this;
    }
    
    public Builder setEncoding(int paramInt)
    {
      this.e = paramInt;
      return this;
    }
    
    public Builder setFilePath(String paramString)
    {
      this.a = paramString;
      return this;
    }
    
    public Builder setHapticDataLength(int paramInt)
    {
      this.k = paramInt;
      return this;
    }
    
    public Builder setHapticDataStartByteOffset(int paramInt)
    {
      this.l = paramInt;
      return this;
    }
    
    public Builder setMajorVersion(int paramInt)
    {
      this.c = paramInt;
      return this;
    }
    
    public Builder setMinorVersion(int paramInt)
    {
      this.d = paramInt;
      return this;
    }
    
    public Builder setNumberOfChannels(int paramInt)
    {
      this.h = paramInt;
      return this;
    }
    
    public Builder setSampleHertz(int paramInt)
    {
      this.f = paramInt;
      return this;
    }
    
    public Builder setTotalFileLength(int paramInt)
    {
      this.b = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/immersion/hapticmediasdk/models/HapticFileInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */