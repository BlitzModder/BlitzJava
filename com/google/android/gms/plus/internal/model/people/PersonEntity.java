package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class PersonEntity
  extends FastSafeParcelableJsonResponse
  implements Person
{
  public static final zza CREATOR = new zza();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap();
  final int mVersionCode;
  String zzF;
  String zzVu;
  String zzZe;
  final Set<Integer> zzaZA;
  String zzbaA;
  String zzbaB;
  int zzbaC;
  CoverEntity zzbaD;
  String zzbaE;
  ImageEntity zzbaF;
  boolean zzbaG;
  NameEntity zzbaH;
  String zzbaI;
  int zzbaJ;
  List<OrganizationsEntity> zzbaK;
  List<PlacesLivedEntity> zzbaL;
  int zzbaM;
  int zzbaN;
  String zzbaO;
  List<UrlsEntity> zzbaP;
  boolean zzbaQ;
  String zzbay;
  AgeRangeEntity zzbaz;
  int zztH;
  String zzxX;
  
  static
  {
    zzaZz.put("aboutMe", FastJsonResponse.Field.zzl("aboutMe", 2));
    zzaZz.put("ageRange", FastJsonResponse.Field.zza("ageRange", 3, AgeRangeEntity.class));
    zzaZz.put("birthday", FastJsonResponse.Field.zzl("birthday", 4));
    zzaZz.put("braggingRights", FastJsonResponse.Field.zzl("braggingRights", 5));
    zzaZz.put("circledByCount", FastJsonResponse.Field.zzi("circledByCount", 6));
    zzaZz.put("cover", FastJsonResponse.Field.zza("cover", 7, CoverEntity.class));
    zzaZz.put("currentLocation", FastJsonResponse.Field.zzl("currentLocation", 8));
    zzaZz.put("displayName", FastJsonResponse.Field.zzl("displayName", 9));
    zzaZz.put("gender", FastJsonResponse.Field.zza("gender", 12, new StringToIntConverter().zzh("male", 0).zzh("female", 1).zzh("other", 2), false));
    zzaZz.put("id", FastJsonResponse.Field.zzl("id", 14));
    zzaZz.put("image", FastJsonResponse.Field.zza("image", 15, ImageEntity.class));
    zzaZz.put("isPlusUser", FastJsonResponse.Field.zzk("isPlusUser", 16));
    zzaZz.put("language", FastJsonResponse.Field.zzl("language", 18));
    zzaZz.put("name", FastJsonResponse.Field.zza("name", 19, NameEntity.class));
    zzaZz.put("nickname", FastJsonResponse.Field.zzl("nickname", 20));
    zzaZz.put("objectType", FastJsonResponse.Field.zza("objectType", 21, new StringToIntConverter().zzh("person", 0).zzh("page", 1), false));
    zzaZz.put("organizations", FastJsonResponse.Field.zzb("organizations", 22, OrganizationsEntity.class));
    zzaZz.put("placesLived", FastJsonResponse.Field.zzb("placesLived", 23, PlacesLivedEntity.class));
    zzaZz.put("plusOneCount", FastJsonResponse.Field.zzi("plusOneCount", 24));
    zzaZz.put("relationshipStatus", FastJsonResponse.Field.zza("relationshipStatus", 25, new StringToIntConverter().zzh("single", 0).zzh("in_a_relationship", 1).zzh("engaged", 2).zzh("married", 3).zzh("its_complicated", 4).zzh("open_relationship", 5).zzh("widowed", 6).zzh("in_domestic_partnership", 7).zzh("in_civil_union", 8), false));
    zzaZz.put("tagline", FastJsonResponse.Field.zzl("tagline", 26));
    zzaZz.put("url", FastJsonResponse.Field.zzl("url", 27));
    zzaZz.put("urls", FastJsonResponse.Field.zzb("urls", 28, UrlsEntity.class));
    zzaZz.put("verified", FastJsonResponse.Field.zzk("verified", 29));
  }
  
  public PersonEntity()
  {
    this.mVersionCode = 1;
    this.zzaZA = new HashSet();
  }
  
  public PersonEntity(String paramString1, String paramString2, ImageEntity paramImageEntity, int paramInt, String paramString3)
  {
    this.mVersionCode = 1;
    this.zzaZA = new HashSet();
    this.zzVu = paramString1;
    this.zzaZA.add(Integer.valueOf(9));
    this.zzxX = paramString2;
    this.zzaZA.add(Integer.valueOf(14));
    this.zzbaF = paramImageEntity;
    this.zzaZA.add(Integer.valueOf(15));
    this.zzbaJ = paramInt;
    this.zzaZA.add(Integer.valueOf(21));
    this.zzF = paramString3;
    this.zzaZA.add(Integer.valueOf(27));
  }
  
  PersonEntity(Set<Integer> paramSet, int paramInt1, String paramString1, AgeRangeEntity paramAgeRangeEntity, String paramString2, String paramString3, int paramInt2, CoverEntity paramCoverEntity, String paramString4, String paramString5, int paramInt3, String paramString6, ImageEntity paramImageEntity, boolean paramBoolean1, String paramString7, NameEntity paramNameEntity, String paramString8, int paramInt4, List<OrganizationsEntity> paramList, List<PlacesLivedEntity> paramList1, int paramInt5, int paramInt6, String paramString9, String paramString10, List<UrlsEntity> paramList2, boolean paramBoolean2)
  {
    this.zzaZA = paramSet;
    this.mVersionCode = paramInt1;
    this.zzbay = paramString1;
    this.zzbaz = paramAgeRangeEntity;
    this.zzbaA = paramString2;
    this.zzbaB = paramString3;
    this.zzbaC = paramInt2;
    this.zzbaD = paramCoverEntity;
    this.zzbaE = paramString4;
    this.zzVu = paramString5;
    this.zztH = paramInt3;
    this.zzxX = paramString6;
    this.zzbaF = paramImageEntity;
    this.zzbaG = paramBoolean1;
    this.zzZe = paramString7;
    this.zzbaH = paramNameEntity;
    this.zzbaI = paramString8;
    this.zzbaJ = paramInt4;
    this.zzbaK = paramList;
    this.zzbaL = paramList1;
    this.zzbaM = paramInt5;
    this.zzbaN = paramInt6;
    this.zzbaO = paramString9;
    this.zzF = paramString10;
    this.zzbaP = paramList2;
    this.zzbaQ = paramBoolean2;
  }
  
  public static PersonEntity zzu(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = CREATOR.zzgt(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  public int describeContents()
  {
    zza localzza = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PersonEntity)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (PersonEntity)paramObject;
    Iterator localIterator = zzaZz.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (zza(localField))
      {
        if (((PersonEntity)paramObject).zza(localField))
        {
          if (!zzb(localField).equals(((PersonEntity)paramObject).zzb(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((PersonEntity)paramObject).zza(localField)) {
        return false;
      }
    }
    return true;
  }
  
  public String getAboutMe()
  {
    return this.zzbay;
  }
  
  public Person.AgeRange getAgeRange()
  {
    return this.zzbaz;
  }
  
  public String getBirthday()
  {
    return this.zzbaA;
  }
  
  public String getBraggingRights()
  {
    return this.zzbaB;
  }
  
  public int getCircledByCount()
  {
    return this.zzbaC;
  }
  
  public Person.Cover getCover()
  {
    return this.zzbaD;
  }
  
  public String getCurrentLocation()
  {
    return this.zzbaE;
  }
  
  public String getDisplayName()
  {
    return this.zzVu;
  }
  
  public int getGender()
  {
    return this.zztH;
  }
  
  public String getId()
  {
    return this.zzxX;
  }
  
  public Person.Image getImage()
  {
    return this.zzbaF;
  }
  
  public String getLanguage()
  {
    return this.zzZe;
  }
  
  public Person.Name getName()
  {
    return this.zzbaH;
  }
  
  public String getNickname()
  {
    return this.zzbaI;
  }
  
  public int getObjectType()
  {
    return this.zzbaJ;
  }
  
  public List<Person.Organizations> getOrganizations()
  {
    return (ArrayList)this.zzbaK;
  }
  
  public List<Person.PlacesLived> getPlacesLived()
  {
    return (ArrayList)this.zzbaL;
  }
  
  public int getPlusOneCount()
  {
    return this.zzbaM;
  }
  
  public int getRelationshipStatus()
  {
    return this.zzbaN;
  }
  
  public String getTagline()
  {
    return this.zzbaO;
  }
  
  public String getUrl()
  {
    return this.zzF;
  }
  
  public List<Person.Urls> getUrls()
  {
    return (ArrayList)this.zzbaP;
  }
  
  public boolean hasAboutMe()
  {
    return this.zzaZA.contains(Integer.valueOf(2));
  }
  
  public boolean hasAgeRange()
  {
    return this.zzaZA.contains(Integer.valueOf(3));
  }
  
  public boolean hasBirthday()
  {
    return this.zzaZA.contains(Integer.valueOf(4));
  }
  
  public boolean hasBraggingRights()
  {
    return this.zzaZA.contains(Integer.valueOf(5));
  }
  
  public boolean hasCircledByCount()
  {
    return this.zzaZA.contains(Integer.valueOf(6));
  }
  
  public boolean hasCover()
  {
    return this.zzaZA.contains(Integer.valueOf(7));
  }
  
  public boolean hasCurrentLocation()
  {
    return this.zzaZA.contains(Integer.valueOf(8));
  }
  
  public boolean hasDisplayName()
  {
    return this.zzaZA.contains(Integer.valueOf(9));
  }
  
  public boolean hasGender()
  {
    return this.zzaZA.contains(Integer.valueOf(12));
  }
  
  public boolean hasId()
  {
    return this.zzaZA.contains(Integer.valueOf(14));
  }
  
  public boolean hasImage()
  {
    return this.zzaZA.contains(Integer.valueOf(15));
  }
  
  public boolean hasIsPlusUser()
  {
    return this.zzaZA.contains(Integer.valueOf(16));
  }
  
  public boolean hasLanguage()
  {
    return this.zzaZA.contains(Integer.valueOf(18));
  }
  
  public boolean hasName()
  {
    return this.zzaZA.contains(Integer.valueOf(19));
  }
  
  public boolean hasNickname()
  {
    return this.zzaZA.contains(Integer.valueOf(20));
  }
  
  public boolean hasObjectType()
  {
    return this.zzaZA.contains(Integer.valueOf(21));
  }
  
  public boolean hasOrganizations()
  {
    return this.zzaZA.contains(Integer.valueOf(22));
  }
  
  public boolean hasPlacesLived()
  {
    return this.zzaZA.contains(Integer.valueOf(23));
  }
  
  public boolean hasPlusOneCount()
  {
    return this.zzaZA.contains(Integer.valueOf(24));
  }
  
  public boolean hasRelationshipStatus()
  {
    return this.zzaZA.contains(Integer.valueOf(25));
  }
  
  public boolean hasTagline()
  {
    return this.zzaZA.contains(Integer.valueOf(26));
  }
  
  public boolean hasUrl()
  {
    return this.zzaZA.contains(Integer.valueOf(27));
  }
  
  public boolean hasUrls()
  {
    return this.zzaZA.contains(Integer.valueOf(28));
  }
  
  public boolean hasVerified()
  {
    return this.zzaZA.contains(Integer.valueOf(29));
  }
  
  public int hashCode()
  {
    Iterator localIterator = zzaZz.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (!zza(localField)) {
        break label68;
      }
      int j = localField.zzrc();
      i = zzb(localField).hashCode() + (i + j);
    }
    label68:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isPlusUser()
  {
    return this.zzbaG;
  }
  
  public boolean isVerified()
  {
    return this.zzbaQ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza localzza = CREATOR;
    zza.zza(this, paramParcel, paramInt);
  }
  
  public HashMap<String, FastJsonResponse.Field<?, ?>> zzDq()
  {
    return zzaZz;
  }
  
  public PersonEntity zzDu()
  {
    return this;
  }
  
  protected boolean zza(FastJsonResponse.Field paramField)
  {
    return this.zzaZA.contains(Integer.valueOf(paramField.zzrc()));
  }
  
  protected Object zzb(FastJsonResponse.Field paramField)
  {
    switch (paramField.zzrc())
    {
    case 10: 
    case 11: 
    case 13: 
    case 17: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzrc());
    case 2: 
      return this.zzbay;
    case 3: 
      return this.zzbaz;
    case 4: 
      return this.zzbaA;
    case 5: 
      return this.zzbaB;
    case 6: 
      return Integer.valueOf(this.zzbaC);
    case 7: 
      return this.zzbaD;
    case 8: 
      return this.zzbaE;
    case 9: 
      return this.zzVu;
    case 12: 
      return Integer.valueOf(this.zztH);
    case 14: 
      return this.zzxX;
    case 15: 
      return this.zzbaF;
    case 16: 
      return Boolean.valueOf(this.zzbaG);
    case 18: 
      return this.zzZe;
    case 19: 
      return this.zzbaH;
    case 20: 
      return this.zzbaI;
    case 21: 
      return Integer.valueOf(this.zzbaJ);
    case 22: 
      return this.zzbaK;
    case 23: 
      return this.zzbaL;
    case 24: 
      return Integer.valueOf(this.zzbaM);
    case 25: 
      return Integer.valueOf(this.zzbaN);
    case 26: 
      return this.zzbaO;
    case 27: 
      return this.zzF;
    case 28: 
      return this.zzbaP;
    }
    return Boolean.valueOf(this.zzbaQ);
  }
  
  public static final class AgeRangeEntity
    extends FastSafeParcelableJsonResponse
    implements Person.AgeRange
  {
    public static final zzb CREATOR = new zzb();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap();
    final int mVersionCode;
    final Set<Integer> zzaZA;
    int zzbaR;
    int zzbaS;
    
    static
    {
      zzaZz.put("max", FastJsonResponse.Field.zzi("max", 2));
      zzaZz.put("min", FastJsonResponse.Field.zzi("min", 3));
    }
    
    public AgeRangeEntity()
    {
      this.mVersionCode = 1;
      this.zzaZA = new HashSet();
    }
    
    AgeRangeEntity(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3)
    {
      this.zzaZA = paramSet;
      this.mVersionCode = paramInt1;
      this.zzbaR = paramInt2;
      this.zzbaS = paramInt3;
    }
    
    public int describeContents()
    {
      zzb localzzb = CREATOR;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof AgeRangeEntity)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (AgeRangeEntity)paramObject;
      Iterator localIterator = zzaZz.values().iterator();
      while (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (zza(localField))
        {
          if (((AgeRangeEntity)paramObject).zza(localField))
          {
            if (!zzb(localField).equals(((AgeRangeEntity)paramObject).zzb(localField))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((AgeRangeEntity)paramObject).zza(localField)) {
          return false;
        }
      }
      return true;
    }
    
    public int getMax()
    {
      return this.zzbaR;
    }
    
    public int getMin()
    {
      return this.zzbaS;
    }
    
    public boolean hasMax()
    {
      return this.zzaZA.contains(Integer.valueOf(2));
    }
    
    public boolean hasMin()
    {
      return this.zzaZA.contains(Integer.valueOf(3));
    }
    
    public int hashCode()
    {
      Iterator localIterator = zzaZz.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (!zza(localField)) {
          break label68;
        }
        int j = localField.zzrc();
        i = zzb(localField).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzb localzzb = CREATOR;
      zzb.zza(this, paramParcel, paramInt);
    }
    
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzDq()
    {
      return zzaZz;
    }
    
    public AgeRangeEntity zzDv()
    {
      return this;
    }
    
    protected boolean zza(FastJsonResponse.Field paramField)
    {
      return this.zzaZA.contains(Integer.valueOf(paramField.zzrc()));
    }
    
    protected Object zzb(FastJsonResponse.Field paramField)
    {
      switch (paramField.zzrc())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzrc());
      case 2: 
        return Integer.valueOf(this.zzbaR);
      }
      return Integer.valueOf(this.zzbaS);
    }
  }
  
  public static final class CoverEntity
    extends FastSafeParcelableJsonResponse
    implements Person.Cover
  {
    public static final zzc CREATOR = new zzc();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap();
    final int mVersionCode;
    final Set<Integer> zzaZA;
    CoverInfoEntity zzbaT;
    CoverPhotoEntity zzbaU;
    int zzbaV;
    
    static
    {
      zzaZz.put("coverInfo", FastJsonResponse.Field.zza("coverInfo", 2, CoverInfoEntity.class));
      zzaZz.put("coverPhoto", FastJsonResponse.Field.zza("coverPhoto", 3, CoverPhotoEntity.class));
      zzaZz.put("layout", FastJsonResponse.Field.zza("layout", 4, new StringToIntConverter().zzh("banner", 0), false));
    }
    
    public CoverEntity()
    {
      this.mVersionCode = 1;
      this.zzaZA = new HashSet();
    }
    
    CoverEntity(Set<Integer> paramSet, int paramInt1, CoverInfoEntity paramCoverInfoEntity, CoverPhotoEntity paramCoverPhotoEntity, int paramInt2)
    {
      this.zzaZA = paramSet;
      this.mVersionCode = paramInt1;
      this.zzbaT = paramCoverInfoEntity;
      this.zzbaU = paramCoverPhotoEntity;
      this.zzbaV = paramInt2;
    }
    
    public int describeContents()
    {
      zzc localzzc = CREATOR;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof CoverEntity)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (CoverEntity)paramObject;
      Iterator localIterator = zzaZz.values().iterator();
      while (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (zza(localField))
        {
          if (((CoverEntity)paramObject).zza(localField))
          {
            if (!zzb(localField).equals(((CoverEntity)paramObject).zzb(localField))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((CoverEntity)paramObject).zza(localField)) {
          return false;
        }
      }
      return true;
    }
    
    public Person.Cover.CoverInfo getCoverInfo()
    {
      return this.zzbaT;
    }
    
    public Person.Cover.CoverPhoto getCoverPhoto()
    {
      return this.zzbaU;
    }
    
    public int getLayout()
    {
      return this.zzbaV;
    }
    
    public boolean hasCoverInfo()
    {
      return this.zzaZA.contains(Integer.valueOf(2));
    }
    
    public boolean hasCoverPhoto()
    {
      return this.zzaZA.contains(Integer.valueOf(3));
    }
    
    public boolean hasLayout()
    {
      return this.zzaZA.contains(Integer.valueOf(4));
    }
    
    public int hashCode()
    {
      Iterator localIterator = zzaZz.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (!zza(localField)) {
          break label68;
        }
        int j = localField.zzrc();
        i = zzb(localField).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzc localzzc = CREATOR;
      zzc.zza(this, paramParcel, paramInt);
    }
    
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzDq()
    {
      return zzaZz;
    }
    
    public CoverEntity zzDw()
    {
      return this;
    }
    
    protected boolean zza(FastJsonResponse.Field paramField)
    {
      return this.zzaZA.contains(Integer.valueOf(paramField.zzrc()));
    }
    
    protected Object zzb(FastJsonResponse.Field paramField)
    {
      switch (paramField.zzrc())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzrc());
      case 2: 
        return this.zzbaT;
      case 3: 
        return this.zzbaU;
      }
      return Integer.valueOf(this.zzbaV);
    }
    
    public static final class CoverInfoEntity
      extends FastSafeParcelableJsonResponse
      implements Person.Cover.CoverInfo
    {
      public static final zzd CREATOR = new zzd();
      private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap();
      final int mVersionCode;
      final Set<Integer> zzaZA;
      int zzbaW;
      int zzbaX;
      
      static
      {
        zzaZz.put("leftImageOffset", FastJsonResponse.Field.zzi("leftImageOffset", 2));
        zzaZz.put("topImageOffset", FastJsonResponse.Field.zzi("topImageOffset", 3));
      }
      
      public CoverInfoEntity()
      {
        this.mVersionCode = 1;
        this.zzaZA = new HashSet();
      }
      
      CoverInfoEntity(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3)
      {
        this.zzaZA = paramSet;
        this.mVersionCode = paramInt1;
        this.zzbaW = paramInt2;
        this.zzbaX = paramInt3;
      }
      
      public int describeContents()
      {
        zzd localzzd = CREATOR;
        return 0;
      }
      
      public boolean equals(Object paramObject)
      {
        if (!(paramObject instanceof CoverInfoEntity)) {
          return false;
        }
        if (this == paramObject) {
          return true;
        }
        paramObject = (CoverInfoEntity)paramObject;
        Iterator localIterator = zzaZz.values().iterator();
        while (localIterator.hasNext())
        {
          FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
          if (zza(localField))
          {
            if (((CoverInfoEntity)paramObject).zza(localField))
            {
              if (!zzb(localField).equals(((CoverInfoEntity)paramObject).zzb(localField))) {
                return false;
              }
            }
            else {
              return false;
            }
          }
          else if (((CoverInfoEntity)paramObject).zza(localField)) {
            return false;
          }
        }
        return true;
      }
      
      public int getLeftImageOffset()
      {
        return this.zzbaW;
      }
      
      public int getTopImageOffset()
      {
        return this.zzbaX;
      }
      
      public boolean hasLeftImageOffset()
      {
        return this.zzaZA.contains(Integer.valueOf(2));
      }
      
      public boolean hasTopImageOffset()
      {
        return this.zzaZA.contains(Integer.valueOf(3));
      }
      
      public int hashCode()
      {
        Iterator localIterator = zzaZz.values().iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
          if (!zza(localField)) {
            break label68;
          }
          int j = localField.zzrc();
          i = zzb(localField).hashCode() + (i + j);
        }
        label68:
        for (;;)
        {
          break;
          return i;
        }
      }
      
      public boolean isDataValid()
      {
        return true;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        zzd localzzd = CREATOR;
        zzd.zza(this, paramParcel, paramInt);
      }
      
      public HashMap<String, FastJsonResponse.Field<?, ?>> zzDq()
      {
        return zzaZz;
      }
      
      public CoverInfoEntity zzDx()
      {
        return this;
      }
      
      protected boolean zza(FastJsonResponse.Field paramField)
      {
        return this.zzaZA.contains(Integer.valueOf(paramField.zzrc()));
      }
      
      protected Object zzb(FastJsonResponse.Field paramField)
      {
        switch (paramField.zzrc())
        {
        default: 
          throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzrc());
        case 2: 
          return Integer.valueOf(this.zzbaW);
        }
        return Integer.valueOf(this.zzbaX);
      }
    }
    
    public static final class CoverPhotoEntity
      extends FastSafeParcelableJsonResponse
      implements Person.Cover.CoverPhoto
    {
      public static final zze CREATOR = new zze();
      private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap();
      final int mVersionCode;
      String zzF;
      final Set<Integer> zzaZA;
      int zzov;
      int zzow;
      
      static
      {
        zzaZz.put("height", FastJsonResponse.Field.zzi("height", 2));
        zzaZz.put("url", FastJsonResponse.Field.zzl("url", 3));
        zzaZz.put("width", FastJsonResponse.Field.zzi("width", 4));
      }
      
      public CoverPhotoEntity()
      {
        this.mVersionCode = 1;
        this.zzaZA = new HashSet();
      }
      
      CoverPhotoEntity(Set<Integer> paramSet, int paramInt1, int paramInt2, String paramString, int paramInt3)
      {
        this.zzaZA = paramSet;
        this.mVersionCode = paramInt1;
        this.zzow = paramInt2;
        this.zzF = paramString;
        this.zzov = paramInt3;
      }
      
      public int describeContents()
      {
        zze localzze = CREATOR;
        return 0;
      }
      
      public boolean equals(Object paramObject)
      {
        if (!(paramObject instanceof CoverPhotoEntity)) {
          return false;
        }
        if (this == paramObject) {
          return true;
        }
        paramObject = (CoverPhotoEntity)paramObject;
        Iterator localIterator = zzaZz.values().iterator();
        while (localIterator.hasNext())
        {
          FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
          if (zza(localField))
          {
            if (((CoverPhotoEntity)paramObject).zza(localField))
            {
              if (!zzb(localField).equals(((CoverPhotoEntity)paramObject).zzb(localField))) {
                return false;
              }
            }
            else {
              return false;
            }
          }
          else if (((CoverPhotoEntity)paramObject).zza(localField)) {
            return false;
          }
        }
        return true;
      }
      
      public int getHeight()
      {
        return this.zzow;
      }
      
      public String getUrl()
      {
        return this.zzF;
      }
      
      public int getWidth()
      {
        return this.zzov;
      }
      
      public boolean hasHeight()
      {
        return this.zzaZA.contains(Integer.valueOf(2));
      }
      
      public boolean hasUrl()
      {
        return this.zzaZA.contains(Integer.valueOf(3));
      }
      
      public boolean hasWidth()
      {
        return this.zzaZA.contains(Integer.valueOf(4));
      }
      
      public int hashCode()
      {
        Iterator localIterator = zzaZz.values().iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
          if (!zza(localField)) {
            break label68;
          }
          int j = localField.zzrc();
          i = zzb(localField).hashCode() + (i + j);
        }
        label68:
        for (;;)
        {
          break;
          return i;
        }
      }
      
      public boolean isDataValid()
      {
        return true;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        zze localzze = CREATOR;
        zze.zza(this, paramParcel, paramInt);
      }
      
      public HashMap<String, FastJsonResponse.Field<?, ?>> zzDq()
      {
        return zzaZz;
      }
      
      public CoverPhotoEntity zzDy()
      {
        return this;
      }
      
      protected boolean zza(FastJsonResponse.Field paramField)
      {
        return this.zzaZA.contains(Integer.valueOf(paramField.zzrc()));
      }
      
      protected Object zzb(FastJsonResponse.Field paramField)
      {
        switch (paramField.zzrc())
        {
        default: 
          throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzrc());
        case 2: 
          return Integer.valueOf(this.zzow);
        case 3: 
          return this.zzF;
        }
        return Integer.valueOf(this.zzov);
      }
    }
  }
  
  public static final class ImageEntity
    extends FastSafeParcelableJsonResponse
    implements Person.Image
  {
    public static final zzf CREATOR = new zzf();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap();
    final int mVersionCode;
    String zzF;
    final Set<Integer> zzaZA;
    
    static
    {
      zzaZz.put("url", FastJsonResponse.Field.zzl("url", 2));
    }
    
    public ImageEntity()
    {
      this.mVersionCode = 1;
      this.zzaZA = new HashSet();
    }
    
    public ImageEntity(String paramString)
    {
      this.zzaZA = new HashSet();
      this.mVersionCode = 1;
      this.zzF = paramString;
      this.zzaZA.add(Integer.valueOf(2));
    }
    
    ImageEntity(Set<Integer> paramSet, int paramInt, String paramString)
    {
      this.zzaZA = paramSet;
      this.mVersionCode = paramInt;
      this.zzF = paramString;
    }
    
    public int describeContents()
    {
      zzf localzzf = CREATOR;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof ImageEntity)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (ImageEntity)paramObject;
      Iterator localIterator = zzaZz.values().iterator();
      while (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (zza(localField))
        {
          if (((ImageEntity)paramObject).zza(localField))
          {
            if (!zzb(localField).equals(((ImageEntity)paramObject).zzb(localField))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((ImageEntity)paramObject).zza(localField)) {
          return false;
        }
      }
      return true;
    }
    
    public String getUrl()
    {
      return this.zzF;
    }
    
    public boolean hasUrl()
    {
      return this.zzaZA.contains(Integer.valueOf(2));
    }
    
    public int hashCode()
    {
      Iterator localIterator = zzaZz.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (!zza(localField)) {
          break label68;
        }
        int j = localField.zzrc();
        i = zzb(localField).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzf localzzf = CREATOR;
      zzf.zza(this, paramParcel, paramInt);
    }
    
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzDq()
    {
      return zzaZz;
    }
    
    public ImageEntity zzDz()
    {
      return this;
    }
    
    protected boolean zza(FastJsonResponse.Field paramField)
    {
      return this.zzaZA.contains(Integer.valueOf(paramField.zzrc()));
    }
    
    protected Object zzb(FastJsonResponse.Field paramField)
    {
      switch (paramField.zzrc())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzrc());
      }
      return this.zzF;
    }
  }
  
  public static final class NameEntity
    extends FastSafeParcelableJsonResponse
    implements Person.Name
  {
    public static final zzg CREATOR = new zzg();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap();
    final int mVersionCode;
    final Set<Integer> zzaZA;
    String zzaZY;
    String zzbaY;
    String zzbaZ;
    String zzbab;
    String zzbba;
    String zzbbb;
    
    static
    {
      zzaZz.put("familyName", FastJsonResponse.Field.zzl("familyName", 2));
      zzaZz.put("formatted", FastJsonResponse.Field.zzl("formatted", 3));
      zzaZz.put("givenName", FastJsonResponse.Field.zzl("givenName", 4));
      zzaZz.put("honorificPrefix", FastJsonResponse.Field.zzl("honorificPrefix", 5));
      zzaZz.put("honorificSuffix", FastJsonResponse.Field.zzl("honorificSuffix", 6));
      zzaZz.put("middleName", FastJsonResponse.Field.zzl("middleName", 7));
    }
    
    public NameEntity()
    {
      this.mVersionCode = 1;
      this.zzaZA = new HashSet();
    }
    
    NameEntity(Set<Integer> paramSet, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this.zzaZA = paramSet;
      this.mVersionCode = paramInt;
      this.zzaZY = paramString1;
      this.zzbaY = paramString2;
      this.zzbab = paramString3;
      this.zzbaZ = paramString4;
      this.zzbba = paramString5;
      this.zzbbb = paramString6;
    }
    
    public int describeContents()
    {
      zzg localzzg = CREATOR;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof NameEntity)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (NameEntity)paramObject;
      Iterator localIterator = zzaZz.values().iterator();
      while (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (zza(localField))
        {
          if (((NameEntity)paramObject).zza(localField))
          {
            if (!zzb(localField).equals(((NameEntity)paramObject).zzb(localField))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((NameEntity)paramObject).zza(localField)) {
          return false;
        }
      }
      return true;
    }
    
    public String getFamilyName()
    {
      return this.zzaZY;
    }
    
    public String getFormatted()
    {
      return this.zzbaY;
    }
    
    public String getGivenName()
    {
      return this.zzbab;
    }
    
    public String getHonorificPrefix()
    {
      return this.zzbaZ;
    }
    
    public String getHonorificSuffix()
    {
      return this.zzbba;
    }
    
    public String getMiddleName()
    {
      return this.zzbbb;
    }
    
    public boolean hasFamilyName()
    {
      return this.zzaZA.contains(Integer.valueOf(2));
    }
    
    public boolean hasFormatted()
    {
      return this.zzaZA.contains(Integer.valueOf(3));
    }
    
    public boolean hasGivenName()
    {
      return this.zzaZA.contains(Integer.valueOf(4));
    }
    
    public boolean hasHonorificPrefix()
    {
      return this.zzaZA.contains(Integer.valueOf(5));
    }
    
    public boolean hasHonorificSuffix()
    {
      return this.zzaZA.contains(Integer.valueOf(6));
    }
    
    public boolean hasMiddleName()
    {
      return this.zzaZA.contains(Integer.valueOf(7));
    }
    
    public int hashCode()
    {
      Iterator localIterator = zzaZz.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (!zza(localField)) {
          break label68;
        }
        int j = localField.zzrc();
        i = zzb(localField).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzg localzzg = CREATOR;
      zzg.zza(this, paramParcel, paramInt);
    }
    
    public NameEntity zzDA()
    {
      return this;
    }
    
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzDq()
    {
      return zzaZz;
    }
    
    protected boolean zza(FastJsonResponse.Field paramField)
    {
      return this.zzaZA.contains(Integer.valueOf(paramField.zzrc()));
    }
    
    protected Object zzb(FastJsonResponse.Field paramField)
    {
      switch (paramField.zzrc())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzrc());
      case 2: 
        return this.zzaZY;
      case 3: 
        return this.zzbaY;
      case 4: 
        return this.zzbab;
      case 5: 
        return this.zzbaZ;
      case 6: 
        return this.zzbba;
      }
      return this.zzbbb;
    }
  }
  
  public static final class OrganizationsEntity
    extends FastSafeParcelableJsonResponse
    implements Person.Organizations
  {
    public static final zzh CREATOR = new zzh();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap();
    String mName;
    final int mVersionCode;
    int zzZU;
    final Set<Integer> zzaZA;
    String zzaZX;
    String zzank;
    String zzavc;
    String zzban;
    String zzbbc;
    String zzbbd;
    boolean zzbbe;
    
    static
    {
      zzaZz.put("department", FastJsonResponse.Field.zzl("department", 2));
      zzaZz.put("description", FastJsonResponse.Field.zzl("description", 3));
      zzaZz.put("endDate", FastJsonResponse.Field.zzl("endDate", 4));
      zzaZz.put("location", FastJsonResponse.Field.zzl("location", 5));
      zzaZz.put("name", FastJsonResponse.Field.zzl("name", 6));
      zzaZz.put("primary", FastJsonResponse.Field.zzk("primary", 7));
      zzaZz.put("startDate", FastJsonResponse.Field.zzl("startDate", 8));
      zzaZz.put("title", FastJsonResponse.Field.zzl("title", 9));
      zzaZz.put("type", FastJsonResponse.Field.zza("type", 10, new StringToIntConverter().zzh("work", 0).zzh("school", 1), false));
    }
    
    public OrganizationsEntity()
    {
      this.mVersionCode = 1;
      this.zzaZA = new HashSet();
    }
    
    OrganizationsEntity(Set<Integer> paramSet, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, String paramString7, int paramInt2)
    {
      this.zzaZA = paramSet;
      this.mVersionCode = paramInt1;
      this.zzbbc = paramString1;
      this.zzavc = paramString2;
      this.zzaZX = paramString3;
      this.zzbbd = paramString4;
      this.mName = paramString5;
      this.zzbbe = paramBoolean;
      this.zzban = paramString6;
      this.zzank = paramString7;
      this.zzZU = paramInt2;
    }
    
    public int describeContents()
    {
      zzh localzzh = CREATOR;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof OrganizationsEntity)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (OrganizationsEntity)paramObject;
      Iterator localIterator = zzaZz.values().iterator();
      while (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (zza(localField))
        {
          if (((OrganizationsEntity)paramObject).zza(localField))
          {
            if (!zzb(localField).equals(((OrganizationsEntity)paramObject).zzb(localField))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((OrganizationsEntity)paramObject).zza(localField)) {
          return false;
        }
      }
      return true;
    }
    
    public String getDepartment()
    {
      return this.zzbbc;
    }
    
    public String getDescription()
    {
      return this.zzavc;
    }
    
    public String getEndDate()
    {
      return this.zzaZX;
    }
    
    public String getLocation()
    {
      return this.zzbbd;
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    public String getStartDate()
    {
      return this.zzban;
    }
    
    public String getTitle()
    {
      return this.zzank;
    }
    
    public int getType()
    {
      return this.zzZU;
    }
    
    public boolean hasDepartment()
    {
      return this.zzaZA.contains(Integer.valueOf(2));
    }
    
    public boolean hasDescription()
    {
      return this.zzaZA.contains(Integer.valueOf(3));
    }
    
    public boolean hasEndDate()
    {
      return this.zzaZA.contains(Integer.valueOf(4));
    }
    
    public boolean hasLocation()
    {
      return this.zzaZA.contains(Integer.valueOf(5));
    }
    
    public boolean hasName()
    {
      return this.zzaZA.contains(Integer.valueOf(6));
    }
    
    public boolean hasPrimary()
    {
      return this.zzaZA.contains(Integer.valueOf(7));
    }
    
    public boolean hasStartDate()
    {
      return this.zzaZA.contains(Integer.valueOf(8));
    }
    
    public boolean hasTitle()
    {
      return this.zzaZA.contains(Integer.valueOf(9));
    }
    
    public boolean hasType()
    {
      return this.zzaZA.contains(Integer.valueOf(10));
    }
    
    public int hashCode()
    {
      Iterator localIterator = zzaZz.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (!zza(localField)) {
          break label68;
        }
        int j = localField.zzrc();
        i = zzb(localField).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public boolean isPrimary()
    {
      return this.zzbbe;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzh localzzh = CREATOR;
      zzh.zza(this, paramParcel, paramInt);
    }
    
    public OrganizationsEntity zzDB()
    {
      return this;
    }
    
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzDq()
    {
      return zzaZz;
    }
    
    protected boolean zza(FastJsonResponse.Field paramField)
    {
      return this.zzaZA.contains(Integer.valueOf(paramField.zzrc()));
    }
    
    protected Object zzb(FastJsonResponse.Field paramField)
    {
      switch (paramField.zzrc())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzrc());
      case 2: 
        return this.zzbbc;
      case 3: 
        return this.zzavc;
      case 4: 
        return this.zzaZX;
      case 5: 
        return this.zzbbd;
      case 6: 
        return this.mName;
      case 7: 
        return Boolean.valueOf(this.zzbbe);
      case 8: 
        return this.zzban;
      case 9: 
        return this.zzank;
      }
      return Integer.valueOf(this.zzZU);
    }
  }
  
  public static final class PlacesLivedEntity
    extends FastSafeParcelableJsonResponse
    implements Person.PlacesLived
  {
    public static final zzi CREATOR = new zzi();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap();
    String mValue;
    final int mVersionCode;
    final Set<Integer> zzaZA;
    boolean zzbbe;
    
    static
    {
      zzaZz.put("primary", FastJsonResponse.Field.zzk("primary", 2));
      zzaZz.put("value", FastJsonResponse.Field.zzl("value", 3));
    }
    
    public PlacesLivedEntity()
    {
      this.mVersionCode = 1;
      this.zzaZA = new HashSet();
    }
    
    PlacesLivedEntity(Set<Integer> paramSet, int paramInt, boolean paramBoolean, String paramString)
    {
      this.zzaZA = paramSet;
      this.mVersionCode = paramInt;
      this.zzbbe = paramBoolean;
      this.mValue = paramString;
    }
    
    public int describeContents()
    {
      zzi localzzi = CREATOR;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof PlacesLivedEntity)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (PlacesLivedEntity)paramObject;
      Iterator localIterator = zzaZz.values().iterator();
      while (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (zza(localField))
        {
          if (((PlacesLivedEntity)paramObject).zza(localField))
          {
            if (!zzb(localField).equals(((PlacesLivedEntity)paramObject).zzb(localField))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((PlacesLivedEntity)paramObject).zza(localField)) {
          return false;
        }
      }
      return true;
    }
    
    public String getValue()
    {
      return this.mValue;
    }
    
    public boolean hasPrimary()
    {
      return this.zzaZA.contains(Integer.valueOf(2));
    }
    
    public boolean hasValue()
    {
      return this.zzaZA.contains(Integer.valueOf(3));
    }
    
    public int hashCode()
    {
      Iterator localIterator = zzaZz.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (!zza(localField)) {
          break label68;
        }
        int j = localField.zzrc();
        i = zzb(localField).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public boolean isPrimary()
    {
      return this.zzbbe;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzi localzzi = CREATOR;
      zzi.zza(this, paramParcel, paramInt);
    }
    
    public PlacesLivedEntity zzDC()
    {
      return this;
    }
    
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzDq()
    {
      return zzaZz;
    }
    
    protected boolean zza(FastJsonResponse.Field paramField)
    {
      return this.zzaZA.contains(Integer.valueOf(paramField.zzrc()));
    }
    
    protected Object zzb(FastJsonResponse.Field paramField)
    {
      switch (paramField.zzrc())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzrc());
      case 2: 
        return Boolean.valueOf(this.zzbbe);
      }
      return this.mValue;
    }
  }
  
  public static final class UrlsEntity
    extends FastSafeParcelableJsonResponse
    implements Person.Urls
  {
    public static final zzj CREATOR = new zzj();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap();
    String mValue;
    final int mVersionCode;
    int zzZU;
    String zzaRQ;
    final Set<Integer> zzaZA;
    private final int zzbbf = 4;
    
    static
    {
      zzaZz.put("label", FastJsonResponse.Field.zzl("label", 5));
      zzaZz.put("type", FastJsonResponse.Field.zza("type", 6, new StringToIntConverter().zzh("home", 0).zzh("work", 1).zzh("blog", 2).zzh("profile", 3).zzh("other", 4).zzh("otherProfile", 5).zzh("contributor", 6).zzh("website", 7), false));
      zzaZz.put("value", FastJsonResponse.Field.zzl("value", 4));
    }
    
    public UrlsEntity()
    {
      this.mVersionCode = 1;
      this.zzaZA = new HashSet();
    }
    
    UrlsEntity(Set<Integer> paramSet, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
    {
      this.zzaZA = paramSet;
      this.mVersionCode = paramInt1;
      this.zzaRQ = paramString1;
      this.zzZU = paramInt2;
      this.mValue = paramString2;
    }
    
    public int describeContents()
    {
      zzj localzzj = CREATOR;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof UrlsEntity)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (UrlsEntity)paramObject;
      Iterator localIterator = zzaZz.values().iterator();
      while (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (zza(localField))
        {
          if (((UrlsEntity)paramObject).zza(localField))
          {
            if (!zzb(localField).equals(((UrlsEntity)paramObject).zzb(localField))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((UrlsEntity)paramObject).zza(localField)) {
          return false;
        }
      }
      return true;
    }
    
    public String getLabel()
    {
      return this.zzaRQ;
    }
    
    public int getType()
    {
      return this.zzZU;
    }
    
    public String getValue()
    {
      return this.mValue;
    }
    
    public boolean hasLabel()
    {
      return this.zzaZA.contains(Integer.valueOf(5));
    }
    
    public boolean hasType()
    {
      return this.zzaZA.contains(Integer.valueOf(6));
    }
    
    public boolean hasValue()
    {
      return this.zzaZA.contains(Integer.valueOf(4));
    }
    
    public int hashCode()
    {
      Iterator localIterator = zzaZz.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (!zza(localField)) {
          break label68;
        }
        int j = localField.zzrc();
        i = zzb(localField).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzj localzzj = CREATOR;
      zzj.zza(this, paramParcel, paramInt);
    }
    
    @Deprecated
    public int zzDD()
    {
      return 4;
    }
    
    public UrlsEntity zzDE()
    {
      return this;
    }
    
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzDq()
    {
      return zzaZz;
    }
    
    protected boolean zza(FastJsonResponse.Field paramField)
    {
      return this.zzaZA.contains(Integer.valueOf(paramField.zzrc()));
    }
    
    protected Object zzb(FastJsonResponse.Field paramField)
    {
      switch (paramField.zzrc())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzrc());
      case 5: 
        return this.zzaRQ;
      case 6: 
        return Integer.valueOf(this.zzZU);
      }
      return this.mValue;
    }
  }
  
  public static class zza
  {
    public static int zzeT(String paramString)
    {
      if (paramString.equals("person")) {
        return 0;
      }
      if (paramString.equals("page")) {
        return 1;
      }
      throw new IllegalArgumentException("Unknown objectType string: " + paramString);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/internal/model/people/PersonEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */