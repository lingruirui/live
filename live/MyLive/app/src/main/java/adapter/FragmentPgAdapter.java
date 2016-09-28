package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/28.
 */
public class FragmentPgAdapter extends FragmentPagerAdapter{
   private ArrayList<Fragment> mList;
    public FragmentPgAdapter(FragmentManager fm, ArrayList<Fragment> mList) {
        super(fm);
        this.mList=mList;
    }

    @Override
    public Fragment getItem(int position) {
        if(mList!=null){
            return mList.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        return mList!=null?mList.size():0;
    }
}
