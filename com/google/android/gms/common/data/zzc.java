package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public abstract class zzc
{
  protected final DataHolder zzafC;
  protected int zzahw;
  private int zzahx;
  
  public zzc(DataHolder paramDataHolder, int paramInt)
  {
    this.zzafC = ((DataHolder)zzx.zzy(paramDataHolder));
    zzbG(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof zzc))
    {
      paramObject = (zzc)paramObject;
      bool1 = bool2;
      if (zzw.equal(Integer.valueOf(((zzc)paramObject).zzahw), Integer.valueOf(this.zzahw)))
      {
        bool1 = bool2;
        if (zzw.equal(Integer.valueOf(((zzc)paramObject).zzahx), Integer.valueOf(this.zzahx)))
        {
          bool1 = bool2;
          if (((zzc)paramObject).zzafC == this.zzafC) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected boolean getBoolean(String paramString)
  {
    return this.zzafC.zze(paramString, this.zzahw, this.zzahx);
  }
  
  protected byte[] getByteArray(String paramString)
  {
    return this.zzafC.zzg(paramString, this.zzahw, this.zzahx);
  }
  
  protected float getFloat(String paramString)
  {
    return this.zzafC.zzf(paramString, this.zzahw, this.zzahx);
  }
  
  protected int getInteger(String paramString)
  {
    return this.zzafC.zzc(paramString, this.zzahw, this.zzahx);
  }
  
  protected long getLong(String paramString)
  {
    return this.zzafC.zzb(paramString, this.zzahw, this.zzahx);
  }
  
  protected String getString(String paramString)
  {
    return this.zzafC.zzd(paramString, this.zzahw, this.zzahx);
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.zzahw), Integer.valueOf(this.zzahx), this.zzafC });
  }
  
  public boolean isDataValid()
  {
    return !this.zzafC.isClosed();
  }
  
  protected void zza(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    this.zzafC.zza(paramString, this.zzahw, this.zzahx, paramCharArrayBuffer);
  }
  
  protected void zzbG(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.zzafC.getCount())) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzaa(bool);
      this.zzahw = paramInt;
      this.zzahx = this.zzafC.zzbI(this.zzahw);
      return;
    }
  }
  
  public boolean zzct(String paramString)
  {
    return this.zzafC.zzct(paramString);
  }
  
  protected Uri zzcu(String paramString)
  {
    return this.zzafC.zzh(paramString, this.zzahw, this.zzahx);
  }
  
  protected boolean zzcv(String paramString)
  {
    return this.zzafC.zzi(paramString, this.zzahw, this.zzahx);
  }
  
  protected int zzpK()
  {
    return this.zzahw;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/data/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */