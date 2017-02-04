package com.google.android.gms.internal;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.zzg;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@zzha
class zzeh
{
  final String zzpH;
  final AdRequestParcel zzqo;
  
  zzeh(AdRequestParcel paramAdRequestParcel, String paramString)
  {
    this.zzqo = paramAdRequestParcel;
    this.zzpH = paramString;
  }
  
  zzeh(String paramString)
    throws IOException
  {
    Object localObject1 = paramString.split("\000");
    if (localObject1.length != 2) {
      throw new IOException("Incorrect field count for QueueSeed.");
    }
    paramString = Parcel.obtain();
    try
    {
      this.zzpH = new String(Base64.decode(localObject1[0], 0), "UTF-8");
      localObject1 = Base64.decode(localObject1[1], 0);
      paramString.unmarshall((byte[])localObject1, 0, localObject1.length);
      paramString.setDataPosition(0);
      this.zzqo = AdRequestParcel.CREATOR.zzb(paramString);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new IOException("Malformed QueueSeed encoding.");
    }
    finally
    {
      paramString.recycle();
    }
  }
  
  String zzef()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      String str1 = Base64.encodeToString(this.zzpH.getBytes("UTF-8"), 0);
      this.zzqo.writeToParcel(localParcel, 0);
      String str2 = Base64.encodeToString(localParcel.marshall(), 0);
      str1 = str1 + "\000" + str2;
      return str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      zzb.e("QueueSeed encode failed because UTF-8 is not available.");
      return "";
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzeh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */