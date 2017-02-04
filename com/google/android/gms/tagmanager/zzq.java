package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzq
  extends zzak
{
  private static final String ID = zzad.zzbr.toString();
  private final String zzabv;
  
  public zzq(String paramString)
  {
    super(ID, new String[0]);
    this.zzabv = paramString;
  }
  
  public boolean zzEa()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    if (this.zzabv == null) {
      return zzdf.zzFJ();
    }
    return zzdf.zzR(this.zzabv);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */