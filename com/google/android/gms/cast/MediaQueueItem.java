package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznu;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaQueueItem
{
  public static final double DEFAULT_PLAYBACK_DURATION = Double.POSITIVE_INFINITY;
  public static final int INVALID_ITEM_ID = 0;
  private double zzZA = Double.POSITIVE_INFINITY;
  private double zzZB;
  private long[] zzZC;
  private JSONObject zzZn;
  private MediaInfo zzZw;
  private int zzZx = 0;
  private boolean zzZy = true;
  private double zzZz;
  
  private MediaQueueItem(MediaInfo paramMediaInfo)
    throws IllegalArgumentException
  {
    if (paramMediaInfo == null) {
      throw new IllegalArgumentException("media cannot be null.");
    }
    this.zzZw = paramMediaInfo;
  }
  
  private MediaQueueItem(MediaQueueItem paramMediaQueueItem)
    throws IllegalArgumentException
  {
    this.zzZw = paramMediaQueueItem.getMedia();
    if (this.zzZw == null) {
      throw new IllegalArgumentException("media cannot be null.");
    }
    this.zzZx = paramMediaQueueItem.getItemId();
    this.zzZy = paramMediaQueueItem.getAutoplay();
    this.zzZz = paramMediaQueueItem.getStartTime();
    this.zzZA = paramMediaQueueItem.getPlaybackDuration();
    this.zzZB = paramMediaQueueItem.getPreloadTime();
    this.zzZC = paramMediaQueueItem.getActiveTrackIds();
    this.zzZn = paramMediaQueueItem.getCustomData();
  }
  
  MediaQueueItem(JSONObject paramJSONObject)
    throws JSONException
  {
    zzg(paramJSONObject);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (this == paramObject) {
      bool1 = true;
    }
    int i;
    int j;
    label51:
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool3;
        } while (!(paramObject instanceof MediaQueueItem));
        paramObject = (MediaQueueItem)paramObject;
        if (this.zzZn != null) {
          break;
        }
        i = 1;
        if (((MediaQueueItem)paramObject).zzZn != null) {
          break label190;
        }
        j = 1;
        bool1 = bool3;
      } while (i != j);
      if ((this.zzZn == null) || (((MediaQueueItem)paramObject).zzZn == null)) {
        break;
      }
      bool1 = bool3;
    } while (!zznu.zze(this.zzZn, ((MediaQueueItem)paramObject).zzZn));
    if ((zzf.zza(this.zzZw, ((MediaQueueItem)paramObject).zzZw)) && (this.zzZx == ((MediaQueueItem)paramObject).zzZx) && (this.zzZy == ((MediaQueueItem)paramObject).zzZy) && (this.zzZz == ((MediaQueueItem)paramObject).zzZz) && (this.zzZA == ((MediaQueueItem)paramObject).zzZA) && (this.zzZB == ((MediaQueueItem)paramObject).zzZB) && (zzf.zza(this.zzZC, ((MediaQueueItem)paramObject).zzZC))) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      i = 0;
      break;
      label190:
      j = 0;
      break label51;
    }
  }
  
  public long[] getActiveTrackIds()
  {
    return this.zzZC;
  }
  
  public boolean getAutoplay()
  {
    return this.zzZy;
  }
  
  public JSONObject getCustomData()
  {
    return this.zzZn;
  }
  
  public int getItemId()
  {
    return this.zzZx;
  }
  
  public MediaInfo getMedia()
  {
    return this.zzZw;
  }
  
  public double getPlaybackDuration()
  {
    return this.zzZA;
  }
  
  public double getPreloadTime()
  {
    return this.zzZB;
  }
  
  public double getStartTime()
  {
    return this.zzZz;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzZw, Integer.valueOf(this.zzZx), Boolean.valueOf(this.zzZy), Double.valueOf(this.zzZz), Double.valueOf(this.zzZA), Double.valueOf(this.zzZB), this.zzZC, String.valueOf(this.zzZn) });
  }
  
  void setCustomData(JSONObject paramJSONObject)
  {
    this.zzZn = paramJSONObject;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("media", this.zzZw.toJson());
      if (this.zzZx != 0) {
        localJSONObject.put("itemId", this.zzZx);
      }
      localJSONObject.put("autoplay", this.zzZy);
      localJSONObject.put("startTime", this.zzZz);
      if (this.zzZA != Double.POSITIVE_INFINITY) {
        localJSONObject.put("playbackDuration", this.zzZA);
      }
      localJSONObject.put("preloadTime", this.zzZB);
      if (this.zzZC != null)
      {
        JSONArray localJSONArray = new JSONArray();
        long[] arrayOfLong = this.zzZC;
        int j = arrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          localJSONArray.put(arrayOfLong[i]);
          i += 1;
        }
        localJSONObject.put("activeTrackIds", localJSONArray);
      }
      if (this.zzZn != null) {
        localJSONObject.put("customData", this.zzZn);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  void zzV(boolean paramBoolean)
  {
    this.zzZy = paramBoolean;
  }
  
  void zza(long[] paramArrayOfLong)
  {
    this.zzZC = paramArrayOfLong;
  }
  
  void zzba(int paramInt)
  {
    this.zzZx = paramInt;
  }
  
  void zzc(double paramDouble)
    throws IllegalArgumentException
  {
    if ((Double.isNaN(paramDouble)) || (paramDouble < 0.0D)) {
      throw new IllegalArgumentException("startTime cannot be negative or NaN.");
    }
    this.zzZz = paramDouble;
  }
  
  void zzd(double paramDouble)
    throws IllegalArgumentException
  {
    if (Double.isNaN(paramDouble)) {
      throw new IllegalArgumentException("playbackDuration cannot be NaN.");
    }
    this.zzZA = paramDouble;
  }
  
  void zze(double paramDouble)
    throws IllegalArgumentException
  {
    if ((Double.isNaN(paramDouble)) || (paramDouble < 0.0D)) {
      throw new IllegalArgumentException("preloadTime cannot be negative or NaN.");
    }
    this.zzZB = paramDouble;
  }
  
  public boolean zzg(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject.has("media")) {
      this.zzZw = new MediaInfo(paramJSONObject.getJSONObject("media"));
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool1 = bool2;
      int i;
      if (paramJSONObject.has("itemId"))
      {
        i = paramJSONObject.getInt("itemId");
        bool1 = bool2;
        if (this.zzZx != i)
        {
          this.zzZx = i;
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (paramJSONObject.has("autoplay"))
      {
        boolean bool3 = paramJSONObject.getBoolean("autoplay");
        bool2 = bool1;
        if (this.zzZy != bool3)
        {
          this.zzZy = bool3;
          bool2 = true;
        }
      }
      bool1 = bool2;
      double d;
      if (paramJSONObject.has("startTime"))
      {
        d = paramJSONObject.getDouble("startTime");
        bool1 = bool2;
        if (Math.abs(d - this.zzZz) > 1.0E-7D)
        {
          this.zzZz = d;
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (paramJSONObject.has("playbackDuration"))
      {
        d = paramJSONObject.getDouble("playbackDuration");
        bool2 = bool1;
        if (Math.abs(d - this.zzZA) > 1.0E-7D)
        {
          this.zzZA = d;
          bool2 = true;
        }
      }
      bool1 = bool2;
      if (paramJSONObject.has("preloadTime"))
      {
        d = paramJSONObject.getDouble("preloadTime");
        bool1 = bool2;
        if (Math.abs(d - this.zzZB) > 1.0E-7D)
        {
          this.zzZB = d;
          bool1 = true;
        }
      }
      int j;
      long[] arrayOfLong;
      if (paramJSONObject.has("activeTrackIds"))
      {
        JSONArray localJSONArray = paramJSONObject.getJSONArray("activeTrackIds");
        j = localJSONArray.length();
        arrayOfLong = new long[j];
        i = 0;
        while (i < j)
        {
          arrayOfLong[i] = localJSONArray.getLong(i);
          i += 1;
        }
        if (this.zzZC == null) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          this.zzZC = arrayOfLong;
          bool1 = true;
        }
        if (paramJSONObject.has("customData"))
        {
          this.zzZn = paramJSONObject.getJSONObject("customData");
          return true;
          if (this.zzZC.length != j)
          {
            i = 1;
          }
          else
          {
            i = 0;
            for (;;)
            {
              if (i >= j) {
                break label425;
              }
              if (this.zzZC[i] != arrayOfLong[i])
              {
                i = 1;
                break;
              }
              i += 1;
            }
          }
        }
        else
        {
          return bool1;
          label425:
          i = 0;
          continue;
          i = 0;
          arrayOfLong = null;
        }
      }
    }
  }
  
  void zznv()
    throws IllegalArgumentException
  {
    if (this.zzZw == null) {
      throw new IllegalArgumentException("media cannot be null.");
    }
    if ((Double.isNaN(this.zzZz)) || (this.zzZz < 0.0D)) {
      throw new IllegalArgumentException("startTime cannot be negative or NaN.");
    }
    if (Double.isNaN(this.zzZA)) {
      throw new IllegalArgumentException("playbackDuration cannot be NaN.");
    }
    if ((Double.isNaN(this.zzZB)) || (this.zzZB < 0.0D)) {
      throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
    }
  }
  
  public static class Builder
  {
    private final MediaQueueItem zzZD;
    
    public Builder(MediaInfo paramMediaInfo)
      throws IllegalArgumentException
    {
      this.zzZD = new MediaQueueItem(paramMediaInfo, null);
    }
    
    public Builder(MediaQueueItem paramMediaQueueItem)
      throws IllegalArgumentException
    {
      this.zzZD = new MediaQueueItem(paramMediaQueueItem, null);
    }
    
    public Builder(JSONObject paramJSONObject)
      throws JSONException
    {
      this.zzZD = new MediaQueueItem(paramJSONObject);
    }
    
    public MediaQueueItem build()
    {
      this.zzZD.zznv();
      return this.zzZD;
    }
    
    public Builder clearItemId()
    {
      this.zzZD.zzba(0);
      return this;
    }
    
    public Builder setActiveTrackIds(long[] paramArrayOfLong)
    {
      this.zzZD.zza(paramArrayOfLong);
      return this;
    }
    
    public Builder setAutoplay(boolean paramBoolean)
    {
      this.zzZD.zzV(paramBoolean);
      return this;
    }
    
    public Builder setCustomData(JSONObject paramJSONObject)
    {
      this.zzZD.setCustomData(paramJSONObject);
      return this;
    }
    
    public Builder setPlaybackDuration(double paramDouble)
    {
      this.zzZD.zzd(paramDouble);
      return this;
    }
    
    public Builder setPreloadTime(double paramDouble)
      throws IllegalArgumentException
    {
      this.zzZD.zze(paramDouble);
      return this;
    }
    
    public Builder setStartTime(double paramDouble)
      throws IllegalArgumentException
    {
      this.zzZD.zzc(paramDouble);
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/cast/MediaQueueItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */