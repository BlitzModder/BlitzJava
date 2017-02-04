package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class ConnectionConfiguration
  implements SafeParcelable
{
  public static final Parcelable.Creator<ConnectionConfiguration> CREATOR = new zzg();
  private final String mName;
  final int mVersionCode;
  private boolean zzRH;
  private final int zzZU;
  private final int zzans;
  private final String zzatX;
  private final boolean zzblP;
  private String zzblQ;
  private boolean zzblR;
  private String zzblS;
  
  ConnectionConfiguration(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, String paramString3, boolean paramBoolean3, String paramString4)
  {
    this.mVersionCode = paramInt1;
    this.mName = paramString1;
    this.zzatX = paramString2;
    this.zzZU = paramInt2;
    this.zzans = paramInt3;
    this.zzblP = paramBoolean1;
    this.zzRH = paramBoolean2;
    this.zzblQ = paramString3;
    this.zzblR = paramBoolean3;
    this.zzblS = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ConnectionConfiguration)) {}
    do
    {
      return false;
      paramObject = (ConnectionConfiguration)paramObject;
    } while ((!zzw.equal(Integer.valueOf(this.mVersionCode), Integer.valueOf(((ConnectionConfiguration)paramObject).mVersionCode))) || (!zzw.equal(this.mName, ((ConnectionConfiguration)paramObject).mName)) || (!zzw.equal(this.zzatX, ((ConnectionConfiguration)paramObject).zzatX)) || (!zzw.equal(Integer.valueOf(this.zzZU), Integer.valueOf(((ConnectionConfiguration)paramObject).zzZU))) || (!zzw.equal(Integer.valueOf(this.zzans), Integer.valueOf(((ConnectionConfiguration)paramObject).zzans))) || (!zzw.equal(Boolean.valueOf(this.zzblP), Boolean.valueOf(((ConnectionConfiguration)paramObject).zzblP))) || (!zzw.equal(Boolean.valueOf(this.zzblR), Boolean.valueOf(((ConnectionConfiguration)paramObject).zzblR))));
    return true;
  }
  
  public String getAddress()
  {
    return this.zzatX;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getNodeId()
  {
    return this.zzblS;
  }
  
  public int getRole()
  {
    return this.zzans;
  }
  
  public int getType()
  {
    return this.zzZU;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.mVersionCode), this.mName, this.zzatX, Integer.valueOf(this.zzZU), Integer.valueOf(this.zzans), Boolean.valueOf(this.zzblP), Boolean.valueOf(this.zzblR) });
  }
  
  public boolean isConnected()
  {
    return this.zzRH;
  }
  
  public boolean isEnabled()
  {
    return this.zzblP;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ConnectionConfiguration[ ");
    localStringBuilder.append("mName=" + this.mName);
    localStringBuilder.append(", mAddress=" + this.zzatX);
    localStringBuilder.append(", mType=" + this.zzZU);
    localStringBuilder.append(", mRole=" + this.zzans);
    localStringBuilder.append(", mEnabled=" + this.zzblP);
    localStringBuilder.append(", mIsConnected=" + this.zzRH);
    localStringBuilder.append(", mPeerNodeId=" + this.zzblQ);
    localStringBuilder.append(", mBtlePriority=" + this.zzblR);
    localStringBuilder.append(", mNodeId=" + this.zzblS);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public String zzGw()
  {
    return this.zzblQ;
  }
  
  public boolean zzGx()
  {
    return this.zzblR;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/ConnectionConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */