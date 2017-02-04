package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class AccountChangeEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();
  final int mVersion;
  final long zzTC;
  final String zzTD;
  final int zzTE;
  final int zzTF;
  final String zzTG;
  
  AccountChangeEvent(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    this.mVersion = paramInt1;
    this.zzTC = paramLong;
    this.zzTD = ((String)zzx.zzy(paramString1));
    this.zzTE = paramInt2;
    this.zzTF = paramInt3;
    this.zzTG = paramString2;
  }
  
  public AccountChangeEvent(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.mVersion = 1;
    this.zzTC = paramLong;
    this.zzTD = ((String)zzx.zzy(paramString1));
    this.zzTE = paramInt1;
    this.zzTF = paramInt2;
    this.zzTG = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof AccountChangeEvent)) {
        break;
      }
      paramObject = (AccountChangeEvent)paramObject;
    } while ((this.mVersion == ((AccountChangeEvent)paramObject).mVersion) && (this.zzTC == ((AccountChangeEvent)paramObject).zzTC) && (zzw.equal(this.zzTD, ((AccountChangeEvent)paramObject).zzTD)) && (this.zzTE == ((AccountChangeEvent)paramObject).zzTE) && (this.zzTF == ((AccountChangeEvent)paramObject).zzTF) && (zzw.equal(this.zzTG, ((AccountChangeEvent)paramObject).zzTG)));
    return false;
    return false;
  }
  
  public String getAccountName()
  {
    return this.zzTD;
  }
  
  public String getChangeData()
  {
    return this.zzTG;
  }
  
  public int getChangeType()
  {
    return this.zzTE;
  }
  
  public int getEventIndex()
  {
    return this.zzTF;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.mVersion), Long.valueOf(this.zzTC), this.zzTD, Integer.valueOf(this.zzTE), Integer.valueOf(this.zzTF), this.zzTG });
  }
  
  public String toString()
  {
    String str = "UNKNOWN";
    switch (this.zzTE)
    {
    }
    for (;;)
    {
      return "AccountChangeEvent {accountName = " + this.zzTD + ", changeType = " + str + ", changeData = " + this.zzTG + ", eventIndex = " + this.zzTF + "}";
      str = "ADDED";
      continue;
      str = "REMOVED";
      continue;
      str = "RENAMED_TO";
      continue;
      str = "RENAMED_FROM";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/AccountChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */