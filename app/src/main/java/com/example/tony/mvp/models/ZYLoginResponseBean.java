package com.example.tony.mvp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tony on 7/11/16.
 */
public class ZYLoginResponseBean implements Parcelable {

    private String anme;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.anme);
    }

    protected ZYLoginResponseBean(Parcel in) {
        this.anme = in.readString();
    }

    public static final Parcelable.Creator<ZYLoginResponseBean> CREATOR = new Parcelable.Creator<ZYLoginResponseBean>() {
        @Override
        public ZYLoginResponseBean createFromParcel(Parcel source) {
            return new ZYLoginResponseBean(source);
        }

        @Override
        public ZYLoginResponseBean[] newArray(int size) {
            return new ZYLoginResponseBean[size];
        }
    };
}
