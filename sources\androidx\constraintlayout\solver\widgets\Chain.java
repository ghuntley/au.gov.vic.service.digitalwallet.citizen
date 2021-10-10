package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        ChainHead[] chainHeadArr;
        int i2;
        int i3;
        if (i == 0) {
            i3 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i2 = 0;
        } else {
            int i4 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i2 = 2;
            i3 = i4;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            ChainHead chainHead = chainHeadArr[i5];
            chainHead.define();
            if (arrayList == null || (arrayList != null && arrayList.contains(chainHead.mFirst))) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i2, chainHead);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v63, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r2.mHorizontalChainStyle == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r2.mVerticalChainStyle == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004c, code lost:
        r5 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x03c9  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x03e7  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x04bb  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x04f0  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x0517  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x051c  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0522  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0527  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x052b  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x053c  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x053f  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x03ca A[SYNTHETIC] */
    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        ConstraintWidget constraintWidget;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintWidget constraintWidget2;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        int i3;
        ConstraintWidget constraintWidget3;
        int i4;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        ConstraintAnchor constraintAnchor4;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        ConstraintAnchor constraintAnchor5;
        float f;
        int size;
        int i5;
        ArrayList<ConstraintWidget> arrayList;
        int i6;
        boolean z3;
        ConstraintWidget constraintWidget6;
        boolean z4;
        int i7;
        ConstraintWidget constraintWidget7 = chainHead.mFirst;
        ConstraintWidget constraintWidget8 = chainHead.mLast;
        ConstraintWidget constraintWidget9 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget10 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget11 = chainHead.mHead;
        float f2 = chainHead.mTotalWeight;
        ConstraintWidget constraintWidget12 = chainHead.mFirstMatchConstraintWidget;
        ConstraintWidget constraintWidget13 = chainHead.mLastMatchConstraintWidget;
        boolean z5 = constraintWidgetContainer.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            z2 = constraintWidget11.mHorizontalChainStyle == 0;
            z = constraintWidget11.mHorizontalChainStyle == 1;
        } else {
            z2 = constraintWidget11.mVerticalChainStyle == 0;
            z = constraintWidget11.mVerticalChainStyle == 1;
        }
        boolean z6 = true;
        ConstraintWidget constraintWidget14 = constraintWidget7;
        boolean z7 = z;
        boolean z8 = z2;
        boolean z9 = false;
        while (true) {
            constraintWidget = null;
            if (z9) {
                break;
            }
            ConstraintAnchor constraintAnchor6 = constraintWidget14.mListAnchors[i2];
            int i8 = z6 ? 1 : 4;
            int margin = constraintAnchor6.getMargin();
            boolean z10 = constraintWidget14.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget14.mResolvedMatchConstraintDefault[i] == 0;
            if (!(constraintAnchor6.mTarget == null || constraintWidget14 == constraintWidget7)) {
                margin += constraintAnchor6.mTarget.getMargin();
            }
            if (!z6 || constraintWidget14 == constraintWidget7 || constraintWidget14 == constraintWidget9) {
                z3 = z7;
            } else {
                z3 = z7;
                i8 = 8;
            }
            if (constraintAnchor6.mTarget != null) {
                if (constraintWidget14 == constraintWidget9) {
                    z4 = z8;
                    constraintWidget6 = constraintWidget11;
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, margin, 6);
                } else {
                    constraintWidget6 = constraintWidget11;
                    z4 = z8;
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, margin, 8);
                }
                linearSystem.addEquality(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, margin, (!z10 || z6) ? i8 : 5);
            } else {
                constraintWidget6 = constraintWidget11;
                z4 = z8;
            }
            if (z5) {
                if (constraintWidget14.getVisibility() == 8 || constraintWidget14.mListDimensionBehaviors[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i7 = 0;
                } else {
                    i7 = 0;
                    linearSystem.addGreaterThan(constraintWidget14.mListAnchors[i2 + 1].mSolverVariable, constraintWidget14.mListAnchors[i2].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(constraintWidget14.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, i7, 8);
            }
            ConstraintAnchor constraintAnchor7 = constraintWidget14.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor7 != null) {
                ConstraintWidget constraintWidget15 = constraintAnchor7.mOwner;
                if (constraintWidget15.mListAnchors[i2].mTarget != null && constraintWidget15.mListAnchors[i2].mTarget.mOwner == constraintWidget14) {
                    constraintWidget = constraintWidget15;
                }
            }
            if (constraintWidget != null) {
                constraintWidget14 = constraintWidget;
                z9 = z9;
            } else {
                z9 = true;
            }
            z7 = z3;
            f2 = f2;
            z8 = z4;
            constraintWidget11 = constraintWidget6;
        }
        if (constraintWidget10 != null) {
            int i9 = i2 + 1;
            if (constraintWidget8.mListAnchors[i9].mTarget != null) {
                ConstraintAnchor constraintAnchor8 = constraintWidget10.mListAnchors[i9];
                if ((constraintWidget10.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget10.mResolvedMatchConstraintDefault[i] == 0) && !z6 && constraintAnchor8.mTarget.mOwner == constraintWidgetContainer) {
                    linearSystem.addEquality(constraintAnchor8.mSolverVariable, constraintAnchor8.mTarget.mSolverVariable, -constraintAnchor8.getMargin(), 5);
                } else if (z6 && constraintAnchor8.mTarget.mOwner == constraintWidgetContainer) {
                    linearSystem.addEquality(constraintAnchor8.mSolverVariable, constraintAnchor8.mTarget.mSolverVariable, -constraintAnchor8.getMargin(), 4);
                }
                linearSystem.addLowerThan(constraintAnchor8.mSolverVariable, constraintWidget8.mListAnchors[i9].mTarget.mSolverVariable, -constraintAnchor8.getMargin(), 6);
                if (z5) {
                    int i10 = i2 + 1;
                    linearSystem.addGreaterThan(constraintWidgetContainer.mListAnchors[i10].mSolverVariable, constraintWidget8.mListAnchors[i10].mSolverVariable, constraintWidget8.mListAnchors[i10].getMargin(), 8);
                }
                ArrayList<ConstraintWidget> arrayList2 = chainHead.mWeightedMatchConstraintsWidgets;
                if (arrayList2 != null && (size = arrayList2.size()) > 1) {
                    float f3 = (chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f2 : (float) chainHead.mWidgetsMatchCount;
                    float f4 = 0.0f;
                    float f5 = 0.0f;
                    ConstraintWidget constraintWidget16 = null;
                    i5 = 0;
                    while (i5 < size) {
                        ConstraintWidget constraintWidget17 = arrayList2.get(i5);
                        float f6 = constraintWidget17.mWeight[i];
                        if (f6 < f4) {
                            if (chainHead.mHasComplexMatchWeights) {
                                linearSystem.addEquality(constraintWidget17.mListAnchors[i2 + 1].mSolverVariable, constraintWidget17.mListAnchors[i2].mSolverVariable, 0, 4);
                                arrayList = arrayList2;
                                i6 = size;
                                i5++;
                                size = i6;
                                arrayList2 = arrayList;
                                f4 = 0.0f;
                            } else {
                                f6 = 1.0f;
                                f4 = 0.0f;
                            }
                        }
                        if (f6 == f4) {
                            linearSystem.addEquality(constraintWidget17.mListAnchors[i2 + 1].mSolverVariable, constraintWidget17.mListAnchors[i2].mSolverVariable, 0, 8);
                            arrayList = arrayList2;
                            i6 = size;
                            i5++;
                            size = i6;
                            arrayList2 = arrayList;
                            f4 = 0.0f;
                        } else {
                            if (constraintWidget16 != null) {
                                SolverVariable solverVariable7 = constraintWidget16.mListAnchors[i2].mSolverVariable;
                                int i11 = i2 + 1;
                                SolverVariable solverVariable8 = constraintWidget16.mListAnchors[i11].mSolverVariable;
                                SolverVariable solverVariable9 = constraintWidget17.mListAnchors[i2].mSolverVariable;
                                arrayList = arrayList2;
                                SolverVariable solverVariable10 = constraintWidget17.mListAnchors[i11].mSolverVariable;
                                i6 = size;
                                ArrayRow createRow = linearSystem.createRow();
                                createRow.createRowEqualMatchDimensions(f5, f3, f6, solverVariable7, solverVariable8, solverVariable9, solverVariable10);
                                linearSystem.addConstraint(createRow);
                            } else {
                                arrayList = arrayList2;
                                i6 = size;
                            }
                            f5 = f6;
                            constraintWidget16 = constraintWidget17;
                            i5++;
                            size = i6;
                            arrayList2 = arrayList;
                            f4 = 0.0f;
                        }
                    }
                }
                if (constraintWidget9 == null && (constraintWidget9 == constraintWidget10 || z6)) {
                    ConstraintAnchor constraintAnchor9 = constraintWidget7.mListAnchors[i2];
                    int i12 = i2 + 1;
                    ConstraintAnchor constraintAnchor10 = constraintWidget8.mListAnchors[i12];
                    SolverVariable solverVariable11 = constraintAnchor9.mTarget != null ? constraintAnchor9.mTarget.mSolverVariable : null;
                    SolverVariable solverVariable12 = constraintAnchor10.mTarget != null ? constraintAnchor10.mTarget.mSolverVariable : null;
                    ConstraintAnchor constraintAnchor11 = constraintWidget9.mListAnchors[i2];
                    ConstraintAnchor constraintAnchor12 = constraintWidget10.mListAnchors[i12];
                    if (!(solverVariable11 == null || solverVariable12 == null)) {
                        if (i == 0) {
                            f = constraintWidget11.mHorizontalBiasPercent;
                        } else {
                            f = constraintWidget11.mVerticalBiasPercent;
                        }
                        linearSystem.addCentering(constraintAnchor11.mSolverVariable, solverVariable11, constraintAnchor11.getMargin(), f, solverVariable12, constraintAnchor12.mSolverVariable, constraintAnchor12.getMargin(), 7);
                    }
                } else if (z8 || constraintWidget9 == null) {
                    int i13 = 8;
                    if (z7 && constraintWidget9 != null) {
                        boolean z11 = chainHead.mWidgetsMatchCount <= 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
                        constraintWidget2 = constraintWidget9;
                        ConstraintWidget constraintWidget18 = constraintWidget2;
                        while (constraintWidget2 != null) {
                            ConstraintWidget constraintWidget19 = constraintWidget2.mNextChainWidget[i];
                            while (constraintWidget19 != null && constraintWidget19.getVisibility() == i13) {
                                constraintWidget19 = constraintWidget19.mNextChainWidget[i];
                            }
                            if (constraintWidget2 == constraintWidget9 || constraintWidget2 == constraintWidget10 || constraintWidget19 == null) {
                                constraintWidget3 = constraintWidget18;
                                i4 = i13;
                            } else {
                                ConstraintWidget constraintWidget20 = constraintWidget19 == constraintWidget10 ? null : constraintWidget19;
                                ConstraintAnchor constraintAnchor13 = constraintWidget2.mListAnchors[i2];
                                SolverVariable solverVariable13 = constraintAnchor13.mSolverVariable;
                                if (constraintAnchor13.mTarget != null) {
                                    SolverVariable solverVariable14 = constraintAnchor13.mTarget.mSolverVariable;
                                }
                                int i14 = i2 + 1;
                                SolverVariable solverVariable15 = constraintWidget18.mListAnchors[i14].mSolverVariable;
                                int margin2 = constraintAnchor13.getMargin();
                                int margin3 = constraintWidget2.mListAnchors[i14].getMargin();
                                if (constraintWidget20 != null) {
                                    constraintAnchor4 = constraintWidget20.mListAnchors[i2];
                                    solverVariable4 = constraintAnchor4.mSolverVariable;
                                    solverVariable3 = constraintAnchor4.mTarget != null ? constraintAnchor4.mTarget.mSolverVariable : null;
                                } else {
                                    constraintAnchor4 = constraintWidget10.mListAnchors[i2];
                                    solverVariable4 = constraintAnchor4 != null ? constraintAnchor4.mSolverVariable : null;
                                    solverVariable3 = constraintWidget2.mListAnchors[i14].mSolverVariable;
                                }
                                if (constraintAnchor4 != null) {
                                    margin3 += constraintAnchor4.getMargin();
                                }
                                if (constraintWidget18 != null) {
                                    margin2 += constraintWidget18.mListAnchors[i14].getMargin();
                                }
                                int i15 = z11 ? 8 : 4;
                                if (solverVariable13 == null || solverVariable15 == null || solverVariable4 == null || solverVariable3 == null) {
                                    constraintWidget4 = constraintWidget20;
                                    constraintWidget3 = constraintWidget18;
                                    i4 = 8;
                                } else {
                                    constraintWidget4 = constraintWidget20;
                                    constraintWidget3 = constraintWidget18;
                                    i4 = 8;
                                    linearSystem.addCentering(solverVariable13, solverVariable15, margin2, 0.5f, solverVariable4, solverVariable3, margin3, i15);
                                }
                                constraintWidget19 = constraintWidget4;
                            }
                            if (constraintWidget2.getVisibility() == i4) {
                                constraintWidget2 = constraintWidget3;
                            }
                            i13 = i4;
                            constraintWidget18 = constraintWidget2;
                            constraintWidget2 = constraintWidget19;
                        }
                        ConstraintAnchor constraintAnchor14 = constraintWidget9.mListAnchors[i2];
                        constraintAnchor = constraintWidget7.mListAnchors[i2].mTarget;
                        int i16 = i2 + 1;
                        constraintAnchor2 = constraintWidget10.mListAnchors[i16];
                        constraintAnchor3 = constraintWidget8.mListAnchors[i16].mTarget;
                        if (constraintAnchor != null) {
                            i3 = 5;
                        } else if (constraintWidget9 != constraintWidget10) {
                            i3 = 5;
                            linearSystem.addEquality(constraintAnchor14.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor14.getMargin(), 5);
                        } else {
                            i3 = 5;
                            if (constraintAnchor3 != null) {
                                linearSystem.addCentering(constraintAnchor14.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor14.getMargin(), 0.5f, constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, constraintAnchor2.getMargin(), 5);
                            }
                        }
                        if (!(constraintAnchor3 == null || constraintWidget9 == constraintWidget10)) {
                            linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i3);
                        }
                    }
                } else {
                    boolean z12 = chainHead.mWidgetsMatchCount > 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
                    ConstraintWidget constraintWidget21 = constraintWidget9;
                    ConstraintWidget constraintWidget22 = constraintWidget21;
                    while (constraintWidget21 != null) {
                        ConstraintWidget constraintWidget23 = constraintWidget21.mNextChainWidget[i];
                        while (true) {
                            if (constraintWidget23 != null) {
                                if (constraintWidget23.getVisibility() != 8) {
                                    break;
                                }
                                constraintWidget23 = constraintWidget23.mNextChainWidget[i];
                            } else {
                                break;
                            }
                        }
                        if (constraintWidget23 != null || constraintWidget21 == constraintWidget10) {
                            ConstraintAnchor constraintAnchor15 = constraintWidget21.mListAnchors[i2];
                            SolverVariable solverVariable16 = constraintAnchor15.mSolverVariable;
                            SolverVariable solverVariable17 = constraintAnchor15.mTarget != null ? constraintAnchor15.mTarget.mSolverVariable : null;
                            if (constraintWidget22 != constraintWidget21) {
                                solverVariable17 = constraintWidget22.mListAnchors[i2 + 1].mSolverVariable;
                            } else if (constraintWidget21 == constraintWidget9 && constraintWidget22 == constraintWidget21) {
                                solverVariable17 = constraintWidget7.mListAnchors[i2].mTarget != null ? constraintWidget7.mListAnchors[i2].mTarget.mSolverVariable : null;
                            }
                            int margin4 = constraintAnchor15.getMargin();
                            int i17 = i2 + 1;
                            int margin5 = constraintWidget21.mListAnchors[i17].getMargin();
                            if (constraintWidget23 != null) {
                                constraintAnchor5 = constraintWidget23.mListAnchors[i2];
                                SolverVariable solverVariable18 = constraintAnchor5.mSolverVariable;
                                solverVariable5 = constraintWidget21.mListAnchors[i17].mSolverVariable;
                                solverVariable6 = solverVariable18;
                            } else {
                                constraintAnchor5 = constraintWidget8.mListAnchors[i17].mTarget;
                                solverVariable6 = constraintAnchor5 != null ? constraintAnchor5.mSolverVariable : null;
                                solverVariable5 = constraintWidget21.mListAnchors[i17].mSolverVariable;
                            }
                            if (constraintAnchor5 != null) {
                                margin5 += constraintAnchor5.getMargin();
                            }
                            if (constraintWidget22 != null) {
                                margin4 += constraintWidget22.mListAnchors[i17].getMargin();
                            }
                            if (!(solverVariable16 == null || solverVariable17 == null || solverVariable6 == null || solverVariable5 == null)) {
                                if (constraintWidget21 == constraintWidget9) {
                                    margin4 = constraintWidget9.mListAnchors[i2].getMargin();
                                }
                                constraintWidget5 = constraintWidget23;
                                linearSystem.addCentering(solverVariable16, solverVariable17, margin4, 0.5f, solverVariable6, solverVariable5, constraintWidget21 == constraintWidget10 ? constraintWidget10.mListAnchors[i17].getMargin() : margin5, z12 ? 8 : 5);
                                if (constraintWidget21.getVisibility() == 8) {
                                    constraintWidget22 = constraintWidget21;
                                }
                                constraintWidget21 = constraintWidget5;
                            }
                        }
                        constraintWidget5 = constraintWidget23;
                        if (constraintWidget21.getVisibility() == 8) {
                        }
                        constraintWidget21 = constraintWidget5;
                    }
                }
                if ((!z8 || z7) && constraintWidget9 != null && constraintWidget9 != constraintWidget10) {
                    ConstraintAnchor constraintAnchor16 = constraintWidget9.mListAnchors[i2];
                    int i18 = i2 + 1;
                    ConstraintAnchor constraintAnchor17 = constraintWidget10.mListAnchors[i18];
                    solverVariable = constraintAnchor16.mTarget == null ? constraintAnchor16.mTarget.mSolverVariable : null;
                    SolverVariable solverVariable19 = constraintAnchor17.mTarget == null ? constraintAnchor17.mTarget.mSolverVariable : null;
                    if (constraintWidget8 == constraintWidget10) {
                        ConstraintAnchor constraintAnchor18 = constraintWidget8.mListAnchors[i18];
                        if (constraintAnchor18.mTarget != null) {
                            constraintWidget = constraintAnchor18.mTarget.mSolverVariable;
                        }
                        solverVariable2 = constraintWidget;
                    } else {
                        solverVariable2 = solverVariable19;
                    }
                    if (constraintWidget9 == constraintWidget10) {
                        constraintAnchor16 = constraintWidget9.mListAnchors[i2];
                        constraintAnchor17 = constraintWidget9.mListAnchors[i18];
                    }
                    if (solverVariable != null && solverVariable2 != null) {
                        int margin6 = constraintAnchor16.getMargin();
                        if (constraintWidget10 != null) {
                            constraintWidget8 = constraintWidget10;
                        }
                        linearSystem.addCentering(constraintAnchor16.mSolverVariable, solverVariable, margin6, 0.5f, solverVariable2, constraintAnchor17.mSolverVariable, constraintWidget8.mListAnchors[i18].getMargin(), 5);
                        return;
                    }
                }
                return;
            }
        }
        if (z5) {
        }
        ArrayList<ConstraintWidget> arrayList22 = chainHead.mWeightedMatchConstraintsWidgets;
        if (chainHead.mHasUndefinedWeights) {
        }
        float f42 = 0.0f;
        float f52 = 0.0f;
        ConstraintWidget constraintWidget162 = null;
        i5 = 0;
        while (i5 < size) {
        }
        if (constraintWidget9 == null) {
        }
        if (z8) {
        }
        int i132 = 8;
        if (chainHead.mWidgetsMatchCount <= 0) {
        }
        constraintWidget2 = constraintWidget9;
        ConstraintWidget constraintWidget182 = constraintWidget2;
        while (constraintWidget2 != null) {
        }
        ConstraintAnchor constraintAnchor142 = constraintWidget9.mListAnchors[i2];
        constraintAnchor = constraintWidget7.mListAnchors[i2].mTarget;
        int i162 = i2 + 1;
        constraintAnchor2 = constraintWidget10.mListAnchors[i162];
        constraintAnchor3 = constraintWidget8.mListAnchors[i162].mTarget;
        if (constraintAnchor != null) {
        }
        linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i3);
        if (!z8) {
        }
        ConstraintAnchor constraintAnchor162 = constraintWidget9.mListAnchors[i2];
        int i182 = i2 + 1;
        ConstraintAnchor constraintAnchor172 = constraintWidget10.mListAnchors[i182];
        if (constraintAnchor162.mTarget == null) {
        }
        if (constraintAnchor172.mTarget == null) {
        }
        if (constraintWidget8 == constraintWidget10) {
        }
        if (constraintWidget9 == constraintWidget10) {
        }
        if (solverVariable != null) {
        }
    }
}
