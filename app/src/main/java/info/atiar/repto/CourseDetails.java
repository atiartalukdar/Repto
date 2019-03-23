package info.atiar.repto;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import info.atiar.repto.fragments.AllCourses;
import info.atiar.repto.fragments.MoreAboutTheCourse;
import info.atiar.repto.fragments.Report;
import info.atiar.repto.fragments.SingleCourseDetails;


/**
 * Created by Atiar on 21.02.2019
 */

public class CourseDetails extends AppCompatActivity {
    private final String TAG = getClass().getName() + " Atiar=  ";

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private String CourseTitle = "Dummy Course Title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true); //uncomment to enable backbutton on action bar
        getSupportActionBar().setTitle(CourseTitle); //Dynamic action bar title
        getSupportActionBar().setLogo(R.drawable.ic_actionbar_icon);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        Log.e(TAG, "testing");
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SingleCourseDetails(), "Lectures");
        adapter.addFragment(new MoreAboutTheCourse(), "More");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
