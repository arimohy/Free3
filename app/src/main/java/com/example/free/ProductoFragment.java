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
public class ProductoFragment extends Fragment {
    RecyclerView recyclerView;
    MyProductoRecyclerViewAdapter adapterProductos;
    List<Producto> productosList;
    // TODO: Customize parameters
    private int mColumnCount = 1;

    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ProductoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_producto_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            //lista de productos
            productosList=new ArrayList<>();
            productosList.add(new Producto("Gas","https://http2.mlstatic.com/venta-de-balones-de-gas-al-por-mayor-y-menor-D_NQ_NP_483125-MPE25373645354_022017-F.jpg","Escoger Gas"));
            productosList.add(new Producto("Cerveza","https://elbunker.pe/wp-content/uploads/2017/09/cervezas-mas-populares-del-peru.jpg","Escoger Cerveza"));
            productosList.add(new Producto("Agua","https://publimetro.pe/resizer/Tq2lMmrg_6wdkKardH9U_bAPFPI=/980x528/smart/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/KJLMASIUYJAO3DQ6VP3APXLQXA.jpg","Escoger AguaActivity"));
            //asignacion del adaptador

            adapterProductos=new MyProductoRecyclerViewAdapter(productosList, mListener,getActivity());
            recyclerView.setAdapter(adapterProductos);
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
        void onListFragmentInteraction(Producto item);
    }
}
