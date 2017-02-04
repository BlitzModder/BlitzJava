package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public final class PasswordSpecification
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  public static final PasswordSpecification zzUO = new zza().zzh(12, 16).zzbD("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").zze("abcdefghijkmnopqrstxyz", 1).zze("ABCDEFGHJKLMNPQRSTXY", 1).zze("3456789", 1).zzmj();
  public static final PasswordSpecification zzUP = new zza().zzh(12, 16).zzbD("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").zze("abcdefghijklmnopqrstuvwxyz", 1).zze("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).zze("1234567890", 1).zzmj();
  final int mVersionCode;
  final String zzUQ;
  final List<String> zzUR;
  final List<Integer> zzUS;
  final int zzUT;
  final int zzUU;
  private final int[] zzUV;
  private final Random zzuj;
  
  PasswordSpecification(int paramInt1, String paramString, List<String> paramList, List<Integer> paramList1, int paramInt2, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzUQ = paramString;
    this.zzUR = Collections.unmodifiableList(paramList);
    this.zzUS = Collections.unmodifiableList(paramList1);
    this.zzUT = paramInt2;
    this.zzUU = paramInt3;
    this.zzUV = zzmi();
    this.zzuj = new SecureRandom();
  }
  
  private int zza(char paramChar)
  {
    return paramChar - ' ';
  }
  
  private static String zzb(Collection<Character> paramCollection)
  {
    char[] arrayOfChar = new char[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfChar[i] = ((Character)paramCollection.next()).charValue();
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  private static boolean zzb(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 < paramInt2) || (paramInt1 > paramInt3);
  }
  
  private int[] zzmi()
  {
    int[] arrayOfInt = new int[95];
    Arrays.fill(arrayOfInt, -1);
    Iterator localIterator = this.zzUR.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      char[] arrayOfChar = ((String)localIterator.next()).toCharArray();
      int k = arrayOfChar.length;
      int j = 0;
      while (j < k)
      {
        arrayOfInt[zza(arrayOfChar[j])] = i;
        j += 1;
      }
      i += 1;
    }
    return arrayOfInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public static class zza
  {
    private final List<String> zzUR = new ArrayList();
    private final List<Integer> zzUS = new ArrayList();
    private int zzUT = 12;
    private int zzUU = 16;
    private final TreeSet<Character> zzUW = new TreeSet();
    
    private void zzmk()
    {
      Iterator localIterator = this.zzUS.iterator();
      for (int i = 0; localIterator.hasNext(); i = ((Integer)localIterator.next()).intValue() + i) {}
      if (i > this.zzUU) {
        throw new PasswordSpecification.zzb("required character count cannot be greater than the max password size");
      }
    }
    
    private void zzml()
    {
      boolean[] arrayOfBoolean = new boolean[95];
      Iterator localIterator = this.zzUR.iterator();
      while (localIterator.hasNext())
      {
        char[] arrayOfChar = ((String)localIterator.next()).toCharArray();
        int j = arrayOfChar.length;
        int i = 0;
        while (i < j)
        {
          char c = arrayOfChar[i];
          if (arrayOfBoolean[(c - ' ')] != 0) {
            throw new PasswordSpecification.zzb("character " + c + " occurs in more than one required character set");
          }
          arrayOfBoolean[(c - ' ')] = true;
          i += 1;
        }
      }
    }
    
    private TreeSet<Character> zzr(String paramString1, String paramString2)
    {
      if (TextUtils.isEmpty(paramString1)) {
        throw new PasswordSpecification.zzb(paramString2 + " cannot be null or empty");
      }
      TreeSet localTreeSet = new TreeSet();
      paramString1 = paramString1.toCharArray();
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        char c = paramString1[i];
        if (PasswordSpecification.zzc(c, 32, 126)) {
          throw new PasswordSpecification.zzb(paramString2 + " must only contain ASCII printable characters");
        }
        localTreeSet.add(Character.valueOf(c));
        i += 1;
      }
      return localTreeSet;
    }
    
    public zza zzbD(String paramString)
    {
      this.zzUW.addAll(zzr(paramString, "allowedChars"));
      return this;
    }
    
    public zza zze(String paramString, int paramInt)
    {
      if (paramInt < 1) {
        throw new PasswordSpecification.zzb("count must be at least 1");
      }
      paramString = zzr(paramString, "requiredChars");
      this.zzUR.add(PasswordSpecification.zzc(paramString));
      this.zzUS.add(Integer.valueOf(paramInt));
      return this;
    }
    
    public zza zzh(int paramInt1, int paramInt2)
    {
      if (paramInt1 < 1) {
        throw new PasswordSpecification.zzb("minimumSize must be at least 1");
      }
      if (paramInt1 > paramInt2) {
        throw new PasswordSpecification.zzb("maximumSize must be greater than or equal to minimumSize");
      }
      this.zzUT = paramInt1;
      this.zzUU = paramInt2;
      return this;
    }
    
    public PasswordSpecification zzmj()
    {
      if (this.zzUW.isEmpty()) {
        throw new PasswordSpecification.zzb("no allowed characters specified");
      }
      zzmk();
      zzml();
      return new PasswordSpecification(1, PasswordSpecification.zzc(this.zzUW), this.zzUR, this.zzUS, this.zzUT, this.zzUU);
    }
  }
  
  public static class zzb
    extends Error
  {
    public zzb(String paramString)
    {
      super();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/credentials/PasswordSpecification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */