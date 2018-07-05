package com.example.mypc.firstskool;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class Home_fragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_fragment, container,
                false);
        String[] values={"Data Interpretation","Quantitative Analysis","Verbal Ability","Logical Reasoning","Interview Puzzles","GD & PI"};
        GridView gridView=(GridView)rootView.findViewById(R.id.subject_classification);

        GridAdapter ga=new GridAdapter(getActivity(),values);
        gridView.setAdapter(ga);

        return rootView;
    }
}
class GridAdapter extends BaseAdapter {
    Context context;
    private String[] values;
    View view;
    LayoutInflater layoutInflater;

    public GridAdapter(Context c, String[] values) {
        context = c;
        this.values = values;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View Vview, ViewGroup viewGroup) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (Vview == null) {
            view = new View(context);
            view = layoutInflater.inflate(R.layout.single_idea_for_home_fragment, null);

            TextView textView = (TextView) view.findViewById(R.id.classification);
            textView.setText( values[position]);
        }
        return view;
    }
}

