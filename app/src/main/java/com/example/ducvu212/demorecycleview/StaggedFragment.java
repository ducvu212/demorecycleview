package com.example.ducvu212.demorecycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class StaggedFragment extends Fragment implements interfaceImage{

    private AdapterImage mAdapterImage;
    private ArrayList<Item> mItemArrayList;
    private RecyclerView mRecyclerView;

    public StaggedFragment() {
        // Required empty public constructor
    }

    public static StaggedFragment newInstance() {
        StaggedFragment fragment = new StaggedFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stagged, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findViewByIds();
        initComponents();
    }

    private void initComponents() {
        mItemArrayList = new ArrayList<>() ;
        mItemArrayList.add(new Item(R.drawable.image1));
        mItemArrayList.add(new Item(R.drawable.image2));
        mItemArrayList.add(new Item(R.drawable.image3));
        mItemArrayList.add(new Item(R.drawable.image4));
        mItemArrayList.add(new Item(R.drawable.image5));
        mItemArrayList.add(new Item(R.drawable.image6));
        mItemArrayList.add(new Item(R.drawable.image7));
        mItemArrayList.add(new Item(R.drawable.image8));
        mAdapterImage = new AdapterImage(mRecyclerView, getActivity(),this, mItemArrayList);
        mRecyclerView.setAdapter(mAdapterImage);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(position % 3 ==  0) {
                    return 2;
                } else if (position % 3 == 1){
                    return 3 ;
                }else  {
                    return 1;
                }
            }
        });
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.addItemDecoration(new ItemOffsetDecoration(10));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void findViewByIds() {
        mRecyclerView = getActivity().findViewById(R.id.recycleview_stagged);
    }

    @Override
    public Item getItem(int position) {
        return mItemArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return mItemArrayList.size();
    }
}
