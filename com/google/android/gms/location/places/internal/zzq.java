package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzf.zza;

public class zzq
  implements PlacePhotoMetadata
{
  private int mIndex;
  private final int zzCF;
  private final int zzCG;
  private final String zzaOg;
  private final CharSequence zzaOh;
  
  public zzq(String paramString, int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3)
  {
    this.zzaOg = paramString;
    this.zzCF = paramInt1;
    this.zzCG = paramInt2;
    this.zzaOh = paramCharSequence;
    this.mIndex = paramInt3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzq)) {
        return false;
      }
      paramObject = (zzq)paramObject;
    } while ((((zzq)paramObject).zzCF == this.zzCF) && (((zzq)paramObject).zzCG == this.zzCG) && (zzw.equal(((zzq)paramObject).zzaOg, this.zzaOg)) && (zzw.equal(((zzq)paramObject).zzaOh, this.zzaOh)));
    return false;
  }
  
  public CharSequence getAttributions()
  {
    return this.zzaOh;
  }
  
  public int getMaxHeight()
  {
    return this.zzCG;
  }
  
  public int getMaxWidth()
  {
    return this.zzCF;
  }
  
  public PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient paramGoogleApiClient)
  {
    return getScaledPhoto(paramGoogleApiClient, getMaxWidth(), getMaxHeight());
  }
  
  public PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient paramGoogleApiClient, final int paramInt1, final int paramInt2)
  {
    paramGoogleApiClient.zza(new zzf.zza(Places.zzaMU, paramGoogleApiClient)
    {
      protected void zza(zze paramAnonymouszze)
        throws RemoteException
      {
        paramAnonymouszze.zza(new zzf(this), zzq.zza(zzq.this), paramInt1, paramInt2, zzq.zzb(zzq.this));
      }
    });
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.zzCF), Integer.valueOf(this.zzCG), this.zzaOg, this.zzaOh });
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public PlacePhotoMetadata zzyN()
  {
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/internal/zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */