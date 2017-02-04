package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata
  implements SafeParcelable
{
  public static final Parcelable.Creator<ApplicationMetadata> CREATOR = new zza();
  String mName;
  private final int mVersionCode;
  String zzXW;
  List<String> zzXX;
  String zzXY;
  Uri zzXZ;
  List<WebImage> zzxz;
  
  private ApplicationMetadata()
  {
    this.mVersionCode = 1;
    this.zzxz = new ArrayList();
    this.zzXX = new ArrayList();
  }
  
  ApplicationMetadata(int paramInt, String paramString1, String paramString2, List<WebImage> paramList, List<String> paramList1, String paramString3, Uri paramUri)
  {
    this.mVersionCode = paramInt;
    this.zzXW = paramString1;
    this.mName = paramString2;
    this.zzxz = paramList;
    this.zzXX = paramList1;
    this.zzXY = paramString3;
    this.zzXZ = paramUri;
  }
  
  public boolean areNamespacesSupported(List<String> paramList)
  {
    return (this.zzXX != null) && (this.zzXX.containsAll(paramList));
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
      if (!(paramObject instanceof ApplicationMetadata)) {
        return false;
      }
      paramObject = (ApplicationMetadata)paramObject;
    } while ((zzf.zza(this.zzXW, ((ApplicationMetadata)paramObject).zzXW)) && (zzf.zza(this.zzxz, ((ApplicationMetadata)paramObject).zzxz)) && (zzf.zza(this.mName, ((ApplicationMetadata)paramObject).mName)) && (zzf.zza(this.zzXX, ((ApplicationMetadata)paramObject).zzXX)) && (zzf.zza(this.zzXY, ((ApplicationMetadata)paramObject).zzXY)) && (zzf.zza(this.zzXZ, ((ApplicationMetadata)paramObject).zzXZ)));
    return false;
  }
  
  public String getApplicationId()
  {
    return this.zzXW;
  }
  
  public List<WebImage> getImages()
  {
    return this.zzxz;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getSenderAppIdentifier()
  {
    return this.zzXY;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.mVersionCode), this.zzXW, this.mName, this.zzxz, this.zzXX, this.zzXY, this.zzXZ });
  }
  
  public boolean isNamespaceSupported(String paramString)
  {
    return (this.zzXX != null) && (this.zzXX.contains(paramString));
  }
  
  public String toString()
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder().append("applicationId: ").append(this.zzXW).append(", name: ").append(this.mName).append(", images.count: ");
    if (this.zzxz == null)
    {
      i = 0;
      localStringBuilder = localStringBuilder.append(i).append(", namespaces.count: ");
      if (this.zzXX != null) {
        break label114;
      }
    }
    label114:
    for (int i = j;; i = this.zzXX.size())
    {
      return i + ", senderAppIdentifier: " + this.zzXY + ", senderAppLaunchUrl: " + this.zzXZ;
      i = this.zzxz.size();
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public Uri zznh()
  {
    return this.zzXZ;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/cast/ApplicationMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */