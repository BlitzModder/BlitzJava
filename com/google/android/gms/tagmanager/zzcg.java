package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzcg
  extends zzak
{
  private static final String ID = zzad.zzbI.toString();
  private final Context mContext;
  
  public zzcg(Context paramContext)
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
    paramMap = new DisplayMetrics();
    ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(paramMap);
    int i = paramMap.widthPixels;
    int j = paramMap.heightPixels;
    return zzdf.zzR(i + "x" + j);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzcg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */