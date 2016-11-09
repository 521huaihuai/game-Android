package com.imooc.utils;

import java.util.Vector;

import com.imooc.gameMenu.SimpleGameMenuFail;
import com.imooc.gameMenu.SimpleGameMenuSuccess;
import com.imooc.myConstant.MyConstant;
import com.imooc.myConstant.Pos;
import com.imooc.mySufaceView.MainActivity;
import com.imooc.mySufaceView.MyAplication;
import com.imooc.particle.PieceParticle;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * ���߰�
 * 
 * @author Administrator
 *
 */
public class Utils
{

	public enum Position
	{
		CEN, LEFT, RIGHT, CEN_UP, CEN_DOEN, UP_RIGHT, UP_LEFT, CEN_UP_UP
	}


	/**
	 * ������ʱ�����ص�����
	 * 
	 * @param canvas
	 * @param text
	 * @param paint
	 * @param alpha
	 */
	public static void drawAlphaText(Canvas canvas, String text, Paint paint, float alpha)
	{
		drawAlphaText(Position.CEN, canvas, text, paint, alpha);
	}

	public static void drawAlphaText(Position position, Canvas canvas, String text, Paint paint, float alpha)
	{
		if (alpha < 0)
		{
			alpha = 0;
		}
		if (alpha > 255)
		{
			alpha = 255;
		}
		canvas.save();
		paint.setAlpha((int) alpha);
		drawText(position, canvas, text, paint);
		paint.setAlpha(100);
		canvas.restore();
	}

	public static void drawText(Position position, Canvas canvas, String text, int textSize, Paint paint)
	{
		int length = text.length();
		int size = textSize;
		int width = length * size;
		paint.setTextSize(textSize);
		switch (position)
		{
			case CEN:
				canvas.drawText(text, MainActivity.screenWidth / 2 - width / 2, MainActivity.screenHeight / 2, paint);
				break;
			case LEFT:
				canvas.drawText(text, 0, MainActivity.screenHeight / 2, paint);
				break;
			case CEN_UP_UP:
				canvas.drawText(text, MainActivity.screenWidth / 2 - width / 2, MainActivity.screenHeight / 5, paint);
				break;
			case CEN_UP:
				canvas.drawText(text, MainActivity.screenWidth / 2 - width / 2, MainActivity.screenHeight / 3, paint);
				break;
			case CEN_DOEN:
				canvas.drawText(text, MainActivity.screenWidth / 2 - width / 2, 2 * MainActivity.screenHeight / 3, paint);
				break;

			case UP_RIGHT:
				canvas.drawText(text, MainActivity.screenWidth - width, MainActivity.screenHeight / 3, paint);
				break;
			case UP_LEFT:
				canvas.drawText(text, MainActivity.screenWidth / 2 - width / 2, MainActivity.screenHeight / 3, paint);
				break;

			case RIGHT:
				canvas.drawText(text, MainActivity.screenWidth - width, MainActivity.screenHeight / 2, paint);
				break;
		}
		paint.setTextSize(MyAplication.getTextSize());
	}

	/**
	 * ���ڻ��ƶ�����Ϣ
	 * 
	 * @param position
	 * @param canvas
	 * @param text
	 * @param paint
	 */
	public static void drawMessageText(String[] messages, Canvas canvas, int size, Paint paint)
	{
		paint.setTextSize(size);
		for (int i = 0; i < messages.length; i++)
		{
			int length = messages[i].length();
			int width = length * size;
			canvas.drawText(messages[i], MainActivity.screenWidth / 2 - width / 2, MainActivity.screenHeight / 3.5f + (1 + 0.15f) * size * i, paint);
		}
		paint.setTextSize(MyAplication.getTextSize());
	}

	public static void drawText(Position position, Canvas canvas, String text, Paint paint)
	{
		drawText(position, canvas, text, MyAplication.getTextSize(), paint);
	}

	/**
	 * alpha ��time��ʱ��˥��255 - 0
	 * 
	 * @param time
	 * @return
	 */
	public static float alphaDecreaseInNearBytime(int time)
	{
		return 6.4f * 1.0f / time;
	}

	/**
	 * �Ƿ�Խ��
	 */
	public static boolean isOutOfBunds(int x, int y)
	{
		if (x < 0 || x > MainActivity.screenWidth) { return true; }
		if (y < 0 || y > MainActivity.screenHeight) { return true; }
		return false;
	}

	/**
	 * �Ƿ���԰��
	 */
	public static boolean isInRound(PieceParticle particle, float x, float y, float radius)
	{
		float distance = (float) Math.sqrt(Math.pow(x - particle.getX(), 2) + Math.pow(y - particle.getY(), 2));
		return distance <= radius;
	}

	/**
	 * ����Ѫ��
	 * 
	 * @param hp
	 */
	public static void drawHp(Canvas canvas, Paint paint, float radius, int hp)
	{
		float screenWidth = MainActivity.screenWidth;
		float screenHeight = MainActivity.screenHeight;
		// ����Ѫ��
		canvas.drawText("HP : ", (int) (screenWidth - 0.12 * screenWidth), screenHeight / 25, paint);
		canvas.drawRoundRect(new RectF(screenWidth - 1.0f / 240 * hp * screenWidth, 0.5f / 108 * screenHeight, screenWidth, 4.5f / 108 * screenHeight), radius,
				radius, paint);
	}

	/**
	 * ����ʱ��
	 * 
	 * @param time
	 */
	public static void drawTime(Canvas canvas, Paint paint, float radius, long time)
	{
		float screenWidth = MainActivity.screenWidth;
		float screenHeight = MainActivity.screenHeight;
		// ����ʱ��
		canvas.drawText("T : ", (int) (0.01 * screenWidth), screenHeight / 25, paint);
		canvas.drawText("" + time / 1000, (int) (0.05 * screenWidth), screenHeight / 25, paint);
	}

	/**
	 * �����ռ���
	 * 
	 * @param canvas
	 * @param paint
	 * @param radius
	 * @param hp
	 */
	public static void drawCollection(Canvas canvas, Paint paint, int collectionNum)
	{
		float screenWidth = MainActivity.screenWidth;
		float screenHeight = MainActivity.screenHeight;
		// ����Ѫ��
		canvas.drawText("DG : ", (int) (screenWidth - 0.12 * screenWidth), 2.5f * screenHeight / 25, paint);
		canvas.drawText("" + collectionNum, (int) (screenWidth - 0.05 * screenWidth), 2.5f * screenHeight / 25, paint);
	}

	/**
	 * ��������
	 * 
	 * @param canvas
	 * @param particles
	 * @param paint
	 */
	public static void drawParticle(Canvas canvas, Vector<PieceParticle> particles, Paint paint)
	{
		for (PieceParticle particle : particles)
		{
			paint.setColor(particle.getColor());
			canvas.drawCircle(particle.getX(), particle.getY(), particle.getRadius(), paint);
		}
	}

	/**
	 * ��ȡ�÷����ƶ�����һ���ƶ�����
	 * 
	 * @param direction
	 *            0 - 360
	 * @return
	 */
	public static Pos getMoveDistance(double direction, int currentX, int currentY, float speed)
	{
		double x = speed * Math.cos(Math.PI / 180 * direction) + currentX;
		double y = speed * Math.sin(Math.PI / 180 * direction) + currentY;
		return new Pos((int) Math.round(x), (int) Math.round(y));
	}

	/**
	 * ����򵥵� ��Ϣ
	 * 
	 * @param context
	 * @param string
	 * @return
	 */
	public static void saveDataString(Context context, String key, String string)
	{
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("content", string);
		editor.commit();
	}

	/**
	 * ����򵥵� ��Ϣ
	 * 
	 * @param context
	 * @param string
	 */
	public static void saveDataInt(Context context, String key, int num)
	{
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putInt(key, num);
		editor.commit();
	}

	/**
	 * ��ȡSharedPreferences����
	 * 
	 * @param context
	 */
	public static int loadDataInt(Context context, String key)
	{
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		return sp.getInt(key, 1);
	}

	/**
	 * ��ȡSharedPreferences����
	 * 
	 * @param context
	 */
	public static String loadDataString(Context context, String key)
	{
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		return sp.getString(key, "");
	}

	/**
	 * ������һ��
	 * 
	 * @param string
	 * @param message
	 */
	public static void enterNextCheckPoint(String title, String... message)
	{
		try
		{
			Thread.sleep(500);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		MyAplication.getSurfaceView().setOnISurfaceViewCallBack(new SimpleGameMenuSuccess(title, message));
	}

	public static void reStartCheckPoint(String title, String... message)
	{
		try
		{
			Thread.sleep(500);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		MyAplication.getSurfaceView().setOnISurfaceViewCallBack(new SimpleGameMenuFail(title, message));
	}

	public static float getAdapterMenuRadius()
	{
		float radius = MainActivity.screenWidth / 13;
		return radius;
	}

	/**
	 * ��ȡ��ͬ����ɫ
	 * 
	 * @param color
	 * @return
	 */
	public static int getDifferentColor(int color)
	{
		if (color == MyConstant.COLOR_BLUE)
		{
			color = Color.BLUE;
		}
		switch (color)
		{
			case MyConstant.COLOR_RED:
				return MyConstant.COLOR_BLUE;
			case MyConstant.COLOR_BLACK:
				return MyConstant.COLOR_GREEN;
			case Color.BLUE:
				return MyConstant.COLOR_BLACK;
			case MyConstant.COLOR_GREEN:
				return MyConstant.COLOR_GOLD;
			default:
				return MyConstant.COLOR_RED;
		}
	}

}