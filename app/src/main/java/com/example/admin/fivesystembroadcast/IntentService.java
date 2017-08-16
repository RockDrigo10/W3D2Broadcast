package com.example.admin.fivesystembroadcast;

import android.content.Intent;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class IntentService extends android.app.IntentService {

    public int imgs[]={
            R.drawable.icon,
            R.drawable.mp,
            R.drawable.camera,
            R.drawable.save,
            R.drawable.stylee,
            R.drawable.user,
            R.drawable.dolphin,
            R.drawable.tiger,
            R.drawable.elephant
    };

    public IntentService() {
        super("ListObject");
    }
    ArrayList<ListObject> randomList = new ArrayList<>();
    SecureRandom randomS = new SecureRandom();
    @Override
    protected void onHandleIntent(Intent intent) {
        switch(intent.getAction()) {
            case "createObject":
                String number1 = new BigInteger(130, randomS).toString(32);
                double random2 = ((double)(new Random()).nextInt(100000 - 1))/100;
                int random3 = (new Random()).nextInt(1000 - 1);
                int random4 = imgs[(new Random()).nextInt(9)];
                randomList.add(new ListObject(number1, random2, random3, random4));
                break;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Intent intent = new Intent();
        intent.setAction("list");
        intent.putExtra("randomList",randomList);
        sendBroadcast(intent);
        super.onDestroy();
    }
}
