package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@zzha
public class zzbn
{
  private final int zzte;
  private final int zztf;
  private final int zztg;
  private final zzbm zzth = new zzbp();
  
  public zzbn(int paramInt)
  {
    this.zztf = paramInt;
    this.zzte = 6;
    this.zztg = 0;
  }
  
  private String zzA(String paramString)
  {
    String[] arrayOfString = paramString.split("\n");
    if (arrayOfString.length == 0) {
      return "";
    }
    paramString = zzcH();
    Arrays.sort(arrayOfString, new Comparator()
    {
      public int compare(String paramAnonymousString1, String paramAnonymousString2)
      {
        return paramAnonymousString2.length() - paramAnonymousString1.length();
      }
    });
    int i = 0;
    if ((i < arrayOfString.length) && (i < this.zztf))
    {
      if (arrayOfString[i].trim().length() == 0) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          paramString.write(this.zzth.zzz(arrayOfString[i]));
        }
        catch (IOException localIOException)
        {
          zzb.zzb("Error while writing hash to byteStream", localIOException);
        }
      }
    }
    return paramString.toString();
  }
  
  String zzB(String paramString)
  {
    Object localObject1 = paramString.split("\n");
    if (localObject1.length == 0) {
      return "";
    }
    paramString = zzcH();
    Object localObject2 = new PriorityQueue(this.zztf, new Comparator()
    {
      public int zza(zzbq.zza paramAnonymouszza1, zzbq.zza paramAnonymouszza2)
      {
        return (int)(paramAnonymouszza1.value - paramAnonymouszza2.value);
      }
    });
    int i = 0;
    if (i < localObject1.length)
    {
      String[] arrayOfString = zzbo.zzD(localObject1[i]);
      if (arrayOfString.length < this.zzte) {}
      for (;;)
      {
        i += 1;
        break;
        zzbq.zza(arrayOfString, this.zztf, this.zzte, (PriorityQueue)localObject2);
      }
    }
    localObject1 = ((PriorityQueue)localObject2).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (zzbq.zza)((Iterator)localObject1).next();
        try
        {
          paramString.write(this.zzth.zzz(((zzbq.zza)localObject2).zztm));
        }
        catch (IOException localIOException)
        {
          zzb.zzb("Error while writing hash to byteStream", localIOException);
        }
      }
    }
    return paramString.toString();
  }
  
  public String zza(ArrayList<String> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localStringBuffer.append(((String)paramArrayList.next()).toLowerCase(Locale.US));
      localStringBuffer.append('\n');
    }
    switch (this.zztg)
    {
    default: 
      return "";
    case 0: 
      return zzB(localStringBuffer.toString());
    }
    return zzA(localStringBuffer.toString());
  }
  
  zza zzcH()
  {
    return new zza();
  }
  
  static class zza
  {
    ByteArrayOutputStream zztj = new ByteArrayOutputStream(4096);
    Base64OutputStream zztk = new Base64OutputStream(this.zztj, 10);
    
    public String toString()
    {
      try
      {
        this.zztk.close();
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          try
          {
            this.zztj.close();
            String str = this.zztj.toString();
            return str;
          }
          catch (IOException localIOException2)
          {
            zzb.zzb("HashManager: Unable to convert to Base64.", localIOException2);
            return "";
          }
          finally
          {
            this.zztj = null;
            this.zztk = null;
          }
          localIOException1 = localIOException1;
          zzb.zzb("HashManager: Unable to convert to Base64.", localIOException1);
        }
      }
    }
    
    public void write(byte[] paramArrayOfByte)
      throws IOException
    {
      this.zztk.write(paramArrayOfByte);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzbn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */