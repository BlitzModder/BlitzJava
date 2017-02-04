package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableCollaborator
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableCollaborator> CREATOR = new zzq();
  final int mVersionCode;
  final String zzJX;
  final String zzJg;
  final String zzVu;
  final boolean zzadn;
  final boolean zzasC;
  final String zzasD;
  final String zzasE;
  
  ParcelableCollaborator(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.mVersionCode = paramInt;
    this.zzasC = paramBoolean1;
    this.zzadn = paramBoolean2;
    this.zzJX = paramString1;
    this.zzJg = paramString2;
    this.zzVu = paramString3;
    this.zzasD = paramString4;
    this.zzasE = paramString5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ParcelableCollaborator)) {
      return false;
    }
    paramObject = (ParcelableCollaborator)paramObject;
    return this.zzJX.equals(((ParcelableCollaborator)paramObject).zzJX);
  }
  
  public int hashCode()
  {
    return this.zzJX.hashCode();
  }
  
  public String toString()
  {
    return "Collaborator [isMe=" + this.zzasC + ", isAnonymous=" + this.zzadn + ", sessionId=" + this.zzJX + ", userId=" + this.zzJg + ", displayName=" + this.zzVu + ", color=" + this.zzasD + ", photoUrl=" + this.zzasE + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzq.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/ParcelableCollaborator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */