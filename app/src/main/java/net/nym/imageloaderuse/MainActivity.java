package net.nym.imageloaderuse;

import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import net.nym.frescoimageloaderlibrary.impl.FrescoImageLoaderImpl;
import net.nym.imageloaderlibrary.operation.NImageLoader;
import net.nym.imageloaderlibrary.operation.NImageOptions;

public class MainActivity extends AppCompatActivity {

    SimpleDraweeView image1,image2,image3,image4,image5,image6,image7,image8;
    NImageLoader<SimpleDraweeView> imageLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageLoader = FrescoImageLoaderImpl.getInstance(this);
        setContentView(R.layout.activity_main);
        image1 = findView(R.id.image1);
        image2 = findView(R.id.image2);
        image3 = findView(R.id.image3);
        image4 = findView(R.id.image4);
        image5 = findView(R.id.image5);
        image6 = findView(R.id.image6);
        image7 = findView(R.id.image7);
        image8 = findView(R.id.image8);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageLoader.toggleAnimate(image1);
            }
        });
        imageLoader.setImageAnimateURI(image1,"res:///" + R.mipmap.gif);

        String[] images = {
                "http://h.hiphotos.baidu.com/image/h%3D200/sign=066ddaa1ae014c08063b2fa53a7b025b/023b5bb5c9ea15ced99ab701b1003af33a87b246.jpg"
                ,"http://g.hiphotos.baidu.com/image/h%3D200/sign=838884f57c899e51678e3d1472a6d990/b999a9014c086e06abe7684305087bf40ad1cb6f.jpg"
                ,"http://b.hiphotos.baidu.com/image/h%3D200/sign=bea54b927e310a55db24d9f487444387/503d269759ee3d6d1c6856aa44166d224f4ade21.jpg"
                ,"http://c.hiphotos.baidu.com/image/h%3D300/sign=5bffe3d59b82d158a4825fb1b00b19d5/0824ab18972bd407bf0cb6c67c899e510eb309c5.jpg"
                ,"http://a.hiphotos.baidu.com/image/h%3D300/sign=da03ef026c63f624035d3f03b744eb32/203fb80e7bec54e71ecd7e25be389b504fc26ae3.jpg"
                ,"http://a.hiphotos.baidu.com/image/h%3D300/sign=da03ef026c63f624035d3f03b744eb32/203fb80e7bec54e71ecd7e25be389b504fc26ae3.jpg"
                ,"http://a.hiphotos.baidu.com/image/h%3D300/sign=da03ef026c63f624035d3f03b744eb32/203fb80e7bec54e71ecd7e25be389b504fc26ae3.jpg"
        };
        imageLoader.setImageURI(image2,images[0]);
        imageLoader.setImageCorner(image3, Uri.parse(images[1]),10);
        imageLoader.setImageCorner(image4, Uri.parse(images[2]),0,5,10,15);
        imageLoader.setImageCornerWithBorder(image5, Uri.parse(images[3]),8,R.color.colorAccent,2);
        imageLoader.setImageCircle(image6,Uri.parse(images[4]),0);
        imageLoader.setImageCircleWithBorder(image7,Uri.parse(images[5]),0,R.color.colorPrimary,5);

        NImageOptions options = new NImageOptions.Builder()
                .asCircle(false)
                .setImageResRetry(R.mipmap.ic_launcher)
                .build();
        imageLoader.setImageURI(image8,Uri.parse(images[6]),options);
    }


    private <T extends View> T findView(@IdRes int res){
        return (T)findViewById(res);
    }
}
