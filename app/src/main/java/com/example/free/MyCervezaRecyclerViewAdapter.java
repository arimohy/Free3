package com.example.free;

import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.free.CervezaFragment.OnListFragmentInteractionListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyCervezaRecyclerViewAdapter extends RecyclerView.Adapter<MyCervezaRecyclerViewAdapter.ViewHolder> {

    private final List<cCerverza> mValues;
    private final CervezaFragment.OnListFragmentInteractionListener mListener;
    private Activity activity;

    public MyCervezaRecyclerViewAdapter(List<cCerverza> items, OnListFragmentInteractionListener listener, Activity activity) {
        mValues = items;
        mListener = listener;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_cerveza, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem  = mValues.get(position);
        holder.textViewMarcaNombre.setText(holder.mItem.getNombreMarca());
        //holder.editTextCantidad.setText(holder.mItem.getCantidad());
        //holder.editTextkilo.setText(holder.mItem.getKilo());


        Picasso.get()
                .load(holder.mItem.getUrlPhoto())
                .resize(400, 150)
                .centerCrop()
                .into(holder.imageViewGas);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewMarcaNombre;
        public final EditText editTextCantidad;
        public final EditText editTextkilo;
        public final Button aBooleanConfirmar;
        public final ImageView imageViewGas;
        public cCerverza mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewMarcaNombre = (TextView) view.findViewById(R.id.textMarcaCerveza);
            editTextCantidad = (EditText) view.findViewById(R.id.editTextKilloCerveza);
            editTextkilo = (EditText) view.findViewById(R.id.editTextKilloCerveza);
            aBooleanConfirmar = (Button) view.findViewById(R.id.buttonConfirmarCerveza);
            imageViewGas = (ImageView) view.findViewById(R.id.imageViewPhotoCerveza);
        }
    }
}
