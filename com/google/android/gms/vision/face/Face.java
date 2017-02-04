package com.google.android.gms.vision.face;

import android.graphics.PointF;
import java.util.Arrays;
import java.util.List;

public class Face
{
  public static final float UNCOMPUTED_PROBABILITY = -1.0F;
  private int mId;
  private float zzaQo;
  private float zzaQp;
  private PointF zzbit;
  private float zzbiu;
  private float zzbiv;
  private List<Landmark> zzbiw;
  private float zzbix;
  private float zzbiy;
  private float zzbiz;
  
  public Face(int paramInt, PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Landmark[] paramArrayOfLandmark, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.mId = paramInt;
    this.zzbit = paramPointF;
    this.zzaQo = paramFloat1;
    this.zzaQp = paramFloat2;
    this.zzbiu = paramFloat3;
    this.zzbiv = paramFloat4;
    this.zzbiw = Arrays.asList(paramArrayOfLandmark);
    if ((paramFloat5 >= 0.0F) && (paramFloat5 <= 1.0F))
    {
      this.zzbix = paramFloat5;
      if ((paramFloat6 < 0.0F) || (paramFloat6 > 1.0F)) {
        break label120;
      }
    }
    label120:
    for (this.zzbiy = paramFloat6;; this.zzbiy = -1.0F)
    {
      if ((this.zzbiz < 0.0F) || (this.zzbiz > 1.0F)) {
        break label129;
      }
      this.zzbiz = paramFloat7;
      return;
      this.zzbix = -1.0F;
      break;
    }
    label129:
    this.zzbiz = -1.0F;
  }
  
  public float getEulerY()
  {
    return this.zzbiu;
  }
  
  public float getEulerZ()
  {
    return this.zzbiv;
  }
  
  public float getHeight()
  {
    return this.zzaQp;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public float getIsLeftEyeOpenProbability()
  {
    return this.zzbix;
  }
  
  public float getIsRightEyeOpenProbability()
  {
    return this.zzbiy;
  }
  
  public float getIsSmilingProbability()
  {
    return this.zzbiz;
  }
  
  public List<Landmark> getLandmarks()
  {
    return this.zzbiw;
  }
  
  public PointF getPosition()
  {
    return new PointF(this.zzbit.x - this.zzaQo / 2.0F, this.zzbit.y - this.zzaQp / 2.0F);
  }
  
  public float getWidth()
  {
    return this.zzaQo;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/vision/face/Face.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */