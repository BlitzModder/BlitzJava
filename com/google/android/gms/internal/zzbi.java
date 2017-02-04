package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.Iterator;

@zzha
public class zzbi
{
  private final Object zzpK = new Object();
  private final int zzsC;
  private final int zzsD;
  private final int zzsE;
  private final zzbn zzsF;
  private ArrayList<String> zzsG = new ArrayList();
  private int zzsH = 0;
  private int zzsI = 0;
  private int zzsJ = 0;
  private int zzsK;
  private String zzsL = "";
  
  public zzbi(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.zzsC = paramInt1;
    this.zzsD = paramInt2;
    this.zzsE = paramInt3;
    this.zzsF = new zzbn(paramInt4);
  }
  
  private String zza(ArrayList<String> paramArrayList, int paramInt)
  {
    if (paramArrayList.isEmpty()) {
      paramArrayList = "";
    }
    Object localObject;
    do
    {
      return paramArrayList;
      localObject = new StringBuffer();
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        ((StringBuffer)localObject).append((String)paramArrayList.next());
        ((StringBuffer)localObject).append(' ');
      } while (((StringBuffer)localObject).length() <= paramInt);
      ((StringBuffer)localObject).deleteCharAt(((StringBuffer)localObject).length() - 1);
      localObject = ((StringBuffer)localObject).toString();
      paramArrayList = (ArrayList<String>)localObject;
    } while (((String)localObject).length() < paramInt);
    return ((String)localObject).substring(0, paramInt);
  }
  
  private void zzx(String paramString)
  {
    if ((paramString == null) || (paramString.length() < this.zzsE)) {
      return;
    }
    synchronized (this.zzpK)
    {
      this.zzsG.add(paramString);
      this.zzsH += paramString.length();
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzbi)) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      paramObject = (zzbi)paramObject;
    } while ((((zzbi)paramObject).zzcu() == null) || (!((zzbi)paramObject).zzcu().equals(zzcu())));
    return true;
  }
  
  public int getScore()
  {
    return this.zzsK;
  }
  
  public int hashCode()
  {
    return zzcu().hashCode();
  }
  
  public String toString()
  {
    return "ActivityContent fetchId: " + this.zzsI + " score:" + this.zzsK + " total_length:" + this.zzsH + "\n text: " + zza(this.zzsG, 200) + "\n signture: " + this.zzsL;
  }
  
  int zzb(int paramInt1, int paramInt2)
  {
    return this.zzsC * paramInt1 + this.zzsD * paramInt2;
  }
  
  public boolean zzct()
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        if (this.zzsJ == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public String zzcu()
  {
    return this.zzsL;
  }
  
  public void zzcv()
  {
    synchronized (this.zzpK)
    {
      this.zzsK -= 100;
      return;
    }
  }
  
  public void zzcw()
  {
    synchronized (this.zzpK)
    {
      this.zzsJ -= 1;
      return;
    }
  }
  
  public void zzcx()
  {
    synchronized (this.zzpK)
    {
      this.zzsJ += 1;
      return;
    }
  }
  
  public void zzcy()
  {
    synchronized (this.zzpK)
    {
      int i = zzb(this.zzsH, this.zzsI);
      if (i > this.zzsK)
      {
        this.zzsK = i;
        this.zzsL = this.zzsF.zza(this.zzsG);
      }
      return;
    }
  }
  
  int zzcz()
  {
    return this.zzsH;
  }
  
  public void zzh(int paramInt)
  {
    this.zzsI = paramInt;
  }
  
  public void zzv(String arg1)
  {
    zzx(???);
    synchronized (this.zzpK)
    {
      if (this.zzsJ < 0) {
        zzb.zzaF("ActivityContent: negative number of WebViews.");
      }
      zzcy();
      return;
    }
  }
  
  public void zzw(String paramString)
  {
    zzx(paramString);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */