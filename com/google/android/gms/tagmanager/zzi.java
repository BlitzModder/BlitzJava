package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzi
  extends zzak
{
  private static final String ID = zzad.zzdu.toString();
  private final Context mContext;
  
  public zzi(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public boolean zzEa()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    try
    {
      paramMap = zzdf.zzR(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName);
      return paramMap;
    }
    catch (PackageManager.NameNotFoundException paramMap)
    {
      zzbg.e("Package name " + this.mContext.getPackageName() + " not found. " + paramMap.getMessage());
    }
    return zzdf.zzFJ();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */