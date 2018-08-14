package qasir.test.com;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Asad.
 */
public class DetailProductActivity extends AppCompatActivity {

    @BindView(R.id.titleText)
    TextView titleText;

    @BindView(R.id.productName)
    TextView productName;
    @BindView(R.id.productPrice)
    TextView productPrice;
    @BindView(R.id.productDescription)
    TextView productDescription;

    @BindView(R.id.image)
    ImageView image;

    @BindView(R.id.backBtn)
    ImageButton backBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        ButterKnife.bind(this);

        backBtn.setOnClickListener(view->{
            finish();
        });
        Intent intent = getIntent();

        titleText.setText(intent.getStringExtra("product_name"));
        productName.setText(intent.getStringExtra("product_name"));
        productPrice.setText("Rp. "+intent.getStringExtra("product_price"));
        productDescription.setText(Html.fromHtml(intent.getStringExtra("description")));

        Glide.with(getApplicationContext()).load(intent.getStringExtra("image")).into(image);



    }
}
