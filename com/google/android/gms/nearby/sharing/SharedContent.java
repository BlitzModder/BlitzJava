package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;

public class SharedContent
  implements SafeParcelable
{
  public static final Parcelable.Creator<SharedContent> CREATOR = new zzc();
  private final int versionCode;
  @Deprecated
  private String zzaXT;
  private ViewableItem[] zzaXU;
  private LocalContent[] zzaXV;
  
  private SharedContent()
  {
    this.versionCode = 2;
  }
  
  SharedContent(int paramInt, String paramString, ViewableItem[] paramArrayOfViewableItem, LocalContent[] paramArrayOfLocalContent)
  {
    this.versionCode = paramInt;
    this.zzaXT = paramString;
    this.zzaXU = paramArrayOfViewableItem;
    this.zzaXV = paramArrayOfLocalContent;
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
      if (!(paramObject instanceof SharedContent)) {
        return false;
      }
      paramObject = (SharedContent)paramObject;
    } while ((zzw.equal(this.zzaXU, ((SharedContent)paramObject).zzaXU)) && (zzw.equal(this.zzaXV, ((SharedContent)paramObject).zzaXV)) && (zzw.equal(this.zzaXT, ((SharedContent)paramObject).zzaXT)));
    return false;
  }
  
  public String getUri()
  {
    return this.zzaXT;
  }
  
  int getVersionCode()
  {
    return this.versionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaXU, this.zzaXV, this.zzaXT });
  }
  
  public String toString()
  {
    return "SharedContent[viewableItems=" + Arrays.toString(this.zzaXU) + ", localContents=" + Arrays.toString(this.zzaXV) + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public ViewableItem[] zzCQ()
  {
    return this.zzaXU;
  }
  
  public LocalContent[] zzCR()
  {
    return this.zzaXV;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/sharing/SharedContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */