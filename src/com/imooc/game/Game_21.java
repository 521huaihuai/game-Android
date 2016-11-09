package com.imooc.game;

import java.util.List;

import com.imooc.snake.Node;
import com.imooc.snake.RedSnake;
import com.imooc.snake.Snake;
import com.imooc.utils.Utils;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Game_21 extends GuideCommonGame{
	private int colorchangetimes;

	@Override
	public Snake getSnake() {
		return new RedSnake();
	}

	@Override
	public String[] getGuideString() {
		return new String[] { "���Ǹ���Ϸ����һЩ�Ѷ�", "������˲���������ͬ����ɫ������˵���ɫ", "���ͻ�ת��Ϊ���Ե���ɫ", "��Ȼ��, ��������Ҳ��֮�ı�!", "����ת��10����ɫ��~" };
	}

	@Override
	public int[] getGuideIndexTime() {
		return new int[] { 2, 3, 3, 2, 10 };
	}

	@Override
	public void detailDraw(Canvas canvas, Paint paint, int screenWidth, int screenHeight) {
	}

	@Override
	public void detailLogic() {
		if (colorchangetimes == 10) {
			Utils.enterNextCheckPoint("�е㲻��Ӧ��?", "����, ������������һ������ ��ˣ��~");
		}

	}

	@Override
	public void sameColorCrossHandle(int color) {

	}

	@Override
	public void oppositeColorCrossHandle(int color) {
		mSnake.setHp(mSnake.getCurrentHp() - 5);
	}

	@Override
	public void differentColorCrossHandle(int color) {
		List<Node> mList = mSnake.getList();
		for (Node node : mList) {
			node.setColor(color);
		}
		colorchangetimes ++;
	}

	@Override
	public void birthColorCrosshandle(int color) {
		List<Node> mList = mSnake.getList();
		for (Node node : mList) {
			node.setColor(color);
		}
		colorchangetimes ++;
	}

	@Override
	public long setTimeLimite() {
		return 0;
	}

	@Override
	public int gameOverPos() {
		return 21;
	}


	@Override
	public void hpIsOver() {
		Utils.reStartCheckPoint("ʧ����", "С��ʾ", "֮�����Ϸ�������ɫ�����������ֵ�½�", "������������");
	}

	@Override
	public void timeIsOver(long usedTime) {
	}

}