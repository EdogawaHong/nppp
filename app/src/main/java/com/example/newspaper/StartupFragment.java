package com.example.newspaper;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartupFragment extends Fragment {
    ListView listView;
    CustomAdapter customAdapter;
    ArrayList<ReadListView> readListView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.thoi_su_fragment, container, false);

        listView=view.findViewById(R.id.listview);
        readListView=new ArrayList<ReadListView>();


        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ReadRSS().execute("https://vnexpress.net/rss/startup.rss");
    }

    private class ReadRSS extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line);
                }
                bufferedReader.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            XMLDOMParser parser=new XMLDOMParser();
            Document document=parser.getDocument(s);
            NodeList nodeList=document.getElementsByTagName("item");
            NodeList nodeListdescription=document.getElementsByTagName("description");

            String title="";
            String hinhanh="";
            String link="";
            String date="";

            for(int i=0;i<nodeList.getLength();i++){
                String cdata=nodeListdescription.item(i+1).getTextContent();
                Pattern p=Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
                Matcher matcher=p.matcher(cdata);
                if(matcher.find()){
                    hinhanh=matcher.group(1);

                }

                Element element= (Element) nodeList.item(i);
                title=parser.getValue(element,"title");
                date=parser.getValue(element,"pubDate");
                link=parser.getValue(element,"link");
                readListView.add(new ReadListView(title,hinhanh,date,link));
            }
            customAdapter=new CustomAdapter(getContext(),android.R.layout.simple_list_item_1,readListView);
            listView.setAdapter(customAdapter);

        }
    }
}
