package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class NavDeepLink {
    private static final Pattern SCHEME_PATTERN = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    private final String mAction;
    private final ArrayList<String> mArguments;
    private boolean mExactDeepLink;
    private boolean mIsParameterizedQuery;
    private final String mMimeType;
    private Pattern mMimeTypePattern;
    private final Map<String, ParamQuery> mParamArgMap;
    private Pattern mPattern;
    private final String mUri;

    NavDeepLink(String str, String str2, String str3) {
        this.mArguments = new ArrayList<>();
        this.mParamArgMap = new HashMap();
        this.mPattern = null;
        int i = 0;
        this.mExactDeepLink = false;
        this.mIsParameterizedQuery = false;
        this.mMimeTypePattern = null;
        this.mUri = str;
        this.mAction = str2;
        this.mMimeType = str3;
        if (str != null) {
            Uri parse = Uri.parse(str);
            this.mIsParameterizedQuery = parse.getQuery() != null;
            StringBuilder sb = new StringBuilder("^");
            if (!SCHEME_PATTERN.matcher(str).find()) {
                sb.append("http[s]?://");
            }
            Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (this.mIsParameterizedQuery) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str);
                if (matcher.find()) {
                    buildPathRegex(str.substring(0, matcher.start()), sb, compile);
                }
                this.mExactDeepLink = false;
                for (String str4 : parse.getQueryParameterNames()) {
                    StringBuilder sb2 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(str4);
                    Matcher matcher2 = compile.matcher(queryParameter);
                    ParamQuery paramQuery = new ParamQuery();
                    int i2 = i;
                    while (matcher2.find()) {
                        paramQuery.addArgumentName(matcher2.group(1));
                        sb2.append(Pattern.quote(queryParameter.substring(i2, matcher2.start())));
                        sb2.append("(.+?)?");
                        i2 = matcher2.end();
                    }
                    if (i2 < queryParameter.length()) {
                        sb2.append(Pattern.quote(queryParameter.substring(i2)));
                    }
                    paramQuery.setParamRegex(sb2.toString().replace(".*", "\\E.*\\Q"));
                    this.mParamArgMap.put(str4, paramQuery);
                    i = 0;
                }
            } else {
                this.mExactDeepLink = buildPathRegex(str, sb, compile);
            }
            this.mPattern = Pattern.compile(sb.toString().replace(".*", "\\E.*\\Q"));
        }
        if (str3 == null) {
            return;
        }
        if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(str3).matches()) {
            MimeType mimeType = new MimeType(str3);
            this.mMimeTypePattern = Pattern.compile(("^(" + mimeType.mType + "|[*]+)/(" + mimeType.mSubType + "|[*]+)$").replace("*|[*]", "[\\s\\S]"));
            return;
        }
        throw new IllegalArgumentException("The given mimeType " + str3 + " does not match to required \"type/subtype\" format");
    }

    NavDeepLink(String str) {
        this(str, null, null);
    }

    private boolean buildPathRegex(String str, StringBuilder sb, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z = !str.contains(".*");
        int i = 0;
        while (matcher.find()) {
            this.mArguments.add(matcher.group(1));
            sb.append(Pattern.quote(str.substring(i, matcher.start())));
            sb.append("(.+?)");
            i = matcher.end();
            z = false;
        }
        if (i < str.length()) {
            sb.append(Pattern.quote(str.substring(i)));
        }
        sb.append("($|(\\?(.)*))");
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean matches(Uri uri) {
        return matches(new NavDeepLinkRequest(uri, null, null));
    }

    /* access modifiers changed from: package-private */
    public boolean matches(NavDeepLinkRequest navDeepLinkRequest) {
        if (matchUri(navDeepLinkRequest.getUri()) && matchAction(navDeepLinkRequest.getAction())) {
            return matchMimeType(navDeepLinkRequest.getMimeType());
        }
        return false;
    }

    private boolean matchUri(Uri uri) {
        boolean z = uri == null;
        Pattern pattern = this.mPattern;
        if (z == (pattern != null)) {
            return false;
        }
        return uri == null || pattern.matcher(uri.toString()).matches();
    }

    private boolean matchAction(String str) {
        boolean z = str == null;
        String str2 = this.mAction;
        if (z == (str2 != null)) {
            return false;
        }
        return str == null || str2.equals(str);
    }

    private boolean matchMimeType(String str) {
        if ((str == null) == (this.mMimeType != null)) {
            return false;
        }
        return str == null || this.mMimeTypePattern.matcher(str).matches();
    }

    /* access modifiers changed from: package-private */
    public boolean isExactDeepLink() {
        return this.mExactDeepLink;
    }

    public String getUriPattern() {
        return this.mUri;
    }

    public String getAction() {
        return this.mAction;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    /* access modifiers changed from: package-private */
    public int getMimeTypeMatchRating(String str) {
        if (this.mMimeType == null || !this.mMimeTypePattern.matcher(str).matches()) {
            return -1;
        }
        return new MimeType(this.mMimeType).compareTo(new MimeType(str));
    }

    /* access modifiers changed from: package-private */
    public Bundle getMatchingArguments(Uri uri, Map<String, NavArgument> map) {
        Matcher matcher;
        Matcher matcher2 = this.mPattern.matcher(uri.toString());
        if (!matcher2.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        int size = this.mArguments.size();
        int i = 0;
        while (i < size) {
            String str = this.mArguments.get(i);
            i++;
            if (parseArgument(bundle, str, Uri.decode(matcher2.group(i)), map.get(str))) {
                return null;
            }
        }
        if (this.mIsParameterizedQuery) {
            for (String str2 : this.mParamArgMap.keySet()) {
                ParamQuery paramQuery = this.mParamArgMap.get(str2);
                String queryParameter = uri.getQueryParameter(str2);
                if (queryParameter != null) {
                    matcher = Pattern.compile(paramQuery.getParamRegex()).matcher(queryParameter);
                    if (!matcher.matches()) {
                        return null;
                    }
                } else {
                    matcher = null;
                }
                int i2 = 0;
                while (true) {
                    if (i2 < paramQuery.size()) {
                        String decode = matcher != null ? Uri.decode(matcher.group(i2 + 1)) : null;
                        String argumentName = paramQuery.getArgumentName(i2);
                        NavArgument navArgument = map.get(argumentName);
                        if (navArgument != null && (decode == null || decode.replaceAll("[{}]", "").equals(argumentName))) {
                            if (navArgument.getDefaultValue() != null) {
                                decode = navArgument.getDefaultValue().toString();
                            } else if (navArgument.isNullable()) {
                                decode = null;
                            }
                        }
                        if (parseArgument(bundle, argumentName, decode, navArgument)) {
                            return null;
                        }
                        i2++;
                    }
                }
            }
        }
        return bundle;
    }

    private boolean parseArgument(Bundle bundle, String str, String str2, NavArgument navArgument) {
        if (navArgument != null) {
            try {
                navArgument.getType().parseAndPut(bundle, str, str2);
                return false;
            } catch (IllegalArgumentException unused) {
                return true;
            }
        } else {
            bundle.putString(str, str2);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static class ParamQuery {
        private ArrayList<String> mArguments = new ArrayList<>();
        private String mParamRegex;

        ParamQuery() {
        }

        /* access modifiers changed from: package-private */
        public void setParamRegex(String str) {
            this.mParamRegex = str;
        }

        /* access modifiers changed from: package-private */
        public String getParamRegex() {
            return this.mParamRegex;
        }

        /* access modifiers changed from: package-private */
        public void addArgumentName(String str) {
            this.mArguments.add(str);
        }

        /* access modifiers changed from: package-private */
        public String getArgumentName(int i) {
            return this.mArguments.get(i);
        }

        public int size() {
            return this.mArguments.size();
        }
    }

    /* access modifiers changed from: private */
    public static class MimeType implements Comparable<MimeType> {
        String mSubType;
        String mType;

        MimeType(String str) {
            String[] split = str.split("/", -1);
            this.mType = split[0];
            this.mSubType = split[1];
        }

        public int compareTo(MimeType mimeType) {
            int i = this.mType.equals(mimeType.mType) ? 2 : 0;
            return this.mSubType.equals(mimeType.mSubType) ? i + 1 : i;
        }
    }

    public static final class Builder {
        private String mAction;
        private String mMimeType;
        private String mUriPattern;

        Builder() {
        }

        public static Builder fromUriPattern(String str) {
            Builder builder = new Builder();
            builder.setUriPattern(str);
            return builder;
        }

        public static Builder fromAction(String str) {
            if (!str.isEmpty()) {
                Builder builder = new Builder();
                builder.setAction(str);
                return builder;
            }
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
        }

        public static Builder fromMimeType(String str) {
            Builder builder = new Builder();
            builder.setMimeType(str);
            return builder;
        }

        public Builder setUriPattern(String str) {
            this.mUriPattern = str;
            return this;
        }

        public Builder setAction(String str) {
            if (!str.isEmpty()) {
                this.mAction = str;
                return this;
            }
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
        }

        public Builder setMimeType(String str) {
            this.mMimeType = str;
            return this;
        }

        public NavDeepLink build() {
            return new NavDeepLink(this.mUriPattern, this.mAction, this.mMimeType);
        }
    }
}
