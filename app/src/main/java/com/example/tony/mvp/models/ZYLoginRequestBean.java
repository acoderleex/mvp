package com.example.tony.mvp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tony on 7/11/16.
 */
public class ZYLoginRequestBean implements Parcelable {

    private  String phone;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.phone);
    }

    public ZYLoginRequestBean() {
    }

    protected ZYLoginRequestBean(Parcel in) {
        this.phone = in.readString();
    }

    public static final Parcelable.Creator<ZYLoginRequestBean> CREATOR = new Parcelable.Creator<ZYLoginRequestBean>() {
        @Override
        public ZYLoginRequestBean createFromParcel(Parcel source) {
            return new ZYLoginRequestBean(source);
        }

        @Override
        public ZYLoginRequestBean[] newArray(int size) {
            return new ZYLoginRequestBean[size];
        }
    };
}
