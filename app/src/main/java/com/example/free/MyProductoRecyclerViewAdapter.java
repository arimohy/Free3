package com.example.free;

import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.free.ProductoFragment.OnListFragmentInteractionListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Producto} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyProductoRecyclerViewAdapter extends RecyclerView.Adapter<MyProductoRecyclerViewAdapter.ViewHolder> {

    private final List<Producto> mValues;
    private final OnListFragmentInteractionListener mListener;
    private Activity activity;

    public MyProductoRecyclerViewAdapter(List<Producto> items, OnListFragmentInteractionListener listener,Activity activity) {
        mValues = items;
        mListener = listener;
        this.activity=activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_producto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.textViewNombreProducto.setText(holder.mItem.getNombre());
        holder.textViewComentario.setText(holder.mItem.getComentario());

        Picasso.get()
                .load(holder.mItem.getUrlPhoto())
                .resize(400,150)
                .centerCrop()
                .into(holder.imageViewProducto);



        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                //    mListener.onListFragmentInteraction(holder.mItem);
                //}

                String vi=holder.mItem.getNombre();
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
        public final TextView textViewNombreProducto;
        public final TextView textViewComentario;
        public final ImageView imageViewProducto;
        public Producto mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewNombreProducto = (TextView) view.findViewById(R.id.textViewNombre);
            textViewComentario = (TextView) view.findViewById(R.id.textViewComentario);
            imageViewProducto=(ImageView) view.findViewById(R.id.imageViewPhotoGas);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewNombreProducto.getText() + "'";
        }
    }
}
