package qasir.test.com;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import qasir.test.com.pojo.Pojo;

/**
 * Created by Asad.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Viewholder> {

    private Context context;
    List<Pojo.Product> data;

    private int selected_position = -1;

    public RecyclerViewAdapter(Context context, List<Pojo.Product> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(context).inflate(R.layout.item_product, null);
                Viewholder viewholder = new Viewholder(view);
                return viewholder;

    }


    @Override
    public void onBindViewHolder(Viewholder holder, int position) {

        Pojo.Product item = data.get(position);


        Glide.with(context).load(item.getImages().getThumbnail()).into(holder.img);

        holder.name.setText(item.getProductName());

        NumberFormat nf = NumberFormat.getNumberInstance();
        String cPrice = nf.format(item.getPrice());
        String priceStr = cPrice.replaceAll(",", ".");


        holder.price.setText("Rp. "+priceStr);
        holder.stock.setText(item.getStock().toString());


        holder.wrapper.setOnClickListener(view ->{
            Intent intent =new Intent(context, DetailProductActivity.class);
            intent.putExtra("image", item.getImages().getLarge());
            intent.putExtra("product_name", item.getProductName());
            intent.putExtra("product_price", priceStr);
            intent.putExtra("description",item.getDescription());

            context.startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        @BindView(R.id.wrapper)
        View wrapper;

        @BindView(R.id.img)
        ImageView img;

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.price)
        TextView price;

        @BindView(R.id.stock)
        TextView stock;

        public Viewholder(View itemView) {
            super(itemView);
            try {
                ButterKnife.bind(this, itemView);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }


}