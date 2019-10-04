// Generated code from Butter Knife. Do not modify!
package com.indieappsbrasil.calculotup;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class CalculoABCPActivity$$ViewBinder<T extends com.indieappsbrasil.calculotup.CalculoABCPActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296258, "field 'edtFck'");
    target.edtFck = finder.castView(view, 2131296258, "field 'edtFck'");
    view = finder.findRequiredView(source, 2131296264, "field 'sptDmax'");
    target.sptDmax = finder.castView(view, 2131296264, "field 'sptDmax'");
    view = finder.findRequiredView(source, 2131296272, "field 'edtGamaM'");
    target.edtGamaM = finder.castView(view, 2131296272, "field 'edtGamaM'");
    view = finder.findRequiredView(source, 2131296268, "field 'edtMassaUni'");
    target.edtMassaUni = finder.castView(view, 2131296268, "field 'edtMassaUni'");
    view = finder.findRequiredView(source, 2131296273, "field 'edtGamaG'");
    target.edtGamaG = finder.castView(view, 2131296273, "field 'edtGamaG'");
    view = finder.findRequiredView(source, 2131296262, "field 'edtAbatimento'");
    target.edtAbatimento = finder.castView(view, 2131296262, "field 'edtAbatimento'");
    view = finder.findRequiredView(source, 2131296269, "field 'spTipoCimento'");
    target.spTipoCimento = finder.castView(view, 2131296269, "field 'spTipoCimento'");
    view = finder.findRequiredView(source, 2131296266, "field 'spFinura'");
    target.spFinura = finder.castView(view, 2131296266, "field 'spFinura'");
    view = finder.findRequiredView(source, 2131296274, "field 'edtGamaC'");
    target.edtGamaC = finder.castView(view, 2131296274, "field 'edtGamaC'");
  }

  @Override public void unbind(T target) {
    target.edtFck = null;
    target.sptDmax = null;
    target.edtGamaM = null;
    target.edtMassaUni = null;
    target.edtGamaG = null;
    target.edtAbatimento = null;
    target.spTipoCimento = null;
    target.spFinura = null;
    target.edtGamaC = null;
  }
}
