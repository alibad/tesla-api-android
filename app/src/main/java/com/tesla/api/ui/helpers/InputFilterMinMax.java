package com.tesla.api.ui.helpers;

import android.text.InputFilter;
import android.text.Spanned;

import java.math.BigDecimal;

public class InputFilterMinMax implements InputFilter {
    private static final int MIN_SIG_FIG = 2;
    private BigDecimal min, max;

    public InputFilterMinMax(BigDecimal min, BigDecimal max) {
        this.min = min;
        this.max = max;
    }

    public InputFilterMinMax(String min, String max) {
        this.min = new BigDecimal(min);
        this.max = new BigDecimal(max);
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart,
                               int dend) {
        try {
            BigDecimal input = new BigDecimal(dest.toString() + source.toString());

            if (isInRange(min, max, input)) {

                return null;
            }
        } catch (NumberFormatException nfe) {

        }
        return "";
    }

    private boolean isInRange(BigDecimal a, BigDecimal b, BigDecimal c) {
        return b.compareTo(a) > 0 ? c.compareTo(a) >= 0 && c.compareTo(b) <= 0
                : c.compareTo(b) >= 0 && c.compareTo(a) <= 0;
    }
}
