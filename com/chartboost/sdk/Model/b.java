package com.chartboost.sdk.Model;

import com.chartboost.sdk.Libraries.a;
import com.chartboost.sdk.Libraries.g;
import com.chartboost.sdk.Libraries.g.a;
import com.chartboost.sdk.Libraries.g.k;

public class b
{
  public static g.a a;
  public static g.a b;
  public static g.a c = g.a(new g.k[] { g.a("status", a.a), g.a("message", g.a()), g.a("to", g.a()), g.a("media_type", g.a(g.a())), g.a("type", g.a(g.a())), g.a("link", g.a()), g.a("cgn", g.a()), g.a("prefetch_required", g.a(g.c())), g.a("show_loading", g.a(g.c())), g.a("events", g.a(g.a(new g.k[0]))), g.a("creative", g.a()), g.a("webview", l), g.a("ad_id", g.a()) });
  public static g.a d = g.a(new g.k[] { g.a("status", a.a), g.a("message", g.a()), g.a("type", g.a()), g.a("assets", a), g.a("cells", k) });
  public static g.a e = g.a(new g.k[] { g.a("status", a.a), g.a("ad_id", g.a()), g.a("to", g.a(g.a())), g.a("type", g.a(g.a())), g.a("native", g.a(g.a())), g.a("message", g.a(g.a())), g.a("link", g.a()), g.a("name", g.a()), g.a("deep-link", g.a(g.a())), g.a("cgn", g.a()), g.a("creative", g.a()), g.a("icons", g.a(new g.k[] { g.a("sm", g.a()), g.a("md", g.a()), g.a("lg", g.a()) })) });
  public static g.a f = g.a(new g.a[] { c, b });
  private static g.a g = g.a(new g.k[] { g.a("url", g.a()), g.a("id", g.a()), g.a("local-file", g.a()), g.a("buffer", g.a(g.b())) });
  private static g.a h = g.a(new g.k[] { g.a("url", g.a()), g.a("scale", g.a(g.b())), g.a("offset", g.a(g.b(new g.k[] { g.a("x", g.b()), g.a("y", g.b()) }))) });
  private static g.a i = g.a(new g.k[] { g.a("video-landscape", g.a(g)), g.a("video-portrait", g.a(g)), g.a("ad-landscape", g.a(h)), g.a("frame-landscape", g.a(h)), g.a("close-landscape", g.a(h)), g.a("replay-landscape", g.a(h)), g.a("ad-portrait", g.a(h)), g.a("frame-portrait", g.a(h)), g.a("close-portrait", g.a(h)), g.a("replay-portrait", g.a(h)), g.a("video-click-button", g.a(h)), g.a("post-video-icon", g.a(h)), g.a("post-video-button", g.a(h)), g.a("video-confirmation-icon", g.a(h)), g.a("video-confirmation-button", g.a(h)), g.a("post-video-reward-icon", g.a(h)), g.a("blur-background", g.a(h)) });
  private static g.a j = g.a(g.a(new g.k[] { g.a("progress", g.a(g.b(new g.k[] { g.a("delay", g.b()), g.a("background-color", g.a()), g.a("progress-color", g.a()), g.a("border-color", g.a()), g.a("radius", g.b()) }))), g.a("video-controls-togglable", g.a(g.c())), g.a("video-controls-background", g.b(new g.k[] { g.a("color", g.a()), g.a("border-color", g.a()) })), g.a("post-video-toaster", g.a(g.b(new g.k[] { g.a("title", g.a()), g.a("tagline", g.a()) }))), g.a("pre-popup", g.a(g.b(new g.k[] { g.a("title", g.a()), g.a("text", g.a()), g.a("confirm", g.a()), g.a("cancel", g.a()) }))), g.a("post-popup", g.a(g.b(new g.k[] { g.a("title", g.a()), g.a("text", g.a()), g.a("confirm", g.a()) }))), g.a("cancel-popup", g.a(g.b(new g.k[] { g.a("title", g.a()), g.a("text", g.a()), g.a("confirm", g.a()), g.a("cancel", g.a()) }))), g.a("confirmation", g.a(g.b(new g.k[] { g.a("text", g.a()), g.a("color", g.a()) }))), g.a("video-progress-timer-enabled", g.a(g.c())), g.a("post-video-reward-toaster", g.a(g.b(new g.k[] { g.a("text", g.a()), g.a("position", g.a(new Object[] { "inside-top", "outside-bottom" })) }))), g.a("play-another-popup", g.a(g.b(new g.k[] { g.a("skip-confirmation", g.c()), g.a("title", g.a()), g.a("text", g.a()), g.a("cancel", g.a()), g.a("confirm", g.a()) }))) }));
  private static g.a k;
  private static g.a l;
  
  static
  {
    a = g.a(new g.k[] { g.a("close", g.a(h)), g.a("header-center", g.a(h)), g.a("header-tile", g.a(h)), g.a("header-height", g.a(g.b())), g.a("background-color", g.a(g.a())), g.a("header-text", g.a(g.a())), g.a("text-color", g.a(g.a())), g.a("close-landscape", g.a(h)), g.a("header-landscape", g.a(h)), g.a("close-portrait", g.a(h)), g.a("header-portrait", g.a(h)), g.a("install-button", g.a(h)), g.a("play-button", g.a(h)), g.a("offset", g.a(g.b(new g.k[] { g.a("x", g.b()), g.a("y", g.b()) }))) });
    k = g.b(g.a(new g.k[] { g.a("type", g.a()), g.a("name", g.a()), g.a("cgn", g.a()), g.a("more_type", g.a()), g.a("assets", g.a(new g.k[] { g.a("icon", h) })), g.a("text", g.a(g.a())), g.a("link", g.a(g.a())), g.a("deep-link", g.a(g.a())), g.a("itunes_id", g.a(g.a())), g.a("publisher", g.a(g.a())), g.a("description", g.a(g.a())), g.a("border-color", g.a(g.a())) }));
    b = g.a(new g.k[] { g.a("status", a.a), g.a("ad_id", g.a()), g.a("to", g.a()), g.a("type", g.a()), g.a("native", g.a(g.a())), g.a("message", g.a()), g.a("link", g.a()), g.a("deep-link", g.a(g.a())), g.a("cgn", g.a()), g.a("creative", g.a()), g.a("assets", i), g.a("ux", j), g.a("reward", g.a(g.a(Object.class))) });
    l = g.a(new g.k[] { g.a("template", g.a()), g.a("elements", g.b(g.a(new g.k[] { g.a("type", g.a()), g.a("name", g.a()), g.a("param", g.a(g.a())), g.a("value", g.a()) }))) });
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/Model/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */