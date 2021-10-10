package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int BOTH = 2;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    private boolean OPTIMIZE_WRAP;
    private boolean OPTIMIZE_WRAP_ON_RESOLVED;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    public HorizontalWidgetRun horizontalRun;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    public ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    public ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtuaLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    private int mLastHorizontalMeasureSpec;
    private int mLastVerticalMeasureSpec;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    private boolean mMeasureRequested;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    protected int mX;
    protected int mY;
    public boolean measured;
    private boolean resolvedHorizontal;
    private boolean resolvedVertical;
    public WidgetRun[] run;
    public ChainRun verticalChainRun;
    public int verticalGroup;
    public VerticalWidgetRun verticalRun;

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public WidgetRun getRun(int i) {
        if (i == 0) {
            return this.horizontalRun;
        }
        if (i == 1) {
            return this.verticalRun;
        }
        return null;
    }

    public void setFinalFrame(int i, int i2, int i3, int i4, int i5, int i6) {
        setFrame(i, i2, i3, i4);
        setBaselineDistance(i5);
        if (i6 == 0) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = false;
        } else if (i6 == 1) {
            this.resolvedHorizontal = false;
            this.resolvedVertical = true;
        } else if (i6 == 2) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = true;
        } else {
            this.resolvedHorizontal = false;
            this.resolvedVertical = false;
        }
    }

    public void setFinalLeft(int i) {
        this.mLeft.setFinalValue(i);
        this.mX = i;
    }

    public void setFinalTop(int i) {
        this.mTop.setFinalValue(i);
        this.mY = i;
    }

    public void setFinalHorizontal(int i, int i2) {
        this.mLeft.setFinalValue(i);
        this.mRight.setFinalValue(i2);
        this.mX = i;
        this.mWidth = i2 - i;
        this.resolvedHorizontal = true;
    }

    public void setFinalVertical(int i, int i2) {
        this.mTop.setFinalValue(i);
        this.mBottom.setFinalValue(i2);
        this.mY = i;
        this.mHeight = i2 - i;
        if (this.hasBaseline) {
            this.mBaseline.setFinalValue(i + this.mBaselineDistance);
        }
        this.resolvedVertical = true;
    }

    public void setFinalBaseline(int i) {
        if (this.hasBaseline) {
            int i2 = i - this.mBaselineDistance;
            int i3 = this.mHeight + i2;
            this.mY = i2;
            this.mTop.setFinalValue(i2);
            this.mBottom.setFinalValue(i3);
            this.mBaseline.setFinalValue(i);
            this.resolvedVertical = true;
        }
    }

    public boolean isResolvedHorizontally() {
        return this.resolvedHorizontal || (this.mLeft.hasFinalValue() && this.mRight.hasFinalValue());
    }

    public boolean isResolvedVertically() {
        return this.resolvedVertical || (this.mTop.hasFinalValue() && this.mBottom.hasFinalValue());
    }

    public void resetFinalResolution() {
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            this.mAnchors.get(i).resetFinalResolution();
        }
    }

    public void ensureMeasureRequested() {
        this.mMeasureRequested = true;
    }

    public boolean hasDependencies() {
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            if (this.mAnchors.get(i).hasDependents()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDanglingDimension(int i) {
        if (i == 0) {
            return (this.mLeft.mTarget != null ? 1 : 0) + (this.mRight.mTarget != null ? 1 : 0) < 2;
        }
        return ((this.mTop.mTarget != null ? 1 : 0) + (this.mBottom.mTarget != null ? 1 : 0)) + (this.mBaseline.mTarget != null ? 1 : 0) < 2;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtuaLayout;
    }

    public void setInVirtualLayout(boolean z) {
        this.mInVirtuaLayout = z;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public void setMaxWidth(int i) {
        this.mMaxDimension[0] = i;
    }

    public void setMaxHeight(int i) {
        this.mMaxDimension[1] = i;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void setHasBaseline(boolean z) {
        this.hasBaseline = z;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public void setInPlaceholder(boolean z) {
        this.inPlaceholder = z;
    }

    /* access modifiers changed from: protected */
    public void setInBarrier(int i, boolean z) {
        this.mIsInBarrier[i] = z;
    }

    public void setMeasureRequested(boolean z) {
        this.mMeasureRequested = z;
    }

    public boolean isMeasureRequested() {
        return this.mMeasureRequested && this.mVisibility != 8;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.mLastHorizontalMeasureSpec;
    }

    public int getLastVerticalMeasureSpec() {
        return this.mLastVerticalMeasureSpec;
    }

    public void setLastMeasureSpec(int i, int i2) {
        this.mLastHorizontalMeasureSpec = i;
        this.mLastVerticalMeasureSpec = i2;
        setMeasureRequested(false);
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mGroupsToSolver = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtuaLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
        this.mMeasureRequested = true;
    }

    public boolean oppositeDimensionDependsOn(int i) {
        char c = i == 0 ? (char) 1 : 0;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        return dimensionBehaviourArr[i] == DimensionBehaviour.MATCH_CONSTRAINT && dimensionBehaviourArr[c] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean oppositeDimensionsTied() {
        return this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
    }

    public ConstraintWidget(String str) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
        setDebugName(str);
    }

    public ConstraintWidget(int i, int i2, int i3, int i4) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.mX = i;
        this.mY = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        addAnchors();
    }

    public ConstraintWidget(String str, int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4);
        setDebugName(str);
    }

    public ConstraintWidget(int i, int i2) {
        this(0, 0, i, i2);
    }

    public void ensureWidgetRuns() {
        if (this.horizontalRun == null) {
            this.horizontalRun = new HorizontalWidgetRun(this);
        }
        if (this.verticalRun == null) {
            this.verticalRun = new VerticalWidgetRun(this);
        }
    }

    public ConstraintWidget(String str, int i, int i2) {
        this(i, i2);
        setDebugName(str);
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int i) {
        immediateConnect(ConstraintAnchor.Type.CENTER, constraintWidget, ConstraintAnchor.Type.CENTER, i, 0);
        this.mCircleConstraintAngle = f;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        createObjectVariable.setName(str + ".left");
        createObjectVariable2.setName(str + ".top");
        createObjectVariable3.setName(str + ".right");
        createObjectVariable4.setName(str + ".bottom");
        SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
        createObjectVariable5.setName(str + ".baseline");
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.mType != null) {
            str = "type: " + this.mType + " ";
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.mX);
        sb.append(", ");
        sb.append(this.mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        sb.append(this.mHeight);
        sb.append(")");
        return sb.toString();
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mX;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mY;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getOptimizerWrapWidth() {
        int i;
        int i2 = this.mWidth;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            i = Math.max(this.mMatchConstraintMinWidth, i2);
        } else {
            i = this.mMatchConstraintMinWidth;
            if (i > 0) {
                this.mWidth = i;
            } else {
                i = 0;
            }
        }
        int i3 = this.mMatchConstraintMaxWidth;
        return (i3 <= 0 || i3 >= i) ? i : i3;
    }

    public int getOptimizerWrapHeight() {
        int i;
        int i2 = this.mHeight;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultHeight == 1) {
            i = Math.max(this.mMatchConstraintMinHeight, i2);
        } else {
            i = this.mMatchConstraintMinHeight;
            if (i > 0) {
                this.mHeight = i;
            } else {
                i = 0;
            }
        }
        int i3 = this.mMatchConstraintMaxHeight;
        return (i3 <= 0 || i3 >= i) ? i : i3;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public int getLength(int i) {
        if (i == 0) {
            return getWidth();
        }
        if (i == 1) {
            return getHeight();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getRootX() {
        return this.mX + this.mOffsetX;
    }

    /* access modifiers changed from: protected */
    public int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getLeft() {
        return getX();
    }

    public int getTop() {
        return getY();
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public int getHorizontalMargin() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        int i = 0;
        if (constraintAnchor != null) {
            i = 0 + constraintAnchor.mMargin;
        }
        ConstraintAnchor constraintAnchor2 = this.mRight;
        return constraintAnchor2 != null ? i + constraintAnchor2.mMargin : i;
    }

    public int getVerticalMargin() {
        int i = 0;
        if (this.mLeft != null) {
            i = 0 + this.mTop.mMargin;
        }
        return this.mRight != null ? i + this.mBottom.mMargin : i;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public float getBiasPercent(int i) {
        if (i == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public void setX(int i) {
        this.mX = i;
    }

    public void setY(int i) {
        this.mY = i;
    }

    public void setOrigin(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i) {
        int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()];
        if (i2 == 1) {
            this.mLeft.mGoneMargin = i;
        } else if (i2 == 2) {
            this.mTop.mGoneMargin = i;
        } else if (i2 == 3) {
            this.mRight.mGoneMargin = i;
        } else if (i2 == 4) {
            this.mBottom.mGoneMargin = i;
        }
    }

    public void setWidth(int i) {
        this.mWidth = i;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    public void setLength(int i, int i2) {
        if (i2 == 0) {
            setWidth(i);
        } else if (i2 == 1) {
            setHeight(i);
        }
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.mMatchConstraintMaxWidth = i3;
        this.mMatchConstraintPercentWidth = f;
        if (f > 0.0f && f < 1.0f && i == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.mMatchConstraintMaxHeight = i3;
        this.mMatchConstraintPercentHeight = f;
        if (f > 0.0f && f < 1.0f && i == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    public void setDimensionRatio(String str) {
        float f;
        if (str == null || str.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int i = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i2 = 0;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase("W")) {
                i = 0;
            } else if (substring.equalsIgnoreCase("H")) {
                i = 1;
            }
            i2 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(i2);
            if (substring2.length() > 0) {
                f = Float.parseFloat(substring2);
                if (f > 0.0f) {
                    this.mDimensionRatio = f;
                    this.mDimensionRatioSide = i;
                    return;
                }
                return;
            }
        } else {
            String substring3 = str.substring(i2, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                try {
                    float parseFloat = Float.parseFloat(substring3);
                    float parseFloat2 = Float.parseFloat(substring4);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        f = i == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                        if (f > 0.0f) {
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        f = 0.0f;
        if (f > 0.0f) {
        }
    }

    public void setDimensionRatio(float f, int i) {
        this.mDimensionRatio = f;
        this.mDimensionRatioSide = i;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public void setHorizontalBiasPercent(float f) {
        this.mHorizontalBiasPercent = f;
    }

    public void setVerticalBiasPercent(float f) {
        this.mVerticalBiasPercent = f;
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public void setDimension(int i, int i2) {
        this.mWidth = i;
        int i3 = this.mMinWidth;
        if (i < i3) {
            this.mWidth = i3;
        }
        this.mHeight = i2;
        int i4 = this.mMinHeight;
        if (i2 < i4) {
            this.mHeight = i4;
        }
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.mX = i;
        this.mY = i2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i7 < (i6 = this.mWidth)) {
            i7 = i6;
        }
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i8 < (i5 = this.mHeight)) {
            i8 = i5;
        }
        this.mWidth = i7;
        this.mHeight = i8;
        int i9 = this.mMinHeight;
        if (i8 < i9) {
            this.mHeight = i9;
        }
        int i10 = this.mMinWidth;
        if (i7 < i10) {
            this.mWidth = i10;
        }
    }

    public void setFrame(int i, int i2, int i3) {
        if (i3 == 0) {
            setHorizontalDimension(i, i2);
        } else if (i3 == 1) {
            setVerticalDimension(i, i2);
        }
    }

    public void setHorizontalDimension(int i, int i2) {
        this.mX = i;
        int i3 = i2 - i;
        this.mWidth = i3;
        int i4 = this.mMinWidth;
        if (i3 < i4) {
            this.mWidth = i4;
        }
    }

    public void setVerticalDimension(int i, int i2) {
        this.mY = i;
        int i3 = i2 - i;
        this.mHeight = i3;
        int i4 = this.mMinHeight;
        if (i3 < i4) {
            this.mHeight = i4;
        }
    }

    /* access modifiers changed from: package-private */
    public int getRelativePositioning(int i) {
        if (i == 0) {
            return this.mRelX;
        }
        if (i == 1) {
            return this.mRelY;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void setRelativePositioning(int i, int i2) {
        if (i2 == 0) {
            this.mRelX = i;
        } else if (i2 == 1) {
            this.mRelY = i;
        }
    }

    public void setBaselineDistance(int i) {
        this.mBaselineDistance = i;
        this.hasBaseline = i > 0;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i) {
        if (i >= 0) {
            this.mContainerItemSkip = i;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, true);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i);
        }
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        boolean z;
        if (type == ConstraintAnchor.Type.CENTER) {
            if (type2 == ConstraintAnchor.Type.CENTER) {
                ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
                ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                boolean z2 = true;
                if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                    connect(ConstraintAnchor.Type.LEFT, constraintWidget, ConstraintAnchor.Type.LEFT, 0);
                    connect(ConstraintAnchor.Type.RIGHT, constraintWidget, ConstraintAnchor.Type.RIGHT, 0);
                    z = true;
                } else {
                    z = false;
                }
                if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                    connect(ConstraintAnchor.Type.TOP, constraintWidget, ConstraintAnchor.Type.TOP, 0);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, ConstraintAnchor.Type.BOTTOM, 0);
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER), 0);
                } else if (z) {
                    getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_X), 0);
                } else if (z2) {
                    getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0);
                }
            } else if (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT) {
                connect(ConstraintAnchor.Type.LEFT, constraintWidget, type2, 0);
                connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0);
            } else if (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM) {
                connect(ConstraintAnchor.Type.TOP, constraintWidget, type2, 0);
                connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0);
            }
        } else if (type == ConstraintAnchor.Type.CENTER_X && (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.RIGHT);
            anchor5.connect(anchor6, 0);
            anchor7.connect(anchor6, 0);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(anchor6, 0);
        } else if (type == ConstraintAnchor.Type.CENTER_Y && (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(ConstraintAnchor.Type.TOP).connect(anchor8, 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(anchor8, 0);
        } else if (type == ConstraintAnchor.Type.CENTER_X && type2 == ConstraintAnchor.Type.CENTER_X) {
            getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT), 0);
            getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT), 0);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(type2), 0);
        } else if (type == ConstraintAnchor.Type.CENTER_Y && type2 == ConstraintAnchor.Type.CENTER_Y) {
            getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP), 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM), 0);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(type2), 0);
        } else {
            ConstraintAnchor anchor9 = getAnchor(type);
            ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
            if (anchor9.isValidConnection(anchor10)) {
                if (type == ConstraintAnchor.Type.BASELINE) {
                    ConstraintAnchor anchor11 = getAnchor(ConstraintAnchor.Type.TOP);
                    ConstraintAnchor anchor12 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                    if (anchor11 != null) {
                        anchor11.reset();
                    }
                    if (anchor12 != null) {
                        anchor12.reset();
                    }
                    i = 0;
                } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                    ConstraintAnchor anchor13 = getAnchor(ConstraintAnchor.Type.BASELINE);
                    if (anchor13 != null) {
                        anchor13.reset();
                    }
                    ConstraintAnchor anchor14 = getAnchor(ConstraintAnchor.Type.CENTER);
                    if (anchor14.getTarget() != anchor10) {
                        anchor14.reset();
                    }
                    ConstraintAnchor opposite = getAnchor(type).getOpposite();
                    ConstraintAnchor anchor15 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
                    if (anchor15.isConnected()) {
                        opposite.reset();
                        anchor15.reset();
                    }
                } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                    ConstraintAnchor anchor16 = getAnchor(ConstraintAnchor.Type.CENTER);
                    if (anchor16.getTarget() != anchor10) {
                        anchor16.reset();
                    }
                    ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                    ConstraintAnchor anchor17 = getAnchor(ConstraintAnchor.Type.CENTER_X);
                    if (anchor17.isConnected()) {
                        opposite2.reset();
                        anchor17.reset();
                    }
                }
                anchor9.connect(anchor10, i);
            }
        }
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() == null || !(getParent() instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
            ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
            if (constraintAnchor == anchor5) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor.reset();
                    anchor2.reset();
                }
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor6) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                    anchor.reset();
                    anchor2.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor7) {
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
                if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor5.reset();
                }
            } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor5.reset();
            }
            constraintAnchor.reset();
        }
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i = 0; i < size; i++) {
                this.mAnchors.get(i).reset();
            }
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public boolean isInHorizontalChain() {
        if (this.mLeft.mTarget == null || this.mLeft.mTarget.mTarget != this.mLeft) {
            return this.mRight.mTarget != null && this.mRight.mTarget.mTarget == this.mRight;
        }
        return true;
    }

    public ConstraintWidget getPreviousChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            if (this.mLeft.mTarget == null || this.mLeft.mTarget.mTarget != (constraintAnchor2 = this.mLeft)) {
                return null;
            }
            return constraintAnchor2.mTarget.mOwner;
        } else if (i == 1 && this.mTop.mTarget != null && this.mTop.mTarget.mTarget == (constraintAnchor = this.mTop)) {
            return constraintAnchor.mTarget.mOwner;
        } else {
            return null;
        }
    }

    public ConstraintWidget getNextChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            if (this.mRight.mTarget == null || this.mRight.mTarget.mTarget != (constraintAnchor2 = this.mRight)) {
                return null;
            }
            return constraintAnchor2.mTarget.mOwner;
        } else if (i == 1 && this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == (constraintAnchor = this.mBottom)) {
            return constraintAnchor.mTarget.mOwner;
        } else {
            return null;
        }
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    public boolean isInVerticalChain() {
        if (this.mTop.mTarget == null || this.mTop.mTarget.mTarget != this.mTop) {
            return this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == this.mBottom;
        }
        return true;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    private boolean isChainHead(int i) {
        int i2 = i * 2;
        if (this.mListAnchors[i2].mTarget != null) {
            ConstraintAnchor constraintAnchor = this.mListAnchors[i2].mTarget.mTarget;
            ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
            if (constraintAnchor != constraintAnchorArr[i2]) {
                int i3 = i2 + 1;
                return constraintAnchorArr[i3].mTarget != null && this.mListAnchors[i3].mTarget.mTarget == this.mListAnchors[i3];
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:182:0x030e  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0332  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x033d  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0340  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x035f  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x03ae  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x03b7  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x03bd  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x03c6  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x03ea  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x03ed  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x045b  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x04c5  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x04d9  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x04db  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x04de  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x056f  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0572  */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x05b8  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x05e3  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x05ed  */
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        int i2;
        int i3;
        boolean z6;
        int i4;
        boolean z7;
        int i5;
        boolean z8;
        int i6;
        boolean z9;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        boolean z10;
        boolean z11;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        boolean z12;
        ConstraintWidget constraintWidget;
        LinearSystem linearSystem2;
        SolverVariable solverVariable6;
        SolverVariable solverVariable7;
        int i7;
        int i8;
        int i9;
        int i10;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        ConstraintWidget constraintWidget2;
        boolean z13;
        HorizontalWidgetRun horizontalWidgetRun;
        int i11;
        int i12;
        boolean z14;
        boolean z15;
        HorizontalWidgetRun horizontalWidgetRun2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
        ConstraintWidget constraintWidget5 = this.mParent;
        if (constraintWidget5 != null) {
            boolean z16 = constraintWidget5 != null && constraintWidget5.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
            ConstraintWidget constraintWidget6 = this.mParent;
            z3 = z16;
            z2 = constraintWidget6 != null && constraintWidget6.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
        } else {
            z3 = false;
            z2 = false;
        }
        if (this.mVisibility == 8 && !hasDependencies()) {
            boolean[] zArr = this.mIsInBarrier;
            if (!zArr[0] && !zArr[1]) {
                return;
            }
        }
        boolean z17 = this.resolvedHorizontal;
        if (z17 || this.resolvedVertical) {
            if (z17) {
                linearSystem.addEquality(createObjectVariable, this.mX);
                linearSystem.addEquality(createObjectVariable2, this.mX + this.mWidth);
                if (z3 && (constraintWidget4 = this.mParent) != null) {
                    if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget4;
                        constraintWidgetContainer.addVerticalWrapMinVariable(this.mLeft);
                        constraintWidgetContainer.addHorizontalWrapMaxVariable(this.mRight);
                    } else {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget4.mRight), createObjectVariable2, 0, 5);
                    }
                }
            }
            if (this.resolvedVertical) {
                linearSystem.addEquality(createObjectVariable3, this.mY);
                linearSystem.addEquality(createObjectVariable4, this.mY + this.mHeight);
                if (this.mBaseline.hasDependents()) {
                    linearSystem.addEquality(createObjectVariable5, this.mY + this.mBaselineDistance);
                }
                if (z2 && (constraintWidget3 = this.mParent) != null) {
                    if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                        ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget3;
                        constraintWidgetContainer2.addVerticalWrapMinVariable(this.mTop);
                        constraintWidgetContainer2.addVerticalWrapMaxVariable(this.mBottom);
                    } else {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget3.mBottom), createObjectVariable4, 0, 5);
                    }
                }
            }
            if (this.resolvedHorizontal && this.resolvedVertical) {
                this.resolvedHorizontal = false;
                this.resolvedVertical = false;
                return;
            }
        }
        if (LinearSystem.sMetrics != null) {
            LinearSystem.sMetrics.widgets++;
        }
        if (!z || (horizontalWidgetRun2 = this.horizontalRun) == null || this.verticalRun == null || !horizontalWidgetRun2.start.resolved || !this.horizontalRun.end.resolved || !this.verticalRun.start.resolved || !this.verticalRun.end.resolved) {
            if (LinearSystem.sMetrics != null) {
                LinearSystem.sMetrics.linearSolved++;
            }
            if (this.mParent != null) {
                if (isChainHead(0)) {
                    ((ConstraintWidgetContainer) this.mParent).addChain(this, 0);
                    z14 = true;
                } else {
                    z14 = isInHorizontalChain();
                }
                if (isChainHead(1)) {
                    ((ConstraintWidgetContainer) this.mParent).addChain(this, 1);
                    z15 = true;
                } else {
                    z15 = isInVerticalChain();
                }
                if (!z14 && z3 && this.mVisibility != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 1);
                }
                if (!z15 && z2 && this.mVisibility != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), createObjectVariable4, 0, 1);
                }
                z4 = z14;
                z5 = z15;
            } else {
                z5 = false;
                z4 = false;
            }
            int i13 = this.mWidth;
            int i14 = this.mMinWidth;
            if (i13 < i14) {
                i13 = i14;
            }
            int i15 = this.mHeight;
            int i16 = this.mMinHeight;
            if (i15 < i16) {
                i15 = i16;
            }
            boolean z18 = this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z19 = this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT;
            this.mResolvedDimensionRatioSide = this.mDimensionRatioSide;
            float f = this.mDimensionRatio;
            this.mResolvedDimensionRatio = f;
            int i17 = this.mMatchConstraintDefaultWidth;
            int i18 = this.mMatchConstraintDefaultHeight;
            if (f <= 0.0f || this.mVisibility == 8) {
                i12 = i15;
                i2 = i18;
                i = i17;
                i4 = i13;
            } else {
                i12 = i15;
                if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && i17 == 0) {
                    i17 = 3;
                }
                if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i18 == 0) {
                    i18 = 3;
                }
                if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i17 == 3 && i18 == 3) {
                    setupDimensionRatio(z3, z2, z18, z19);
                } else if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && i17 == 3) {
                    this.mResolvedDimensionRatioSide = 0;
                    i4 = (int) (this.mResolvedDimensionRatio * ((float) this.mHeight));
                    i2 = i18;
                    if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
                        i = 4;
                    } else {
                        i = i17;
                        i3 = i12;
                        z6 = true;
                        int[] iArr = this.mResolvedMatchConstraintDefault;
                        iArr[0] = i;
                        iArr[1] = i2;
                        this.mResolvedHasRatio = z6;
                        if (z6) {
                        }
                        z7 = false;
                        if (!z6) {
                        }
                        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT) {
                        }
                        if (!z8) {
                        }
                        z9 = !this.mCenter.isConnected();
                        boolean[] zArr2 = this.mIsInBarrier;
                        boolean z20 = zArr2[0];
                        boolean z21 = zArr2[1];
                        if (z) {
                        }
                        ConstraintWidget constraintWidget7 = this.mParent;
                        if (constraintWidget7 == null) {
                        }
                        ConstraintWidget constraintWidget8 = this.mParent;
                        if (constraintWidget8 == null) {
                        }
                        boolean z22 = this.isTerminalWidget[0];
                        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
                        z10 = z3;
                        z12 = z2;
                        z11 = z6;
                        solverVariable3 = createObjectVariable5;
                        solverVariable2 = createObjectVariable4;
                        solverVariable = createObjectVariable3;
                        solverVariable5 = createObjectVariable2;
                        solverVariable4 = createObjectVariable;
                        applyConstraints(linearSystem, true, z3, z2, z22, r27, r16, dimensionBehaviourArr[0], z8, this.mLeft, this.mRight, this.mX, i6, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z7, dimensionBehaviourArr[1] != DimensionBehaviour.MATCH_CONSTRAINT, z4, z5, z20, i, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z9);
                        if (z) {
                        }
                        i9 = i7;
                        if ((constraintWidget.mVerticalResolution != 2 ? i8 : i9) != 0) {
                        }
                        solverVariable10 = solverVariable7;
                        solverVariable9 = solverVariable6;
                        if (!z11) {
                        }
                        if (constraintWidget2.mCenter.isConnected()) {
                        }
                        constraintWidget2.resolvedHorizontal = false;
                        constraintWidget2.resolvedVertical = false;
                        return;
                    }
                } else if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i18 == 3) {
                    this.mResolvedDimensionRatioSide = 1;
                    if (this.mDimensionRatioSide == -1) {
                        this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                    }
                    i3 = (int) (this.mResolvedDimensionRatio * ((float) this.mWidth));
                    if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
                        i = i17;
                        i2 = 4;
                        i4 = i13;
                        z6 = false;
                        int[] iArr2 = this.mResolvedMatchConstraintDefault;
                        iArr2[0] = i;
                        iArr2[1] = i2;
                        this.mResolvedHasRatio = z6;
                        if (z6) {
                            int i19 = this.mResolvedDimensionRatioSide;
                            i5 = -1;
                            if (i19 == 0 || i19 == -1) {
                                z7 = true;
                                boolean z23 = !z6 && ((i11 = this.mResolvedDimensionRatioSide) == 1 || i11 == i5);
                                z8 = this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT && (this instanceof ConstraintWidgetContainer);
                                i6 = !z8 ? 0 : i4;
                                z9 = !this.mCenter.isConnected();
                                boolean[] zArr22 = this.mIsInBarrier;
                                boolean z202 = zArr22[0];
                                boolean z212 = zArr22[1];
                                if (this.mHorizontalResolution != 2 && !this.resolvedHorizontal) {
                                    if (z || (horizontalWidgetRun = this.horizontalRun) == null || !horizontalWidgetRun.start.resolved || !this.horizontalRun.end.resolved) {
                                        ConstraintWidget constraintWidget72 = this.mParent;
                                        SolverVariable createObjectVariable6 = constraintWidget72 == null ? linearSystem.createObjectVariable(constraintWidget72.mRight) : null;
                                        ConstraintWidget constraintWidget82 = this.mParent;
                                        SolverVariable createObjectVariable7 = constraintWidget82 == null ? linearSystem.createObjectVariable(constraintWidget82.mLeft) : null;
                                        boolean z222 = this.isTerminalWidget[0];
                                        DimensionBehaviour[] dimensionBehaviourArr2 = this.mListDimensionBehaviors;
                                        z10 = z3;
                                        z12 = z2;
                                        z11 = z6;
                                        solverVariable3 = createObjectVariable5;
                                        solverVariable2 = createObjectVariable4;
                                        solverVariable = createObjectVariable3;
                                        solverVariable5 = createObjectVariable2;
                                        solverVariable4 = createObjectVariable;
                                        applyConstraints(linearSystem, true, z3, z2, z222, createObjectVariable7, createObjectVariable6, dimensionBehaviourArr2[0], z8, this.mLeft, this.mRight, this.mX, i6, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z7, dimensionBehaviourArr2[1] != DimensionBehaviour.MATCH_CONSTRAINT, z4, z5, z202, i, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z9);
                                        if (z) {
                                            constraintWidget = this;
                                            VerticalWidgetRun verticalWidgetRun = constraintWidget.verticalRun;
                                            if (verticalWidgetRun == null || !verticalWidgetRun.start.resolved || !constraintWidget.verticalRun.end.resolved) {
                                                linearSystem2 = linearSystem;
                                                solverVariable8 = solverVariable3;
                                                solverVariable7 = solverVariable2;
                                                solverVariable6 = solverVariable;
                                                i10 = 8;
                                                i8 = 0;
                                                i7 = 1;
                                            } else {
                                                linearSystem2 = linearSystem;
                                                solverVariable6 = solverVariable;
                                                linearSystem2.addEquality(solverVariable6, constraintWidget.verticalRun.start.value);
                                                solverVariable7 = solverVariable2;
                                                linearSystem2.addEquality(solverVariable7, constraintWidget.verticalRun.end.value);
                                                solverVariable8 = solverVariable3;
                                                linearSystem2.addEquality(solverVariable8, constraintWidget.verticalRun.baseline.value);
                                                ConstraintWidget constraintWidget9 = constraintWidget.mParent;
                                                if (constraintWidget9 == null || z5 || !z12) {
                                                    i10 = 8;
                                                    i8 = 0;
                                                    i7 = 1;
                                                } else {
                                                    i7 = 1;
                                                    if (constraintWidget.isTerminalWidget[1]) {
                                                        i10 = 8;
                                                        i8 = 0;
                                                        linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(constraintWidget9.mBottom), solverVariable7, 0, 8);
                                                    } else {
                                                        i10 = 8;
                                                        i8 = 0;
                                                    }
                                                }
                                                i9 = i8;
                                                if ((constraintWidget.mVerticalResolution != 2 ? i8 : i9) != 0 || constraintWidget.resolvedVertical) {
                                                    solverVariable10 = solverVariable7;
                                                    solverVariable9 = solverVariable6;
                                                } else {
                                                    boolean z24 = (constraintWidget.mListDimensionBehaviors[i7] != DimensionBehaviour.WRAP_CONTENT || !(constraintWidget instanceof ConstraintWidgetContainer)) ? i8 : i7;
                                                    if (z24) {
                                                        i3 = i8;
                                                    }
                                                    ConstraintWidget constraintWidget10 = constraintWidget.mParent;
                                                    SolverVariable createObjectVariable8 = constraintWidget10 != null ? linearSystem2.createObjectVariable(constraintWidget10.mBottom) : null;
                                                    ConstraintWidget constraintWidget11 = constraintWidget.mParent;
                                                    SolverVariable createObjectVariable9 = constraintWidget11 != null ? linearSystem2.createObjectVariable(constraintWidget11.mTop) : null;
                                                    if (constraintWidget.mBaselineDistance > 0 || constraintWidget.mVisibility == i10) {
                                                        if (constraintWidget.mBaseline.mTarget != null) {
                                                            linearSystem2.addEquality(solverVariable8, solverVariable6, getBaselineDistance(), i10);
                                                            linearSystem2.addEquality(solverVariable8, linearSystem2.createObjectVariable(constraintWidget.mBaseline.mTarget), i8, i10);
                                                            if (z12) {
                                                                linearSystem2.addGreaterThan(createObjectVariable8, linearSystem2.createObjectVariable(constraintWidget.mBottom), i8, 5);
                                                            }
                                                            z13 = i8;
                                                            boolean z25 = constraintWidget.isTerminalWidget[i7];
                                                            DimensionBehaviour[] dimensionBehaviourArr3 = constraintWidget.mListDimensionBehaviors;
                                                            solverVariable10 = solverVariable7;
                                                            solverVariable9 = solverVariable6;
                                                            applyConstraints(linearSystem, false, z12, z10, z25, createObjectVariable9, createObjectVariable8, dimensionBehaviourArr3[i7], z24, constraintWidget.mTop, constraintWidget.mBottom, constraintWidget.mY, i3, constraintWidget.mMinHeight, constraintWidget.mMaxDimension[i7], constraintWidget.mVerticalBiasPercent, z23, dimensionBehaviourArr3[0] != DimensionBehaviour.MATCH_CONSTRAINT, z5, z4, z212, i2, i, constraintWidget.mMatchConstraintMinHeight, constraintWidget.mMatchConstraintMaxHeight, constraintWidget.mMatchConstraintPercentHeight, z13);
                                                        } else if (constraintWidget.mVisibility == i10) {
                                                            linearSystem2.addEquality(solverVariable8, solverVariable6, i8, i10);
                                                        } else {
                                                            linearSystem2.addEquality(solverVariable8, solverVariable6, getBaselineDistance(), i10);
                                                        }
                                                    }
                                                    z13 = z9;
                                                    boolean z252 = constraintWidget.isTerminalWidget[i7];
                                                    DimensionBehaviour[] dimensionBehaviourArr32 = constraintWidget.mListDimensionBehaviors;
                                                    solverVariable10 = solverVariable7;
                                                    solverVariable9 = solverVariable6;
                                                    applyConstraints(linearSystem, false, z12, z10, z252, createObjectVariable9, createObjectVariable8, dimensionBehaviourArr32[i7], z24, constraintWidget.mTop, constraintWidget.mBottom, constraintWidget.mY, i3, constraintWidget.mMinHeight, constraintWidget.mMaxDimension[i7], constraintWidget.mVerticalBiasPercent, z23, dimensionBehaviourArr32[0] != DimensionBehaviour.MATCH_CONSTRAINT, z5, z4, z212, i2, i, constraintWidget.mMatchConstraintMinHeight, constraintWidget.mMatchConstraintMaxHeight, constraintWidget.mMatchConstraintPercentHeight, z13);
                                                }
                                                if (!z11) {
                                                    constraintWidget2 = this;
                                                    if (constraintWidget2.mResolvedDimensionRatioSide == 1) {
                                                        linearSystem.addRatio(solverVariable10, solverVariable9, solverVariable5, solverVariable4, constraintWidget2.mResolvedDimensionRatio, 8);
                                                    } else {
                                                        linearSystem.addRatio(solverVariable5, solverVariable4, solverVariable10, solverVariable9, constraintWidget2.mResolvedDimensionRatio, 8);
                                                    }
                                                } else {
                                                    constraintWidget2 = this;
                                                }
                                                if (constraintWidget2.mCenter.isConnected()) {
                                                    linearSystem.addCenterPoint(constraintWidget2, constraintWidget2.mCenter.getTarget().getOwner(), (float) Math.toRadians((double) (constraintWidget2.mCircleConstraintAngle + 90.0f)), constraintWidget2.mCenter.getMargin());
                                                }
                                                constraintWidget2.resolvedHorizontal = false;
                                                constraintWidget2.resolvedVertical = false;
                                                return;
                                            }
                                        } else {
                                            i10 = 8;
                                            i8 = 0;
                                            i7 = 1;
                                            constraintWidget = this;
                                            linearSystem2 = linearSystem;
                                            solverVariable8 = solverVariable3;
                                            solverVariable7 = solverVariable2;
                                            solverVariable6 = solverVariable;
                                        }
                                        i9 = i7;
                                        if ((constraintWidget.mVerticalResolution != 2 ? i8 : i9) != 0) {
                                        }
                                        solverVariable10 = solverVariable7;
                                        solverVariable9 = solverVariable6;
                                        if (!z11) {
                                        }
                                        if (constraintWidget2.mCenter.isConnected()) {
                                        }
                                        constraintWidget2.resolvedHorizontal = false;
                                        constraintWidget2.resolvedVertical = false;
                                        return;
                                    } else if (z) {
                                        linearSystem.addEquality(createObjectVariable, this.horizontalRun.start.value);
                                        linearSystem.addEquality(createObjectVariable2, this.horizontalRun.end.value);
                                        if (this.mParent != null && z3 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                                            linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 8);
                                        }
                                    }
                                }
                                z10 = z3;
                                z12 = z2;
                                z11 = z6;
                                solverVariable3 = createObjectVariable5;
                                solverVariable2 = createObjectVariable4;
                                solverVariable = createObjectVariable3;
                                solverVariable5 = createObjectVariable2;
                                solverVariable4 = createObjectVariable;
                                if (z) {
                                }
                                i9 = i7;
                                if ((constraintWidget.mVerticalResolution != 2 ? i8 : i9) != 0) {
                                }
                                solverVariable10 = solverVariable7;
                                solverVariable9 = solverVariable6;
                                if (!z11) {
                                }
                                if (constraintWidget2.mCenter.isConnected()) {
                                }
                                constraintWidget2.resolvedHorizontal = false;
                                constraintWidget2.resolvedVertical = false;
                                return;
                            }
                        } else {
                            i5 = -1;
                        }
                        z7 = false;
                        if (!z6) {
                        }
                        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT) {
                        }
                        if (!z8) {
                        }
                        z9 = !this.mCenter.isConnected();
                        boolean[] zArr222 = this.mIsInBarrier;
                        boolean z2022 = zArr222[0];
                        boolean z2122 = zArr222[1];
                        if (z) {
                        }
                        ConstraintWidget constraintWidget722 = this.mParent;
                        if (constraintWidget722 == null) {
                        }
                        ConstraintWidget constraintWidget822 = this.mParent;
                        if (constraintWidget822 == null) {
                        }
                        boolean z2222 = this.isTerminalWidget[0];
                        DimensionBehaviour[] dimensionBehaviourArr22 = this.mListDimensionBehaviors;
                        z10 = z3;
                        z12 = z2;
                        z11 = z6;
                        solverVariable3 = createObjectVariable5;
                        solverVariable2 = createObjectVariable4;
                        solverVariable = createObjectVariable3;
                        solverVariable5 = createObjectVariable2;
                        solverVariable4 = createObjectVariable;
                        applyConstraints(linearSystem, true, z3, z2, z2222, createObjectVariable7, createObjectVariable6, dimensionBehaviourArr22[0], z8, this.mLeft, this.mRight, this.mX, i6, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z7, dimensionBehaviourArr22[1] != DimensionBehaviour.MATCH_CONSTRAINT, z4, z5, z2022, i, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z9);
                        if (z) {
                        }
                        i9 = i7;
                        if ((constraintWidget.mVerticalResolution != 2 ? i8 : i9) != 0) {
                        }
                        solverVariable10 = solverVariable7;
                        solverVariable9 = solverVariable6;
                        if (!z11) {
                        }
                        if (constraintWidget2.mCenter.isConnected()) {
                        }
                        constraintWidget2.resolvedHorizontal = false;
                        constraintWidget2.resolvedVertical = false;
                        return;
                    }
                    i2 = i18;
                    i = i17;
                    i4 = i13;
                    z6 = true;
                    int[] iArr22 = this.mResolvedMatchConstraintDefault;
                    iArr22[0] = i;
                    iArr22[1] = i2;
                    this.mResolvedHasRatio = z6;
                    if (z6) {
                    }
                    z7 = false;
                    if (!z6) {
                    }
                    if (this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT) {
                    }
                    if (!z8) {
                    }
                    z9 = !this.mCenter.isConnected();
                    boolean[] zArr2222 = this.mIsInBarrier;
                    boolean z20222 = zArr2222[0];
                    boolean z21222 = zArr2222[1];
                    if (z) {
                    }
                    ConstraintWidget constraintWidget7222 = this.mParent;
                    if (constraintWidget7222 == null) {
                    }
                    ConstraintWidget constraintWidget8222 = this.mParent;
                    if (constraintWidget8222 == null) {
                    }
                    boolean z22222 = this.isTerminalWidget[0];
                    DimensionBehaviour[] dimensionBehaviourArr222 = this.mListDimensionBehaviors;
                    z10 = z3;
                    z12 = z2;
                    z11 = z6;
                    solverVariable3 = createObjectVariable5;
                    solverVariable2 = createObjectVariable4;
                    solverVariable = createObjectVariable3;
                    solverVariable5 = createObjectVariable2;
                    solverVariable4 = createObjectVariable;
                    applyConstraints(linearSystem, true, z3, z2, z22222, createObjectVariable7, createObjectVariable6, dimensionBehaviourArr222[0], z8, this.mLeft, this.mRight, this.mX, i6, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z7, dimensionBehaviourArr222[1] != DimensionBehaviour.MATCH_CONSTRAINT, z4, z5, z20222, i, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z9);
                    if (z) {
                    }
                    i9 = i7;
                    if ((constraintWidget.mVerticalResolution != 2 ? i8 : i9) != 0) {
                    }
                    solverVariable10 = solverVariable7;
                    solverVariable9 = solverVariable6;
                    if (!z11) {
                    }
                    if (constraintWidget2.mCenter.isConnected()) {
                    }
                    constraintWidget2.resolvedHorizontal = false;
                    constraintWidget2.resolvedVertical = false;
                    return;
                }
                i2 = i18;
                i = i17;
                i4 = i13;
                i3 = i12;
                z6 = true;
                int[] iArr222 = this.mResolvedMatchConstraintDefault;
                iArr222[0] = i;
                iArr222[1] = i2;
                this.mResolvedHasRatio = z6;
                if (z6) {
                }
                z7 = false;
                if (!z6) {
                }
                if (this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT) {
                }
                if (!z8) {
                }
                z9 = !this.mCenter.isConnected();
                boolean[] zArr22222 = this.mIsInBarrier;
                boolean z202222 = zArr22222[0];
                boolean z212222 = zArr22222[1];
                if (z) {
                }
                ConstraintWidget constraintWidget72222 = this.mParent;
                if (constraintWidget72222 == null) {
                }
                ConstraintWidget constraintWidget82222 = this.mParent;
                if (constraintWidget82222 == null) {
                }
                boolean z222222 = this.isTerminalWidget[0];
                DimensionBehaviour[] dimensionBehaviourArr2222 = this.mListDimensionBehaviors;
                z10 = z3;
                z12 = z2;
                z11 = z6;
                solverVariable3 = createObjectVariable5;
                solverVariable2 = createObjectVariable4;
                solverVariable = createObjectVariable3;
                solverVariable5 = createObjectVariable2;
                solverVariable4 = createObjectVariable;
                applyConstraints(linearSystem, true, z3, z2, z222222, createObjectVariable7, createObjectVariable6, dimensionBehaviourArr2222[0], z8, this.mLeft, this.mRight, this.mX, i6, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z7, dimensionBehaviourArr2222[1] != DimensionBehaviour.MATCH_CONSTRAINT, z4, z5, z202222, i, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z9);
                if (z) {
                }
                i9 = i7;
                if ((constraintWidget.mVerticalResolution != 2 ? i8 : i9) != 0) {
                }
                solverVariable10 = solverVariable7;
                solverVariable9 = solverVariable6;
                if (!z11) {
                }
                if (constraintWidget2.mCenter.isConnected()) {
                }
                constraintWidget2.resolvedHorizontal = false;
                constraintWidget2.resolvedVertical = false;
                return;
            }
            i3 = i12;
            z6 = false;
            int[] iArr2222 = this.mResolvedMatchConstraintDefault;
            iArr2222[0] = i;
            iArr2222[1] = i2;
            this.mResolvedHasRatio = z6;
            if (z6) {
            }
            z7 = false;
            if (!z6) {
            }
            if (this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT) {
            }
            if (!z8) {
            }
            z9 = !this.mCenter.isConnected();
            boolean[] zArr222222 = this.mIsInBarrier;
            boolean z2022222 = zArr222222[0];
            boolean z2122222 = zArr222222[1];
            if (z) {
            }
            ConstraintWidget constraintWidget722222 = this.mParent;
            if (constraintWidget722222 == null) {
            }
            ConstraintWidget constraintWidget822222 = this.mParent;
            if (constraintWidget822222 == null) {
            }
            boolean z2222222 = this.isTerminalWidget[0];
            DimensionBehaviour[] dimensionBehaviourArr22222 = this.mListDimensionBehaviors;
            z10 = z3;
            z12 = z2;
            z11 = z6;
            solverVariable3 = createObjectVariable5;
            solverVariable2 = createObjectVariable4;
            solverVariable = createObjectVariable3;
            solverVariable5 = createObjectVariable2;
            solverVariable4 = createObjectVariable;
            applyConstraints(linearSystem, true, z3, z2, z2222222, createObjectVariable7, createObjectVariable6, dimensionBehaviourArr22222[0], z8, this.mLeft, this.mRight, this.mX, i6, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z7, dimensionBehaviourArr22222[1] != DimensionBehaviour.MATCH_CONSTRAINT, z4, z5, z2022222, i, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z9);
            if (z) {
            }
            i9 = i7;
            if ((constraintWidget.mVerticalResolution != 2 ? i8 : i9) != 0) {
            }
            solverVariable10 = solverVariable7;
            solverVariable9 = solverVariable6;
            if (!z11) {
            }
            if (constraintWidget2.mCenter.isConnected()) {
            }
            constraintWidget2.resolvedHorizontal = false;
            constraintWidget2.resolvedVertical = false;
            return;
        }
        if (LinearSystem.sMetrics != null) {
            LinearSystem.sMetrics.graphSolved++;
        }
        linearSystem.addEquality(createObjectVariable, this.horizontalRun.start.value);
        linearSystem.addEquality(createObjectVariable2, this.horizontalRun.end.value);
        linearSystem.addEquality(createObjectVariable3, this.verticalRun.start.value);
        linearSystem.addEquality(createObjectVariable4, this.verticalRun.end.value);
        linearSystem.addEquality(createObjectVariable5, this.verticalRun.baseline.value);
        if (this.mParent != null) {
            if (z3 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 8);
            }
            if (z2 && this.isTerminalWidget[1] && !isInVerticalChain()) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), createObjectVariable4, 0, 8);
            }
        }
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
    }

    /* access modifiers changed from: package-private */
    public boolean addFirst() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z3 && !z4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z3 && z4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            int i = this.mMatchConstraintMinWidth;
            if (i > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (i == 0 && this.mMatchConstraintMinHeight > 0) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x03dd  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x03f8  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x041f  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0439  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x0489  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x04bf A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x04ec  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x04f9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:347:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:351:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00df  */
    private void applyConstraints(LinearSystem linearSystem, boolean z, boolean z2, boolean z3, boolean z4, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z5, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i5, int i6, int i7, int i8, float f2, boolean z11) {
        int i9;
        boolean z12;
        int i10;
        int i11;
        SolverVariable solverVariable3;
        int i12;
        boolean z13;
        int i13;
        int i14;
        int i15;
        boolean z14;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        int i16;
        SolverVariable solverVariable7;
        int i17;
        int i18;
        SolverVariable solverVariable8;
        int i19;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        int i20;
        boolean z15;
        int i21;
        SolverVariable solverVariable11;
        ConstraintWidget constraintWidget;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        SolverVariable solverVariable12;
        int i27;
        int i28;
        boolean z16;
        int i29;
        ConstraintWidget constraintWidget2;
        int i30;
        SolverVariable solverVariable13;
        SolverVariable solverVariable14;
        ConstraintWidget constraintWidget3;
        SolverVariable solverVariable15;
        int i31;
        int i32;
        ConstraintWidget constraintWidget4;
        boolean z17;
        int i33;
        SolverVariable solverVariable16;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        ConstraintWidget constraintWidget5;
        int i39;
        SolverVariable solverVariable17;
        SolverVariable solverVariable18;
        int i40;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintAnchor);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(constraintAnchor2);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(constraintAnchor.getTarget());
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(constraintAnchor2.getTarget());
        if (LinearSystem.getMetrics() != null) {
            LinearSystem.getMetrics().nonresolvedWidgets++;
        }
        boolean isConnected = constraintAnchor.isConnected();
        boolean isConnected2 = constraintAnchor2.isConnected();
        boolean isConnected3 = this.mCenter.isConnected();
        if (isConnected2) {
            i9 = (isConnected ? 1 : 0) + 1;
        } else {
            i9 = isConnected ? 1 : 0;
        }
        if (isConnected3) {
            i9++;
        }
        int i41 = z6 ? 3 : i5;
        int i42 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[dimensionBehaviour.ordinal()];
        if (i42 == 1 || i42 == 2 || i42 == 3 || i42 != 4) {
            i10 = i41;
        } else {
            i10 = i41;
            if (i10 != 4) {
                z12 = true;
                if (this.mVisibility != 8) {
                    i11 = 0;
                    z12 = false;
                } else {
                    i11 = i2;
                }
                if (!z11) {
                    if (!isConnected && !isConnected2 && !isConnected3) {
                        linearSystem.addEquality(createObjectVariable, i);
                    } else if (isConnected && !isConnected2) {
                        solverVariable3 = createObjectVariable4;
                        i12 = 8;
                        linearSystem.addEquality(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), 8);
                    }
                    solverVariable3 = createObjectVariable4;
                    i12 = 8;
                } else {
                    solverVariable3 = createObjectVariable4;
                    i12 = 8;
                }
                if (z12) {
                    if (z5) {
                        i40 = 0;
                        linearSystem.addEquality(createObjectVariable2, createObjectVariable, 0, 3);
                        if (i3 > 0) {
                            linearSystem.addGreaterThan(createObjectVariable2, createObjectVariable, i3, 8);
                        }
                        if (i4 < Integer.MAX_VALUE) {
                            linearSystem.addLowerThan(createObjectVariable2, createObjectVariable, i4, 8);
                        }
                    } else {
                        i40 = 0;
                        linearSystem.addEquality(createObjectVariable2, createObjectVariable, i11, i12);
                    }
                    i13 = i7;
                    i16 = i8;
                    i15 = i40;
                    solverVariable5 = createObjectVariable3;
                    solverVariable4 = createObjectVariable2;
                } else if (i9 == 2 || z6 || !(i10 == 1 || i10 == 0)) {
                    int i43 = i7 == -2 ? i11 : i7;
                    i16 = i8 == -2 ? i11 : i8;
                    if (i11 > 0 && i10 != 1) {
                        i11 = 0;
                    }
                    if (i43 > 0) {
                        linearSystem.addGreaterThan(createObjectVariable2, createObjectVariable, i43, 8);
                        i11 = Math.max(i11, i43);
                    }
                    if (i16 > 0) {
                        if (!z2 || i10 != 1) {
                            i39 = 8;
                            linearSystem.addLowerThan(createObjectVariable2, createObjectVariable, i16, 8);
                        } else {
                            i39 = 8;
                        }
                        i11 = Math.min(i11, i16);
                    } else {
                        i39 = 8;
                    }
                    if (i10 == 1) {
                        if (z2) {
                            linearSystem.addEquality(createObjectVariable2, createObjectVariable, i11, i39);
                        } else if (z8) {
                            linearSystem.addEquality(createObjectVariable2, createObjectVariable, i11, 5);
                            linearSystem.addLowerThan(createObjectVariable2, createObjectVariable, i11, i39);
                        } else {
                            linearSystem.addEquality(createObjectVariable2, createObjectVariable, i11, 5);
                            linearSystem.addLowerThan(createObjectVariable2, createObjectVariable, i11, i39);
                        }
                        i15 = 0;
                        solverVariable5 = createObjectVariable3;
                        solverVariable4 = createObjectVariable2;
                        i13 = i43;
                    } else {
                        if (i10 == 2) {
                            if (constraintAnchor.getType() == ConstraintAnchor.Type.TOP || constraintAnchor.getType() == ConstraintAnchor.Type.BOTTOM) {
                                solverVariable18 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.TOP));
                                solverVariable17 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                            } else {
                                solverVariable18 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                                solverVariable17 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                            }
                            solverVariable6 = solverVariable3;
                            i15 = 0;
                            i14 = i9;
                            solverVariable5 = createObjectVariable3;
                            solverVariable4 = createObjectVariable2;
                            linearSystem.addConstraint(linearSystem.createRow().createRowDimensionRatio(createObjectVariable2, createObjectVariable, solverVariable17, solverVariable18, f2));
                            z14 = z4;
                            i13 = i43;
                            z13 = false;
                        } else {
                            i15 = 0;
                            solverVariable5 = createObjectVariable3;
                            solverVariable4 = createObjectVariable2;
                            solverVariable6 = solverVariable3;
                            i14 = i9;
                            i13 = i43;
                            z13 = z12;
                            z14 = true;
                        }
                        if (z11) {
                            solverVariable10 = solverVariable;
                            solverVariable8 = solverVariable2;
                            solverVariable9 = solverVariable4;
                            i19 = i15;
                            solverVariable7 = createObjectVariable;
                            i18 = i14;
                            i17 = 2;
                        } else if (z8) {
                            solverVariable10 = solverVariable;
                            solverVariable8 = solverVariable2;
                            solverVariable9 = solverVariable4;
                            i19 = i15;
                            i18 = i14;
                            i17 = 2;
                            solverVariable7 = createObjectVariable;
                        } else {
                            if ((isConnected || isConnected2 || isConnected3) && (!isConnected || isConnected2)) {
                                if (isConnected || !isConnected2) {
                                    i22 = i15;
                                    if (isConnected && isConnected2) {
                                        ConstraintWidget constraintWidget6 = constraintAnchor.mTarget.mOwner;
                                        ConstraintWidget constraintWidget7 = constraintAnchor2.mTarget.mOwner;
                                        ConstraintWidget parent = getParent();
                                        int i44 = 6;
                                        if (z13) {
                                            if (i10 == 0) {
                                                if (i16 != 0 || i13 != 0) {
                                                    i38 = i22;
                                                    i28 = 1;
                                                    i26 = 1;
                                                    i37 = 5;
                                                    i24 = 5;
                                                } else if (!solverVariable5.isFinalValue || !solverVariable6.isFinalValue) {
                                                    i28 = i22;
                                                    i26 = i28;
                                                    i38 = 1;
                                                    i37 = 8;
                                                    i24 = 8;
                                                } else {
                                                    linearSystem.addEquality(createObjectVariable, solverVariable5, constraintAnchor.getMargin(), 8);
                                                    linearSystem.addEquality(solverVariable4, solverVariable6, -constraintAnchor2.getMargin(), 8);
                                                    return;
                                                }
                                                if ((constraintWidget6 instanceof Barrier) || (constraintWidget7 instanceof Barrier)) {
                                                    solverVariable12 = solverVariable2;
                                                    i23 = i37;
                                                    i24 = 4;
                                                } else {
                                                    solverVariable12 = solverVariable2;
                                                    i23 = i37;
                                                }
                                                i25 = i38;
                                                i27 = 6;
                                            } else {
                                                if (i10 == 1) {
                                                    solverVariable12 = solverVariable2;
                                                    i27 = 6;
                                                    i28 = 1;
                                                    i26 = 1;
                                                    i25 = 0;
                                                    i24 = 4;
                                                } else if (i10 != 3) {
                                                    solverVariable12 = solverVariable2;
                                                    i27 = 6;
                                                    i28 = 0;
                                                    i26 = 0;
                                                } else if (this.mResolvedDimensionRatioSide == -1) {
                                                    if (z9) {
                                                        solverVariable12 = solverVariable2;
                                                        i28 = 1;
                                                        i27 = z2 ? 5 : 4;
                                                    } else {
                                                        solverVariable12 = solverVariable2;
                                                        i28 = 1;
                                                        i27 = 8;
                                                    }
                                                    i26 = 1;
                                                    i25 = 1;
                                                    i24 = 5;
                                                } else if (z6) {
                                                    if (!(i6 == 2 || i6 == 1)) {
                                                        i36 = 8;
                                                        i35 = 5;
                                                    } else {
                                                        i36 = 5;
                                                        i35 = 4;
                                                    }
                                                    solverVariable12 = solverVariable2;
                                                    i23 = i36;
                                                    i24 = i35;
                                                    i27 = 6;
                                                    i28 = 1;
                                                    i26 = 1;
                                                    i25 = 1;
                                                } else {
                                                    if (i16 > 0) {
                                                        solverVariable12 = solverVariable2;
                                                        i27 = 6;
                                                        i28 = 1;
                                                        i26 = 1;
                                                        i25 = 1;
                                                        i24 = 5;
                                                    } else if (i16 != 0 || i13 != 0) {
                                                        solverVariable12 = solverVariable2;
                                                        i27 = 6;
                                                        i28 = 1;
                                                        i26 = 1;
                                                        i25 = 1;
                                                        i24 = 4;
                                                    } else if (!z9) {
                                                        solverVariable12 = solverVariable2;
                                                        i27 = 6;
                                                        i28 = 1;
                                                        i26 = 1;
                                                        i25 = 1;
                                                        i24 = 8;
                                                    } else {
                                                        solverVariable12 = solverVariable2;
                                                        i23 = (constraintWidget6 == parent || constraintWidget7 == parent) ? 5 : 4;
                                                        i27 = 6;
                                                        i28 = 1;
                                                        i26 = 1;
                                                        i25 = 1;
                                                        i24 = 4;
                                                    }
                                                    i23 = 5;
                                                }
                                                i23 = 8;
                                            }
                                            if (i26 == 0 && solverVariable5 == solverVariable6 && constraintWidget6 != parent) {
                                                i26 = 0;
                                                z16 = false;
                                            } else {
                                                z16 = true;
                                            }
                                            if (i28 == 0) {
                                                if (z13 || z7 || z9 || solverVariable5 != solverVariable || solverVariable6 != solverVariable12) {
                                                    i30 = i23;
                                                    z17 = z16;
                                                    z15 = z2;
                                                    i33 = i27;
                                                } else {
                                                    z15 = false;
                                                    i33 = 8;
                                                    z17 = false;
                                                    i30 = 8;
                                                }
                                                i29 = i10;
                                                constraintWidget2 = parent;
                                                constraintWidget3 = constraintWidget7;
                                                solverVariable13 = solverVariable4;
                                                solverVariable14 = createObjectVariable;
                                                linearSystem.addCentering(createObjectVariable, solverVariable5, constraintAnchor.getMargin(), f, solverVariable6, solverVariable4, constraintAnchor2.getMargin(), i33);
                                                z16 = z17;
                                            } else {
                                                i29 = i10;
                                                constraintWidget2 = parent;
                                                constraintWidget3 = constraintWidget7;
                                                solverVariable13 = solverVariable4;
                                                solverVariable14 = createObjectVariable;
                                                i30 = i23;
                                                z15 = z2;
                                            }
                                            if (this.mVisibility == 8 || constraintAnchor2.hasDependents()) {
                                                if (i26 == 0) {
                                                    int i45 = (!z15 || solverVariable5 == solverVariable6 || z13 || (!(constraintWidget6 instanceof Barrier) && !(constraintWidget3 instanceof Barrier))) ? i30 : 6;
                                                    linearSystem.addGreaterThan(solverVariable14, solverVariable5, constraintAnchor.getMargin(), i45);
                                                    solverVariable15 = solverVariable13;
                                                    linearSystem.addLowerThan(solverVariable15, solverVariable6, -constraintAnchor2.getMargin(), i45);
                                                    i30 = i45;
                                                } else {
                                                    solverVariable15 = solverVariable13;
                                                }
                                                if (z15 || !z10 || (constraintWidget6 instanceof Barrier) || (constraintWidget3 instanceof Barrier)) {
                                                    i32 = i24;
                                                    i31 = i30;
                                                } else {
                                                    i32 = 6;
                                                    i31 = 6;
                                                    z16 = true;
                                                }
                                                if (z16) {
                                                    if (i25 == 0 || (z9 && !z3)) {
                                                        constraintWidget4 = constraintWidget2;
                                                    } else {
                                                        constraintWidget4 = constraintWidget2;
                                                        if (!(constraintWidget6 == constraintWidget4 || constraintWidget3 == constraintWidget4)) {
                                                            i44 = i32;
                                                        }
                                                        if ((constraintWidget6 instanceof Guideline) || (constraintWidget3 instanceof Guideline)) {
                                                            i44 = 5;
                                                        }
                                                        if ((constraintWidget6 instanceof Barrier) || (constraintWidget3 instanceof Barrier)) {
                                                            i44 = 5;
                                                        }
                                                        i32 = Math.max(z9 ? 5 : i44, i32);
                                                    }
                                                    if (z15) {
                                                        i32 = Math.min(i31, i32);
                                                        if (z6 && !z9 && (constraintWidget6 == constraintWidget4 || constraintWidget3 == constraintWidget4)) {
                                                            i32 = 4;
                                                        }
                                                    }
                                                    linearSystem.addEquality(solverVariable14, solverVariable5, constraintAnchor.getMargin(), i32);
                                                    linearSystem.addEquality(solverVariable15, solverVariable6, -constraintAnchor2.getMargin(), i32);
                                                }
                                                if (z15) {
                                                    int margin = solverVariable == solverVariable5 ? constraintAnchor.getMargin() : 0;
                                                    if (solverVariable5 != solverVariable) {
                                                        linearSystem.addGreaterThan(solverVariable14, solverVariable, margin, 5);
                                                    }
                                                }
                                                if (z15 || !z13) {
                                                    solverVariable11 = solverVariable15;
                                                } else {
                                                    solverVariable11 = solverVariable15;
                                                    if (i3 == 0 && i13 == 0) {
                                                        if (!z13 || i29 != 3) {
                                                            i21 = 0;
                                                            linearSystem.addGreaterThan(solverVariable11, solverVariable14, 0, 5);
                                                        } else {
                                                            i21 = 0;
                                                            linearSystem.addGreaterThan(solverVariable11, solverVariable14, 0, 8);
                                                        }
                                                        if (!z15 && z14) {
                                                            if (constraintAnchor2.mTarget != null) {
                                                                i21 = constraintAnchor2.getMargin();
                                                            }
                                                            if (solverVariable6 == solverVariable2) {
                                                                return;
                                                            }
                                                            if (!this.OPTIMIZE_WRAP || !solverVariable11.isFinalValue || (constraintWidget = this.mParent) == null) {
                                                                linearSystem.addGreaterThan(solverVariable2, solverVariable11, i21, 5);
                                                                return;
                                                            }
                                                            ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget;
                                                            if (z) {
                                                                constraintWidgetContainer.addHorizontalWrapMaxVariable(constraintAnchor2);
                                                                return;
                                                            } else {
                                                                constraintWidgetContainer.addVerticalWrapMaxVariable(constraintAnchor2);
                                                                return;
                                                            }
                                                        } else {
                                                            return;
                                                        }
                                                    }
                                                }
                                                i21 = 0;
                                                if (!z15) {
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        } else if (!solverVariable5.isFinalValue || !solverVariable6.isFinalValue) {
                                            solverVariable12 = solverVariable2;
                                            i27 = 6;
                                            i28 = 1;
                                            i26 = 1;
                                        } else {
                                            linearSystem.addCentering(createObjectVariable, solverVariable5, constraintAnchor.getMargin(), f, solverVariable6, solverVariable4, constraintAnchor2.getMargin(), 8);
                                            if (z2 && z14) {
                                                if (constraintAnchor2.mTarget != null) {
                                                    i34 = constraintAnchor2.getMargin();
                                                    solverVariable16 = solverVariable2;
                                                } else {
                                                    solverVariable16 = solverVariable2;
                                                    i34 = 0;
                                                }
                                                if (solverVariable6 != solverVariable16) {
                                                    linearSystem.addGreaterThan(solverVariable16, solverVariable4, i34, 5);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        i25 = 0;
                                        i24 = 4;
                                        i23 = 5;
                                        if (i26 == 0) {
                                        }
                                        z16 = true;
                                        if (i28 == 0) {
                                        }
                                        if (this.mVisibility == 8) {
                                        }
                                        if (i26 == 0) {
                                        }
                                        if (z15) {
                                        }
                                        i32 = i24;
                                        i31 = i30;
                                        if (z16) {
                                        }
                                        if (z15) {
                                        }
                                        if (z15) {
                                        }
                                        solverVariable11 = solverVariable15;
                                        i21 = 0;
                                        if (!z15) {
                                        }
                                    }
                                } else {
                                    linearSystem.addEquality(solverVariable4, solverVariable6, -constraintAnchor2.getMargin(), 8);
                                    if (z2) {
                                        if (!this.OPTIMIZE_WRAP || !createObjectVariable.isFinalValue || (constraintWidget5 = this.mParent) == null) {
                                            i22 = i15;
                                            linearSystem.addGreaterThan(createObjectVariable, solverVariable, i22, 5);
                                        } else {
                                            ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget5;
                                            if (z) {
                                                i22 = i15;
                                                constraintWidgetContainer2.addHorizontalWrapMinVariable(constraintAnchor);
                                            } else {
                                                i22 = i15;
                                                constraintWidgetContainer2.addVerticalWrapMinVariable(constraintAnchor);
                                            }
                                        }
                                    }
                                }
                                i21 = i22;
                                solverVariable11 = solverVariable4;
                                z15 = z2;
                                if (!z15) {
                                }
                            }
                            solverVariable11 = solverVariable4;
                            i21 = i15;
                            z15 = z2;
                            if (!z15) {
                            }
                        }
                        if (i18 < i17 && z2 && z14) {
                            linearSystem.addGreaterThan(solverVariable7, solverVariable10, i19, 8);
                            int i46 = (z || this.mBaseline.mTarget == null) ? 1 : i19;
                            if (z || this.mBaseline.mTarget == null) {
                                i20 = i46;
                            } else {
                                ConstraintWidget constraintWidget8 = this.mBaseline.mTarget.mOwner;
                                i20 = (constraintWidget8.mDimensionRatio != 0.0f && constraintWidget8.mListDimensionBehaviors[i19] == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget8.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) ? 1 : i19;
                            }
                            if (i20 != 0) {
                                linearSystem.addGreaterThan(solverVariable8, solverVariable9, i19, 8);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    int max = Math.max(i7, i11);
                    if (i8 > 0) {
                        max = Math.min(i8, max);
                    }
                    linearSystem.addEquality(createObjectVariable2, createObjectVariable, max, 8);
                    z14 = z4;
                    i13 = i7;
                    i16 = i8;
                    i15 = 0;
                    z13 = false;
                    solverVariable5 = createObjectVariable3;
                    solverVariable4 = createObjectVariable2;
                    solverVariable6 = solverVariable3;
                    i14 = i9;
                    if (z11) {
                    }
                    if (i18 < i17) {
                        return;
                    }
                    return;
                }
                z13 = z12;
                solverVariable6 = solverVariable3;
                z14 = z4;
                i14 = i9;
                if (z11) {
                }
                if (i18 < i17) {
                }
            }
        }
        z12 = false;
        if (this.mVisibility != 8) {
        }
        if (!z11) {
        }
        if (z12) {
        }
        z13 = z12;
        solverVariable6 = solverVariable3;
        z14 = z4;
        i14 = i9;
        if (z11) {
        }
        if (i18 < i17) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;

        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008f */
        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = iArr2;
            iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean z) {
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        if (z && (horizontalWidgetRun = this.horizontalRun) != null && horizontalWidgetRun.start.resolved && this.horizontalRun.end.resolved) {
            objectVariableValue = this.horizontalRun.start.value;
            objectVariableValue3 = this.horizontalRun.end.value;
        }
        if (z && (verticalWidgetRun = this.verticalRun) != null && verticalWidgetRun.start.resolved && this.verticalRun.end.resolved) {
            objectVariableValue2 = this.verticalRun.start.value;
            objectVariableValue4 = this.verticalRun.end.value;
        }
        int i = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue4 = 0;
            objectVariableValue = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        this.mHorizontalResolution = constraintWidget.mHorizontalResolution;
        this.mVerticalResolution = constraintWidget.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = constraintWidget.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = constraintWidget.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = constraintWidget.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = constraintWidget.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = constraintWidget.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = constraintWidget.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = constraintWidget.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = constraintWidget.mIsWidthWrapContent;
        this.mIsHeightWrapContent = constraintWidget.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = constraintWidget.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = constraintWidget.mResolvedDimensionRatio;
        int[] iArr3 = constraintWidget.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(iArr3, iArr3.length);
        this.mCircleConstraintAngle = constraintWidget.mCircleConstraintAngle;
        this.hasBaseline = constraintWidget.hasBaseline;
        this.inPlaceholder = constraintWidget.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        ConstraintWidget constraintWidget2 = null;
        this.mParent = this.mParent == null ? null : hashMap.get(constraintWidget.mParent);
        this.mWidth = constraintWidget.mWidth;
        this.mHeight = constraintWidget.mHeight;
        this.mDimensionRatio = constraintWidget.mDimensionRatio;
        this.mDimensionRatioSide = constraintWidget.mDimensionRatioSide;
        this.mX = constraintWidget.mX;
        this.mY = constraintWidget.mY;
        this.mRelX = constraintWidget.mRelX;
        this.mRelY = constraintWidget.mRelY;
        this.mOffsetX = constraintWidget.mOffsetX;
        this.mOffsetY = constraintWidget.mOffsetY;
        this.mBaselineDistance = constraintWidget.mBaselineDistance;
        this.mMinWidth = constraintWidget.mMinWidth;
        this.mMinHeight = constraintWidget.mMinHeight;
        this.mHorizontalBiasPercent = constraintWidget.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = constraintWidget.mVerticalBiasPercent;
        this.mCompanionWidget = constraintWidget.mCompanionWidget;
        this.mContainerItemSkip = constraintWidget.mContainerItemSkip;
        this.mVisibility = constraintWidget.mVisibility;
        this.mDebugName = constraintWidget.mDebugName;
        this.mType = constraintWidget.mType;
        this.mDistToTop = constraintWidget.mDistToTop;
        this.mDistToLeft = constraintWidget.mDistToLeft;
        this.mDistToRight = constraintWidget.mDistToRight;
        this.mDistToBottom = constraintWidget.mDistToBottom;
        this.mLeftHasCentered = constraintWidget.mLeftHasCentered;
        this.mRightHasCentered = constraintWidget.mRightHasCentered;
        this.mTopHasCentered = constraintWidget.mTopHasCentered;
        this.mBottomHasCentered = constraintWidget.mBottomHasCentered;
        this.mHorizontalWrapVisited = constraintWidget.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = constraintWidget.mVerticalWrapVisited;
        this.mHorizontalChainStyle = constraintWidget.mHorizontalChainStyle;
        this.mVerticalChainStyle = constraintWidget.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = constraintWidget.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = constraintWidget.mVerticalChainFixedPosition;
        float[] fArr = this.mWeight;
        float[] fArr2 = constraintWidget.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.mListNextMatchConstraintsWidget;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.mNextChainWidget;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget3 = constraintWidget.mHorizontalNextWidget;
        this.mHorizontalNextWidget = constraintWidget3 == null ? null : hashMap.get(constraintWidget3);
        ConstraintWidget constraintWidget4 = constraintWidget.mVerticalNextWidget;
        if (constraintWidget4 != null) {
            constraintWidget2 = hashMap.get(constraintWidget4);
        }
        this.mVerticalNextWidget = constraintWidget2;
    }

    public void updateFromRuns(boolean z, boolean z2) {
        int i;
        int i2;
        boolean isResolved = z & this.horizontalRun.isResolved();
        boolean isResolved2 = z2 & this.verticalRun.isResolved();
        int i3 = this.horizontalRun.start.value;
        int i4 = this.verticalRun.start.value;
        int i5 = this.horizontalRun.end.value;
        int i6 = this.verticalRun.end.value;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (isResolved) {
            this.mX = i3;
        }
        if (isResolved2) {
            this.mY = i4;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (isResolved) {
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i8 < (i2 = this.mWidth)) {
                i8 = i2;
            }
            this.mWidth = i8;
            int i10 = this.mMinWidth;
            if (i8 < i10) {
                this.mWidth = i10;
            }
        }
        if (isResolved2) {
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i9 < (i = this.mHeight)) {
                i9 = i;
            }
            this.mHeight = i9;
            int i11 = this.mMinHeight;
            if (i9 < i11) {
                this.mHeight = i11;
            }
        }
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int i, boolean z) {
        if (z) {
            if (hashSet.contains(this)) {
                Optimizer.checkMatchParent(constraintWidgetContainer, linearSystem, this);
                hashSet.remove(this);
                addToSolver(linearSystem, constraintWidgetContainer.optimizeFor(64));
            } else {
                return;
            }
        }
        if (i == 0) {
            HashSet<ConstraintAnchor> dependents = this.mLeft.getDependents();
            if (dependents != null) {
                Iterator<ConstraintAnchor> it = dependents.iterator();
                while (it.hasNext()) {
                    it.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
            }
            HashSet<ConstraintAnchor> dependents2 = this.mRight.getDependents();
            if (dependents2 != null) {
                Iterator<ConstraintAnchor> it2 = dependents2.iterator();
                while (it2.hasNext()) {
                    it2.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> dependents3 = this.mTop.getDependents();
        if (dependents3 != null) {
            Iterator<ConstraintAnchor> it3 = dependents3.iterator();
            while (it3.hasNext()) {
                it3.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        HashSet<ConstraintAnchor> dependents4 = this.mBottom.getDependents();
        if (dependents4 != null) {
            Iterator<ConstraintAnchor> it4 = dependents4.iterator();
            while (it4.hasNext()) {
                it4.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        HashSet<ConstraintAnchor> dependents5 = this.mBaseline.getDependents();
        if (dependents5 != null) {
            Iterator<ConstraintAnchor> it5 = dependents5.iterator();
            while (it5.hasNext()) {
                it5.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
    }
}
