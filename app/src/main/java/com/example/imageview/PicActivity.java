package com.example.imageview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 测试提交项，修改后再次提交。
 */
public class PicActivity extends Activity implements OnClickListener {


	Button pre,next;
	ImageView image;
	//图片数组
	int images[] = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
	//表示选中图片索引位置
	int position = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//初始化
		pre = (Button) findViewById(R.id.pre);
		next = (Button) findViewById(R.id.next);
		image = (ImageView) findViewById(R.id.imageView1);

		pre.setOnClickListener(this);
		next.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {

		//发现图片不能沾满左右边界，设置图片属性scaleType = "fixXY"即可。
		switch (v.getId()) {
			case R.id.pre:
				position--;
				if(position < 0){
					position = images.length - 1;
				}
				image.setImageResource(images[position]);
				break;
			case R.id.next:
				position++;
				if(position >= images.length){
					position = 0;
				}
				image.setImageResource(images[position]);
				break;

			default:
				break;
		}

	}

}
