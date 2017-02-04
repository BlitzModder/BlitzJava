package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ItemScopeEntity
  extends FastSafeParcelableJsonResponse
  implements ItemScope
{
  public static final zza CREATOR = new zza();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap();
  String mName;
  final int mVersionCode;
  String zzF;
  String zzIx;
  double zzaKR;
  double zzaKS;
  final Set<Integer> zzaZA;
  ItemScopeEntity zzaZB;
  List<String> zzaZC;
  ItemScopeEntity zzaZD;
  String zzaZE;
  String zzaZF;
  String zzaZG;
  List<ItemScopeEntity> zzaZH;
  int zzaZI;
  List<ItemScopeEntity> zzaZJ;
  ItemScopeEntity zzaZK;
  List<ItemScopeEntity> zzaZL;
  String zzaZM;
  String zzaZN;
  ItemScopeEntity zzaZO;
  String zzaZP;
  String zzaZQ;
  List<ItemScopeEntity> zzaZR;
  String zzaZS;
  String zzaZT;
  String zzaZU;
  String zzaZV;
  String zzaZW;
  String zzaZX;
  String zzaZY;
  String zzaZZ;
  String zzavc;
  ItemScopeEntity zzbaa;
  String zzbab;
  String zzbac;
  String zzbad;
  ItemScopeEntity zzbae;
  ItemScopeEntity zzbaf;
  ItemScopeEntity zzbag;
  List<ItemScopeEntity> zzbah;
  String zzbai;
  String zzbaj;
  String zzbak;
  String zzbal;
  ItemScopeEntity zzbam;
  String zzban;
  String zzbao;
  String zzbap;
  ItemScopeEntity zzbaq;
  String zzbar;
  String zzbas;
  String zzbat;
  String zzbau;
  String zztN;
  String zzxX;
  
  static
  {
    zzaZz.put("about", FastJsonResponse.Field.zza("about", 2, ItemScopeEntity.class));
    zzaZz.put("additionalName", FastJsonResponse.Field.zzm("additionalName", 3));
    zzaZz.put("address", FastJsonResponse.Field.zza("address", 4, ItemScopeEntity.class));
    zzaZz.put("addressCountry", FastJsonResponse.Field.zzl("addressCountry", 5));
    zzaZz.put("addressLocality", FastJsonResponse.Field.zzl("addressLocality", 6));
    zzaZz.put("addressRegion", FastJsonResponse.Field.zzl("addressRegion", 7));
    zzaZz.put("associated_media", FastJsonResponse.Field.zzb("associated_media", 8, ItemScopeEntity.class));
    zzaZz.put("attendeeCount", FastJsonResponse.Field.zzi("attendeeCount", 9));
    zzaZz.put("attendees", FastJsonResponse.Field.zzb("attendees", 10, ItemScopeEntity.class));
    zzaZz.put("audio", FastJsonResponse.Field.zza("audio", 11, ItemScopeEntity.class));
    zzaZz.put("author", FastJsonResponse.Field.zzb("author", 12, ItemScopeEntity.class));
    zzaZz.put("bestRating", FastJsonResponse.Field.zzl("bestRating", 13));
    zzaZz.put("birthDate", FastJsonResponse.Field.zzl("birthDate", 14));
    zzaZz.put("byArtist", FastJsonResponse.Field.zza("byArtist", 15, ItemScopeEntity.class));
    zzaZz.put("caption", FastJsonResponse.Field.zzl("caption", 16));
    zzaZz.put("contentSize", FastJsonResponse.Field.zzl("contentSize", 17));
    zzaZz.put("contentUrl", FastJsonResponse.Field.zzl("contentUrl", 18));
    zzaZz.put("contributor", FastJsonResponse.Field.zzb("contributor", 19, ItemScopeEntity.class));
    zzaZz.put("dateCreated", FastJsonResponse.Field.zzl("dateCreated", 20));
    zzaZz.put("dateModified", FastJsonResponse.Field.zzl("dateModified", 21));
    zzaZz.put("datePublished", FastJsonResponse.Field.zzl("datePublished", 22));
    zzaZz.put("description", FastJsonResponse.Field.zzl("description", 23));
    zzaZz.put("duration", FastJsonResponse.Field.zzl("duration", 24));
    zzaZz.put("embedUrl", FastJsonResponse.Field.zzl("embedUrl", 25));
    zzaZz.put("endDate", FastJsonResponse.Field.zzl("endDate", 26));
    zzaZz.put("familyName", FastJsonResponse.Field.zzl("familyName", 27));
    zzaZz.put("gender", FastJsonResponse.Field.zzl("gender", 28));
    zzaZz.put("geo", FastJsonResponse.Field.zza("geo", 29, ItemScopeEntity.class));
    zzaZz.put("givenName", FastJsonResponse.Field.zzl("givenName", 30));
    zzaZz.put("height", FastJsonResponse.Field.zzl("height", 31));
    zzaZz.put("id", FastJsonResponse.Field.zzl("id", 32));
    zzaZz.put("image", FastJsonResponse.Field.zzl("image", 33));
    zzaZz.put("inAlbum", FastJsonResponse.Field.zza("inAlbum", 34, ItemScopeEntity.class));
    zzaZz.put("latitude", FastJsonResponse.Field.zzj("latitude", 36));
    zzaZz.put("location", FastJsonResponse.Field.zza("location", 37, ItemScopeEntity.class));
    zzaZz.put("longitude", FastJsonResponse.Field.zzj("longitude", 38));
    zzaZz.put("name", FastJsonResponse.Field.zzl("name", 39));
    zzaZz.put("partOfTVSeries", FastJsonResponse.Field.zza("partOfTVSeries", 40, ItemScopeEntity.class));
    zzaZz.put("performers", FastJsonResponse.Field.zzb("performers", 41, ItemScopeEntity.class));
    zzaZz.put("playerType", FastJsonResponse.Field.zzl("playerType", 42));
    zzaZz.put("postOfficeBoxNumber", FastJsonResponse.Field.zzl("postOfficeBoxNumber", 43));
    zzaZz.put("postalCode", FastJsonResponse.Field.zzl("postalCode", 44));
    zzaZz.put("ratingValue", FastJsonResponse.Field.zzl("ratingValue", 45));
    zzaZz.put("reviewRating", FastJsonResponse.Field.zza("reviewRating", 46, ItemScopeEntity.class));
    zzaZz.put("startDate", FastJsonResponse.Field.zzl("startDate", 47));
    zzaZz.put("streetAddress", FastJsonResponse.Field.zzl("streetAddress", 48));
    zzaZz.put("text", FastJsonResponse.Field.zzl("text", 49));
    zzaZz.put("thumbnail", FastJsonResponse.Field.zza("thumbnail", 50, ItemScopeEntity.class));
    zzaZz.put("thumbnailUrl", FastJsonResponse.Field.zzl("thumbnailUrl", 51));
    zzaZz.put("tickerSymbol", FastJsonResponse.Field.zzl("tickerSymbol", 52));
    zzaZz.put("type", FastJsonResponse.Field.zzl("type", 53));
    zzaZz.put("url", FastJsonResponse.Field.zzl("url", 54));
    zzaZz.put("width", FastJsonResponse.Field.zzl("width", 55));
    zzaZz.put("worstRating", FastJsonResponse.Field.zzl("worstRating", 56));
  }
  
  public ItemScopeEntity()
  {
    this.mVersionCode = 1;
    this.zzaZA = new HashSet();
  }
  
  ItemScopeEntity(Set<Integer> paramSet, int paramInt1, ItemScopeEntity paramItemScopeEntity1, List<String> paramList, ItemScopeEntity paramItemScopeEntity2, String paramString1, String paramString2, String paramString3, List<ItemScopeEntity> paramList1, int paramInt2, List<ItemScopeEntity> paramList2, ItemScopeEntity paramItemScopeEntity3, List<ItemScopeEntity> paramList3, String paramString4, String paramString5, ItemScopeEntity paramItemScopeEntity4, String paramString6, String paramString7, String paramString8, List<ItemScopeEntity> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, ItemScopeEntity paramItemScopeEntity5, String paramString18, String paramString19, String paramString20, String paramString21, ItemScopeEntity paramItemScopeEntity6, double paramDouble1, ItemScopeEntity paramItemScopeEntity7, double paramDouble2, String paramString22, ItemScopeEntity paramItemScopeEntity8, List<ItemScopeEntity> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, ItemScopeEntity paramItemScopeEntity9, String paramString27, String paramString28, String paramString29, ItemScopeEntity paramItemScopeEntity10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.zzaZA = paramSet;
    this.mVersionCode = paramInt1;
    this.zzaZB = paramItemScopeEntity1;
    this.zzaZC = paramList;
    this.zzaZD = paramItemScopeEntity2;
    this.zzaZE = paramString1;
    this.zzaZF = paramString2;
    this.zzaZG = paramString3;
    this.zzaZH = paramList1;
    this.zzaZI = paramInt2;
    this.zzaZJ = paramList2;
    this.zzaZK = paramItemScopeEntity3;
    this.zzaZL = paramList3;
    this.zzaZM = paramString4;
    this.zzaZN = paramString5;
    this.zzaZO = paramItemScopeEntity4;
    this.zzaZP = paramString6;
    this.zzaZQ = paramString7;
    this.zztN = paramString8;
    this.zzaZR = paramList4;
    this.zzaZS = paramString9;
    this.zzaZT = paramString10;
    this.zzaZU = paramString11;
    this.zzavc = paramString12;
    this.zzaZV = paramString13;
    this.zzaZW = paramString14;
    this.zzaZX = paramString15;
    this.zzaZY = paramString16;
    this.zzaZZ = paramString17;
    this.zzbaa = paramItemScopeEntity5;
    this.zzbab = paramString18;
    this.zzbac = paramString19;
    this.zzxX = paramString20;
    this.zzbad = paramString21;
    this.zzbae = paramItemScopeEntity6;
    this.zzaKR = paramDouble1;
    this.zzbaf = paramItemScopeEntity7;
    this.zzaKS = paramDouble2;
    this.mName = paramString22;
    this.zzbag = paramItemScopeEntity8;
    this.zzbah = paramList5;
    this.zzbai = paramString23;
    this.zzbaj = paramString24;
    this.zzbak = paramString25;
    this.zzbal = paramString26;
    this.zzbam = paramItemScopeEntity9;
    this.zzban = paramString27;
    this.zzbao = paramString28;
    this.zzbap = paramString29;
    this.zzbaq = paramItemScopeEntity10;
    this.zzbar = paramString30;
    this.zzbas = paramString31;
    this.zzIx = paramString32;
    this.zzF = paramString33;
    this.zzbat = paramString34;
    this.zzbau = paramString35;
  }
  
  public ItemScopeEntity(Set<Integer> paramSet, ItemScopeEntity paramItemScopeEntity1, List<String> paramList, ItemScopeEntity paramItemScopeEntity2, String paramString1, String paramString2, String paramString3, List<ItemScopeEntity> paramList1, int paramInt, List<ItemScopeEntity> paramList2, ItemScopeEntity paramItemScopeEntity3, List<ItemScopeEntity> paramList3, String paramString4, String paramString5, ItemScopeEntity paramItemScopeEntity4, String paramString6, String paramString7, String paramString8, List<ItemScopeEntity> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, ItemScopeEntity paramItemScopeEntity5, String paramString18, String paramString19, String paramString20, String paramString21, ItemScopeEntity paramItemScopeEntity6, double paramDouble1, ItemScopeEntity paramItemScopeEntity7, double paramDouble2, String paramString22, ItemScopeEntity paramItemScopeEntity8, List<ItemScopeEntity> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, ItemScopeEntity paramItemScopeEntity9, String paramString27, String paramString28, String paramString29, ItemScopeEntity paramItemScopeEntity10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.zzaZA = paramSet;
    this.mVersionCode = 1;
    this.zzaZB = paramItemScopeEntity1;
    this.zzaZC = paramList;
    this.zzaZD = paramItemScopeEntity2;
    this.zzaZE = paramString1;
    this.zzaZF = paramString2;
    this.zzaZG = paramString3;
    this.zzaZH = paramList1;
    this.zzaZI = paramInt;
    this.zzaZJ = paramList2;
    this.zzaZK = paramItemScopeEntity3;
    this.zzaZL = paramList3;
    this.zzaZM = paramString4;
    this.zzaZN = paramString5;
    this.zzaZO = paramItemScopeEntity4;
    this.zzaZP = paramString6;
    this.zzaZQ = paramString7;
    this.zztN = paramString8;
    this.zzaZR = paramList4;
    this.zzaZS = paramString9;
    this.zzaZT = paramString10;
    this.zzaZU = paramString11;
    this.zzavc = paramString12;
    this.zzaZV = paramString13;
    this.zzaZW = paramString14;
    this.zzaZX = paramString15;
    this.zzaZY = paramString16;
    this.zzaZZ = paramString17;
    this.zzbaa = paramItemScopeEntity5;
    this.zzbab = paramString18;
    this.zzbac = paramString19;
    this.zzxX = paramString20;
    this.zzbad = paramString21;
    this.zzbae = paramItemScopeEntity6;
    this.zzaKR = paramDouble1;
    this.zzbaf = paramItemScopeEntity7;
    this.zzaKS = paramDouble2;
    this.mName = paramString22;
    this.zzbag = paramItemScopeEntity8;
    this.zzbah = paramList5;
    this.zzbai = paramString23;
    this.zzbaj = paramString24;
    this.zzbak = paramString25;
    this.zzbal = paramString26;
    this.zzbam = paramItemScopeEntity9;
    this.zzban = paramString27;
    this.zzbao = paramString28;
    this.zzbap = paramString29;
    this.zzbaq = paramItemScopeEntity10;
    this.zzbar = paramString30;
    this.zzbas = paramString31;
    this.zzIx = paramString32;
    this.zzF = paramString33;
    this.zzbat = paramString34;
    this.zzbau = paramString35;
  }
  
  public int describeContents()
  {
    zza localzza = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ItemScopeEntity)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (ItemScopeEntity)paramObject;
    Iterator localIterator = zzaZz.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (zza(localField))
      {
        if (((ItemScopeEntity)paramObject).zza(localField))
        {
          if (!zzb(localField).equals(((ItemScopeEntity)paramObject).zzb(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((ItemScopeEntity)paramObject).zza(localField)) {
        return false;
      }
    }
    return true;
  }
  
  public ItemScope getAbout()
  {
    return this.zzaZB;
  }
  
  public List<String> getAdditionalName()
  {
    return this.zzaZC;
  }
  
  public ItemScope getAddress()
  {
    return this.zzaZD;
  }
  
  public String getAddressCountry()
  {
    return this.zzaZE;
  }
  
  public String getAddressLocality()
  {
    return this.zzaZF;
  }
  
  public String getAddressRegion()
  {
    return this.zzaZG;
  }
  
  public List<ItemScope> getAssociated_media()
  {
    return (ArrayList)this.zzaZH;
  }
  
  public int getAttendeeCount()
  {
    return this.zzaZI;
  }
  
  public List<ItemScope> getAttendees()
  {
    return (ArrayList)this.zzaZJ;
  }
  
  public ItemScope getAudio()
  {
    return this.zzaZK;
  }
  
  public List<ItemScope> getAuthor()
  {
    return (ArrayList)this.zzaZL;
  }
  
  public String getBestRating()
  {
    return this.zzaZM;
  }
  
  public String getBirthDate()
  {
    return this.zzaZN;
  }
  
  public ItemScope getByArtist()
  {
    return this.zzaZO;
  }
  
  public String getCaption()
  {
    return this.zzaZP;
  }
  
  public String getContentSize()
  {
    return this.zzaZQ;
  }
  
  public String getContentUrl()
  {
    return this.zztN;
  }
  
  public List<ItemScope> getContributor()
  {
    return (ArrayList)this.zzaZR;
  }
  
  public String getDateCreated()
  {
    return this.zzaZS;
  }
  
  public String getDateModified()
  {
    return this.zzaZT;
  }
  
  public String getDatePublished()
  {
    return this.zzaZU;
  }
  
  public String getDescription()
  {
    return this.zzavc;
  }
  
  public String getDuration()
  {
    return this.zzaZV;
  }
  
  public String getEmbedUrl()
  {
    return this.zzaZW;
  }
  
  public String getEndDate()
  {
    return this.zzaZX;
  }
  
  public String getFamilyName()
  {
    return this.zzaZY;
  }
  
  public String getGender()
  {
    return this.zzaZZ;
  }
  
  public ItemScope getGeo()
  {
    return this.zzbaa;
  }
  
  public String getGivenName()
  {
    return this.zzbab;
  }
  
  public String getHeight()
  {
    return this.zzbac;
  }
  
  public String getId()
  {
    return this.zzxX;
  }
  
  public String getImage()
  {
    return this.zzbad;
  }
  
  public ItemScope getInAlbum()
  {
    return this.zzbae;
  }
  
  public double getLatitude()
  {
    return this.zzaKR;
  }
  
  public ItemScope getLocation()
  {
    return this.zzbaf;
  }
  
  public double getLongitude()
  {
    return this.zzaKS;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public ItemScope getPartOfTVSeries()
  {
    return this.zzbag;
  }
  
  public List<ItemScope> getPerformers()
  {
    return (ArrayList)this.zzbah;
  }
  
  public String getPlayerType()
  {
    return this.zzbai;
  }
  
  public String getPostOfficeBoxNumber()
  {
    return this.zzbaj;
  }
  
  public String getPostalCode()
  {
    return this.zzbak;
  }
  
  public String getRatingValue()
  {
    return this.zzbal;
  }
  
  public ItemScope getReviewRating()
  {
    return this.zzbam;
  }
  
  public String getStartDate()
  {
    return this.zzban;
  }
  
  public String getStreetAddress()
  {
    return this.zzbao;
  }
  
  public String getText()
  {
    return this.zzbap;
  }
  
  public ItemScope getThumbnail()
  {
    return this.zzbaq;
  }
  
  public String getThumbnailUrl()
  {
    return this.zzbar;
  }
  
  public String getTickerSymbol()
  {
    return this.zzbas;
  }
  
  public String getType()
  {
    return this.zzIx;
  }
  
  public String getUrl()
  {
    return this.zzF;
  }
  
  public String getWidth()
  {
    return this.zzbat;
  }
  
  public String getWorstRating()
  {
    return this.zzbau;
  }
  
  public boolean hasAbout()
  {
    return this.zzaZA.contains(Integer.valueOf(2));
  }
  
  public boolean hasAdditionalName()
  {
    return this.zzaZA.contains(Integer.valueOf(3));
  }
  
  public boolean hasAddress()
  {
    return this.zzaZA.contains(Integer.valueOf(4));
  }
  
  public boolean hasAddressCountry()
  {
    return this.zzaZA.contains(Integer.valueOf(5));
  }
  
  public boolean hasAddressLocality()
  {
    return this.zzaZA.contains(Integer.valueOf(6));
  }
  
  public boolean hasAddressRegion()
  {
    return this.zzaZA.contains(Integer.valueOf(7));
  }
  
  public boolean hasAssociated_media()
  {
    return this.zzaZA.contains(Integer.valueOf(8));
  }
  
  public boolean hasAttendeeCount()
  {
    return this.zzaZA.contains(Integer.valueOf(9));
  }
  
  public boolean hasAttendees()
  {
    return this.zzaZA.contains(Integer.valueOf(10));
  }
  
  public boolean hasAudio()
  {
    return this.zzaZA.contains(Integer.valueOf(11));
  }
  
  public boolean hasAuthor()
  {
    return this.zzaZA.contains(Integer.valueOf(12));
  }
  
  public boolean hasBestRating()
  {
    return this.zzaZA.contains(Integer.valueOf(13));
  }
  
  public boolean hasBirthDate()
  {
    return this.zzaZA.contains(Integer.valueOf(14));
  }
  
  public boolean hasByArtist()
  {
    return this.zzaZA.contains(Integer.valueOf(15));
  }
  
  public boolean hasCaption()
  {
    return this.zzaZA.contains(Integer.valueOf(16));
  }
  
  public boolean hasContentSize()
  {
    return this.zzaZA.contains(Integer.valueOf(17));
  }
  
  public boolean hasContentUrl()
  {
    return this.zzaZA.contains(Integer.valueOf(18));
  }
  
  public boolean hasContributor()
  {
    return this.zzaZA.contains(Integer.valueOf(19));
  }
  
  public boolean hasDateCreated()
  {
    return this.zzaZA.contains(Integer.valueOf(20));
  }
  
  public boolean hasDateModified()
  {
    return this.zzaZA.contains(Integer.valueOf(21));
  }
  
  public boolean hasDatePublished()
  {
    return this.zzaZA.contains(Integer.valueOf(22));
  }
  
  public boolean hasDescription()
  {
    return this.zzaZA.contains(Integer.valueOf(23));
  }
  
  public boolean hasDuration()
  {
    return this.zzaZA.contains(Integer.valueOf(24));
  }
  
  public boolean hasEmbedUrl()
  {
    return this.zzaZA.contains(Integer.valueOf(25));
  }
  
  public boolean hasEndDate()
  {
    return this.zzaZA.contains(Integer.valueOf(26));
  }
  
  public boolean hasFamilyName()
  {
    return this.zzaZA.contains(Integer.valueOf(27));
  }
  
  public boolean hasGender()
  {
    return this.zzaZA.contains(Integer.valueOf(28));
  }
  
  public boolean hasGeo()
  {
    return this.zzaZA.contains(Integer.valueOf(29));
  }
  
  public boolean hasGivenName()
  {
    return this.zzaZA.contains(Integer.valueOf(30));
  }
  
  public boolean hasHeight()
  {
    return this.zzaZA.contains(Integer.valueOf(31));
  }
  
  public boolean hasId()
  {
    return this.zzaZA.contains(Integer.valueOf(32));
  }
  
  public boolean hasImage()
  {
    return this.zzaZA.contains(Integer.valueOf(33));
  }
  
  public boolean hasInAlbum()
  {
    return this.zzaZA.contains(Integer.valueOf(34));
  }
  
  public boolean hasLatitude()
  {
    return this.zzaZA.contains(Integer.valueOf(36));
  }
  
  public boolean hasLocation()
  {
    return this.zzaZA.contains(Integer.valueOf(37));
  }
  
  public boolean hasLongitude()
  {
    return this.zzaZA.contains(Integer.valueOf(38));
  }
  
  public boolean hasName()
  {
    return this.zzaZA.contains(Integer.valueOf(39));
  }
  
  public boolean hasPartOfTVSeries()
  {
    return this.zzaZA.contains(Integer.valueOf(40));
  }
  
  public boolean hasPerformers()
  {
    return this.zzaZA.contains(Integer.valueOf(41));
  }
  
  public boolean hasPlayerType()
  {
    return this.zzaZA.contains(Integer.valueOf(42));
  }
  
  public boolean hasPostOfficeBoxNumber()
  {
    return this.zzaZA.contains(Integer.valueOf(43));
  }
  
  public boolean hasPostalCode()
  {
    return this.zzaZA.contains(Integer.valueOf(44));
  }
  
  public boolean hasRatingValue()
  {
    return this.zzaZA.contains(Integer.valueOf(45));
  }
  
  public boolean hasReviewRating()
  {
    return this.zzaZA.contains(Integer.valueOf(46));
  }
  
  public boolean hasStartDate()
  {
    return this.zzaZA.contains(Integer.valueOf(47));
  }
  
  public boolean hasStreetAddress()
  {
    return this.zzaZA.contains(Integer.valueOf(48));
  }
  
  public boolean hasText()
  {
    return this.zzaZA.contains(Integer.valueOf(49));
  }
  
  public boolean hasThumbnail()
  {
    return this.zzaZA.contains(Integer.valueOf(50));
  }
  
  public boolean hasThumbnailUrl()
  {
    return this.zzaZA.contains(Integer.valueOf(51));
  }
  
  public boolean hasTickerSymbol()
  {
    return this.zzaZA.contains(Integer.valueOf(52));
  }
  
  public boolean hasType()
  {
    return this.zzaZA.contains(Integer.valueOf(53));
  }
  
  public boolean hasUrl()
  {
    return this.zzaZA.contains(Integer.valueOf(54));
  }
  
  public boolean hasWidth()
  {
    return this.zzaZA.contains(Integer.valueOf(55));
  }
  
  public boolean hasWorstRating()
  {
    return this.zzaZA.contains(Integer.valueOf(56));
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
    zza localzza = CREATOR;
    zza.zza(this, paramParcel, paramInt);
  }
  
  public HashMap<String, FastJsonResponse.Field<?, ?>> zzDq()
  {
    return zzaZz;
  }
  
  public ItemScopeEntity zzDr()
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
    case 35: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzrc());
    case 2: 
      return this.zzaZB;
    case 3: 
      return this.zzaZC;
    case 4: 
      return this.zzaZD;
    case 5: 
      return this.zzaZE;
    case 6: 
      return this.zzaZF;
    case 7: 
      return this.zzaZG;
    case 8: 
      return this.zzaZH;
    case 9: 
      return Integer.valueOf(this.zzaZI);
    case 10: 
      return this.zzaZJ;
    case 11: 
      return this.zzaZK;
    case 12: 
      return this.zzaZL;
    case 13: 
      return this.zzaZM;
    case 14: 
      return this.zzaZN;
    case 15: 
      return this.zzaZO;
    case 16: 
      return this.zzaZP;
    case 17: 
      return this.zzaZQ;
    case 18: 
      return this.zztN;
    case 19: 
      return this.zzaZR;
    case 20: 
      return this.zzaZS;
    case 21: 
      return this.zzaZT;
    case 22: 
      return this.zzaZU;
    case 23: 
      return this.zzavc;
    case 24: 
      return this.zzaZV;
    case 25: 
      return this.zzaZW;
    case 26: 
      return this.zzaZX;
    case 27: 
      return this.zzaZY;
    case 28: 
      return this.zzaZZ;
    case 29: 
      return this.zzbaa;
    case 30: 
      return this.zzbab;
    case 31: 
      return this.zzbac;
    case 32: 
      return this.zzxX;
    case 33: 
      return this.zzbad;
    case 34: 
      return this.zzbae;
    case 36: 
      return Double.valueOf(this.zzaKR);
    case 37: 
      return this.zzbaf;
    case 38: 
      return Double.valueOf(this.zzaKS);
    case 39: 
      return this.mName;
    case 40: 
      return this.zzbag;
    case 41: 
      return this.zzbah;
    case 42: 
      return this.zzbai;
    case 43: 
      return this.zzbaj;
    case 44: 
      return this.zzbak;
    case 45: 
      return this.zzbal;
    case 46: 
      return this.zzbam;
    case 47: 
      return this.zzban;
    case 48: 
      return this.zzbao;
    case 49: 
      return this.zzbap;
    case 50: 
      return this.zzbaq;
    case 51: 
      return this.zzbar;
    case 52: 
      return this.zzbas;
    case 53: 
      return this.zzIx;
    case 54: 
      return this.zzF;
    case 55: 
      return this.zzbat;
    }
    return this.zzbau;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/internal/model/moments/ItemScopeEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */