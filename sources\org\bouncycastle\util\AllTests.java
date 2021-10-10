package org.bouncycastle.util;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class AllTests {
    public static void main(String[] strArr) {
        TestRunner.run(suite());
    }

    public static Test suite() {
        TestSuite testSuite = new TestSuite("util tests");
        testSuite.addTestSuite(IPTest.class);
        return testSuite;
    }
}
