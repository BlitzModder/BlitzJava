package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.events.DisabledEventsStrategy;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;

class DisabledSessionAnalyticsManagerStrategy
  extends DisabledEventsStrategy<SessionEvent>
  implements SessionAnalyticsManagerStrategy<SessionEvent>
{
  public void processEvent(SessionEvent.Builder paramBuilder) {}
  
  public void setAnalyticsSettingsData(AnalyticsSettingsData paramAnalyticsSettingsData, String paramString) {}
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/crashlytics/android/answers/DisabledSessionAnalyticsManagerStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */