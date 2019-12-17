package com.example.free;

import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.free.GasFragment.OnListFragmentInteractionListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link cGas} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyGasRecyclerViewAdapter extends RecyclerView.Adapter<MyGasRecyclerViewAdapter.ViewHolder> {

    private final List<cGas> mValues;
    private final GasFragment.OnListFragmentInteractionListener mListener;
    private Activity activity;

    public MyGasRecyclerViewAdapter(List<cGas> items, OnListFragmentInteractionListener listener,Activity activity) {
        mValues = items;
        mListener = listener;
        this.activity=activity;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_gas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem=mValues.get(position);
        holder.textViewMarcaNombre.setText(holder.mItem.getNombreMarca());
        //holder.editTextCantidad.setText(holder.mItem.getCantidad());
        //holder.editTextkilo.setText(holder.mItem.getKilo());


        Picasso.get()
                .load(holder.mItem.getUrlPhoto())
                .resize(400,150)
                .centerCrop()
                .into(holder.imageViewGas);



        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (null != mListener) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                //    mListener.onListFragmentInteraction(holder.mItem);
                //}

                /***String vi=holder.mItem.getNombreMarca();
                System.out.println(vi);
                if(vi=="Gas") {
                    Intent intent = new Intent(activity,GasActivity.class);
                    activity.startActivity(intent);
                }
                else {
                    if (vi=="Cerveza"){
                        Intent intent = new Intent(activity,CervezaActivity.class );
                        activity.startActivity(intent);
                    }
                    if (vi=="Agua"){
                        Intent intent = new Intent(activity, AguaActivity.class);
                        activity.startActivity(intent);
                    }
                }***/

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
        public final CheckBox aBooleanPrimium;
        public final Button aBooleanConfirmar;
        public final ImageView imageViewGas;
        public cGas mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewMarcaNombre = (TextView) view.findViewById(R.id.textMarcaGas);
            editTextCantidad = (EditText) view.findViewById(R.id.editTextKilloGas);
            editTextkilo=(EditText)view.findViewById(R.id.editTextKilloGas);
            aBooleanPrimium=(CheckBox)view.findViewById(R.id.checkBoxGasPrimium);
            aBooleanConfirmar=(Button)view.findViewById(R.id.buttonConfirmarGas);
            imageViewGas=(ImageView)view.findViewById(R.id.imageViewPhotoGas);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewMarcaNombre.getText() + "'";
        }
    }
}
