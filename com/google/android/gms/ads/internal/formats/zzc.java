package com.google.android.gms.ads.internal.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcn.zza;
import com.google.android.gms.internal.zzha;

@zzha
public class zzc
  extends zzcn.zza
{
  private final Uri mUri;
  private final Drawable zzxw;
  private final double zzxx;
  
  public zzc(Drawable paramDrawable, Uri paramUri, double paramDouble)
  {
    this.zzxw = paramDrawable;
    this.mUri = paramUri;
    this.zzxx = paramDouble;
  }
  
  public double getScale()
  {
    return this.zzxx;
  }
  
  public Uri getUri()
    throws RemoteException
  {
    return this.mUri;
  }
  
  public zzd zzdC()
    throws RemoteException
  {
    return zze.zzB(this.zzxw);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/formats/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */