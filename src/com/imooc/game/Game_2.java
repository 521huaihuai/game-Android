package com.imooc.game;

import com.imooc.gameMenu.SimpleGameMenuSuccess;
import com.imooc.mySufaceView.MyAplication;
import com.imooc.particle.PieceParticle;
import com.imooc.snake.RedSnake;
import com.imooc.snake.Snake;
import com.imooc.utils.Utils;
import com.imooc.utils.Utils.Position;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Game_2 extends CommonGame{

	private float alpha = 255;
	private float decreaseAlpha;
	private String[] text;
	private int index = 0;

	public Game_2() {
		decreaseAlpha = Utils.alphaDecreaseInNearBytime(6);
		text = new String[]{"�����Կ������Ͻ���ʱ��, ���ϽǷֱ���Ѫ�����ռ��ĸ���","���Ծ����ռ���Ļ�ϵ�����20��С�ߵ��~"};
	}

	@Override
	public long setTimeLimite() {
		return 111111110;
	}

	@Override
	public Snake getSnake() {
		return new RedSnake();
	}

	@Override
	public int gameOverPos() {
		return 2;
	}

	@Override
	public void childDraw(Canvas canvas, Paint paint, int screenWidth, int screenHeight) {
		if (alpha < 10) {
			if (index < 1) {
				index++;
				alpha = 255;
			}
		}
		Utils.drawAlphaText(Position.CEN, canvas, text[index], paint, alpha);
	}

	@Override
	public void childLogic() {
		if (mCollectionNUM == 20) {
			MyAplication.getSurfaceView().setOnISurfaceViewCallBack(new SimpleGameMenuSuccess("�ܺ�, ��ɹ����ռ���20���ߵ�~", ""));
		}
		if (alpha > 0) {
			alpha -= decreaseAlpha;
		}
	}

	@Override
	public void sameColorCrossHandle(int color) {
		mCollectionNUM++;
	}

	@Override
	public void oppositeColorCrossHandle(int color) {
		mCollectionNUM++;
	}

	@Override
	public void differentColorCrossHandle(int color) {
		mCollectionNUM++;
	}

	@Override
	public void birthColorCrosshandle(int color) {
		mCollectionNUM++;
	}

	@Override
	public void hpIsOver() {
	}

	@Override
	public void timeIsOver(long usedTime) {
	}

	@Override
	public void onRemoveParticleCallBack(PieceParticle particle) {
		// TODO Auto-generated method stub
		
	}

}