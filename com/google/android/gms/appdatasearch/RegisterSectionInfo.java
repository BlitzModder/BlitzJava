package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class RegisterSectionInfo
  implements SafeParcelable
{
  public static final zzi CREATOR = new zzi();
  final int mVersionCode;
  public final String name;
  public final int weight;
  public final String zzSJ;
  public final boolean zzSK;
  public final boolean zzSL;
  public final String zzSM;
  public final Feature[] zzSN;
  final int[] zzSO;
  public final String zzSP;
  
  RegisterSectionInfo(int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString3, Feature[] paramArrayOfFeature, int[] paramArrayOfInt, String paramString4)
  {
    this.mVersionCode = paramInt1;
    this.name = paramString1;
    this.zzSJ = paramString2;
    this.zzSK = paramBoolean1;
    this.weight = paramInt2;
    this.zzSL = paramBoolean2;
    this.zzSM = paramString3;
    this.zzSN = paramArrayOfFeature;
    this.zzSO = paramArrayOfInt;
    this.zzSP = paramString4;
  }
  
  RegisterSectionInfo(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString3, Feature[] paramArrayOfFeature, int[] paramArrayOfInt, String paramString4)
  {
    this(2, paramString1, paramString2, paramBoolean1, paramInt, paramBoolean2, paramString3, paramArrayOfFeature, paramArrayOfInt, paramString4);
  }
  
  public int describeContents()
  {
    zzi localzzi = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi localzzi = CREATOR;
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public static final class zza
  {
    private final String mName;
    private String zzSQ;
    private boolean zzSR;
    private int zzSS;
    private boolean zzST;
    private String zzSU;
    private final List<Feature> zzSV;
    private BitSet zzSW;
    private String zzSX;
    
    public zza(String paramString)
    {
      this.mName = paramString;
      this.zzSS = 1;
      this.zzSV = new ArrayList();
    }
    
    public zza zzM(boolean paramBoolean)
    {
      this.zzSR = paramBoolean;
      return this;
    }
    
    public zza zzN(boolean paramBoolean)
    {
      this.zzST = paramBoolean;
      return this;
    }
    
    public zza zzap(int paramInt)
    {
      if (this.zzSW == null) {
        this.zzSW = new BitSet();
      }
      this.zzSW.set(paramInt);
      return this;
    }
    
    public zza zzby(String paramString)
    {
      this.zzSQ = paramString;
      return this;
    }
    
    public zza zzbz(String paramString)
    {
      this.zzSX = paramString;
      return this;
    }
    
    public RegisterSectionInfo zzlQ()
    {
      int i = 0;
      Object localObject = null;
      if (this.zzSW != null)
      {
        int[] arrayOfInt = new int[this.zzSW.cardinality()];
        int j = this.zzSW.nextSetBit(0);
        for (;;)
        {
          localObject = arrayOfInt;
          if (j < 0) {
            break;
          }
          arrayOfInt[i] = j;
          j = this.zzSW.nextSetBit(j + 1);
          i += 1;
        }
      }
      return new RegisterSectionInfo(this.mName, this.zzSQ, this.zzSR, this.zzSS, this.zzST, this.zzSU, (Feature[])this.zzSV.toArray(new Feature[this.zzSV.size()]), (int[])localObject, this.zzSX);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/appdatasearch/RegisterSectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */