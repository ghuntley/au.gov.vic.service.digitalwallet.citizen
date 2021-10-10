package com.digitalwallet;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.databinding.BannerCheckInSuccessBindingImpl;
import com.digitalwallet.databinding.FragmentCheckInAddDependantInputBindingImpl;
import com.digitalwallet.databinding.FragmentCheckInEditPersonInputBindingImpl;
import com.digitalwallet.databinding.FragmentCheckInFeedbackBindingImpl;
import com.digitalwallet.databinding.FragmentCheckInFeedbackSuccessBindingImpl;
import com.digitalwallet.databinding.FragmentCheckInHistoryDetailBindingImpl;
import com.digitalwallet.databinding.FragmentCheckInOverviewBindingImpl;
import com.digitalwallet.databinding.FragmentCheckInPrimaryInputBindingImpl;
import com.digitalwallet.databinding.FragmentCheckInScannerBindingImpl;
import com.digitalwallet.databinding.FragmentCheckInShortcutBindingImpl;
import com.digitalwallet.databinding.FragmentCheckInSubmittingBindingImpl;
import com.digitalwallet.databinding.FragmentCheckInSuccessBindingImpl;
import com.digitalwallet.databinding.FragmentCheckInSummaryBindingImpl;
import com.digitalwallet.databinding.ItemCheckInFavouriteCellBindingImpl;
import com.digitalwallet.databinding.ItemCheckInFavouriteRowBindingImpl;
import com.digitalwallet.databinding.ItemCheckInHistoryHeaderBindingImpl;
import com.digitalwallet.databinding.ItemCheckInHistoryRowBindingImpl;
import com.digitalwallet.databinding.ItemCheckInPersonRowBindingImpl;
import com.digitalwallet.databinding.LayoutCheckInHistorySearchBindingImpl;
import com.digitalwallet.databinding.LayoutCheckInInputBindingImpl;
import com.digitalwallet.databinding.LayoutCheckInPrivacyBindingImpl;
import com.digitalwallet.databinding.LayoutCheckInSuccessConversionBindingImpl;
import com.digitalwallet.databinding.LayoutCheckInTitleBarBindingImpl;
import com.digitalwallet.databinding.LayoutCheckedInDetailFavouringBindingImpl;
import com.digitalwallet.databinding.LayoutInfoBoxBindingImpl;
import com.digitalwallet.databinding.LayoutLoadingBindingImpl;
import com.digitalwallet.databinding.LayoutTitleBarBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bouncycastle.i18n.MessageBundle;

public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_BANNERCHECKINSUCCESS = 1;
    private static final int LAYOUT_FRAGMENTCHECKINADDDEPENDANTINPUT = 2;
    private static final int LAYOUT_FRAGMENTCHECKINEDITPERSONINPUT = 3;
    private static final int LAYOUT_FRAGMENTCHECKINFEEDBACK = 4;
    private static final int LAYOUT_FRAGMENTCHECKINFEEDBACKSUCCESS = 5;
    private static final int LAYOUT_FRAGMENTCHECKINHISTORYDETAIL = 6;
    private static final int LAYOUT_FRAGMENTCHECKINOVERVIEW = 7;
    private static final int LAYOUT_FRAGMENTCHECKINPRIMARYINPUT = 8;
    private static final int LAYOUT_FRAGMENTCHECKINSCANNER = 9;
    private static final int LAYOUT_FRAGMENTCHECKINSHORTCUT = 10;
    private static final int LAYOUT_FRAGMENTCHECKINSUBMITTING = 11;
    private static final int LAYOUT_FRAGMENTCHECKINSUCCESS = 12;
    private static final int LAYOUT_FRAGMENTCHECKINSUMMARY = 13;
    private static final int LAYOUT_ITEMCHECKINFAVOURITECELL = 14;
    private static final int LAYOUT_ITEMCHECKINFAVOURITEROW = 15;
    private static final int LAYOUT_ITEMCHECKINHISTORYHEADER = 16;
    private static final int LAYOUT_ITEMCHECKINHISTORYROW = 17;
    private static final int LAYOUT_ITEMCHECKINPERSONROW = 18;
    private static final int LAYOUT_LAYOUTCHECKEDINDETAILFAVOURING = 24;
    private static final int LAYOUT_LAYOUTCHECKINHISTORYSEARCH = 19;
    private static final int LAYOUT_LAYOUTCHECKININPUT = 20;
    private static final int LAYOUT_LAYOUTCHECKINPRIVACY = 21;
    private static final int LAYOUT_LAYOUTCHECKINSUCCESSCONVERSION = 22;
    private static final int LAYOUT_LAYOUTCHECKINTITLEBAR = 23;
    private static final int LAYOUT_LAYOUTINFOBOX = 25;
    private static final int LAYOUT_LAYOUTLOADING = 26;
    private static final int LAYOUT_LAYOUTTITLEBAR = 27;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(27);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.banner_check_in_success, 1);
        sparseIntArray.put(R.layout.fragment_check_in_add_dependant_input, 2);
        sparseIntArray.put(R.layout.fragment_check_in_edit_person_input, 3);
        sparseIntArray.put(R.layout.fragment_check_in_feedback, 4);
        sparseIntArray.put(R.layout.fragment_check_in_feedback_success, 5);
        sparseIntArray.put(R.layout.fragment_check_in_history_detail, 6);
        sparseIntArray.put(R.layout.fragment_check_in_overview, 7);
        sparseIntArray.put(R.layout.fragment_check_in_primary_input, 8);
        sparseIntArray.put(R.layout.fragment_check_in_scanner, 9);
        sparseIntArray.put(R.layout.fragment_check_in_shortcut, 10);
        sparseIntArray.put(R.layout.fragment_check_in_submitting, 11);
        sparseIntArray.put(R.layout.fragment_check_in_success, 12);
        sparseIntArray.put(R.layout.fragment_check_in_summary, 13);
        sparseIntArray.put(R.layout.item_check_in_favourite_cell, 14);
        sparseIntArray.put(R.layout.item_check_in_favourite_row, 15);
        sparseIntArray.put(R.layout.item_check_in_history_header, 16);
        sparseIntArray.put(R.layout.item_check_in_history_row, 17);
        sparseIntArray.put(R.layout.item_check_in_person_row, 18);
        sparseIntArray.put(R.layout.layout_check_in_history_search, 19);
        sparseIntArray.put(R.layout.layout_check_in_input, 20);
        sparseIntArray.put(R.layout.layout_check_in_privacy, 21);
        sparseIntArray.put(R.layout.layout_check_in_success_conversion, 22);
        sparseIntArray.put(R.layout.layout_check_in_title_bar, 23);
        sparseIntArray.put(R.layout.layout_checked_in_detail_favouring, 24);
        sparseIntArray.put(R.layout.layout_info_box, 25);
        sparseIntArray.put(R.layout.layout_loading_RES_2131492939, 26);
        sparseIntArray.put(R.layout.layout_title_bar_RES_2131492940, 27);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch (i2) {
                case 1:
                    if ("layout/banner_check_in_success_0".equals(tag)) {
                        return new BannerCheckInSuccessBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for banner_check_in_success is invalid. Received: " + tag);
                case 2:
                    if ("layout/fragment_check_in_add_dependant_input_0".equals(tag)) {
                        return new FragmentCheckInAddDependantInputBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_check_in_add_dependant_input is invalid. Received: " + tag);
                case 3:
                    if ("layout/fragment_check_in_edit_person_input_0".equals(tag)) {
                        return new FragmentCheckInEditPersonInputBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_check_in_edit_person_input is invalid. Received: " + tag);
                case 4:
                    if ("layout/fragment_check_in_feedback_0".equals(tag)) {
                        return new FragmentCheckInFeedbackBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_check_in_feedback is invalid. Received: " + tag);
                case 5:
                    if ("layout/fragment_check_in_feedback_success_0".equals(tag)) {
                        return new FragmentCheckInFeedbackSuccessBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_check_in_feedback_success is invalid. Received: " + tag);
                case 6:
                    if ("layout/fragment_check_in_history_detail_0".equals(tag)) {
                        return new FragmentCheckInHistoryDetailBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_check_in_history_detail is invalid. Received: " + tag);
                case 7:
                    if ("layout/fragment_check_in_overview_0".equals(tag)) {
                        return new FragmentCheckInOverviewBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_check_in_overview is invalid. Received: " + tag);
                case 8:
                    if ("layout/fragment_check_in_primary_input_0".equals(tag)) {
                        return new FragmentCheckInPrimaryInputBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_check_in_primary_input is invalid. Received: " + tag);
                case 9:
                    if ("layout/fragment_check_in_scanner_0".equals(tag)) {
                        return new FragmentCheckInScannerBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_check_in_scanner is invalid. Received: " + tag);
                case 10:
                    if ("layout/fragment_check_in_shortcut_0".equals(tag)) {
                        return new FragmentCheckInShortcutBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_check_in_shortcut is invalid. Received: " + tag);
                case 11:
                    if ("layout/fragment_check_in_submitting_0".equals(tag)) {
                        return new FragmentCheckInSubmittingBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_check_in_submitting is invalid. Received: " + tag);
                case 12:
                    if ("layout/fragment_check_in_success_0".equals(tag)) {
                        return new FragmentCheckInSuccessBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_check_in_success is invalid. Received: " + tag);
                case 13:
                    if ("layout/fragment_check_in_summary_0".equals(tag)) {
                        return new FragmentCheckInSummaryBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_check_in_summary is invalid. Received: " + tag);
                case 14:
                    if ("layout/item_check_in_favourite_cell_0".equals(tag)) {
                        return new ItemCheckInFavouriteCellBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_check_in_favourite_cell is invalid. Received: " + tag);
                case 15:
                    if ("layout/item_check_in_favourite_row_0".equals(tag)) {
                        return new ItemCheckInFavouriteRowBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_check_in_favourite_row is invalid. Received: " + tag);
                case 16:
                    if ("layout/item_check_in_history_header_0".equals(tag)) {
                        return new ItemCheckInHistoryHeaderBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_check_in_history_header is invalid. Received: " + tag);
                case 17:
                    if ("layout/item_check_in_history_row_0".equals(tag)) {
                        return new ItemCheckInHistoryRowBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_check_in_history_row is invalid. Received: " + tag);
                case 18:
                    if ("layout/item_check_in_person_row_0".equals(tag)) {
                        return new ItemCheckInPersonRowBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_check_in_person_row is invalid. Received: " + tag);
                case 19:
                    if ("layout/layout_check_in_history_search_0".equals(tag)) {
                        return new LayoutCheckInHistorySearchBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for layout_check_in_history_search is invalid. Received: " + tag);
                case 20:
                    if ("layout/layout_check_in_input_0".equals(tag)) {
                        return new LayoutCheckInInputBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for layout_check_in_input is invalid. Received: " + tag);
                case 21:
                    if ("layout/layout_check_in_privacy_0".equals(tag)) {
                        return new LayoutCheckInPrivacyBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for layout_check_in_privacy is invalid. Received: " + tag);
                case 22:
                    if ("layout/layout_check_in_success_conversion_0".equals(tag)) {
                        return new LayoutCheckInSuccessConversionBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for layout_check_in_success_conversion is invalid. Received: " + tag);
                case 23:
                    if ("layout/layout_check_in_title_bar_0".equals(tag)) {
                        return new LayoutCheckInTitleBarBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for layout_check_in_title_bar is invalid. Received: " + tag);
                case 24:
                    if ("layout/layout_checked_in_detail_favouring_0".equals(tag)) {
                        return new LayoutCheckedInDetailFavouringBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for layout_checked_in_detail_favouring is invalid. Received: " + tag);
                case 25:
                    if ("layout/layout_info_box_0".equals(tag)) {
                        return new LayoutInfoBoxBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for layout_info_box is invalid. Received: " + tag);
                case 26:
                    if ("layout/layout_loading_0".equals(tag)) {
                        return new LayoutLoadingBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for layout_loading is invalid. Received: " + tag);
                case 27:
                    if ("layout/layout_title_bar_0".equals(tag)) {
                        return new LayoutTitleBarBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for layout_title_bar is invalid. Received: " + tag);
                default:
                    return null;
            }
        } else {
            throw new RuntimeException("view must have a tag");
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(9);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "info");
            sparseArray.put(2, "mediumDate");
            sparseArray.put(3, "relativeDay");
            sparseArray.put(4, "showBack");
            sparseArray.put(5, "showDoneButton");
            sparseArray.put(6, "showLoading");
            sparseArray.put(7, MessageBundle.TITLE_ENTRY);
            sparseArray.put(8, "vm");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(27);
            sKeys = hashMap;
            hashMap.put("layout/banner_check_in_success_0", Integer.valueOf((int) R.layout.banner_check_in_success));
            hashMap.put("layout/fragment_check_in_add_dependant_input_0", Integer.valueOf((int) R.layout.fragment_check_in_add_dependant_input));
            hashMap.put("layout/fragment_check_in_edit_person_input_0", Integer.valueOf((int) R.layout.fragment_check_in_edit_person_input));
            hashMap.put("layout/fragment_check_in_feedback_0", Integer.valueOf((int) R.layout.fragment_check_in_feedback));
            hashMap.put("layout/fragment_check_in_feedback_success_0", Integer.valueOf((int) R.layout.fragment_check_in_feedback_success));
            hashMap.put("layout/fragment_check_in_history_detail_0", Integer.valueOf((int) R.layout.fragment_check_in_history_detail));
            hashMap.put("layout/fragment_check_in_overview_0", Integer.valueOf((int) R.layout.fragment_check_in_overview));
            hashMap.put("layout/fragment_check_in_primary_input_0", Integer.valueOf((int) R.layout.fragment_check_in_primary_input));
            hashMap.put("layout/fragment_check_in_scanner_0", Integer.valueOf((int) R.layout.fragment_check_in_scanner));
            hashMap.put("layout/fragment_check_in_shortcut_0", Integer.valueOf((int) R.layout.fragment_check_in_shortcut));
            hashMap.put("layout/fragment_check_in_submitting_0", Integer.valueOf((int) R.layout.fragment_check_in_submitting));
            hashMap.put("layout/fragment_check_in_success_0", Integer.valueOf((int) R.layout.fragment_check_in_success));
            hashMap.put("layout/fragment_check_in_summary_0", Integer.valueOf((int) R.layout.fragment_check_in_summary));
            hashMap.put("layout/item_check_in_favourite_cell_0", Integer.valueOf((int) R.layout.item_check_in_favourite_cell));
            hashMap.put("layout/item_check_in_favourite_row_0", Integer.valueOf((int) R.layout.item_check_in_favourite_row));
            hashMap.put("layout/item_check_in_history_header_0", Integer.valueOf((int) R.layout.item_check_in_history_header));
            hashMap.put("layout/item_check_in_history_row_0", Integer.valueOf((int) R.layout.item_check_in_history_row));
            hashMap.put("layout/item_check_in_person_row_0", Integer.valueOf((int) R.layout.item_check_in_person_row));
            hashMap.put("layout/layout_check_in_history_search_0", Integer.valueOf((int) R.layout.layout_check_in_history_search));
            hashMap.put("layout/layout_check_in_input_0", Integer.valueOf((int) R.layout.layout_check_in_input));
            hashMap.put("layout/layout_check_in_privacy_0", Integer.valueOf((int) R.layout.layout_check_in_privacy));
            hashMap.put("layout/layout_check_in_success_conversion_0", Integer.valueOf((int) R.layout.layout_check_in_success_conversion));
            hashMap.put("layout/layout_check_in_title_bar_0", Integer.valueOf((int) R.layout.layout_check_in_title_bar));
            hashMap.put("layout/layout_checked_in_detail_favouring_0", Integer.valueOf((int) R.layout.layout_checked_in_detail_favouring));
            hashMap.put("layout/layout_info_box_0", Integer.valueOf((int) R.layout.layout_info_box));
            hashMap.put("layout/layout_loading_0", Integer.valueOf((int) R.layout.layout_loading_RES_2131492939));
            hashMap.put("layout/layout_title_bar_0", Integer.valueOf((int) R.layout.layout_title_bar_RES_2131492940));
        }
    }
}
