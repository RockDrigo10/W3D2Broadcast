package com.example.admin.fivesystembroadcast;

import android.os.Parcel;
import android.os.Parcelable;

public class ListObject implements Parcelable {

    String random1;
    double random2;
    int random3;
    int random4;

    public ListObject(String random1, double random2, int random3, int random4) {
        this.random1 = random1;
        this.random2 = random2;
        this.random3 = random3;
        this.random4 = random4;
    }

    protected ListObject(Parcel in) {
        random1 = in.readString();
        random2 = in.readDouble();
        random3 = in.readInt();
        random4 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(random1);
        dest.writeDouble(random2);
        dest.writeInt(random3);
        dest.writeInt(random4);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ListObject> CREATOR = new Creator<ListObject>() {
        @Override
        public ListObject createFromParcel(Parcel in) {
            return new ListObject(in);
        }

        @Override
        public ListObject[] newArray(int size) {
            return new ListObject[size];
        }
    };

    public String getRandom1() {
        return random1;
    }
    public double getRandom2() {
        return random2;
    }
    public int getRandom3() {
        return random3;
    }
    public int getRandom4() {
        return random4;
    }
}
