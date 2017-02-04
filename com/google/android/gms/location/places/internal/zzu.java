package com.google.android.gms.location.places.internal;

import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzta;
import com.google.android.gms.internal.zztj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class zzu
  extends com.google.android.gms.common.data.zzc
{
  private final String TAG = "SafeDataBufferRef";
  
  public zzu(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  protected String zzI(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (zzct(paramString1))
    {
      str = paramString2;
      if (!zzcv(paramString1)) {
        str = getString(paramString1);
      }
    }
    return str;
  }
  
  protected <E extends SafeParcelable> E zza(String paramString, Parcelable.Creator<E> paramCreator)
  {
    paramString = zzc(paramString, null);
    if (paramString == null) {
      return null;
    }
    return com.google.android.gms.common.internal.safeparcel.zzc.zza(paramString, paramCreator);
  }
  
  protected <E extends SafeParcelable> List<E> zza(String paramString, Parcelable.Creator<E> paramCreator, List<E> paramList)
  {
    paramString = zzc(paramString, null);
    if (paramString == null) {}
    do
    {
      for (;;)
      {
        return paramList;
        try
        {
          Object localObject = zzta.zzA(paramString);
          if (((zzta)localObject).zzbpC != null)
          {
            paramString = new ArrayList(((zzta)localObject).zzbpC.length);
            localObject = ((zzta)localObject).zzbpC;
            int j = localObject.length;
            int i = 0;
            while (i < j)
            {
              paramString.add(com.google.android.gms.common.internal.safeparcel.zzc.zza(localObject[i], paramCreator));
              i += 1;
            }
            return paramString;
          }
        }
        catch (zztj paramString) {}
      }
    } while (!Log.isLoggable("SafeDataBufferRef", 6));
    Log.e("SafeDataBufferRef", "Cannot parse byte[]", paramString);
    return paramList;
  }
  
  protected List<Integer> zza(String paramString, List<Integer> paramList)
  {
    paramString = zzc(paramString, null);
    if (paramString == null) {}
    do
    {
      for (;;)
      {
        return paramList;
        try
        {
          paramString = zzta.zzA(paramString);
          if (paramString.zzbpB != null)
          {
            ArrayList localArrayList = new ArrayList(paramString.zzbpB.length);
            int i = 0;
            while (i < paramString.zzbpB.length)
            {
              localArrayList.add(Integer.valueOf(paramString.zzbpB[i]));
              i += 1;
            }
            return localArrayList;
          }
        }
        catch (zztj paramString) {}
      }
    } while (!Log.isLoggable("SafeDataBufferRef", 6));
    Log.e("SafeDataBufferRef", "Cannot parse byte[]", paramString);
    return paramList;
  }
  
  protected float zzb(String paramString, float paramFloat)
  {
    float f = paramFloat;
    if (zzct(paramString))
    {
      f = paramFloat;
      if (!zzcv(paramString)) {
        f = getFloat(paramString);
      }
    }
    return f;
  }
  
  protected List<String> zzb(String paramString, List<String> paramList)
  {
    paramString = zzc(paramString, null);
    if (paramString == null) {}
    do
    {
      for (;;)
      {
        return paramList;
        try
        {
          paramString = zzta.zzA(paramString);
          if (paramString.zzbpA != null)
          {
            paramString = Arrays.asList(paramString.zzbpA);
            return paramString;
          }
        }
        catch (zztj paramString) {}
      }
    } while (!Log.isLoggable("SafeDataBufferRef", 6));
    Log.e("SafeDataBufferRef", "Cannot parse byte[]", paramString);
    return paramList;
  }
  
  protected byte[] zzc(String paramString, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (zzct(paramString))
    {
      arrayOfByte = paramArrayOfByte;
      if (!zzcv(paramString)) {
        arrayOfByte = getByteArray(paramString);
      }
    }
    return arrayOfByte;
  }
  
  protected boolean zzh(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (zzct(paramString))
    {
      bool = paramBoolean;
      if (!zzcv(paramString)) {
        bool = getBoolean(paramString);
      }
    }
    return bool;
  }
  
  protected int zzz(String paramString, int paramInt)
  {
    int i = paramInt;
    if (zzct(paramString))
    {
      i = paramInt;
      if (!zzcv(paramString)) {
        i = getInteger(paramString);
      }
    }
    return i;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/internal/zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */