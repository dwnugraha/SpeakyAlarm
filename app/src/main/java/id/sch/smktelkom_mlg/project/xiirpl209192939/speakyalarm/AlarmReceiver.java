package id.sch.smktelkom_mlg.project.xiirpl209192939.speakyalarm;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.speech.tts.TextToSpeech;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class AlarmReceiver extends WakefulBroadcastReceiver {
    TextToSpeech t1;

        @Override
        public void onReceive(final Context context, Intent intent)
        {
            MainActivity inst = MainActivity.instance();
            inst.setAlarmText("Alarm! Wake up! Wake up!");
          Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

//            t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//                @Override
//                public void onInit(int status) {
//                    if(status != TextToSpeech.ERROR) {
//                        t1.setLanguage(Locale.US);
//                    }
//                }
//            });
//            String toSpeak =  ;
//            Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
//            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            if (alarmUri == null)
            {
                alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            }
            Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
            ringtone.play();

            ComponentName comp = new ComponentName(context.getPackageName(),
                    AlarmService.class.getName());
            startWakefulService(context, (intent.setComponent(comp)));
            setResultCode(Activity.RESULT_OK);
        }
}
