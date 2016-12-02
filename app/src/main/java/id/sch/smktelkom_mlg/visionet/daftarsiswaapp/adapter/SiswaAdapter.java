package id.sch.smktelkom_mlg.visionet.daftarsiswaapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.sch.smktelkom_mlg.visionet.daftarsiswaapp.R;
import id.sch.smktelkom_mlg.visionet.daftarsiswaapp.model.Siswa;

/**
 * Created by hyuam on 24/09/2016.
 */

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.ViewHolder> {
    Context context;
    ArrayList<Siswa> mData;
    ISiswaAdapter mISiswaAdapter;

    public SiswaAdapter(Context context,
                        ArrayList<Siswa> mData) {
        this.context = context;
        this.mData = mData;
        mISiswaAdapter = (ISiswaAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_siswa, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //Log.d("TAG", "onBindViewHolder: getItemCount="+getItemCount());
        final Siswa siswa = mData.get(position);
        holder.tvNama.setText(siswa.nama);
        holder.ivFoto.setImageResource(R.drawable.ic_assignment_black_24dp);
        //Log.d("TAG", "onBindViewHolder: "+siswa.nama);
        holder.llSiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mISiswaAdapter.itemClick(siswa);
            }
        });
        holder.llSiswa.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mISiswaAdapter.itemLongClick(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface ISiswaAdapter {
        void itemClick(Siswa siswa);

        void itemLongClick(int position);

        void doDelete(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.linearLayoutSiswa)
        LinearLayout llSiswa;
        @BindView(R.id.imageViewFoto)
        ImageView ivFoto;
        @BindView(R.id.textViewNama)
        TextView tvNama;
        @BindView(R.id.imageButton)
        ImageButton imgb;

        public ViewHolder(View itemView) {
            super(itemView);
            //ivFoto = (ImageView) itemView.findViewById(R.id.imageViewFoto);
            ButterKnife.bind(this, itemView);


            imgb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mISiswaAdapter.doDelete(getAdapterPosition());


                }
            });
        }


    }


}
