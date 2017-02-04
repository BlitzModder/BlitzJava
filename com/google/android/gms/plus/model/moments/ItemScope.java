package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract interface ItemScope
  extends Freezable<ItemScope>
{
  public abstract ItemScope getAbout();
  
  public abstract List<String> getAdditionalName();
  
  public abstract ItemScope getAddress();
  
  public abstract String getAddressCountry();
  
  public abstract String getAddressLocality();
  
  public abstract String getAddressRegion();
  
  public abstract List<ItemScope> getAssociated_media();
  
  public abstract int getAttendeeCount();
  
  public abstract List<ItemScope> getAttendees();
  
  public abstract ItemScope getAudio();
  
  public abstract List<ItemScope> getAuthor();
  
  public abstract String getBestRating();
  
  public abstract String getBirthDate();
  
  public abstract ItemScope getByArtist();
  
  public abstract String getCaption();
  
  public abstract String getContentSize();
  
  public abstract String getContentUrl();
  
  public abstract List<ItemScope> getContributor();
  
  public abstract String getDateCreated();
  
  public abstract String getDateModified();
  
  public abstract String getDatePublished();
  
  public abstract String getDescription();
  
  public abstract String getDuration();
  
  public abstract String getEmbedUrl();
  
  public abstract String getEndDate();
  
  public abstract String getFamilyName();
  
  public abstract String getGender();
  
  public abstract ItemScope getGeo();
  
  public abstract String getGivenName();
  
  public abstract String getHeight();
  
  public abstract String getId();
  
  public abstract String getImage();
  
  public abstract ItemScope getInAlbum();
  
  public abstract double getLatitude();
  
  public abstract ItemScope getLocation();
  
  public abstract double getLongitude();
  
  public abstract String getName();
  
  public abstract ItemScope getPartOfTVSeries();
  
  public abstract List<ItemScope> getPerformers();
  
  public abstract String getPlayerType();
  
  public abstract String getPostOfficeBoxNumber();
  
  public abstract String getPostalCode();
  
  public abstract String getRatingValue();
  
  public abstract ItemScope getReviewRating();
  
  public abstract String getStartDate();
  
  public abstract String getStreetAddress();
  
  public abstract String getText();
  
  public abstract ItemScope getThumbnail();
  
  public abstract String getThumbnailUrl();
  
  public abstract String getTickerSymbol();
  
  public abstract String getType();
  
  public abstract String getUrl();
  
  public abstract String getWidth();
  
  public abstract String getWorstRating();
  
  public abstract boolean hasAbout();
  
  public abstract boolean hasAdditionalName();
  
  public abstract boolean hasAddress();
  
  public abstract boolean hasAddressCountry();
  
  public abstract boolean hasAddressLocality();
  
  public abstract boolean hasAddressRegion();
  
  public abstract boolean hasAssociated_media();
  
  public abstract boolean hasAttendeeCount();
  
  public abstract boolean hasAttendees();
  
  public abstract boolean hasAudio();
  
  public abstract boolean hasAuthor();
  
  public abstract boolean hasBestRating();
  
  public abstract boolean hasBirthDate();
  
  public abstract boolean hasByArtist();
  
  public abstract boolean hasCaption();
  
  public abstract boolean hasContentSize();
  
  public abstract boolean hasContentUrl();
  
  public abstract boolean hasContributor();
  
  public abstract boolean hasDateCreated();
  
  public abstract boolean hasDateModified();
  
  public abstract boolean hasDatePublished();
  
  public abstract boolean hasDescription();
  
  public abstract boolean hasDuration();
  
  public abstract boolean hasEmbedUrl();
  
  public abstract boolean hasEndDate();
  
  public abstract boolean hasFamilyName();
  
  public abstract boolean hasGender();
  
  public abstract boolean hasGeo();
  
  public abstract boolean hasGivenName();
  
  public abstract boolean hasHeight();
  
  public abstract boolean hasId();
  
  public abstract boolean hasImage();
  
  public abstract boolean hasInAlbum();
  
  public abstract boolean hasLatitude();
  
  public abstract boolean hasLocation();
  
  public abstract boolean hasLongitude();
  
  public abstract boolean hasName();
  
  public abstract boolean hasPartOfTVSeries();
  
  public abstract boolean hasPerformers();
  
  public abstract boolean hasPlayerType();
  
  public abstract boolean hasPostOfficeBoxNumber();
  
  public abstract boolean hasPostalCode();
  
  public abstract boolean hasRatingValue();
  
  public abstract boolean hasReviewRating();
  
  public abstract boolean hasStartDate();
  
  public abstract boolean hasStreetAddress();
  
  public abstract boolean hasText();
  
  public abstract boolean hasThumbnail();
  
  public abstract boolean hasThumbnailUrl();
  
  public abstract boolean hasTickerSymbol();
  
  public abstract boolean hasType();
  
  public abstract boolean hasUrl();
  
  public abstract boolean hasWidth();
  
  public abstract boolean hasWorstRating();
  
  public static class Builder
  {
    private String mName;
    private String zzF;
    private String zzIx;
    private double zzaKR;
    private double zzaKS;
    private final Set<Integer> zzaZA = new HashSet();
    private ItemScopeEntity zzaZB;
    private List<String> zzaZC;
    private ItemScopeEntity zzaZD;
    private String zzaZE;
    private String zzaZF;
    private String zzaZG;
    private List<ItemScopeEntity> zzaZH;
    private int zzaZI;
    private List<ItemScopeEntity> zzaZJ;
    private ItemScopeEntity zzaZK;
    private List<ItemScopeEntity> zzaZL;
    private String zzaZM;
    private String zzaZN;
    private ItemScopeEntity zzaZO;
    private String zzaZP;
    private String zzaZQ;
    private List<ItemScopeEntity> zzaZR;
    private String zzaZS;
    private String zzaZT;
    private String zzaZU;
    private String zzaZV;
    private String zzaZW;
    private String zzaZX;
    private String zzaZY;
    private String zzaZZ;
    private String zzavc;
    private ItemScopeEntity zzbaa;
    private String zzbab;
    private String zzbac;
    private String zzbad;
    private ItemScopeEntity zzbae;
    private ItemScopeEntity zzbaf;
    private ItemScopeEntity zzbag;
    private List<ItemScopeEntity> zzbah;
    private String zzbai;
    private String zzbaj;
    private String zzbak;
    private String zzbal;
    private ItemScopeEntity zzbam;
    private String zzban;
    private String zzbao;
    private String zzbap;
    private ItemScopeEntity zzbaq;
    private String zzbar;
    private String zzbas;
    private String zzbat;
    private String zzbau;
    private String zztN;
    private String zzxX;
    
    public ItemScope build()
    {
      return new ItemScopeEntity(this.zzaZA, this.zzaZB, this.zzaZC, this.zzaZD, this.zzaZE, this.zzaZF, this.zzaZG, this.zzaZH, this.zzaZI, this.zzaZJ, this.zzaZK, this.zzaZL, this.zzaZM, this.zzaZN, this.zzaZO, this.zzaZP, this.zzaZQ, this.zztN, this.zzaZR, this.zzaZS, this.zzaZT, this.zzaZU, this.zzavc, this.zzaZV, this.zzaZW, this.zzaZX, this.zzaZY, this.zzaZZ, this.zzbaa, this.zzbab, this.zzbac, this.zzxX, this.zzbad, this.zzbae, this.zzaKR, this.zzbaf, this.zzaKS, this.mName, this.zzbag, this.zzbah, this.zzbai, this.zzbaj, this.zzbak, this.zzbal, this.zzbam, this.zzban, this.zzbao, this.zzbap, this.zzbaq, this.zzbar, this.zzbas, this.zzIx, this.zzF, this.zzbat, this.zzbau);
    }
    
    public Builder setAbout(ItemScope paramItemScope)
    {
      this.zzaZB = ((ItemScopeEntity)paramItemScope);
      this.zzaZA.add(Integer.valueOf(2));
      return this;
    }
    
    public Builder setAdditionalName(List<String> paramList)
    {
      this.zzaZC = paramList;
      this.zzaZA.add(Integer.valueOf(3));
      return this;
    }
    
    public Builder setAddress(ItemScope paramItemScope)
    {
      this.zzaZD = ((ItemScopeEntity)paramItemScope);
      this.zzaZA.add(Integer.valueOf(4));
      return this;
    }
    
    public Builder setAddressCountry(String paramString)
    {
      this.zzaZE = paramString;
      this.zzaZA.add(Integer.valueOf(5));
      return this;
    }
    
    public Builder setAddressLocality(String paramString)
    {
      this.zzaZF = paramString;
      this.zzaZA.add(Integer.valueOf(6));
      return this;
    }
    
    public Builder setAddressRegion(String paramString)
    {
      this.zzaZG = paramString;
      this.zzaZA.add(Integer.valueOf(7));
      return this;
    }
    
    public Builder setAssociated_media(List<ItemScope> paramList)
    {
      this.zzaZH = paramList;
      this.zzaZA.add(Integer.valueOf(8));
      return this;
    }
    
    public Builder setAttendeeCount(int paramInt)
    {
      this.zzaZI = paramInt;
      this.zzaZA.add(Integer.valueOf(9));
      return this;
    }
    
    public Builder setAttendees(List<ItemScope> paramList)
    {
      this.zzaZJ = paramList;
      this.zzaZA.add(Integer.valueOf(10));
      return this;
    }
    
    public Builder setAudio(ItemScope paramItemScope)
    {
      this.zzaZK = ((ItemScopeEntity)paramItemScope);
      this.zzaZA.add(Integer.valueOf(11));
      return this;
    }
    
    public Builder setAuthor(List<ItemScope> paramList)
    {
      this.zzaZL = paramList;
      this.zzaZA.add(Integer.valueOf(12));
      return this;
    }
    
    public Builder setBestRating(String paramString)
    {
      this.zzaZM = paramString;
      this.zzaZA.add(Integer.valueOf(13));
      return this;
    }
    
    public Builder setBirthDate(String paramString)
    {
      this.zzaZN = paramString;
      this.zzaZA.add(Integer.valueOf(14));
      return this;
    }
    
    public Builder setByArtist(ItemScope paramItemScope)
    {
      this.zzaZO = ((ItemScopeEntity)paramItemScope);
      this.zzaZA.add(Integer.valueOf(15));
      return this;
    }
    
    public Builder setCaption(String paramString)
    {
      this.zzaZP = paramString;
      this.zzaZA.add(Integer.valueOf(16));
      return this;
    }
    
    public Builder setContentSize(String paramString)
    {
      this.zzaZQ = paramString;
      this.zzaZA.add(Integer.valueOf(17));
      return this;
    }
    
    public Builder setContentUrl(String paramString)
    {
      this.zztN = paramString;
      this.zzaZA.add(Integer.valueOf(18));
      return this;
    }
    
    public Builder setContributor(List<ItemScope> paramList)
    {
      this.zzaZR = paramList;
      this.zzaZA.add(Integer.valueOf(19));
      return this;
    }
    
    public Builder setDateCreated(String paramString)
    {
      this.zzaZS = paramString;
      this.zzaZA.add(Integer.valueOf(20));
      return this;
    }
    
    public Builder setDateModified(String paramString)
    {
      this.zzaZT = paramString;
      this.zzaZA.add(Integer.valueOf(21));
      return this;
    }
    
    public Builder setDatePublished(String paramString)
    {
      this.zzaZU = paramString;
      this.zzaZA.add(Integer.valueOf(22));
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      this.zzavc = paramString;
      this.zzaZA.add(Integer.valueOf(23));
      return this;
    }
    
    public Builder setDuration(String paramString)
    {
      this.zzaZV = paramString;
      this.zzaZA.add(Integer.valueOf(24));
      return this;
    }
    
    public Builder setEmbedUrl(String paramString)
    {
      this.zzaZW = paramString;
      this.zzaZA.add(Integer.valueOf(25));
      return this;
    }
    
    public Builder setEndDate(String paramString)
    {
      this.zzaZX = paramString;
      this.zzaZA.add(Integer.valueOf(26));
      return this;
    }
    
    public Builder setFamilyName(String paramString)
    {
      this.zzaZY = paramString;
      this.zzaZA.add(Integer.valueOf(27));
      return this;
    }
    
    public Builder setGender(String paramString)
    {
      this.zzaZZ = paramString;
      this.zzaZA.add(Integer.valueOf(28));
      return this;
    }
    
    public Builder setGeo(ItemScope paramItemScope)
    {
      this.zzbaa = ((ItemScopeEntity)paramItemScope);
      this.zzaZA.add(Integer.valueOf(29));
      return this;
    }
    
    public Builder setGivenName(String paramString)
    {
      this.zzbab = paramString;
      this.zzaZA.add(Integer.valueOf(30));
      return this;
    }
    
    public Builder setHeight(String paramString)
    {
      this.zzbac = paramString;
      this.zzaZA.add(Integer.valueOf(31));
      return this;
    }
    
    public Builder setId(String paramString)
    {
      this.zzxX = paramString;
      this.zzaZA.add(Integer.valueOf(32));
      return this;
    }
    
    public Builder setImage(String paramString)
    {
      this.zzbad = paramString;
      this.zzaZA.add(Integer.valueOf(33));
      return this;
    }
    
    public Builder setInAlbum(ItemScope paramItemScope)
    {
      this.zzbae = ((ItemScopeEntity)paramItemScope);
      this.zzaZA.add(Integer.valueOf(34));
      return this;
    }
    
    public Builder setLatitude(double paramDouble)
    {
      this.zzaKR = paramDouble;
      this.zzaZA.add(Integer.valueOf(36));
      return this;
    }
    
    public Builder setLocation(ItemScope paramItemScope)
    {
      this.zzbaf = ((ItemScopeEntity)paramItemScope);
      this.zzaZA.add(Integer.valueOf(37));
      return this;
    }
    
    public Builder setLongitude(double paramDouble)
    {
      this.zzaKS = paramDouble;
      this.zzaZA.add(Integer.valueOf(38));
      return this;
    }
    
    public Builder setName(String paramString)
    {
      this.mName = paramString;
      this.zzaZA.add(Integer.valueOf(39));
      return this;
    }
    
    public Builder setPartOfTVSeries(ItemScope paramItemScope)
    {
      this.zzbag = ((ItemScopeEntity)paramItemScope);
      this.zzaZA.add(Integer.valueOf(40));
      return this;
    }
    
    public Builder setPerformers(List<ItemScope> paramList)
    {
      this.zzbah = paramList;
      this.zzaZA.add(Integer.valueOf(41));
      return this;
    }
    
    public Builder setPlayerType(String paramString)
    {
      this.zzbai = paramString;
      this.zzaZA.add(Integer.valueOf(42));
      return this;
    }
    
    public Builder setPostOfficeBoxNumber(String paramString)
    {
      this.zzbaj = paramString;
      this.zzaZA.add(Integer.valueOf(43));
      return this;
    }
    
    public Builder setPostalCode(String paramString)
    {
      this.zzbak = paramString;
      this.zzaZA.add(Integer.valueOf(44));
      return this;
    }
    
    public Builder setRatingValue(String paramString)
    {
      this.zzbal = paramString;
      this.zzaZA.add(Integer.valueOf(45));
      return this;
    }
    
    public Builder setReviewRating(ItemScope paramItemScope)
    {
      this.zzbam = ((ItemScopeEntity)paramItemScope);
      this.zzaZA.add(Integer.valueOf(46));
      return this;
    }
    
    public Builder setStartDate(String paramString)
    {
      this.zzban = paramString;
      this.zzaZA.add(Integer.valueOf(47));
      return this;
    }
    
    public Builder setStreetAddress(String paramString)
    {
      this.zzbao = paramString;
      this.zzaZA.add(Integer.valueOf(48));
      return this;
    }
    
    public Builder setText(String paramString)
    {
      this.zzbap = paramString;
      this.zzaZA.add(Integer.valueOf(49));
      return this;
    }
    
    public Builder setThumbnail(ItemScope paramItemScope)
    {
      this.zzbaq = ((ItemScopeEntity)paramItemScope);
      this.zzaZA.add(Integer.valueOf(50));
      return this;
    }
    
    public Builder setThumbnailUrl(String paramString)
    {
      this.zzbar = paramString;
      this.zzaZA.add(Integer.valueOf(51));
      return this;
    }
    
    public Builder setTickerSymbol(String paramString)
    {
      this.zzbas = paramString;
      this.zzaZA.add(Integer.valueOf(52));
      return this;
    }
    
    public Builder setType(String paramString)
    {
      this.zzIx = paramString;
      this.zzaZA.add(Integer.valueOf(53));
      return this;
    }
    
    public Builder setUrl(String paramString)
    {
      this.zzF = paramString;
      this.zzaZA.add(Integer.valueOf(54));
      return this;
    }
    
    public Builder setWidth(String paramString)
    {
      this.zzbat = paramString;
      this.zzaZA.add(Integer.valueOf(55));
      return this;
    }
    
    public Builder setWorstRating(String paramString)
    {
      this.zzbau = paramString;
      this.zzaZA.add(Integer.valueOf(56));
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/model/moments/ItemScope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */