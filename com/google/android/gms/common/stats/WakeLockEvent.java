package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class WakeLockEvent
  extends zzf
  implements SafeParcelable
{
  public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzh();
  private final long mTimeout;
  final int mVersionCode;
  private final String zzalZ;
  private final long zzaln;
  private int zzalo;
  private final long zzalv;
  private long zzalx;
  private final int zzama;
  private final List<String> zzamb;
  private final String zzamc;
  private int zzamd;
  private final String zzame;
  private final String zzamf;
  private final float zzamg;
  
  WakeLockEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, int paramInt3, List<String> paramList, String paramString2, long paramLong2, int paramInt4, String paramString3, String paramString4, float paramFloat, long paramLong3)
  {
    this.mVersionCode = paramInt1;
    this.zzaln = paramLong1;
    this.zzalo = paramInt2;
    this.zzalZ = paramString1;
    this.zzame = paramString3;
    this.zzama = paramInt3;
    this.zzalx = -1L;
    this.zzamb = paramList;
    this.zzamc = paramString2;
    this.zzalv = paramLong2;
    this.zzamd = paramInt4;
    this.zzamf = paramString4;
    this.zzamg = paramFloat;
    this.mTimeout = paramLong3;
  }
  
  public WakeLockEvent(long paramLong1, int paramInt1, String paramString1, int paramInt2, List<String> paramList, String paramString2, long paramLong2, int paramInt3, String paramString3, String paramString4, float paramFloat, long paramLong3)
  {
    this(1, paramLong1, paramInt1, paramString1, paramInt2, paramList, paramString2, paramLong2, paramInt3, paramString3, paramString4, paramFloat, paramLong3);
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
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public String zzrB()
  {
    return this.zzalZ;
  }
  
  public String zzrC()
  {
    return this.zzame;
  }
  
  public int zzrD()
  {
    return this.zzama;
  }
  
  public List<String> zzrE()
  {
    return this.zzamb;
  }
  
  public int zzrF()
  {
    return this.zzamd;
  }
  
  public String zzrG()
  {
    return this.zzamf;
  }
  
  public float zzrH()
  {
    return this.zzamg;
  }
  
  public long zzrI()
  {
    return this.mTimeout;
  }
  
  public String zzru()
  {
    return this.zzamc;
  }
  
  public long zzrv()
  {
    return this.zzalx;
  }
  
  public long zzrx()
  {
    return this.zzalv;
  }
  
  public String zzry()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("\t").append(zzrB()).append("\t").append(zzrD()).append("\t");
    if (zzrE() == null)
    {
      str = "";
      localStringBuilder = localStringBuilder.append(str).append("\t").append(zzrF()).append("\t");
      if (zzrC() != null) {
        break label135;
      }
      str = "";
      label80:
      localStringBuilder = localStringBuilder.append(str).append("\t");
      if (zzrG() != null) {
        break label143;
      }
    }
    label135:
    label143:
    for (String str = "";; str = zzrG())
    {
      return str + "\t" + zzrH();
      str = TextUtils.join(",", zzrE());
      break;
      str = zzrC();
      break label80;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/stats/WakeLockEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */