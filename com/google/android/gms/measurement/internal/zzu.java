package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;

public class zzu
  extends zzl.zza
{
  private final zzt zzaQX;
  private final boolean zzaUB;
  
  public zzu(zzt paramzzt)
  {
    zzx.zzy(paramzzt);
    this.zzaQX = paramzzt;
    this.zzaUB = false;
  }
  
  public zzu(zzt paramzzt, boolean paramBoolean)
  {
    zzx.zzy(paramzzt);
    this.zzaQX = paramzzt;
    this.zzaUB = paramBoolean;
  }
  
  private void zzeB(String paramString)
    throws SecurityException
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.zzaQX.zzzz().zzBl().zzez("Measurement Service called without app package");
      throw new SecurityException("Measurement Service called without app package");
    }
    try
    {
      zzeC(paramString);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      this.zzaQX.zzzz().zzBl().zzj("Measurement Service called with invalid calling package", paramString);
      throw localSecurityException;
    }
  }
  
  private void zzeC(String paramString)
    throws SecurityException
  {
    int i;
    if (this.zzaUB)
    {
      i = Process.myUid();
      if (!GooglePlayServicesUtil.zzb(this.zzaQX.getContext(), i, paramString)) {
        break label34;
      }
    }
    label34:
    while ((GooglePlayServicesUtil.zze(this.zzaQX.getContext(), i)) && (!this.zzaQX.zzBI()))
    {
      return;
      i = Binder.getCallingUid();
      break;
    }
    throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[] { paramString }));
  }
  
  public void zza(final AppMetadata paramAppMetadata)
  {
    zzx.zzy(paramAppMetadata);
    zzeB(paramAppMetadata.packageName);
    this.zzaQX.zzAV().zzg(new Runnable()
    {
      public void run()
      {
        zzu.this.zzeA(paramAppMetadata.zzaSr);
        zzu.zza(zzu.this).zzd(paramAppMetadata);
      }
    });
  }
  
  public void zza(final EventParcel paramEventParcel, final AppMetadata paramAppMetadata)
  {
    zzx.zzy(paramEventParcel);
    zzx.zzy(paramAppMetadata);
    zzeB(paramAppMetadata.packageName);
    this.zzaQX.zzAV().zzg(new Runnable()
    {
      public void run()
      {
        zzu.this.zzeA(paramAppMetadata.zzaSr);
        zzu.zza(zzu.this).zzb(paramEventParcel, paramAppMetadata);
      }
    });
  }
  
  public void zza(final EventParcel paramEventParcel, final String paramString1, final String paramString2)
  {
    zzx.zzy(paramEventParcel);
    zzx.zzcG(paramString1);
    zzeB(paramString1);
    this.zzaQX.zzAV().zzg(new Runnable()
    {
      public void run()
      {
        zzu.this.zzeA(paramString2);
        zzu.zza(zzu.this).zza(paramEventParcel, paramString1);
      }
    });
  }
  
  public void zza(final UserAttributeParcel paramUserAttributeParcel, final AppMetadata paramAppMetadata)
  {
    zzx.zzy(paramUserAttributeParcel);
    zzx.zzy(paramAppMetadata);
    zzeB(paramAppMetadata.packageName);
    if (paramUserAttributeParcel.getValue() == null)
    {
      this.zzaQX.zzAV().zzg(new Runnable()
      {
        public void run()
        {
          zzu.this.zzeA(paramAppMetadata.zzaSr);
          zzu.zza(zzu.this).zzc(paramUserAttributeParcel, paramAppMetadata);
        }
      });
      return;
    }
    this.zzaQX.zzAV().zzg(new Runnable()
    {
      public void run()
      {
        zzu.this.zzeA(paramAppMetadata.zzaSr);
        zzu.zza(zzu.this).zzb(paramUserAttributeParcel, paramAppMetadata);
      }
    });
  }
  
  public void zzb(final AppMetadata paramAppMetadata)
  {
    zzx.zzy(paramAppMetadata);
    zzeB(paramAppMetadata.packageName);
    this.zzaQX.zzAV().zzg(new Runnable()
    {
      public void run()
      {
        zzu.this.zzeA(paramAppMetadata.zzaSr);
        zzu.zza(zzu.this).zzc(paramAppMetadata);
      }
    });
  }
  
  void zzeA(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(":", 2);
      if (paramString.length != 2) {}
    }
    long l;
    try
    {
      l = Long.valueOf(paramString[0]).longValue();
      if (l > 0L)
      {
        this.zzaQX.zzAW().zzaTE.zzg(paramString[1], l);
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      this.zzaQX.zzzz().zzBm().zzj("Combining sample with a non-number weight", paramString[0]);
      return;
    }
    this.zzaQX.zzzz().zzBm().zzj("Combining sample with a non-positive weight", Long.valueOf(l));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */