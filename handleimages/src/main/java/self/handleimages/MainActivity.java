package self.handleimages;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * 图片轮播  2015年9月6日08:07:28
 */
public class MainActivity extends AppCompatActivity {
    private ImageView iv;
    private int indext;
    private int[] images = new int[]{R.mipmap.qqhe,R.mipmap.sc,R.mipmap.sh,R.mipmap.sz,R.mipmap.xg};
    Handler handler = new Handler();
    private MyHandle myHandle = new MyHandle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        handler.postDelayed(myHandle,3000);
    }

    class MyHandle implements Runnable {

        @Override
        public void run() {
            indext++;
            indext = indext%5;
            iv.setImageResource(images[indext]);
            handler.postDelayed(myHandle, 3000);
        }
    }
}


