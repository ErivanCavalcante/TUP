// Generated code from Butter Knife. Do not modify!
package com.indieappsbrasil.calculotup;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class CalculoActivity$$ViewBinder<T extends com.indieappsbrasil.calculotup.CalculoActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296262, "field 'edtAbatimento'");
    target.edtAbatimento = finder.castView(view, 2131296262, "field 'edtAbatimento'");
    view = finder.findRequiredView(source, 2131296266, "field 'spFinura'");
    target.spFinura = finder.castView(view, 2131296266, "field 'spFinura'");
    view = finder.findRequiredView(source, 2131296264, "field 'sptDmax'");
    target.sptDmax = finder.castView(view, 2131296264, "field 'sptDmax'");
    view = finder.findRequiredView(source, 2131296260, "field 'spListaAbatimento' and method 'selecaoAbatimento'");
    target.spListaAbatimento = finder.castView(view, 2131296260, "field 'spListaAbatimento'");
    ((android.widget.AdapterView<?>) view).setOnItemSelectedListener(
      new android.widget.AdapterView.OnItemSelectedListener() {
        @Override public void onItemSelected(
          android.widget.AdapterView<?> p0,
          android.view.View p1,
          int p2,
          long p3
        ) {
          target.selecaoAbatimento(p2);
        }
        @Override public void onNothingSelected(
          android.widget.AdapterView<?> p0
        ) {
          
        }
      });
    view = finder.findRequiredView(source, 2131296268, "field 'edtMassaUni'");
    target.edtMassaUni = finder.castView(view, 2131296268, "field 'edtMassaUni'");
    view = finder.findRequiredView(source, 2131296258, "field 'edtFck'");
    target.edtFck = finder.castView(view, 2131296258, "field 'edtFck'");
  }

  @Override public void unbind(T target) {
    target.edtAbatimento = null;
    target.spFinura = null;
    target.sptDmax = null;
    target.spListaAbatimento = null;
    target.edtMassaUni = null;
    target.edtFck = null;
  }
}
