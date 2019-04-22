package tmour.sismatix.com.tmour.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import tmour.sismatix.com.tmour.Fregment.Dynamic_Product_freg;
import tmour.sismatix.com.tmour.Model.Librarytablist_model;

public class TAb_PAGER_Adapter extends FragmentPagerAdapter {
    Dynamic_Product_freg frag;
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<Librarytablist_model> mFragmentTitleList = new ArrayList<>();
    private ViewPager viewPager;
    boolean visible;

    private int noOfItems;

    public TAb_PAGER_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return Dynamic_Product_freg.newInstance(
                mFragmentTitleList.get(position).getCategory_id(), visible,
                mFragmentTitleList.get(position).getCategory_title());
    }

    @Override
    public int getCount() {
        /*return noOfItems;*/
        return mFragmentList.size();
    }

    public void addFrag(Fragment fragment, Librarytablist_model title) {

        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position).getCategory_title();
    }
}

