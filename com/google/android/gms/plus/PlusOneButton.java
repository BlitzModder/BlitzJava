package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.plus.internal.zzg;

public final class PlusOneButton
  extends FrameLayout
{
  public static final int ANNOTATION_BUBBLE = 1;
  public static final int ANNOTATION_INLINE = 2;
  public static final int ANNOTATION_NONE = 0;
  public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
  public static final int SIZE_MEDIUM = 1;
  public static final int SIZE_SMALL = 0;
  public static final int SIZE_STANDARD = 3;
  public static final int SIZE_TALL = 2;
  private int mSize;
  private String zzF;
  private View zzaYN;
  private int zzaYO;
  private int zzaYP;
  private OnPlusOneClickListener zzaYQ;
  
  public PlusOneButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PlusOneButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mSize = getSize(paramContext, paramAttributeSet);
    this.zzaYO = getAnnotation(paramContext, paramAttributeSet);
    this.zzaYP = -1;
    zzaq(getContext());
    if (isInEditMode()) {}
  }
  
  protected static int getAnnotation(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i = 0;
    paramContext = zzaf.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", paramContext, paramAttributeSet, true, false, "PlusOneButton");
    if ("INLINE".equalsIgnoreCase(paramContext)) {
      i = 2;
    }
    while ("NONE".equalsIgnoreCase(paramContext)) {
      return i;
    }
    return 1;
  }
  
  protected static int getSize(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = zzaf.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", paramContext, paramAttributeSet, true, false, "PlusOneButton");
    if ("SMALL".equalsIgnoreCase(paramContext)) {
      return 0;
    }
    if ("MEDIUM".equalsIgnoreCase(paramContext)) {
      return 1;
    }
    if ("TALL".equalsIgnoreCase(paramContext)) {
      return 2;
    }
    return 3;
  }
  
  private void zzaq(Context paramContext)
  {
    if (this.zzaYN != null) {
      removeView(this.zzaYN);
    }
    this.zzaYN = zzg.zza(paramContext, this.mSize, this.zzaYO, this.zzF, this.zzaYP);
    setOnPlusOneClickListener(this.zzaYQ);
    addView(this.zzaYN);
  }
  
  public void initialize(String paramString, int paramInt)
  {
    zzx.zza(getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
    this.zzF = paramString;
    this.zzaYP = paramInt;
    zzaq(getContext());
  }
  
  public void initialize(String paramString, OnPlusOneClickListener paramOnPlusOneClickListener)
  {
    this.zzF = paramString;
    this.zzaYP = 0;
    zzaq(getContext());
    setOnPlusOneClickListener(paramOnPlusOneClickListener);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.zzaYN.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = this.zzaYN;
    measureChild(localView, paramInt1, paramInt2);
    setMeasuredDimension(localView.getMeasuredWidth(), localView.getMeasuredHeight());
  }
  
  public void plusOneClick()
  {
    this.zzaYN.performClick();
  }
  
  public void setAnnotation(int paramInt)
  {
    this.zzaYO = paramInt;
    zzaq(getContext());
  }
  
  public void setIntent(Intent paramIntent)
  {
    this.zzaYN.setTag(paramIntent);
  }
  
  public void setOnPlusOneClickListener(OnPlusOneClickListener paramOnPlusOneClickListener)
  {
    this.zzaYQ = paramOnPlusOneClickListener;
    this.zzaYN.setOnClickListener(new DefaultOnPlusOneClickListener(paramOnPlusOneClickListener));
  }
  
  public void setSize(int paramInt)
  {
    this.mSize = paramInt;
    zzaq(getContext());
  }
  
  protected class DefaultOnPlusOneClickListener
    implements View.OnClickListener, PlusOneButton.OnPlusOneClickListener
  {
    private final PlusOneButton.OnPlusOneClickListener zzaYR;
    
    public DefaultOnPlusOneClickListener(PlusOneButton.OnPlusOneClickListener paramOnPlusOneClickListener)
    {
      this.zzaYR = paramOnPlusOneClickListener;
    }
    
    public void onClick(View paramView)
    {
      paramView = (Intent)PlusOneButton.zza(PlusOneButton.this).getTag();
      if (this.zzaYR != null)
      {
        this.zzaYR.onPlusOneClick(paramView);
        return;
      }
      onPlusOneClick(paramView);
    }
    
    public void onPlusOneClick(Intent paramIntent)
    {
      Context localContext = PlusOneButton.this.getContext();
      if (((localContext instanceof Activity)) && (paramIntent != null)) {
        ((Activity)localContext).startActivityForResult(paramIntent, PlusOneButton.zzb(PlusOneButton.this));
      }
    }
  }
  
  public static abstract interface OnPlusOneClickListener
  {
    public abstract void onPlusOneClick(Intent paramIntent);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/PlusOneButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */