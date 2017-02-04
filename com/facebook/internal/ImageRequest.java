package com.facebook.internal;

import android.content.Context;
import android.net.Uri.Builder;
import java.net.URI;
import java.net.URISyntaxException;

public class ImageRequest
{
  private static final String HEIGHT_PARAM = "height";
  private static final String MIGRATION_PARAM = "migration_overrides";
  private static final String MIGRATION_VALUE = "{october_2012:true}";
  private static final String PROFILEPIC_URL_FORMAT = "https://graph.facebook.com/%s/picture";
  public static final int UNSPECIFIED_DIMENSION = 0;
  private static final String WIDTH_PARAM = "width";
  private boolean allowCachedRedirects;
  private Callback callback;
  private Object callerTag;
  private Context context;
  private URI imageUri;
  
  private ImageRequest(Builder paramBuilder)
  {
    this.context = paramBuilder.context;
    this.imageUri = paramBuilder.imageUrl;
    this.callback = paramBuilder.callback;
    this.allowCachedRedirects = paramBuilder.allowCachedRedirects;
    if (paramBuilder.callerTag == null) {}
    for (paramBuilder = new Object();; paramBuilder = paramBuilder.callerTag)
    {
      this.callerTag = paramBuilder;
      return;
    }
  }
  
  public static URI getProfilePictureUrl(String paramString, int paramInt1, int paramInt2)
    throws URISyntaxException
  {
    Validate.notNullOrEmpty(paramString, "userId");
    paramInt1 = Math.max(paramInt1, 0);
    paramInt2 = Math.max(paramInt2, 0);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      throw new IllegalArgumentException("Either width or height must be greater than 0");
    }
    paramString = new Uri.Builder().encodedPath(String.format("https://graph.facebook.com/%s/picture", new Object[] { paramString }));
    if (paramInt2 != 0) {
      paramString.appendQueryParameter("height", String.valueOf(paramInt2));
    }
    if (paramInt1 != 0) {
      paramString.appendQueryParameter("width", String.valueOf(paramInt1));
    }
    paramString.appendQueryParameter("migration_overrides", "{october_2012:true}");
    return new URI(paramString.toString());
  }
  
  public Callback getCallback()
  {
    return this.callback;
  }
  
  public Object getCallerTag()
  {
    return this.callerTag;
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public URI getImageUri()
  {
    return this.imageUri;
  }
  
  public boolean isCachedRedirectAllowed()
  {
    return this.allowCachedRedirects;
  }
  
  public static class Builder
  {
    private boolean allowCachedRedirects;
    private ImageRequest.Callback callback;
    private Object callerTag;
    private Context context;
    private URI imageUrl;
    
    public Builder(Context paramContext, URI paramURI)
    {
      Validate.notNull(paramURI, "imageUrl");
      this.context = paramContext;
      this.imageUrl = paramURI;
    }
    
    public ImageRequest build()
    {
      return new ImageRequest(this, null);
    }
    
    public Builder setAllowCachedRedirects(boolean paramBoolean)
    {
      this.allowCachedRedirects = paramBoolean;
      return this;
    }
    
    public Builder setCallback(ImageRequest.Callback paramCallback)
    {
      this.callback = paramCallback;
      return this;
    }
    
    public Builder setCallerTag(Object paramObject)
    {
      this.callerTag = paramObject;
      return this;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onCompleted(ImageResponse paramImageResponse);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/facebook/internal/ImageRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */