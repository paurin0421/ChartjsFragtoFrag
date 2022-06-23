package com.example.chartjsfragtofrag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class Fragment2 extends Fragment {
    String graph_html;
    private View view;
    private TextView numlist;
    private String numlist_str;
    WebView webView;
    WebSettings webSettings;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_2, container, false);


        numlist = view.findViewById(R.id.numlist);

        if (getArguments() != null)
        {
            numlist_str= getArguments().getString("numlist"); // 프래그먼트1에서 받아온 값 넣기
            numlist.setText(numlist_str);
        }
        ///// webview 에 해당 값 넣는 영역
        graph_html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <!-- Required meta tags -->\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Chart.js Filled Line Chart</title>\n" +
                "    <!--Chart.js JS CDN-->\n" +
                "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div>\n" +
                "    <canvas id=\"myChart\"></canvas>\n" +
                "</div>\n" +
                "\n" +
                "<script>\n" +
                "    var ctx = document.getElementById('myChart').getContext('2d');\n" +
                "    var myChart = new Chart(ctx, {\n" +
                "        type: 'line',\n" +
                "        data: {\n" +
                "            labels: [\"6/23\", \"6/24\", \"6/25\", \"6/26\", \"6/27\"],\n" +
                "            datasets: [{\n" +
                "                data: "+numlist_str+",\n" +
                "                label: \"Total\",\n" +
                "                borderColor: \"rgb(62,149,205)\",\n" +
                "                backgroundColor: \"rgb(62,149,205,0.1)\",\n" +
                "            }\n" +
                "            ]\n" +
                "        },\n" +
                "    });\n" +
                "</script>\n" +
                "\n" +
                "\n" +
                "<div>\n" +
                "    <canvas id=\"myChar2\"></canvas>\n" +
                "</div>\n" +
                "\n" +
                "<script>\n" +
                "    var ctx = document.getElementById('myChart2').getContext('2d');\n" +
                "    var myChart2 = new Chart(ctx, {\n" +
                "        type: 'bar',\n" +
                "        data: {\n" +
                "            labels: [\"6/23\", \"6/24\", \"6/25\", \"6/26\", \"6/27\"],\n" +
                "            datasets: [{\n" +
                "                data: "+numlist_str+",\n" +
                "                label: \"Total\",\n" +
                "                borderColor: \"rgb(62,149,205)\",\n" +
                "                backgroundColor: \"rgb(62,149,205,0.1)\",\n" +
                "                borderWidth:2\n" +
                "            }\n" +
                "            ]\n" +
                "        },\n" +
                "    });\n" +
                "</script>\n";



        //webview 영역
        webView = (WebView) view.findViewById(R.id.graph);
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadData(graph_html, "text/html; charset=utf-8", null);
        ///////
        return view;
    }


}