package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.internal.zzni;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zznv;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class FastJsonResponse
{
  private void zza(StringBuilder paramStringBuilder, Field paramField, Object paramObject)
  {
    if (paramField.zzqT() == 11)
    {
      paramStringBuilder.append(((FastJsonResponse)paramField.zzrd().cast(paramObject)).toString());
      return;
    }
    if (paramField.zzqT() == 7)
    {
      paramStringBuilder.append("\"");
      paramStringBuilder.append(zznu.zzcO((String)paramObject));
      paramStringBuilder.append("\"");
      return;
    }
    paramStringBuilder.append(paramObject);
  }
  
  private void zza(StringBuilder paramStringBuilder, Field paramField, ArrayList<Object> paramArrayList)
  {
    paramStringBuilder.append("[");
    int i = 0;
    int j = paramArrayList.size();
    while (i < j)
    {
      if (i > 0) {
        paramStringBuilder.append(",");
      }
      Object localObject = paramArrayList.get(i);
      if (localObject != null) {
        zza(paramStringBuilder, paramField, localObject);
      }
      i += 1;
    }
    paramStringBuilder.append("]");
  }
  
  public String toString()
  {
    Map localMap = zzqV();
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Field localField = (Field)localMap.get(str);
      if (zza(localField))
      {
        Object localObject = zza(localField, zzb(localField));
        if (localStringBuilder.length() == 0) {
          localStringBuilder.append("{");
        }
        for (;;)
        {
          localStringBuilder.append("\"").append(str).append("\":");
          if (localObject != null) {
            break label139;
          }
          localStringBuilder.append("null");
          break;
          localStringBuilder.append(",");
        }
        label139:
        switch (localField.zzqU())
        {
        default: 
          if (localField.zzqZ()) {
            zza(localStringBuilder, localField, (ArrayList)localObject);
          }
          break;
        case 8: 
          localStringBuilder.append("\"").append(zzni.zzj((byte[])localObject)).append("\"");
          break;
        case 9: 
          localStringBuilder.append("\"").append(zzni.zzk((byte[])localObject)).append("\"");
          break;
        case 10: 
          zznv.zza(localStringBuilder, (HashMap)localObject);
          continue;
          zza(localStringBuilder, localField, localObject);
        }
      }
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.append("}");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("{}");
    }
  }
  
  protected <O, I> I zza(Field<I, O> paramField, Object paramObject)
  {
    Object localObject = paramObject;
    if (Field.zzc(paramField) != null) {
      localObject = paramField.convertBack(paramObject);
    }
    return (I)localObject;
  }
  
  protected boolean zza(Field paramField)
  {
    if (paramField.zzqU() == 11)
    {
      if (paramField.zzra()) {
        return zzcK(paramField.zzrb());
      }
      return zzcJ(paramField.zzrb());
    }
    return zzcI(paramField.zzrb());
  }
  
  protected Object zzb(Field paramField)
  {
    String str = paramField.zzrb();
    if (paramField.zzrd() != null)
    {
      boolean bool;
      if (zzcH(paramField.zzrb()) == null)
      {
        bool = true;
        zzx.zza(bool, "Concrete field shouldn't be value object: %s", new Object[] { paramField.zzrb() });
        if (!paramField.zzra()) {
          break label71;
        }
      }
      label71:
      for (paramField = zzqX();; paramField = zzqW())
      {
        if (paramField == null) {
          break label79;
        }
        return paramField.get(str);
        bool = false;
        break;
      }
      try
      {
        label79:
        paramField = "get" + Character.toUpperCase(str.charAt(0)) + str.substring(1);
        paramField = getClass().getMethod(paramField, new Class[0]).invoke(this, new Object[0]);
        return paramField;
      }
      catch (Exception paramField)
      {
        throw new RuntimeException(paramField);
      }
    }
    return zzcH(paramField.zzrb());
  }
  
  protected abstract Object zzcH(String paramString);
  
  protected abstract boolean zzcI(String paramString);
  
  protected boolean zzcJ(String paramString)
  {
    throw new UnsupportedOperationException("Concrete types not supported");
  }
  
  protected boolean zzcK(String paramString)
  {
    throw new UnsupportedOperationException("Concrete type arrays not supported");
  }
  
  public abstract Map<String, Field<?, ?>> zzqV();
  
  public HashMap<String, Object> zzqW()
  {
    return null;
  }
  
  public HashMap<String, Object> zzqX()
  {
    return null;
  }
  
  public static class Field<I, O>
    implements SafeParcelable
  {
    public static final zza CREATOR = new zza();
    private final int mVersionCode;
    protected final int zzakU;
    protected final boolean zzakV;
    protected final int zzakW;
    protected final boolean zzakX;
    protected final String zzakY;
    protected final int zzakZ;
    protected final Class<? extends FastJsonResponse> zzala;
    protected final String zzalb;
    private FieldMappingDictionary zzalc;
    private FastJsonResponse.zza<I, O> zzald;
    
    Field(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, ConverterWrapper paramConverterWrapper)
    {
      this.mVersionCode = paramInt1;
      this.zzakU = paramInt2;
      this.zzakV = paramBoolean1;
      this.zzakW = paramInt3;
      this.zzakX = paramBoolean2;
      this.zzakY = paramString1;
      this.zzakZ = paramInt4;
      if (paramString2 == null) {
        this.zzala = null;
      }
      for (this.zzalb = null; paramConverterWrapper == null; this.zzalb = paramString2)
      {
        this.zzald = null;
        return;
        this.zzala = SafeParcelResponse.class;
      }
      this.zzald = paramConverterWrapper.zzqR();
    }
    
    protected Field(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, int paramInt3, Class<? extends FastJsonResponse> paramClass, FastJsonResponse.zza<I, O> paramzza)
    {
      this.mVersionCode = 1;
      this.zzakU = paramInt1;
      this.zzakV = paramBoolean1;
      this.zzakW = paramInt2;
      this.zzakX = paramBoolean2;
      this.zzakY = paramString;
      this.zzakZ = paramInt3;
      this.zzala = paramClass;
      if (paramClass == null) {}
      for (this.zzalb = null;; this.zzalb = paramClass.getCanonicalName())
      {
        this.zzald = paramzza;
        return;
      }
    }
    
    public static Field zza(String paramString, int paramInt, FastJsonResponse.zza<?, ?> paramzza, boolean paramBoolean)
    {
      return new Field(paramzza.zzqT(), paramBoolean, paramzza.zzqU(), false, paramString, paramInt, null, paramzza);
    }
    
    public static <T extends FastJsonResponse> Field<T, T> zza(String paramString, int paramInt, Class<T> paramClass)
    {
      return new Field(11, false, 11, false, paramString, paramInt, paramClass, null);
    }
    
    public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> zzb(String paramString, int paramInt, Class<T> paramClass)
    {
      return new Field(11, true, 11, true, paramString, paramInt, paramClass, null);
    }
    
    public static Field<Integer, Integer> zzi(String paramString, int paramInt)
    {
      return new Field(0, false, 0, false, paramString, paramInt, null, null);
    }
    
    public static Field<Double, Double> zzj(String paramString, int paramInt)
    {
      return new Field(4, false, 4, false, paramString, paramInt, null, null);
    }
    
    public static Field<Boolean, Boolean> zzk(String paramString, int paramInt)
    {
      return new Field(6, false, 6, false, paramString, paramInt, null, null);
    }
    
    public static Field<String, String> zzl(String paramString, int paramInt)
    {
      return new Field(7, false, 7, false, paramString, paramInt, null, null);
    }
    
    public static Field<ArrayList<String>, ArrayList<String>> zzm(String paramString, int paramInt)
    {
      return new Field(7, true, 7, true, paramString, paramInt, null, null);
    }
    
    public I convertBack(O paramO)
    {
      return (I)this.zzald.convertBack(paramO);
    }
    
    public int describeContents()
    {
      zza localzza = CREATOR;
      return 0;
    }
    
    public int getVersionCode()
    {
      return this.mVersionCode;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Field\n");
      localStringBuilder1.append("            versionCode=").append(this.mVersionCode).append('\n');
      localStringBuilder1.append("                 typeIn=").append(this.zzakU).append('\n');
      localStringBuilder1.append("            typeInArray=").append(this.zzakV).append('\n');
      localStringBuilder1.append("                typeOut=").append(this.zzakW).append('\n');
      localStringBuilder1.append("           typeOutArray=").append(this.zzakX).append('\n');
      localStringBuilder1.append("        outputFieldName=").append(this.zzakY).append('\n');
      localStringBuilder1.append("      safeParcelFieldId=").append(this.zzakZ).append('\n');
      localStringBuilder1.append("       concreteTypeName=").append(zzre()).append('\n');
      if (zzrd() != null) {
        localStringBuilder1.append("     concreteType.class=").append(zzrd().getCanonicalName()).append('\n');
      }
      StringBuilder localStringBuilder2 = localStringBuilder1.append("          converterName=");
      if (this.zzald == null) {}
      for (String str = "null";; str = this.zzald.getClass().getCanonicalName())
      {
        localStringBuilder2.append(str).append('\n');
        return localStringBuilder1.toString();
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zza localzza = CREATOR;
      zza.zza(this, paramParcel, paramInt);
    }
    
    public void zza(FieldMappingDictionary paramFieldMappingDictionary)
    {
      this.zzalc = paramFieldMappingDictionary;
    }
    
    public int zzqT()
    {
      return this.zzakU;
    }
    
    public int zzqU()
    {
      return this.zzakW;
    }
    
    public Field<I, O> zzqY()
    {
      return new Field(this.mVersionCode, this.zzakU, this.zzakV, this.zzakW, this.zzakX, this.zzakY, this.zzakZ, this.zzalb, zzrg());
    }
    
    public boolean zzqZ()
    {
      return this.zzakV;
    }
    
    public boolean zzra()
    {
      return this.zzakX;
    }
    
    public String zzrb()
    {
      return this.zzakY;
    }
    
    public int zzrc()
    {
      return this.zzakZ;
    }
    
    public Class<? extends FastJsonResponse> zzrd()
    {
      return this.zzala;
    }
    
    String zzre()
    {
      if (this.zzalb == null) {
        return null;
      }
      return this.zzalb;
    }
    
    public boolean zzrf()
    {
      return this.zzald != null;
    }
    
    ConverterWrapper zzrg()
    {
      if (this.zzald == null) {
        return null;
      }
      return ConverterWrapper.zza(this.zzald);
    }
    
    public Map<String, Field<?, ?>> zzrh()
    {
      zzx.zzy(this.zzalb);
      zzx.zzy(this.zzalc);
      return this.zzalc.zzcL(this.zzalb);
    }
  }
  
  public static abstract interface zza<I, O>
  {
    public abstract I convertBack(O paramO);
    
    public abstract int zzqT();
    
    public abstract int zzqU();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/server/response/FastJsonResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */