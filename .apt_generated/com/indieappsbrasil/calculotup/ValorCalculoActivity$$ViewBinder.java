// Generated code from Butter Knife. Do not modify!
package com.indieappsbrasil.calculotup;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ValorCalculoActivity$$ViewBinder<T extends com.indieappsbrasil.calculotup.ValorCalculoActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296271, "field 'txtCimento'");
    target.txtCimento = finder.castView(view, 2131296271, "field 'txtCimento'");
    view = finder.findRequiredView(source, 2131296278, "field 'txtAreia'");
    target.txtAreia = finder.castView(view, 2131296278, "field 'txtAreia'");
    view = finder.findRequiredView(source, 2131296280, "field 'txtAgua'");
    target.txtAgua = finder.castView(view, 2131296280, "field 'txtAgua'");
    view = finder.findRequiredView(source, 2131296279, "field 'txtBrita'");
    target.txtBrita = finder.castView(view, 2131296279, "field 'txtBrita'");
    view = finder.findRequiredView(source, 2131296283, "field 'txtResultado'");
    target.txtResultado = finder.castView(view, 2131296283, "field 'txtResultado'");
  }

  @Override public void unbind(T target) {
    target.txtCimento = null;
    target.txtAreia = null;
    target.txtAgua = null;
    target.txtBrita = null;
    target.txtResultado = null;
  }
}
