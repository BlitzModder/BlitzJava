package io.fabric.sdk.android.services.settings;

public class SettingsData
{
  public final AnalyticsSettingsData analyticsSettingsData;
  public final AppSettingsData appData;
  public final BetaSettingsData betaSettingsData;
  public final int cacheDuration;
  public final long expiresAtMillis;
  public final FeaturesSettingsData featuresData;
  public final PromptSettingsData promptData;
  public final SessionSettingsData sessionData;
  public final int settingsVersion;
  
  public SettingsData(long paramLong, AppSettingsData paramAppSettingsData, SessionSettingsData paramSessionSettingsData, PromptSettingsData paramPromptSettingsData, FeaturesSettingsData paramFeaturesSettingsData, AnalyticsSettingsData paramAnalyticsSettingsData, BetaSettingsData paramBetaSettingsData, int paramInt1, int paramInt2)
  {
    this.expiresAtMillis = paramLong;
    this.appData = paramAppSettingsData;
    this.sessionData = paramSessionSettingsData;
    this.promptData = paramPromptSettingsData;
    this.featuresData = paramFeaturesSettingsData;
    this.settingsVersion = paramInt1;
    this.cacheDuration = paramInt2;
    this.analyticsSettingsData = paramAnalyticsSettingsData;
    this.betaSettingsData = paramBetaSettingsData;
  }
  
  public boolean isExpired(long paramLong)
  {
    return this.expiresAtMillis < paramLong;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/io/fabric/sdk/android/services/settings/SettingsData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */