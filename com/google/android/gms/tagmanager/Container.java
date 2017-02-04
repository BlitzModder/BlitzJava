package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaf.zzf;
import com.google.android.gms.internal.zzaf.zzi;
import com.google.android.gms.internal.zzaf.zzj;
import com.google.android.gms.internal.zzag.zza;
import com.google.android.gms.internal.zzsh;
import com.google.android.gms.internal.zzsh.zzc;
import com.google.android.gms.internal.zzsh.zzg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container
{
  private final Context mContext;
  private final String zzbcF;
  private final DataLayer zzbcG;
  private zzcp zzbcH;
  private Map<String, FunctionCallMacroCallback> zzbcI = new HashMap();
  private Map<String, FunctionCallTagCallback> zzbcJ = new HashMap();
  private volatile long zzbcK;
  private volatile String zzbcL = "";
  
  Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, zzaf.zzj paramzzj)
  {
    this.mContext = paramContext;
    this.zzbcG = paramDataLayer;
    this.zzbcF = paramString;
    this.zzbcK = paramLong;
    zza(paramzzj.zzjl);
    if (paramzzj.zzjk != null) {
      zza(paramzzj.zzjk);
    }
  }
  
  Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, zzsh.zzc paramzzc)
  {
    this.mContext = paramContext;
    this.zzbcG = paramDataLayer;
    this.zzbcF = paramString;
    this.zzbcK = paramLong;
    zza(paramzzc);
  }
  
  private zzcp zzEg()
  {
    try
    {
      zzcp localzzcp = this.zzbcH;
      return localzzcp;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void zza(zzaf.zzf paramzzf)
  {
    if (paramzzf == null) {
      throw new NullPointerException();
    }
    try
    {
      zzsh.zzc localzzc = zzsh.zzb(paramzzf);
      zza(localzzc);
      return;
    }
    catch (zzsh.zzg localzzg)
    {
      zzbg.e("Not loading resource: " + paramzzf + " because it is invalid: " + localzzg.toString());
    }
  }
  
  private void zza(zzsh.zzc paramzzc)
  {
    this.zzbcL = paramzzc.getVersion();
    zzah localzzah = zzfe(this.zzbcL);
    zza(new zzcp(this.mContext, paramzzc, this.zzbcG, new zza(null), new zzb(null), localzzah));
    if (getBoolean("_gtm.loadEventEnabled")) {
      this.zzbcG.pushEvent("gtm.load", DataLayer.mapOf(new Object[] { "gtm.id", this.zzbcF }));
    }
  }
  
  private void zza(zzcp paramzzcp)
  {
    try
    {
      this.zzbcH = paramzzcp;
      return;
    }
    finally
    {
      paramzzcp = finally;
      throw paramzzcp;
    }
  }
  
  private void zza(zzaf.zzi[] paramArrayOfzzi)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfzzi.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfzzi[i]);
      i += 1;
    }
    zzEg().zzC(localArrayList);
  }
  
  public boolean getBoolean(String paramString)
  {
    zzcp localzzcp = zzEg();
    if (localzzcp == null)
    {
      zzbg.e("getBoolean called for closed container.");
      return zzdf.zzFG().booleanValue();
    }
    try
    {
      boolean bool = zzdf.zzk((zzag.zza)localzzcp.zzfz(paramString).getObject()).booleanValue();
      return bool;
    }
    catch (Exception paramString)
    {
      zzbg.e("Calling getBoolean() threw an exception: " + paramString.getMessage() + " Returning default value.");
    }
    return zzdf.zzFG().booleanValue();
  }
  
  public String getContainerId()
  {
    return this.zzbcF;
  }
  
  public double getDouble(String paramString)
  {
    zzcp localzzcp = zzEg();
    if (localzzcp == null)
    {
      zzbg.e("getDouble called for closed container.");
      return zzdf.zzFF().doubleValue();
    }
    try
    {
      double d = zzdf.zzj((zzag.zza)localzzcp.zzfz(paramString).getObject()).doubleValue();
      return d;
    }
    catch (Exception paramString)
    {
      zzbg.e("Calling getDouble() threw an exception: " + paramString.getMessage() + " Returning default value.");
    }
    return zzdf.zzFF().doubleValue();
  }
  
  public long getLastRefreshTime()
  {
    return this.zzbcK;
  }
  
  public long getLong(String paramString)
  {
    zzcp localzzcp = zzEg();
    if (localzzcp == null)
    {
      zzbg.e("getLong called for closed container.");
      return zzdf.zzFE().longValue();
    }
    try
    {
      long l = zzdf.zzi((zzag.zza)localzzcp.zzfz(paramString).getObject()).longValue();
      return l;
    }
    catch (Exception paramString)
    {
      zzbg.e("Calling getLong() threw an exception: " + paramString.getMessage() + " Returning default value.");
    }
    return zzdf.zzFE().longValue();
  }
  
  public String getString(String paramString)
  {
    zzcp localzzcp = zzEg();
    if (localzzcp == null)
    {
      zzbg.e("getString called for closed container.");
      return zzdf.zzFI();
    }
    try
    {
      paramString = zzdf.zzg((zzag.zza)localzzcp.zzfz(paramString).getObject());
      return paramString;
    }
    catch (Exception paramString)
    {
      zzbg.e("Calling getString() threw an exception: " + paramString.getMessage() + " Returning default value.");
    }
    return zzdf.zzFI();
  }
  
  public boolean isDefault()
  {
    return getLastRefreshTime() == 0L;
  }
  
  public void registerFunctionCallMacroCallback(String paramString, FunctionCallMacroCallback paramFunctionCallMacroCallback)
  {
    if (paramFunctionCallMacroCallback == null) {
      throw new NullPointerException("Macro handler must be non-null");
    }
    synchronized (this.zzbcI)
    {
      this.zzbcI.put(paramString, paramFunctionCallMacroCallback);
      return;
    }
  }
  
  public void registerFunctionCallTagCallback(String paramString, FunctionCallTagCallback paramFunctionCallTagCallback)
  {
    if (paramFunctionCallTagCallback == null) {
      throw new NullPointerException("Tag callback must be non-null");
    }
    synchronized (this.zzbcJ)
    {
      this.zzbcJ.put(paramString, paramFunctionCallTagCallback);
      return;
    }
  }
  
  void release()
  {
    this.zzbcH = null;
  }
  
  public void unregisterFunctionCallMacroCallback(String paramString)
  {
    synchronized (this.zzbcI)
    {
      this.zzbcI.remove(paramString);
      return;
    }
  }
  
  public void unregisterFunctionCallTagCallback(String paramString)
  {
    synchronized (this.zzbcJ)
    {
      this.zzbcJ.remove(paramString);
      return;
    }
  }
  
  public String zzEf()
  {
    return this.zzbcL;
  }
  
  FunctionCallMacroCallback zzfb(String paramString)
  {
    synchronized (this.zzbcI)
    {
      paramString = (FunctionCallMacroCallback)this.zzbcI.get(paramString);
      return paramString;
    }
  }
  
  public FunctionCallTagCallback zzfc(String paramString)
  {
    synchronized (this.zzbcJ)
    {
      paramString = (FunctionCallTagCallback)this.zzbcJ.get(paramString);
      return paramString;
    }
  }
  
  public void zzfd(String paramString)
  {
    zzEg().zzfd(paramString);
  }
  
  zzah zzfe(String paramString)
  {
    if (zzcb.zzEY().zzEZ().equals(zzcb.zza.zzbeP)) {}
    return new zzbo();
  }
  
  public static abstract interface FunctionCallMacroCallback
  {
    public abstract Object getValue(String paramString, Map<String, Object> paramMap);
  }
  
  public static abstract interface FunctionCallTagCallback
  {
    public abstract void execute(String paramString, Map<String, Object> paramMap);
  }
  
  private class zza
    implements zzt.zza
  {
    private zza() {}
    
    public Object zzc(String paramString, Map<String, Object> paramMap)
    {
      Container.FunctionCallMacroCallback localFunctionCallMacroCallback = Container.this.zzfb(paramString);
      if (localFunctionCallMacroCallback == null) {
        return null;
      }
      return localFunctionCallMacroCallback.getValue(paramString, paramMap);
    }
  }
  
  private class zzb
    implements zzt.zza
  {
    private zzb() {}
    
    public Object zzc(String paramString, Map<String, Object> paramMap)
    {
      Container.FunctionCallTagCallback localFunctionCallTagCallback = Container.this.zzfc(paramString);
      if (localFunctionCallTagCallback != null) {
        localFunctionCallTagCallback.execute(paramString, paramMap);
      }
      return zzdf.zzFI();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/Container.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */