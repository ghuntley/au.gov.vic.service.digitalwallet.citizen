package net.openid.appauth.browser;

public class VersionRange {
    public static final VersionRange ANY_VERSION = new VersionRange(null, null);
    private DelimitedVersion mLowerBound;
    private DelimitedVersion mUpperBound;

    public static VersionRange atLeast(String str) {
        return atLeast(DelimitedVersion.parse(str));
    }

    public static VersionRange atLeast(DelimitedVersion delimitedVersion) {
        return new VersionRange(delimitedVersion, null);
    }

    public static VersionRange atMost(String str) {
        return atMost(DelimitedVersion.parse(str));
    }

    public static VersionRange atMost(DelimitedVersion delimitedVersion) {
        return new VersionRange(null, delimitedVersion);
    }

    public static VersionRange between(String str, String str2) {
        return new VersionRange(DelimitedVersion.parse(str), DelimitedVersion.parse(str2));
    }

    public VersionRange(DelimitedVersion delimitedVersion, DelimitedVersion delimitedVersion2) {
        this.mLowerBound = delimitedVersion;
        this.mUpperBound = delimitedVersion2;
    }

    public boolean matches(String str) {
        return matches(DelimitedVersion.parse(str));
    }

    public boolean matches(DelimitedVersion delimitedVersion) {
        DelimitedVersion delimitedVersion2 = this.mLowerBound;
        if (delimitedVersion2 != null && delimitedVersion2.compareTo(delimitedVersion) > 0) {
            return false;
        }
        DelimitedVersion delimitedVersion3 = this.mUpperBound;
        if (delimitedVersion3 == null || delimitedVersion3.compareTo(delimitedVersion) >= 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        if (this.mLowerBound == null) {
            if (this.mUpperBound == null) {
                return "any version";
            }
            return this.mUpperBound.toString() + " or lower";
        } else if (this.mUpperBound != null) {
            return "between " + this.mLowerBound + " and " + this.mUpperBound;
        } else {
            return this.mLowerBound.toString() + " or higher";
        }
    }
}
