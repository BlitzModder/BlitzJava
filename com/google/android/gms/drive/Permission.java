package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class Permission
  implements SafeParcelable
{
  public static final Parcelable.Creator<Permission> CREATOR = new zzi();
  final int mVersionCode;
  private String zzano;
  private int zzanp;
  private String zzanq;
  private String zzanr;
  private int zzans;
  private boolean zzant;
  
  Permission(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, boolean paramBoolean)
  {
    this.mVersionCode = paramInt1;
    this.zzano = paramString1;
    this.zzanp = paramInt2;
    this.zzanq = paramString2;
    this.zzanr = paramString3;
    this.zzans = paramInt3;
    this.zzant = paramBoolean;
  }
  
  public static boolean zzcA(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean zzcB(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == this);
      paramObject = (Permission)paramObject;
      if ((!zzw.equal(this.zzano, ((Permission)paramObject).zzano)) || (this.zzanp != ((Permission)paramObject).zzanp) || (this.zzans != ((Permission)paramObject).zzans)) {
        break;
      }
      bool1 = bool2;
    } while (this.zzant == ((Permission)paramObject).zzant);
    return false;
  }
  
  public int getRole()
  {
    if (!zzcB(this.zzans)) {
      return -1;
    }
    return this.zzans;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzano, Integer.valueOf(this.zzanp), Integer.valueOf(this.zzans), Boolean.valueOf(this.zzant) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public String zzsr()
  {
    if (!zzcA(this.zzanp)) {
      return null;
    }
    return this.zzano;
  }
  
  public int zzss()
  {
    if (!zzcA(this.zzanp)) {
      return -1;
    }
    return this.zzanp;
  }
  
  public String zzst()
  {
    return this.zzanq;
  }
  
  public String zzsu()
  {
    return this.zzanr;
  }
  
  public boolean zzsv()
  {
    return this.zzant;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/Permission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */