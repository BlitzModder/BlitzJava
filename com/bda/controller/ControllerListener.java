package com.bda.controller;

public abstract interface ControllerListener
{
  public abstract void onKeyEvent(KeyEvent paramKeyEvent);
  
  public abstract void onMotionEvent(MotionEvent paramMotionEvent);
  
  public abstract void onStateEvent(StateEvent paramStateEvent);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/bda/controller/ControllerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */