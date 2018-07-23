package com.example.ducvu212.demorecycleview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    private int[] mIds = { R.id.button_linear, R.id.button_grid, R.id.button_stagged };
    private FragmentActivity mActivity;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (FragmentActivity) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findViewByIds();
        initComponents();
    }

    private void findViewByIds() {
        for (int id : mIds) {
            getActivity().findViewById(id).setOnClickListener(this);
        }
    }

    private void initComponents() {

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager mManager = mActivity.getSupportFragmentManager();
        FragmentTransaction mTransaction = mManager.beginTransaction();
        mTransaction.replace(R.id.layout_main, fragment, "");
        mTransaction.addToBackStack(null);
        mTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        mTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_linear:
                replaceFragment(LinearFragment.newInstance());
                break;

            case R.id.button_grid:
                replaceFragment(GridFragment.newInstance());
                break;

            case R.id.button_stagged:
                replaceFragment(StaggedFragment.newInstance());
                break;

            default:
        }
    }
}
