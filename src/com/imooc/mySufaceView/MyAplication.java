package com.imooc.mySufaceView;

import android.app.Application;
import android.content.Context;

public class MyAplication extends Application
{

	private static Context mContext;
	private static MySurfaceView mSurfaceView;
	private static int textSize;
	private static int titleSize;


	public static int getTextSize()
	{
		return textSize;
	}

	public void setTextSize(int textSize)
	{
		MyAplication.textSize = textSize;
	}

	public void setTitleSize(int textSize)
	{
		MyAplication.titleSize = textSize;
	}

	public static int getTitleSize()
	{
		return titleSize;
	}

	public static MySurfaceView getSurfaceView()
	{
		return mSurfaceView;
	}

	public void setSurfaceView(MySurfaceView mSurfaceView)
	{
		MyAplication.mSurfaceView = mSurfaceView;
	}

	@Override
	public void onCreate()
	{
		super.onCreate();
	}

	public static Context getContext()
	{
		return mContext;
	}

	public void setContext(Context Context)
	{
		mContext = Context;
	}

}
