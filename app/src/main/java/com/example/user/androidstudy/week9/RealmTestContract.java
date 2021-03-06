package com.example.user.androidstudy.week9;

/**
 * Created by USER on 2017-11-16.
 */

public interface RealmTestContract{

    interface View{
        void toastMessage(String message);
    }

    interface Presenter {
        void attachView(RealmTestContract.View view);
        void detachView();

        void attachAdapter(MemoAdapter adapter);

        void init();

        void postMemo(String userName, String memoTitle, String memoContents);
    }
}