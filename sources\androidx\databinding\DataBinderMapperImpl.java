package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
    DataBinderMapperImpl() {
        addMapper(new com.digitalwallet.DataBinderMapperImpl());
        addMapper("com.digitalwallet.app");
        addMapper("com.digitalwallet.check_in");
    }
}
