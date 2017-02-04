package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzqm
  extends zze<zzqm>
{
  public boolean zzaRR;
  public String zzavc;
  
  public String getDescription()
  {
    return this.zzavc;
  }
  
  public void setDescription(String paramString)
  {
    this.zzavc = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("description", this.zzavc);
    localHashMap.put("fatal", Boolean.valueOf(this.zzaRR));
    return zzE(localHashMap);
  }
  
  public boolean zzAk()
  {
    return this.zzaRR;
  }
  
  public void zza(zzqm paramzzqm)
  {
    if (!TextUtils.isEmpty(this.zzavc)) {
      paramzzqm.setDescription(this.zzavc);
    }
    if (this.zzaRR) {
      paramzzqm.zzal(this.zzaRR);
    }
  }
  
  public void zzal(boolean paramBoolean)
  {
    this.zzaRR = paramBoolean;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzqm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */