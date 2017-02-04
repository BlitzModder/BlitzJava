package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager
{
  private static TagManager zzbgg;
  private final Context mContext;
  private final DataLayer zzbcG;
  private final zzs zzbfa;
  private final zza zzbgd;
  private final zzct zzbge;
  private final ConcurrentMap<zzo, Boolean> zzbgf;
  
  TagManager(Context paramContext, zza paramzza, DataLayer paramDataLayer, zzct paramzzct)
  {
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.zzbge = paramzzct;
    this.zzbgd = paramzza;
    this.zzbgf = new ConcurrentHashMap();
    this.zzbcG = paramDataLayer;
    this.zzbcG.zza(new DataLayer.zzb()
    {
      public void zzJ(Map<String, Object> paramAnonymousMap)
      {
        paramAnonymousMap = paramAnonymousMap.get("event");
        if (paramAnonymousMap != null) {
          TagManager.zza(TagManager.this, paramAnonymousMap.toString());
        }
      }
    });
    this.zzbcG.zza(new zzd(this.mContext));
    this.zzbfa = new zzs();
    zzFx();
  }
  
  public static TagManager getInstance(Context paramContext)
  {
    try
    {
      if (zzbgg != null) {
        break label68;
      }
      if (paramContext == null)
      {
        zzbg.e("TagManager.getInstance requires non-null context.");
        throw new NullPointerException();
      }
    }
    finally {}
    zzbgg = new TagManager(paramContext, new zza()new DataLayernew zzw
    {
      public zzp zza(Context paramAnonymousContext, TagManager paramAnonymousTagManager, Looper paramAnonymousLooper, String paramAnonymousString, int paramAnonymousInt, zzs paramAnonymouszzs)
      {
        return new zzp(paramAnonymousContext, paramAnonymousTagManager, paramAnonymousLooper, paramAnonymousString, paramAnonymousInt, paramAnonymouszzs);
      }
    }, new DataLayer(new zzw(paramContext)), zzcu.zzFs());
    label68:
    paramContext = zzbgg;
    return paramContext;
  }
  
  private void zzFx()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.mContext.registerComponentCallbacks(new ComponentCallbacks2()
      {
        public void onConfigurationChanged(Configuration paramAnonymousConfiguration) {}
        
        public void onLowMemory() {}
        
        public void onTrimMemory(int paramAnonymousInt)
        {
          if (paramAnonymousInt == 20) {
            TagManager.this.dispatch();
          }
        }
      });
    }
  }
  
  private void zzfB(String paramString)
  {
    Iterator localIterator = this.zzbgf.keySet().iterator();
    while (localIterator.hasNext()) {
      ((zzo)localIterator.next()).zzfd(paramString);
    }
  }
  
  public void dispatch()
  {
    this.zzbge.dispatch();
  }
  
  public DataLayer getDataLayer()
  {
    return this.zzbcG;
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, int paramInt)
  {
    paramString = this.zzbgd.zza(this.mContext, this, null, paramString, paramInt, this.zzbfa);
    paramString.zzEk();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.zzbgd.zza(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.zzbfa);
    paramString.zzEk();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, int paramInt)
  {
    paramString = this.zzbgd.zza(this.mContext, this, null, paramString, paramInt, this.zzbfa);
    paramString.zzEm();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.zzbgd.zza(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.zzbfa);
    paramString.zzEm();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, int paramInt)
  {
    paramString = this.zzbgd.zza(this.mContext, this, null, paramString, paramInt, this.zzbfa);
    paramString.zzEl();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.zzbgd.zza(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.zzbfa);
    paramString.zzEl();
    return paramString;
  }
  
  public void setVerboseLoggingEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 5)
    {
      zzbg.setLogLevel(i);
      return;
    }
  }
  
  public void zza(zzo paramzzo)
  {
    this.zzbgf.put(paramzzo, Boolean.valueOf(true));
  }
  
  public boolean zzb(zzo paramzzo)
  {
    return this.zzbgf.remove(paramzzo) != null;
  }
  
  boolean zzp(Uri paramUri)
  {
    for (;;)
    {
      boolean bool;
      Object localObject2;
      try
      {
        localObject1 = zzcb.zzEY();
        if (!((zzcb)localObject1).zzp(paramUri)) {
          break label229;
        }
        paramUri = ((zzcb)localObject1).getContainerId();
        int i = 4.zzbgi[localObject1.zzEZ().ordinal()];
        switch (i)
        {
        default: 
          bool = true;
          return bool;
        }
      }
      finally {}
      Object localObject1 = this.zzbgf.keySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (zzo)((Iterator)localObject1).next();
        if (((zzo)localObject2).getContainerId().equals(paramUri))
        {
          ((zzo)localObject2).zzff(null);
          ((zzo)localObject2).refresh();
        }
      }
      else
      {
        continue;
        localObject2 = this.zzbgf.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          zzo localzzo = (zzo)((Iterator)localObject2).next();
          if (localzzo.getContainerId().equals(paramUri))
          {
            localzzo.zzff(((zzcb)localObject1).zzFa());
            localzzo.refresh();
          }
          else if (localzzo.zzEh() != null)
          {
            localzzo.zzff(null);
            localzzo.refresh();
          }
        }
        continue;
        label229:
        bool = false;
      }
    }
  }
  
  public static abstract interface zza
  {
    public abstract zzp zza(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, zzs paramzzs);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/TagManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */