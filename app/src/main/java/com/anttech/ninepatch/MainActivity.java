package com.anttech.ninepatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView msgListView;
    private EditText editText;
    private Button sendButton;
    private MsgAdapter msgAdapter;
    private List<Msg> msgList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMsg();
        msgAdapter=new MsgAdapter(MainActivity.this,R.layout.msg_item,msgList);

        msgListView= (ListView) findViewById(R.id.msg_list_view);
        msgListView.setAdapter(msgAdapter);
        editText= (EditText) findViewById(R.id.input_edit_text);
        sendButton= (Button) findViewById(R.id.send_button);

        sendButton.setOnClickListener(this);

    }

    public void initMsg() {
        Msg msg1=new Msg("Hello world............................",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2=new Msg("Ni hao",Msg.TYPE_SEND);
        msgList.add(msg2);
    }

    @Override
    public void onClick(View v) {
        String content=editText.getText().toString();
        if (!("".equals(content))){
            Msg msg=new Msg(content,Msg.TYPE_SEND);
            msgList.add(msg);
            msgAdapter.notifyDataSetChanged();
            msgListView.setSelection(msgList.size());

            editText.setText("");
        }
    }
}
