package hr.hawa.karim.fersearch.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<BINDING extends ViewDataBinding> extends AppCompatActivity {

    protected AppCompatActivity activity;
    protected BINDING binding;

    protected abstract int defineLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;

        if (defineLayoutId() != 0) {
            binding = DataBindingUtil.setContentView(activity, defineLayoutId());
        }
    }
}
