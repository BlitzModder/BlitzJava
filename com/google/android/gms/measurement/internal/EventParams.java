package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.Set;

public class EventParams
  implements SafeParcelable, Iterable<String>
{
  public static final zzi CREATOR = new zzi();
  public final int versionCode;
  private final Bundle zzaSI;
  
  EventParams(int paramInt, Bundle paramBundle)
  {
    this.versionCode = paramInt;
    this.zzaSI = paramBundle;
  }
  
  EventParams(Bundle paramBundle)
  {
    zzx.zzy(paramBundle);
    this.zzaSI = paramBundle;
    this.versionCode = 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  Object get(String paramString)
  {
    return this.zzaSI.get(paramString);
  }
  
  public Iterator<String> iterator()
  {
    new Iterator()
    {
      Iterator<String> zzaSJ = EventParams.zza(EventParams.this).keySet().iterator();
      
      public boolean hasNext()
      {
        return this.zzaSJ.hasNext();
      }
      
      public String next()
      {
        return (String)this.zzaSJ.next();
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException("Remove not supported");
      }
    };
  }
  
  public int size()
  {
    return this.zzaSI.size();
  }
  
  public String toString()
  {
    return this.zzaSI.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public Bundle zzBh()
  {
    return new Bundle(this.zzaSI);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/EventParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */