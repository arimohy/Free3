package com.example.free;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class GasFragment extends Fragment {

    RecyclerView recyclerView;
    MyGasRecyclerViewAdapter adapterGas;
    List<cGas> gasList;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).**/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gas_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            gasList=new ArrayList<>();
            gasList.add(new cGas("Lima Gas","https://lh3.googleusercontent.com/_2maZQj-R6GuBKj6aQKvQ1Hs0ILYna1CiAJ-W7khXgabb7vnslvgpAYk17oIX84ME7VB7lDGREoZD0WmRw=w768-h768-n-o-v1"));
            gasList.add(new cGas("Sol Gas","https://http2.mlstatic.com/D_NQ_NP_483125-MPE25373645354_022017-O.jpg"));
            gasList.add(new cGas("Z Gas","https://www.ubicome.pe/assets/img_empresa/z/zeta-gas-cercado-arequipa-balones-de-gas-arequipa-arequipa-63243.jpg"));
            //asignacion del adaptador

            adapterGas=new MyGasRecyclerViewAdapter(gasList, mListener,getActivity());
            recyclerView.setAdapter(adapterGas);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(cGas item);
    }
}
