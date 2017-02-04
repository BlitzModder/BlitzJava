package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo
{
  public static final int STREAM_TYPE_BUFFERED = 1;
  public static final int STREAM_TYPE_INVALID = -1;
  public static final int STREAM_TYPE_LIVE = 2;
  public static final int STREAM_TYPE_NONE = 0;
  public static final long UNKNOWN_DURATION = -1L;
  private final String zzZg;
  private int zzZh;
  private String zzZi;
  private MediaMetadata zzZj;
  private long zzZk;
  private List<MediaTrack> zzZl;
  private TextTrackStyle zzZm;
  private JSONObject zzZn;
  
  MediaInfo(String paramString)
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("content ID cannot be null or empty");
    }
    this.zzZg = paramString;
    this.zzZh = -1;
    this.zzZk = -1L;
  }
  
  MediaInfo(JSONObject paramJSONObject)
    throws JSONException
  {
    this.zzZg = paramJSONObject.getString("contentId");
    Object localObject1 = paramJSONObject.getString("streamType");
    if ("NONE".equals(localObject1)) {
      this.zzZh = 0;
    }
    Object localObject2;
    for (;;)
    {
      this.zzZi = paramJSONObject.getString("contentType");
      if (paramJSONObject.has("metadata"))
      {
        localObject1 = paramJSONObject.getJSONObject("metadata");
        this.zzZj = new MediaMetadata(((JSONObject)localObject1).getInt("metadataType"));
        this.zzZj.zzf((JSONObject)localObject1);
      }
      this.zzZk = -1L;
      if ((paramJSONObject.has("duration")) && (!paramJSONObject.isNull("duration")))
      {
        double d = paramJSONObject.optDouble("duration", 0.0D);
        if ((!Double.isNaN(d)) && (!Double.isInfinite(d))) {
          this.zzZk = zzf.zzg(d);
        }
      }
      if (!paramJSONObject.has("tracks")) {
        break;
      }
      this.zzZl = new ArrayList();
      localObject1 = paramJSONObject.getJSONArray("tracks");
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = new MediaTrack(((JSONArray)localObject1).getJSONObject(i));
        this.zzZl.add(localObject2);
        i += 1;
      }
      if ("BUFFERED".equals(localObject1)) {
        this.zzZh = 1;
      } else if ("LIVE".equals(localObject1)) {
        this.zzZh = 2;
      } else {
        this.zzZh = -1;
      }
    }
    this.zzZl = null;
    if (paramJSONObject.has("textTrackStyle"))
    {
      localObject1 = paramJSONObject.getJSONObject("textTrackStyle");
      localObject2 = new TextTrackStyle();
      ((TextTrackStyle)localObject2).zzf((JSONObject)localObject1);
    }
    for (this.zzZm = ((TextTrackStyle)localObject2);; this.zzZm = null)
    {
      this.zzZn = paramJSONObject.optJSONObject("customData");
      return;
    }
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
        } while (!(paramObject instanceof MediaInfo));
        paramObject = (MediaInfo)paramObject;
        if (this.zzZn != null) {
          break;
        }
        i = 1;
        if (((MediaInfo)paramObject).zzZn != null) {
          break label169;
        }
        j = 1;
        bool1 = bool3;
      } while (i != j);
      if ((this.zzZn == null) || (((MediaInfo)paramObject).zzZn == null)) {
        break;
      }
      bool1 = bool3;
    } while (!zznu.zze(this.zzZn, ((MediaInfo)paramObject).zzZn));
    if ((zzf.zza(this.zzZg, ((MediaInfo)paramObject).zzZg)) && (this.zzZh == ((MediaInfo)paramObject).zzZh) && (zzf.zza(this.zzZi, ((MediaInfo)paramObject).zzZi)) && (zzf.zza(this.zzZj, ((MediaInfo)paramObject).zzZj)) && (this.zzZk == ((MediaInfo)paramObject).zzZk)) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      i = 0;
      break;
      label169:
      j = 0;
      break label51;
    }
  }
  
  public String getContentId()
  {
    return this.zzZg;
  }
  
  public String getContentType()
  {
    return this.zzZi;
  }
  
  public JSONObject getCustomData()
  {
    return this.zzZn;
  }
  
  public List<MediaTrack> getMediaTracks()
  {
    return this.zzZl;
  }
  
  public MediaMetadata getMetadata()
  {
    return this.zzZj;
  }
  
  public long getStreamDuration()
  {
    return this.zzZk;
  }
  
  public int getStreamType()
  {
    return this.zzZh;
  }
  
  public TextTrackStyle getTextTrackStyle()
  {
    return this.zzZm;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzZg, Integer.valueOf(this.zzZh), this.zzZi, this.zzZj, Long.valueOf(this.zzZk), String.valueOf(this.zzZn) });
  }
  
  void setContentType(String paramString)
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("content type cannot be null or empty");
    }
    this.zzZi = paramString;
  }
  
  void setCustomData(JSONObject paramJSONObject)
  {
    this.zzZn = paramJSONObject;
  }
  
  void setStreamType(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt < -1) || (paramInt > 2)) {
      throw new IllegalArgumentException("invalid stream type");
    }
    this.zzZh = paramInt;
  }
  
  public void setTextTrackStyle(TextTrackStyle paramTextTrackStyle)
  {
    this.zzZm = paramTextTrackStyle;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("contentId", this.zzZg);
        switch (this.zzZh)
        {
        default: 
          localJSONObject.put("streamType", localObject);
          if (this.zzZi != null) {
            localJSONObject.put("contentType", this.zzZi);
          }
          if (this.zzZj != null) {
            localJSONObject.put("metadata", this.zzZj.toJson());
          }
          if (this.zzZk <= -1L)
          {
            localJSONObject.put("duration", JSONObject.NULL);
            if (this.zzZl == null) {
              continue;
            }
            localObject = new JSONArray();
            Iterator localIterator = this.zzZl.iterator();
            if (localIterator.hasNext())
            {
              ((JSONArray)localObject).put(((MediaTrack)localIterator.next()).toJson());
              continue;
            }
          }
          else
          {
            localJSONObject.put("duration", zzf.zzA(this.zzZk));
            continue;
          }
          localJSONObject.put("tracks", localObject);
          if (this.zzZm != null) {
            localJSONObject.put("textTrackStyle", this.zzZm.toJson());
          }
          if (this.zzZn == null) {
            break label239;
          }
          localJSONObject.put("customData", this.zzZn);
          return localJSONObject;
        }
      }
      catch (JSONException localJSONException) {}
      Object localObject = "NONE";
      continue;
      label239:
      return localJSONObject;
      String str = "BUFFERED";
      continue;
      str = "LIVE";
    }
  }
  
  void zza(MediaMetadata paramMediaMetadata)
  {
    this.zzZj = paramMediaMetadata;
  }
  
  void zznv()
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(this.zzZg)) {
      throw new IllegalArgumentException("content ID cannot be null or empty");
    }
    if (TextUtils.isEmpty(this.zzZi)) {
      throw new IllegalArgumentException("content type cannot be null or empty");
    }
    if (this.zzZh == -1) {
      throw new IllegalArgumentException("a valid stream type must be specified");
    }
  }
  
  void zzs(List<MediaTrack> paramList)
  {
    this.zzZl = paramList;
  }
  
  void zzx(long paramLong)
    throws IllegalArgumentException
  {
    if ((paramLong < 0L) && (paramLong != -1L)) {
      throw new IllegalArgumentException("Invalid stream duration");
    }
    this.zzZk = paramLong;
  }
  
  public static class Builder
  {
    private final MediaInfo zzZo;
    
    public Builder(String paramString)
      throws IllegalArgumentException
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("Content ID cannot be empty");
      }
      this.zzZo = new MediaInfo(paramString);
    }
    
    public MediaInfo build()
      throws IllegalArgumentException
    {
      this.zzZo.zznv();
      return this.zzZo;
    }
    
    public Builder setContentType(String paramString)
      throws IllegalArgumentException
    {
      this.zzZo.setContentType(paramString);
      return this;
    }
    
    public Builder setCustomData(JSONObject paramJSONObject)
    {
      this.zzZo.setCustomData(paramJSONObject);
      return this;
    }
    
    public Builder setMediaTracks(List<MediaTrack> paramList)
    {
      this.zzZo.zzs(paramList);
      return this;
    }
    
    public Builder setMetadata(MediaMetadata paramMediaMetadata)
    {
      this.zzZo.zza(paramMediaMetadata);
      return this;
    }
    
    public Builder setStreamDuration(long paramLong)
      throws IllegalArgumentException
    {
      this.zzZo.zzx(paramLong);
      return this;
    }
    
    public Builder setStreamType(int paramInt)
      throws IllegalArgumentException
    {
      this.zzZo.setStreamType(paramInt);
      return this;
    }
    
    public Builder setTextTrackStyle(TextTrackStyle paramTextTrackStyle)
    {
      this.zzZo.setTextTrackStyle(paramTextTrackStyle);
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/cast/MediaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */