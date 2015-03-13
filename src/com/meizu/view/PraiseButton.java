package com.meizu.view;

import com.meizu.myApplication.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PraiseButton extends LinearLayout {
	private ImageView mImageView;
	private TextView mTextView;
	private static int mCount = 252;
	private Context mContext;

	public PraiseButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		init();
		handleAnimation();
	}

	private void init() {
		this.setOrientation(LinearLayout.HORIZONTAL);
		LinearLayout.LayoutParams lLayoutlayoutParams = new LinearLayout.LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(lLayoutlayoutParams);
		this.setBackgroundResource(R.drawable.button_color);

		mImageView = new ImageView(mContext);
		LinearLayout.LayoutParams layoutParams_mImageView = new LinearLayout.LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.MATCH_PARENT);
		mImageView.setLayoutParams(layoutParams_mImageView);
		mImageView.setImageResource(R.drawable.love);

		mTextView = new TextView(mContext);
		LinearLayout.LayoutParams layoutParams_mTextView = new LinearLayout.LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		mTextView.setLayoutParams(layoutParams_mTextView);
		mTextView.setText(mCount + "");
		mTextView.setTextSize(20);

		this.addView(mImageView);
		this.addView(mTextView);

	}

	private void handleAnimation() {
		this.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Animation shrikImage = AnimationUtils.loadAnimation(mContext,
						R.anim.shrimk_animation);
				mImageView.startAnimation(shrikImage);
				shrikImage.setAnimationListener(new AnimationListener() {

					@Override
					public void onAnimationStart(Animation animation) {

					}

					@Override
					public void onAnimationEnd(Animation animation) {
						mImageView.setImageResource(R.drawable.rlove);
						ImageUpdata();
					}

					@Override
					public void onAnimationRepeat(Animation animation) {

					}
				});

			}

		});
	}

	private void ImageUpdata() {
		Animation ampImage = AnimationUtils.loadAnimation(mContext,
				R.anim.amp_animation);
		mImageView.startAnimation(ampImage);
		ampImage.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
			
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				TextUpdata();

			}
		});

	}

	private void TextUpdata() {
		Animation textAnimation=AnimationUtils.loadAnimation(mContext, R.anim.text_animation);
		mTextView.startAnimation(textAnimation);
		textAnimation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
			
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				mCount=mCount+1;
				mTextView.setText(mCount+"");
			}
		});
	}

}
