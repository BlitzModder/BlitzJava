package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzaa
  extends zzak
{
  private static final String ID = zzad.zzbP.toString();
  private final Context mContext;
  
  public zzaa(Context paramContext)
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
    paramMap = zzaY(this.mContext);
    if (paramMap == null) {
      return zzdf.zzFJ();
    }
    return zzdf.zzR(paramMap);
  }
  
  protected String zzaY(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */