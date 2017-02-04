package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ConnectionEvent
  extends zzf
  implements SafeParcelable
{
  public static final Parcelable.Creator<ConnectionEvent> CREATOR = new zza();
  final int mVersionCode;
  private final long zzaln;
  private int zzalo;
  private final String zzalp;
  private final String zzalq;
  private final String zzalr;
  private final String zzals;
  private final String zzalt;
  private final String zzalu;
  private final long zzalv;
  private final long zzalw;
  private long zzalx;
  
  ConnectionEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, long paramLong3)
  {
    this.mVersionCode = paramInt1;
    this.zzaln = paramLong1;
    this.zzalo = paramInt2;
    this.zzalp = paramString1;
    this.zzalq = paramString2;
    this.zzalr = paramString3;
    this.zzals = paramString4;
    this.zzalx = -1L;
    this.zzalt = paramString5;
    this.zzalu = paramString6;
    this.zzalv = paramLong2;
    this.zzalw = paramLong3;
  }
  
  public ConnectionEvent(long paramLong1, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, long paramLong3)
  {
    this(1, paramLong1, paramInt, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramLong2, paramLong3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getEventType()
  {
    return this.zzalo;
  }
  
  public long getTimeMillis()
  {
    return this.zzaln;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public String zzrp()
  {
    return this.zzalp;
  }
  
  public String zzrq()
  {
    return this.zzalq;
  }
  
  public String zzrr()
  {
    return this.zzalr;
  }
  
  public String zzrs()
  {
    return this.zzals;
  }
  
  public String zzrt()
  {
    return this.zzalt;
  }
  
  public String zzru()
  {
    return this.zzalu;
  }
  
  public long zzrv()
  {
    return this.zzalx;
  }
  
  public long zzrw()
  {
    return this.zzalw;
  }
  
  public long zzrx()
  {
    return this.zzalv;
  }
  
  public String zzry()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("\t").append(zzrp()).append("/").append(zzrq()).append("\t").append(zzrr()).append("/").append(zzrs()).append("\t");
    if (this.zzalt == null) {}
    for (String str = "";; str = this.zzalt) {
      return str + "\t" + zzrw();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/stats/ConnectionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */