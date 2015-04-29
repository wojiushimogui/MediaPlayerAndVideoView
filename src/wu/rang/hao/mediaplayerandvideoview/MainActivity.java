package wu.rang.hao.mediaplayerandvideoview;

import java.io.File;
import java.io.IOException;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	//������Ƶ�Ŀؼ����£�
	private Button buttonPlayMedia;
	private Button buttonPasueMedia;
	private Button buttonStopMedia;
	private TextView textViewMedia;
	private MediaPlayer mediaPlayer=new MediaPlayer();
	//������Ƶ�Ŀؼ����£�
	private Button buttonPlayVideo;
	private Button buttonPasueVideo;
	private Button buttonResumeVideo;
	private TextView textViewVideo;
	private VideoView videoView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		buttonPlayMedia=(Button)findViewById(R.id.playMedia);
		buttonPasueMedia=(Button)findViewById(R.id.pasueMedia);
		buttonStopMedia=(Button)findViewById(R.id.stopMedia);
		textViewMedia=(TextView)findViewById(R.id.textViewId2);
		initsMediaPlayer();
		buttonPlayMedia.setOnClickListener(this);
		buttonPasueMedia.setOnClickListener(this);
		buttonStopMedia.setOnClickListener(this);
		
		
		buttonPlayVideo=(Button)findViewById(R.id.playVideo);
		buttonPasueVideo=(Button)findViewById(R.id.pasueVideo);
		buttonResumeVideo=(Button)findViewById(R.id.resumeVideo);
		textViewVideo=(TextView)findViewById(R.id.textViewId4);
		videoView=(VideoView)findViewById(R.id.videoView);
		initsVideoPath();
		buttonPlayVideo.setOnClickListener(this);
		buttonPasueVideo.setOnClickListener(this);
		buttonResumeVideo.setOnClickListener(this);
		
	}

	
	public void initsMediaPlayer(){
		//System.out.println(Environment.getExternalStorageDirectory());
		//File file=new File(Environment.getExternalStorageDirectory(),"1.mp3");
		//File file=new File("/mnt/storage/emulated","wuranghao.mp3");
		try {
			//System.out.println("1>>>>>>>"+file.getPath());
			//mediaPlayer.setDataSource("/mnt/Sdk/wuranghao.mp3");
			mediaPlayer=MediaPlayer.create(MainActivity.this, R.raw.wuranghao);
			//System.out.println("2>>>>>>>"+file.getPath());
			//mediaPlayer.prepare();
			//System.out.println("3>>>>>>>"+file.getPath());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void initsVideoPath(){
		//File file= new File(Environment.getExternalStorageDirectory(),"1.mp4");
		//videoView.setVideoPath(file.getPath());
		videoView.setVideoURI(Uri.parse(Environment.getExternalStorageDirectory()+"/1.mp4"));
		
		//File file= new File(Environment.getExternalStorageDirectory()+"/1.3gp");
		//videoView.setVideoPath(file.getAbsolutePath());
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.playMedia:
			if(!mediaPlayer.isPlaying()){
				System.out.println("���ڲ�����Ƶ------1");
				textViewMedia.setText("���ڲ�����Ƶ");
				mediaPlayer.start();
				System.out.println("���ڲ�����Ƶ------2");
			}
			break;
		case R.id.pasueMedia:
			if(mediaPlayer.isPlaying()){
				System.out.println("��ͣ������Ƶ------1");
				mediaPlayer.pause();
				textViewMedia.setText("��ͣ������Ƶ");
				System.out.println("��ͣ������Ƶ------2");
			}
			break;
		case R.id.stopMedia:
			if(mediaPlayer.isPlaying()){
				System.out.println("ֹͣ������Ƶ------1");
				mediaPlayer.stop();
				textViewMedia.setText("������Ƶֹͣ");
				System.out.println("ֹͣ������Ƶ------2");
			}
			break;
		case R.id.playVideo:
			if(!videoView.isPlaying()){
				System.out.println("��ʼ������Ƶ------1");
				videoView.isPlaying();
				textViewVideo.setText("���ڲ�����Ƶ");
				System.out.println("��ʼ������Ƶ------2");
				
			}
			break;
		case R.id.pasueVideo:
			if(videoView.isPlaying()){
				System.out.println("ֹͣ������Ƶ------1");
				videoView.pause();
				textViewVideo.setText("��ͣ������Ƶ");
				System.out.println("ֹͣ������Ƶ------2");
			}
			break;
		case R.id.resumeVideo:
			if(videoView.isPlaying()){
				System.out.println("���²�����Ƶ------1");
				videoView.resume();
				textViewVideo.setText("���²�����Ƶ");
				System.out.println("���²�����Ƶ------2");
			}
			break;
		default :
				break;
		}
		
	}


	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if(mediaPlayer!=null){
			mediaPlayer.stop();
			mediaPlayer.release();
		}
		if(videoView!=null){
			videoView.suspend();
		}
	}
}
