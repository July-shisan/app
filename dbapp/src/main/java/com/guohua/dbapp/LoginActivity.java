package com.guohua.dbapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.fastjson.JSON;
import com.guohua.vo.Category;
import com.guohua.vo.Comment;
import com.guohua.vo.Introduction;
import com.guohua.vo.News;

import org.apache.commons.io.IOUtils;
import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ContentView(R.layout.login)
public class LoginActivity extends AppCompatActivity {
    @ViewInject(R.id.username)
    private EditText username;
    @ViewInject(R.id.password)
    private  EditText password;
    @ViewInject(R.id.login)
    private Button login;
    @ViewInject(R.id.delete)
    private Button delete;
    @ViewInject(R.id.update)
    private Button update;
    @ViewInject(R.id.query)
    private Button query;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.login);
        x.view().inject(this);
    }
    @Event(value={R.id.login,R.id.regist,R.id.delete,R.id.update,R.id.query})
    private void doEvent(View view){
        SQLiteDatabase db = Connector.getWritableDatabase();
        switch (view.getId()){
            case R.id.login:
                try {
                    FileOutputStream fos=openFileOutput("msg.json",MODE_PRIVATE);
                    String name=username.getText().toString();
                    String pwd=password.getText().toString();
                    HashMap<String,Object> map=new HashMap<>();
                    map.put("username",name);
                    map.put("password",pwd);
                    String data= JSON.toJSONString(map);
                    IOUtils.write(data,fos,"UTF-8");
                    fos.close();

           /* FileInputStream fis=openFileInput("msg.json");
            List<String> list=IOUtils.readLines(fis,"utf-8");
            String result=list.get(0);
            JSONObject object=(JSONObject) JSON.parse(result);
            String uNmae=(String) object.get("username");*/

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.regist:
                Log.i("dbdbdb","dbdbdb");

                //插入操作
                News news1 = new News("NBA","欧文",1000);
                News news2 = new News("lol","s7",999);

                Comment co1=new Comment("this is first comment!");
                Comment co2=new Comment("this is second comment!");
                co1.save();
                co2.save();
                ArrayList<Comment> con = new ArrayList<>();
                con.add(co1);
                con.add(co2);
                news1.setComments(con);
                news2.setComments(con);

                Category c1 = new Category("体育");
                Category c2 = new Category("推荐");
                Category c3 = new Category("游戏");
                c1.save();
                c2.save();
                ArrayList<Category> cs1 = new ArrayList<>();
                ArrayList<Category> cs2 = new ArrayList<>();
                cs1.add(c1);
                cs1.add(c2);
                cs2.add(c2);
                cs2.add(c3);
                news1.setCategories(cs1);
                news2.setCategories(cs2);

                news1.save();
                news2.save();
                Introduction i1=new Introduction("this is a introduction!");
                Introduction i2=new Introduction("this is another introduction!");
                i1.setNews(news1);
                i2.setNews(news2);
                i1.save();
                i2.save();
                break;
            case R.id.delete:
                DataSupport.delete(News.class,3);
                break;
            case R.id.update:
                ContentValues values=new ContentValues();
                values.put("title","lol_wzry");
                DataSupport.update(News.class,values,2);
                /*优雅的更新
                News updateNews=new News();
                updateNews.setTitle("wzry");
                updateNews.update(2);*/
                break;
            case R.id.query:
                News qn=DataSupport.find(News.class,1);
                System.out.print("查询结果"+qn.getTitle()+qn.getContent());
                break;
            default:
                break;
        }
    }
}
