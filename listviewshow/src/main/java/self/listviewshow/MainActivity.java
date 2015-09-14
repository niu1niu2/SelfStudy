package self.listviewshow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.btn_main_user)
    private Button btnUser;
    @ViewInject(R.id.btn_main_save)
    private Button btnSave;
    @ViewInject(R.id.btn_main_clear)
    private Button btnClear;
    @ViewInject(R.id.btn_main_loading)
    private Button btnLoading;
    @ViewInject(R.id.lv_main_msg)
    private ListView lvMsg;
    private SimpleAdapter adapter;
    private List<Map<String, Object>> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);
        initData();
    }

    public void initData() {
        datas = new ArrayList<>();
        adapter = new SimpleAdapter(this, datas, R.layout.main_listview_item, new String[]{"name", "number"}, new int[]{R.id.tv_item_name, R.id.tv_item_number});
        lvMsg.setAdapter(adapter);
    }

    @OnClick({R.id.btn_main_loading, R.id.btn_main_clear})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_clear:
                datas.clear();
                adapter.notifyDataSetChanged();
                break;

            case R.id.btn_main_loading:
                setData();
                adapter.notifyDataSetChanged();
                break;
        }
    }

    private void setData() {
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", "李" + i);
            map.put("number", "1200000" + i);
            datas.add(map);
        }
    }
}

