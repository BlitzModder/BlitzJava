package com.google.android.gms.ads.internal.formats;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.zzha;
import java.util.List;

@zzha
public class zza
{
  private static final int zzxk = Color.rgb(12, 174, 206);
  private static final int zzxl = Color.rgb(204, 204, 204);
  static final int zzxm = zzxl;
  static final int zzxn = zzxk;
  private final int mTextColor;
  private final String zzxo;
  private final List<Drawable> zzxp;
  private final int zzxq;
  private final int zzxr;
  private final int zzxs;
  
  public zza(String paramString, List<Drawable> paramList, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, int paramInt)
  {
    this.zzxo = paramString;
    this.zzxp = paramList;
    if (paramInteger1 != null)
    {
      i = paramInteger1.intValue();
      this.zzxq = i;
      if (paramInteger2 == null) {
        break label81;
      }
      i = paramInteger2.intValue();
      label42:
      this.mTextColor = i;
      if (paramInteger3 == null) {
        break label89;
      }
    }
    label81:
    label89:
    for (int i = paramInteger3.intValue();; i = 12)
    {
      this.zzxr = i;
      this.zzxs = paramInt;
      return;
      i = zzxm;
      break;
      i = zzxn;
      break label42;
    }
  }
  
  public int getBackgroundColor()
  {
    return this.zzxq;
  }
  
  public String getText()
  {
    return this.zzxo;
  }
  
  public int getTextColor()
  {
    return this.mTextColor;
  }
  
  public int getTextSize()
  {
    return this.zzxr;
  }
  
  public int zzdA()
  {
    return this.zzxs;
  }
  
  public List<Drawable> zzdz()
  {
    return this.zzxp;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/formats/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */