package com.example.peopeletech.model;

import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.peopeletech.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jbathula on 31,January,2020
 */
public class Info {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("rows")
    @Expose
    public List<Row> rows;
    public class Row {

        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("imageHref")
        @Expose
        private String imageHref;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImageHref() {
            return imageHref;
        }

        public void setImageHref(String imageHref) {
            this.imageHref = imageHref;
        }


    }
    @BindingAdapter({ "profileImage" })
    public static  void loadImage(ImageView imageView, String imageURL) {
        if (imageURL != null) {
            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.drawable.user_placeholder)
                    .error(R.drawable.user_placeholder);



            Log.i("URL",imageURL.replace( "http","https" ));
            Glide.with(imageView.getContext()).applyDefaultRequestOptions( options )
                    .load(imageURL.replace( "http","https" ))
                    .into(imageView);
        }
    }
}
