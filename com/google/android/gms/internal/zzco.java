package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;

@zzha
public class zzco
  extends NativeAd.Image
{
  private final Drawable mDrawable;
  private final Uri mUri;
  private final double zzxx;
  private final zzcn zzyn;
  
  public zzco(zzcn paramzzcn)
  {
    this.zzyn = paramzzcn;
    try
    {
      paramzzcn = this.zzyn.zzdC();
      if (paramzzcn == null) {
        break label83;
      }
      paramzzcn = (Drawable)zze.zzp(paramzzcn);
    }
    catch (RemoteException paramzzcn)
    {
      try
      {
        paramzzcn = this.zzyn.getUri();
        this.mUri = paramzzcn;
        double d1 = 1.0D;
        try
        {
          double d2 = this.zzyn.getScale();
          d1 = d2;
        }
        catch (RemoteException paramzzcn)
        {
          for (;;)
          {
            zzb.zzb("Failed to get scale.", paramzzcn);
          }
        }
        this.zzxx = d1;
        return;
        paramzzcn = paramzzcn;
        zzb.zzb("Failed to get drawable.", paramzzcn);
        paramzzcn = null;
      }
      catch (RemoteException paramzzcn)
      {
        for (;;)
        {
          zzb.zzb("Failed to get uri.", paramzzcn);
          paramzzcn = (zzcn)localObject;
        }
      }
    }
    this.mDrawable = paramzzcn;
  }
  
  public Drawable getDrawable()
  {
    return this.mDrawable;
  }
  
  public double getScale()
  {
    return this.zzxx;
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */