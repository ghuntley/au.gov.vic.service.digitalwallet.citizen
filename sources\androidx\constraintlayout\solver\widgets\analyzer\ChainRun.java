package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList<WidgetRun> widgets = new ArrayList<>();

    public ChainRun(ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        this.orientation = i;
        build();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChainRun ");
        sb.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        String sb2 = sb.toString();
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            sb2 = ((sb2 + "<") + it.next()) + "> ";
        }
        return sb2;
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        int size = this.widgets.size();
        for (int i = 0; i < size; i++) {
            if (!this.widgets.get(i).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int size = this.widgets.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            WidgetRun widgetRun = this.widgets.get(i);
            j = j + ((long) widgetRun.start.margin) + widgetRun.getWrapDimension() + ((long) widgetRun.end.margin);
        }
        return j;
    }

    private void build() {
        ConstraintWidget constraintWidget = this.widget;
        ConstraintWidget previousChainMember = constraintWidget.getPreviousChainMember(this.orientation);
        while (true) {
            constraintWidget = previousChainMember;
            if (constraintWidget == null) {
                break;
            }
            previousChainMember = constraintWidget.getPreviousChainMember(this.orientation);
        }
        this.widget = constraintWidget;
        this.widgets.add(constraintWidget.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            this.widgets.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            if (this.orientation == 0) {
                next.widget.horizontalChainRun = this;
            } else if (this.orientation == 1) {
                next.widget.verticalChainRun = this;
            }
        }
        if ((this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.getParent()).isRtl()) && this.widgets.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.widgets;
            this.widget = arrayList.get(arrayList.size() - 1).widget;
        }
        this.chainStyle = this.orientation == 0 ? this.widget.getHorizontalChainStyle() : this.widget.getVerticalChainStyle();
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00cf, code lost:
        if (r2.dimension.resolved != false) goto L_0x00d1;
     */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency, androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void update(Dependency dependency) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        int i6;
        int i7;
        int i8;
        float f2;
        int i9;
        int i10;
        int i11;
        float f3;
        int i12;
        if (this.start.resolved && this.end.resolved) {
            ConstraintWidget parent = this.widget.getParent();
            boolean isRtl = (parent == null || !(parent instanceof ConstraintWidgetContainer)) ? false : ((ConstraintWidgetContainer) parent).isRtl();
            int i13 = this.end.value - this.start.value;
            int size = this.widgets.size();
            int i14 = 0;
            while (true) {
                i = -1;
                i2 = 8;
                if (i14 >= size) {
                    i14 = -1;
                    break;
                }
                if (this.widgets.get(i14).widget.getVisibility() != 8) {
                    break;
                }
                i14++;
            }
            int i15 = size - 1;
            int i16 = i15;
            while (true) {
                if (i16 < 0) {
                    break;
                }
                if (this.widgets.get(i16).widget.getVisibility() != 8) {
                    i = i16;
                    break;
                }
                i16--;
            }
            int i17 = 0;
            while (true) {
                if (i17 >= 2) {
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                    f = 0.0f;
                    break;
                }
                int i18 = 0;
                i4 = 0;
                i5 = 0;
                i12 = 0;
                f = 0.0f;
                while (i18 < size) {
                    WidgetRun widgetRun = this.widgets.get(i18);
                    if (widgetRun.widget.getVisibility() != i2) {
                        i12++;
                        if (i18 > 0 && i18 >= i14) {
                            i4 += widgetRun.start.margin;
                        }
                        int i19 = widgetRun.dimension.value;
                        boolean z = widgetRun.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (!z) {
                            if (widgetRun.matchConstraintsType == 1 && i17 == 0) {
                                i19 = widgetRun.dimension.wrapValue;
                                i5++;
                            }
                            z = true;
                        } else if (this.orientation != 0 || widgetRun.widget.horizontalRun.dimension.resolved) {
                            if (this.orientation == 1 && !widgetRun.widget.verticalRun.dimension.resolved) {
                                return;
                            }
                        } else {
                            return;
                        }
                        if (!z) {
                            i5++;
                            float f4 = widgetRun.widget.mWeight[this.orientation];
                            if (f4 >= 0.0f) {
                                f += f4;
                            }
                        } else {
                            i4 += i19;
                        }
                        if (i18 < i15 && i18 < i) {
                            i4 += -widgetRun.end.margin;
                        }
                    }
                    i18++;
                    i2 = 8;
                }
                if (i4 < i13 || i5 == 0) {
                    i3 = i12;
                } else {
                    i17++;
                    i2 = 8;
                }
            }
            i3 = i12;
            int i20 = this.start.value;
            if (isRtl) {
                i20 = this.end.value;
            }
            if (i4 > i13) {
                i20 = isRtl ? i20 + ((int) ((((float) (i4 - i13)) / 2.0f) + 0.5f)) : i20 - ((int) ((((float) (i4 - i13)) / 2.0f) + 0.5f));
            }
            if (i5 > 0) {
                float f5 = (float) (i13 - i4);
                int i21 = (int) ((f5 / ((float) i5)) + 0.5f);
                int i22 = 0;
                int i23 = 0;
                while (i22 < size) {
                    WidgetRun widgetRun2 = this.widgets.get(i22);
                    if (widgetRun2.widget.getVisibility() != 8 && widgetRun2.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && !widgetRun2.dimension.resolved) {
                        int i24 = f > 0.0f ? (int) (((widgetRun2.widget.mWeight[this.orientation] * f5) / f) + 0.5f) : i21;
                        if (this.orientation == 0) {
                            int i25 = widgetRun2.widget.mMatchConstraintMaxWidth;
                            f3 = f5;
                            i11 = i4;
                            i10 = i20;
                            int max = Math.max(widgetRun2.widget.mMatchConstraintMinWidth, widgetRun2.matchConstraintsType == 1 ? Math.min(i24, widgetRun2.dimension.wrapValue) : i24);
                            if (i25 > 0) {
                                max = Math.min(i25, max);
                            }
                            if (max != i24) {
                                i23++;
                                i24 = max;
                            }
                        } else {
                            i10 = i20;
                            f3 = f5;
                            i11 = i4;
                            int i26 = widgetRun2.widget.mMatchConstraintMaxHeight;
                            int max2 = Math.max(widgetRun2.widget.mMatchConstraintMinHeight, widgetRun2.matchConstraintsType == 1 ? Math.min(i24, widgetRun2.dimension.wrapValue) : i24);
                            if (i26 > 0) {
                                max2 = Math.min(i26, max2);
                            }
                            if (max2 != i24) {
                                i23++;
                                i24 = max2;
                            }
                        }
                        widgetRun2.dimension.resolve(i24);
                    } else {
                        i10 = i20;
                        f3 = f5;
                        i11 = i4;
                    }
                    i22++;
                    i21 = i21;
                    f5 = f3;
                    i4 = i11;
                    i20 = i10;
                }
                i6 = i20;
                if (i23 > 0) {
                    i5 -= i23;
                    int i27 = 0;
                    for (int i28 = 0; i28 < size; i28++) {
                        WidgetRun widgetRun3 = this.widgets.get(i28);
                        if (widgetRun3.widget.getVisibility() != 8) {
                            if (i28 > 0 && i28 >= i14) {
                                i27 += widgetRun3.start.margin;
                            }
                            i27 += widgetRun3.dimension.value;
                            if (i28 < i15 && i28 < i) {
                                i27 += -widgetRun3.end.margin;
                            }
                        }
                    }
                    i4 = i27;
                } else {
                    i4 = i4;
                }
                i7 = 2;
                if (this.chainStyle == 2 && i23 == 0) {
                    i8 = 0;
                    this.chainStyle = 0;
                } else {
                    i8 = 0;
                }
            } else {
                i6 = i20;
                i8 = 0;
                i7 = 2;
            }
            if (i4 > i13) {
                this.chainStyle = i7;
            }
            if (i3 > 0 && i5 == 0 && i14 == i) {
                this.chainStyle = i7;
            }
            int i29 = this.chainStyle;
            if (i29 == 1) {
                if (i3 > 1) {
                    i9 = (i13 - i4) / (i3 - 1);
                } else {
                    i9 = i3 == 1 ? (i13 - i4) / 2 : i8;
                }
                if (i5 > 0) {
                    i9 = i8;
                }
                int i30 = i6;
                for (int i31 = i8; i31 < size; i31++) {
                    WidgetRun widgetRun4 = this.widgets.get(isRtl ? size - (i31 + 1) : i31);
                    if (widgetRun4.widget.getVisibility() == 8) {
                        widgetRun4.start.resolve(i30);
                        widgetRun4.end.resolve(i30);
                    } else {
                        if (i31 > 0) {
                            i30 = isRtl ? i30 - i9 : i30 + i9;
                        }
                        if (i31 > 0 && i31 >= i14) {
                            if (isRtl) {
                                i30 -= widgetRun4.start.margin;
                            } else {
                                i30 += widgetRun4.start.margin;
                            }
                        }
                        if (isRtl) {
                            widgetRun4.end.resolve(i30);
                        } else {
                            widgetRun4.start.resolve(i30);
                        }
                        int i32 = widgetRun4.dimension.value;
                        if (widgetRun4.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.matchConstraintsType == 1) {
                            i32 = widgetRun4.dimension.wrapValue;
                        }
                        i30 = isRtl ? i30 - i32 : i30 + i32;
                        if (isRtl) {
                            widgetRun4.start.resolve(i30);
                        } else {
                            widgetRun4.end.resolve(i30);
                        }
                        widgetRun4.resolved = true;
                        if (i31 < i15 && i31 < i) {
                            i30 = isRtl ? i30 - (-widgetRun4.end.margin) : i30 + (-widgetRun4.end.margin);
                        }
                    }
                }
            } else if (i29 == 0) {
                int i33 = (i13 - i4) / (i3 + 1);
                if (i5 > 0) {
                    i33 = i8;
                }
                int i34 = i6;
                for (int i35 = i8; i35 < size; i35++) {
                    WidgetRun widgetRun5 = this.widgets.get(isRtl ? size - (i35 + 1) : i35);
                    if (widgetRun5.widget.getVisibility() == 8) {
                        widgetRun5.start.resolve(i34);
                        widgetRun5.end.resolve(i34);
                    } else {
                        int i36 = isRtl ? i34 - i33 : i34 + i33;
                        if (i35 > 0 && i35 >= i14) {
                            i36 = isRtl ? i36 - widgetRun5.start.margin : i36 + widgetRun5.start.margin;
                        }
                        if (isRtl) {
                            widgetRun5.end.resolve(i36);
                        } else {
                            widgetRun5.start.resolve(i36);
                        }
                        int i37 = widgetRun5.dimension.value;
                        if (widgetRun5.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.matchConstraintsType == 1) {
                            i37 = Math.min(i37, widgetRun5.dimension.wrapValue);
                        }
                        i34 = isRtl ? i36 - i37 : i36 + i37;
                        if (isRtl) {
                            widgetRun5.start.resolve(i34);
                        } else {
                            widgetRun5.end.resolve(i34);
                        }
                        if (i35 < i15 && i35 < i) {
                            i34 = isRtl ? i34 - (-widgetRun5.end.margin) : i34 + (-widgetRun5.end.margin);
                        }
                    }
                }
            } else if (i29 == 2) {
                if (this.orientation == 0) {
                    f2 = this.widget.getHorizontalBiasPercent();
                } else {
                    f2 = this.widget.getVerticalBiasPercent();
                }
                if (isRtl) {
                    f2 = 1.0f - f2;
                }
                int i38 = (int) ((((float) (i13 - i4)) * f2) + 0.5f);
                if (i38 < 0 || i5 > 0) {
                    i38 = i8;
                }
                int i39 = isRtl ? i6 - i38 : i6 + i38;
                for (int i40 = i8; i40 < size; i40++) {
                    WidgetRun widgetRun6 = this.widgets.get(isRtl ? size - (i40 + 1) : i40);
                    if (widgetRun6.widget.getVisibility() == 8) {
                        widgetRun6.start.resolve(i39);
                        widgetRun6.end.resolve(i39);
                    } else {
                        if (i40 > 0 && i40 >= i14) {
                            if (isRtl) {
                                i39 -= widgetRun6.start.margin;
                            } else {
                                i39 += widgetRun6.start.margin;
                            }
                        }
                        if (isRtl) {
                            widgetRun6.end.resolve(i39);
                        } else {
                            widgetRun6.start.resolve(i39);
                        }
                        int i41 = widgetRun6.dimension.value;
                        if (widgetRun6.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            if (widgetRun6.matchConstraintsType == 1) {
                                i41 = widgetRun6.dimension.wrapValue;
                            }
                        }
                        i39 = isRtl ? i39 - i41 : i39 + i41;
                        if (isRtl) {
                            widgetRun6.start.resolve(i39);
                        } else {
                            widgetRun6.end.resolve(i39);
                        }
                        if (i40 < i15 && i40 < i) {
                            i39 = isRtl ? i39 - (-widgetRun6.end.margin) : i39 + (-widgetRun6.end.margin);
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            this.widgets.get(i).applyToWidget();
        }
    }

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            WidgetRun widgetRun = this.widgets.get(i);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int size = this.widgets.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.widgets.get(size);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int size = this.widgets.size();
        if (size >= 1) {
            ConstraintWidget constraintWidget = this.widgets.get(0).widget;
            ConstraintWidget constraintWidget2 = this.widgets.get(size - 1).widget;
            if (this.orientation == 0) {
                ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
                ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
                DependencyNode target = getTarget(constraintAnchor, 0);
                int margin = constraintAnchor.getMargin();
                ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
                if (firstVisibleWidget != null) {
                    margin = firstVisibleWidget.mLeft.getMargin();
                }
                if (target != null) {
                    addTarget(this.start, target, margin);
                }
                DependencyNode target2 = getTarget(constraintAnchor2, 0);
                int margin2 = constraintAnchor2.getMargin();
                ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
                if (lastVisibleWidget != null) {
                    margin2 = lastVisibleWidget.mRight.getMargin();
                }
                if (target2 != null) {
                    addTarget(this.end, target2, -margin2);
                }
            } else {
                ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
                ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
                DependencyNode target3 = getTarget(constraintAnchor3, 1);
                int margin3 = constraintAnchor3.getMargin();
                ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
                if (firstVisibleWidget2 != null) {
                    margin3 = firstVisibleWidget2.mTop.getMargin();
                }
                if (target3 != null) {
                    addTarget(this.start, target3, margin3);
                }
                DependencyNode target4 = getTarget(constraintAnchor4, 1);
                int margin4 = constraintAnchor4.getMargin();
                ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
                if (lastVisibleWidget2 != null) {
                    margin4 = lastVisibleWidget2.mBottom.getMargin();
                }
                if (target4 != null) {
                    addTarget(this.end, target4, -margin4);
                }
            }
            this.start.updateDelegate = this;
            this.end.updateDelegate = this;
        }
    }
}
