package lastie_wangechian_Animation.com;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
//    private CircleImageView slideImageView;
////    private TextView slideHeading;
////    private TextView slideDesc;

    public SlideAdapter (Context context){

        this.context =  context;
    }
    //arrays for the slides
    public int[] slide_image ={

            R.drawable.default_avatar_1,
            R.drawable.default_avatar_2,
            R.drawable.default_avatar_3

    };

    public String[] slide_heading ={

            "WANGECHI",
            "SIMON",
            "MUGO"

    };

    public String[] slide_desc = {
            "Pioneer International University was established in September 2006, as a College and received University accreditation by the Kenyan government in 2012. ",
            "Pioneer International University (PIU) boasts of a combination of carefully developed curricula mapped with the world of work needs.",
            "Similar efforts dedicated towards being the Technology Institute (PIU is a Microsoft IT Academy) in the region."

    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view ==(RelativeLayout)o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container, false);

        CircleImageView slideImageView = (CircleImageView)view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView)view.findViewById(R.id.slide_heading);
        TextView slideDesc = view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_image[position]);
        slideHeading.setText(slide_heading[position]);
        slideDesc.setText(slide_desc[position]);

        container.addView(view);

        return view;
    };

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);
    }
}
