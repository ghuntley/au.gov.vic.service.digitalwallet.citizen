package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

public class HorizontalWidgetRun extends WidgetRun {
    private static int[] tempDimensions = new int[2];

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.start.type = DependencyNode.Type.LEFT;
        this.end.type = DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    public String toString() {
        return "HorizontalRun " + this.widget.getDebugName();
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.dimension.resolved = false;
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.widget.mMatchConstraintDefaultWidth == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        if (this.widget.measured) {
            this.dimension.resolve(this.widget.getWidth());
        }
        if (!this.dimension.resolved) {
            this.dimensionBehavior = this.widget.getHorizontalDimensionBehaviour();
            if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (((parent2 = this.widget.getParent()) != null && parent2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) || parent2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
                    int width = (parent2.getWidth() - this.widget.mLeft.getMargin()) - this.widget.mRight.getMargin();
                    addTarget(this.start, parent2.horizontalRun.start, this.widget.mLeft.getMargin());
                    addTarget(this.end, parent2.horizontalRun.end, -this.widget.mRight.getMargin());
                    this.dimension.resolve(width);
                    return;
                } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.dimension.resolve(this.widget.getWidth());
                }
            }
        } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (((parent = this.widget.getParent()) != null && parent.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) || parent.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
            addTarget(this.start, parent.horizontalRun.start, this.widget.mLeft.getMargin());
            addTarget(this.end, parent.horizontalRun.end, -this.widget.mRight.getMargin());
            return;
        }
        if (!this.dimension.resolved || !this.widget.measured) {
            if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                int i = this.widget.mMatchConstraintDefaultWidth;
                if (i == 2) {
                    ConstraintWidget parent3 = this.widget.getParent();
                    if (parent3 != null) {
                        DimensionDependency dimensionDependency = parent3.verticalRun.dimension;
                        this.dimension.targets.add(dimensionDependency);
                        dimensionDependency.dependencies.add(this.dimension);
                        this.dimension.delegateToWidgetRun = true;
                        this.dimension.dependencies.add(this.start);
                        this.dimension.dependencies.add(this.end);
                    }
                } else if (i == 3) {
                    if (this.widget.mMatchConstraintDefaultHeight == 3) {
                        this.start.updateDelegate = this;
                        this.end.updateDelegate = this;
                        this.widget.verticalRun.start.updateDelegate = this;
                        this.widget.verticalRun.end.updateDelegate = this;
                        this.dimension.updateDelegate = this;
                        if (this.widget.isInVerticalChain()) {
                            this.dimension.targets.add(this.widget.verticalRun.dimension);
                            this.widget.verticalRun.dimension.dependencies.add(this.dimension);
                            this.widget.verticalRun.dimension.updateDelegate = this;
                            this.dimension.targets.add(this.widget.verticalRun.start);
                            this.dimension.targets.add(this.widget.verticalRun.end);
                            this.widget.verticalRun.start.dependencies.add(this.dimension);
                            this.widget.verticalRun.end.dependencies.add(this.dimension);
                        } else if (this.widget.isInHorizontalChain()) {
                            this.widget.verticalRun.dimension.targets.add(this.dimension);
                            this.dimension.dependencies.add(this.widget.verticalRun.dimension);
                        } else {
                            this.widget.verticalRun.dimension.targets.add(this.dimension);
                        }
                    } else {
                        DimensionDependency dimensionDependency2 = this.widget.verticalRun.dimension;
                        this.dimension.targets.add(dimensionDependency2);
                        dimensionDependency2.dependencies.add(this.dimension);
                        this.widget.verticalRun.start.dependencies.add(this.dimension);
                        this.widget.verticalRun.end.dependencies.add(this.dimension);
                        this.dimension.delegateToWidgetRun = true;
                        this.dimension.dependencies.add(this.start);
                        this.dimension.dependencies.add(this.end);
                        this.start.targets.add(this.dimension);
                        this.end.targets.add(this.dimension);
                    }
                }
            }
            if (this.widget.mListAnchors[0].mTarget == null || this.widget.mListAnchors[1].mTarget == null) {
                if (this.widget.mListAnchors[0].mTarget != null) {
                    DependencyNode target = getTarget(this.widget.mListAnchors[0]);
                    if (target != null) {
                        addTarget(this.start, target, this.widget.mListAnchors[0].getMargin());
                        addTarget(this.end, this.start, 1, this.dimension);
                    }
                } else if (this.widget.mListAnchors[1].mTarget != null) {
                    DependencyNode target2 = getTarget(this.widget.mListAnchors[1]);
                    if (target2 != null) {
                        addTarget(this.end, target2, -this.widget.mListAnchors[1].getMargin());
                        addTarget(this.start, this.end, -1, this.dimension);
                    }
                } else if (!(this.widget instanceof Helper) && this.widget.getParent() != null) {
                    addTarget(this.start, this.widget.getParent().horizontalRun.start, this.widget.getX());
                    addTarget(this.end, this.start, 1, this.dimension);
                }
            } else if (this.widget.isInHorizontalChain()) {
                this.start.margin = this.widget.mListAnchors[0].getMargin();
                this.end.margin = -this.widget.mListAnchors[1].getMargin();
            } else {
                DependencyNode target3 = getTarget(this.widget.mListAnchors[0]);
                DependencyNode target4 = getTarget(this.widget.mListAnchors[1]);
                target3.addDependency(this);
                target4.addDependency(this);
                this.mRunType = WidgetRun.RunType.CENTER;
            }
        } else if (this.widget.mListAnchors[0].mTarget == null || this.widget.mListAnchors[1].mTarget == null) {
            if (this.widget.mListAnchors[0].mTarget != null) {
                DependencyNode target5 = getTarget(this.widget.mListAnchors[0]);
                if (target5 != null) {
                    addTarget(this.start, target5, this.widget.mListAnchors[0].getMargin());
                    addTarget(this.end, this.start, this.dimension.value);
                }
            } else if (this.widget.mListAnchors[1].mTarget != null) {
                DependencyNode target6 = getTarget(this.widget.mListAnchors[1]);
                if (target6 != null) {
                    addTarget(this.end, target6, -this.widget.mListAnchors[1].getMargin());
                    addTarget(this.start, this.end, -this.dimension.value);
                }
            } else if (!(this.widget instanceof Helper) && this.widget.getParent() != null && this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null) {
                addTarget(this.start, this.widget.getParent().horizontalRun.start, this.widget.getX());
                addTarget(this.end, this.start, this.dimension.value);
            }
        } else if (this.widget.isInHorizontalChain()) {
            this.start.margin = this.widget.mListAnchors[0].getMargin();
            this.end.margin = -this.widget.mListAnchors[1].getMargin();
        } else {
            DependencyNode target7 = getTarget(this.widget.mListAnchors[0]);
            if (target7 != null) {
                addTarget(this.start, target7, this.widget.mListAnchors[0].getMargin());
            }
            DependencyNode target8 = getTarget(this.widget.mListAnchors[1]);
            if (target8 != null) {
                addTarget(this.end, target8, -this.widget.mListAnchors[1].getMargin());
            }
            this.start.delegateToWidgetRun = true;
            this.end.delegateToWidgetRun = true;
        }
    }

    private void computeInsetRatio(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 == -1) {
            int i8 = (int) ((((float) i7) * f) + 0.5f);
            int i9 = (int) ((((float) i6) / f) + 0.5f);
            if (i8 <= i6 && i7 <= i7) {
                iArr[0] = i8;
                iArr[1] = i7;
            } else if (i6 <= i6 && i9 <= i7) {
                iArr[0] = i6;
                iArr[1] = i9;
            }
        } else if (i5 == 0) {
            iArr[0] = (int) ((((float) i7) * f) + 0.5f);
            iArr[1] = i7;
        } else if (i5 == 1) {
            iArr[0] = i6;
            iArr[1] = (int) ((((float) i6) * f) + 0.5f);
        }
    }

    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType = iArr;
            iArr[WidgetRun.RunType.START.ordinal()] = 1;
            $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.END.ordinal()] = 2;
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02e6, code lost:
        if (r14 != 1) goto L_0x0351;
     */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency, androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void update(Dependency dependency) {
        int i;
        float f;
        float f2;
        float f3;
        int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (i2 == 1) {
            updateRunStart(dependency);
        } else if (i2 == 2) {
            updateRunEnd(dependency);
        } else if (i2 == 3) {
            updateRunCenter(dependency, this.widget.mLeft, this.widget.mRight, 0);
            return;
        }
        if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i3 = this.widget.mMatchConstraintDefaultWidth;
            if (i3 == 2) {
                ConstraintWidget parent = this.widget.getParent();
                if (parent != null && parent.horizontalRun.dimension.resolved) {
                    this.dimension.resolve((int) ((((float) parent.horizontalRun.dimension.value) * this.widget.mMatchConstraintPercentWidth) + 0.5f));
                }
            } else if (i3 == 3) {
                if (this.widget.mMatchConstraintDefaultHeight == 0 || this.widget.mMatchConstraintDefaultHeight == 3) {
                    DependencyNode dependencyNode = this.widget.verticalRun.start;
                    DependencyNode dependencyNode2 = this.widget.verticalRun.end;
                    boolean z = this.widget.mLeft.mTarget != null;
                    boolean z2 = this.widget.mTop.mTarget != null;
                    boolean z3 = this.widget.mRight.mTarget != null;
                    boolean z4 = this.widget.mBottom.mTarget != null;
                    int dimensionRatioSide = this.widget.getDimensionRatioSide();
                    if (z && z2 && z3 && z4) {
                        float dimensionRatio = this.widget.getDimensionRatio();
                        if (!dependencyNode.resolved || !dependencyNode2.resolved) {
                            if (this.start.resolved && this.end.resolved) {
                                if (dependencyNode.readyToSolve && dependencyNode2.readyToSolve) {
                                    computeInsetRatio(tempDimensions, this.start.value + this.start.margin, this.end.value - this.end.margin, dependencyNode.targets.get(0).value + dependencyNode.margin, dependencyNode2.targets.get(0).value - dependencyNode2.margin, dimensionRatio, dimensionRatioSide);
                                    this.dimension.resolve(tempDimensions[0]);
                                    this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                                } else {
                                    return;
                                }
                            }
                            if (this.start.readyToSolve && this.end.readyToSolve && dependencyNode.readyToSolve && dependencyNode2.readyToSolve) {
                                computeInsetRatio(tempDimensions, this.start.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, dependencyNode.targets.get(0).value + dependencyNode.margin, dependencyNode2.targets.get(0).value - dependencyNode2.margin, dimensionRatio, dimensionRatioSide);
                                this.dimension.resolve(tempDimensions[0]);
                                this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                            } else {
                                return;
                            }
                        } else if (this.start.readyToSolve && this.end.readyToSolve) {
                            computeInsetRatio(tempDimensions, this.start.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, dependencyNode.value + dependencyNode.margin, dependencyNode2.value - dependencyNode2.margin, dimensionRatio, dimensionRatioSide);
                            this.dimension.resolve(tempDimensions[0]);
                            this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                            return;
                        } else {
                            return;
                        }
                    } else if (!z || !z3) {
                        if (z2 && z4) {
                            if (dependencyNode.readyToSolve && dependencyNode2.readyToSolve) {
                                float dimensionRatio2 = this.widget.getDimensionRatio();
                                int i4 = dependencyNode.targets.get(0).value + dependencyNode.margin;
                                int i5 = dependencyNode2.targets.get(0).value - dependencyNode2.margin;
                                if (dimensionRatioSide != -1) {
                                    if (dimensionRatioSide == 0) {
                                        int limitedDimension = getLimitedDimension(i5 - i4, 1);
                                        int i6 = (int) ((((float) limitedDimension) * dimensionRatio2) + 0.5f);
                                        int limitedDimension2 = getLimitedDimension(i6, 0);
                                        if (i6 != limitedDimension2) {
                                            limitedDimension = (int) ((((float) limitedDimension2) / dimensionRatio2) + 0.5f);
                                        }
                                        this.dimension.resolve(limitedDimension2);
                                        this.widget.verticalRun.dimension.resolve(limitedDimension);
                                    }
                                }
                                int limitedDimension3 = getLimitedDimension(i5 - i4, 1);
                                int i7 = (int) ((((float) limitedDimension3) / dimensionRatio2) + 0.5f);
                                int limitedDimension4 = getLimitedDimension(i7, 0);
                                if (i7 != limitedDimension4) {
                                    limitedDimension3 = (int) ((((float) limitedDimension4) * dimensionRatio2) + 0.5f);
                                }
                                this.dimension.resolve(limitedDimension4);
                                this.widget.verticalRun.dimension.resolve(limitedDimension3);
                            } else {
                                return;
                            }
                        }
                    } else if (this.start.readyToSolve && this.end.readyToSolve) {
                        float dimensionRatio3 = this.widget.getDimensionRatio();
                        int i8 = this.start.targets.get(0).value + this.start.margin;
                        int i9 = this.end.targets.get(0).value - this.end.margin;
                        if (dimensionRatioSide == -1 || dimensionRatioSide == 0) {
                            int limitedDimension5 = getLimitedDimension(i9 - i8, 0);
                            int i10 = (int) ((((float) limitedDimension5) * dimensionRatio3) + 0.5f);
                            int limitedDimension6 = getLimitedDimension(i10, 1);
                            if (i10 != limitedDimension6) {
                                limitedDimension5 = (int) ((((float) limitedDimension6) / dimensionRatio3) + 0.5f);
                            }
                            this.dimension.resolve(limitedDimension5);
                            this.widget.verticalRun.dimension.resolve(limitedDimension6);
                        } else if (dimensionRatioSide == 1) {
                            int limitedDimension7 = getLimitedDimension(i9 - i8, 0);
                            int i11 = (int) ((((float) limitedDimension7) / dimensionRatio3) + 0.5f);
                            int limitedDimension8 = getLimitedDimension(i11, 1);
                            if (i11 != limitedDimension8) {
                                limitedDimension7 = (int) ((((float) limitedDimension8) * dimensionRatio3) + 0.5f);
                            }
                            this.dimension.resolve(limitedDimension7);
                            this.widget.verticalRun.dimension.resolve(limitedDimension8);
                        }
                    } else {
                        return;
                    }
                } else {
                    int dimensionRatioSide2 = this.widget.getDimensionRatioSide();
                    if (dimensionRatioSide2 == -1) {
                        f3 = (float) this.widget.verticalRun.dimension.value;
                        f2 = this.widget.getDimensionRatio();
                    } else if (dimensionRatioSide2 == 0) {
                        f = ((float) this.widget.verticalRun.dimension.value) / this.widget.getDimensionRatio();
                        i = (int) (f + 0.5f);
                        this.dimension.resolve(i);
                    } else if (dimensionRatioSide2 != 1) {
                        i = 0;
                        this.dimension.resolve(i);
                    } else {
                        f3 = (float) this.widget.verticalRun.dimension.value;
                        f2 = this.widget.getDimensionRatio();
                    }
                    f = f3 * f2;
                    i = (int) (f + 0.5f);
                    this.dimension.resolve(i);
                }
            }
        }
        if (this.start.readyToSolve && this.end.readyToSolve) {
            if (this.start.resolved && this.end.resolved && this.dimension.resolved) {
                return;
            }
            if (this.dimension.resolved || this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.widget.mMatchConstraintDefaultWidth != 0 || this.widget.isInHorizontalChain()) {
                if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                    int min = Math.min((this.end.targets.get(0).value + this.end.margin) - (this.start.targets.get(0).value + this.start.margin), this.dimension.wrapValue);
                    int i12 = this.widget.mMatchConstraintMaxWidth;
                    int max = Math.max(this.widget.mMatchConstraintMinWidth, min);
                    if (i12 > 0) {
                        max = Math.min(i12, max);
                    }
                    this.dimension.resolve(max);
                }
                if (this.dimension.resolved) {
                    DependencyNode dependencyNode3 = this.start.targets.get(0);
                    DependencyNode dependencyNode4 = this.end.targets.get(0);
                    int i13 = dependencyNode3.value + this.start.margin;
                    int i14 = dependencyNode4.value + this.end.margin;
                    float horizontalBiasPercent = this.widget.getHorizontalBiasPercent();
                    if (dependencyNode3 == dependencyNode4) {
                        i13 = dependencyNode3.value;
                        i14 = dependencyNode4.value;
                        horizontalBiasPercent = 0.5f;
                    }
                    this.start.resolve((int) (((float) i13) + 0.5f + (((float) ((i14 - i13) - this.dimension.value)) * horizontalBiasPercent)));
                    this.end.resolve(this.start.value + this.dimension.value);
                    return;
                }
                return;
            }
            int i15 = this.start.targets.get(0).value + this.start.margin;
            int i16 = this.end.targets.get(0).value + this.end.margin;
            this.start.resolve(i15);
            this.end.resolve(i16);
            this.dimension.resolve(i16 - i15);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (this.start.resolved) {
            this.widget.setX(this.start.value);
        }
    }
}
