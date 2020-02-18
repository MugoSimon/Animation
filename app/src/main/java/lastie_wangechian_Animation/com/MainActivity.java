package lastie_wangechian_Animation.com;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mLinearLayout;
    private TextView[] mDots;
    private Button previousBtn;
    private Button nextBtn;
    private int mCurrentpage;

    private SlideAdapter slideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mLinearLayout = (LinearLayout) findViewById(R.id.layoutDots);
        previousBtn = (Button)findViewById(R.id.previousBtn);
        nextBtn = (Button)findViewById(R.id.nextBtn);

        slideAdapter = new SlideAdapter(this);
        mSlideViewPager.setAdapter(slideAdapter);

        addDotsIndictors(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        //clicks
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSlideViewPager.setCurrentItem(mCurrentpage + 1);
            }
        });

        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentpage - 1);
            }
        });
    }

    public void addDotsIndictors(int position) {
        mDots = new TextView[3];
        mLinearLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.yangu_kando));

            mLinearLayout.addView(mDots[i]);

        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndictors(i);

            mCurrentpage = i;

            if (i == 0) {
                nextBtn.setEnabled(true);
                previousBtn.setEnabled(false);
                previousBtn.setVisibility(View.INVISIBLE);

                nextBtn.setText("Next");
                previousBtn.setText("");

            } else if (i == mDots.length - 1) {
                nextBtn.setEnabled(true);
                previousBtn.setEnabled(true);
                previousBtn.setVisibility(View.VISIBLE);

                nextBtn.setText("Finish");
                previousBtn.setText("Back");

            } else {
                nextBtn.setEnabled(true);
                previousBtn.setEnabled(true);
                previousBtn.setVisibility(View.VISIBLE);

                nextBtn.setText("Next");
                previousBtn.setText("Back");

            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
