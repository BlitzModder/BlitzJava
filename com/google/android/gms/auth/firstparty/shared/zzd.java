package com.google.android.gms.auth.firstparty.shared;

public enum zzd
{
  private final String zzXU;
  
  private zzd(String paramString)
  {
    this.zzXU = paramString;
  }
  
  public static boolean zza(zzd paramzzd)
  {
    return (zzXf.equals(paramzzd)) || (zzXo.equals(paramzzd)) || (zzXr.equals(paramzzd)) || (zzXj.equals(paramzzd)) || (zzXt.equals(paramzzd)) || (zzXv.equals(paramzzd)) || (zzb(paramzzd));
  }
  
  public static boolean zzb(zzd paramzzd)
  {
    return (zzWY.equals(paramzzd)) || (zzXw.equals(paramzzd)) || (zzXx.equals(paramzzd)) || (zzXy.equals(paramzzd)) || (zzXz.equals(paramzzd)) || (zzXA.equals(paramzzd)) || (zzXB.equals(paramzzd)) || (zzXC.equals(paramzzd));
  }
  
  public static final zzd zzbT(String paramString)
  {
    Object localObject = null;
    zzd[] arrayOfzzd = values();
    int j = arrayOfzzd.length;
    int i = 0;
    if (i < j)
    {
      zzd localzzd = arrayOfzzd[i];
      if (!localzzd.zzXU.equals(paramString)) {
        break label48;
      }
      localObject = localzzd;
    }
    label48:
    for (;;)
    {
      i += 1;
      break;
      return (zzd)localObject;
    }
  }
  
  public static boolean zzc(zzd paramzzd)
  {
    return (zzXc.equals(paramzzd)) || (zzXd.equals(paramzzd));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/firstparty/shared/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */