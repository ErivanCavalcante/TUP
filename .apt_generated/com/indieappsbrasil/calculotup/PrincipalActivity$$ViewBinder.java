// Generated code from Butter Knife. Do not modify!
package com.indieappsbrasil.calculotup;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class PrincipalActivity$$ViewBinder<T extends com.indieappsbrasil.calculotup.PrincipalActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296276, "field 'spTipo'");
    target.spTipo = finder.castView(view, 2131296276, "field 'spTipo'");
  }

  @Override public void unbind(T target) {
    target.spTipo = null;
  }
}
