package com.example.a16636.save;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Modify extends Activity implements OnClickListener {

	private EditText et_show;
	private Button updateButton,deleteButton,backButton;
	//�������ݿ�
	private MySqliteOpenHelper dbHelper;
	//�����α�
	private Cursor cursor;
	//�����ֶ�id
	private int id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modify);
		init();
	}
	private void init() {
		et_show=(EditText)findViewById(R.id.et_modify);
		Intent intent = getIntent();
		String data = intent.getStringExtra("data");
		// id=Integer.parseInt(intent.getStringExtra("id"));
		 id=intent.getIntExtra("id",id);
		et_show.setText(data);
		//ʵ�������ݿ�
		dbHelper =new MySqliteOpenHelper(this);
		//�õ��α�
		cursor= dbHelper.select();
		updateButton = (Button)findViewById(R.id.tbn_update);
		deleteButton=(Button)findViewById(R.id.btn_delete);
		backButton=(Button)findViewById(R.id.btn_back);
		updateButton.setOnClickListener(this);
		deleteButton.setOnClickListener(this);
		backButton.setOnClickListener(this);
	}
	
	//�޸�����
		public void updateData(){
			//��������id���޸�����
			if(id==0){
				Toast.makeText(Modify.this, "没有数据", Toast.LENGTH_SHORT).show();
				
			}else{
				dbHelper.update(id, et_show.getText().toString());
				//ˢ���α�
				cursor.requery();
				//��ֵ
		//		et_show.setText("");
				//����
				Toast.makeText(Modify.this, "修改成功", Toast.LENGTH_SHORT).show();
				id=0;
			}
		}
		//ɾ������
		public void deleteData(){
			//�ж�id
			if(id==0){
				Toast.makeText(Modify.this, "无数据可以删除", Toast.LENGTH_SHORT).show();
			}else{
				//ͨ��id����ɾ��
				dbHelper.delete(id);
				//ˢ���α�
				cursor.requery();
				//ˢ��list
				//list.invalidateViews();
				//��ֵ
				//et_show.setText("");
				//����
				id=0;
			}
		}
	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.tbn_update:
		updateData();
			Intent intent1 = new Intent(this,main.class);
			startActivity(intent1);
			finish();
			break;

		case R.id.btn_delete:
			deleteData();
			Intent intent = new Intent(this,main.class);
			startActivity(intent);
			finish();
			break;
		case R.id.btn_back:
			Intent intent2 = new Intent(this,main.class);
			startActivity(intent2);
			finish();
			break;
		}
		
	}
}
