package com.example.projectsamsung;

public class MyTask {
    private OnTaskCompleted mListener;

    public interface OnTaskCompleted {
        void onCompleted();

    }

    public void setOnTaskCompletedListener(OnTaskCompleted listener) {
        mListener = listener;
    }

    private void onPostExecute() {
        if (mListener != null){
            mListener.onCompleted();
        }
    }

}
