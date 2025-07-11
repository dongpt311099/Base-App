// Generated by view binder compiler. Do not edit!
package com.example.baseapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.example.baseapplication.R;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityIntroBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final DotsIndicator dotsIndicator;

  @NonNull
  public final TextView nextIntro1;

  @NonNull
  public final ViewPager2 viewPager;

  private ActivityIntroBinding(@NonNull LinearLayout rootView, @NonNull DotsIndicator dotsIndicator,
      @NonNull TextView nextIntro1, @NonNull ViewPager2 viewPager) {
    this.rootView = rootView;
    this.dotsIndicator = dotsIndicator;
    this.nextIntro1 = nextIntro1;
    this.viewPager = viewPager;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityIntroBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityIntroBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_intro, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityIntroBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.dotsIndicator;
      DotsIndicator dotsIndicator = ViewBindings.findChildViewById(rootView, id);
      if (dotsIndicator == null) {
        break missingId;
      }

      id = R.id.next_intro_1;
      TextView nextIntro1 = ViewBindings.findChildViewById(rootView, id);
      if (nextIntro1 == null) {
        break missingId;
      }

      id = R.id.viewPager;
      ViewPager2 viewPager = ViewBindings.findChildViewById(rootView, id);
      if (viewPager == null) {
        break missingId;
      }

      return new ActivityIntroBinding((LinearLayout) rootView, dotsIndicator, nextIntro1,
          viewPager);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
