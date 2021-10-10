package org.bouncycastle.util.io.pem;

import androidx.core.view.PointerIconCompat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class AllTests extends TestCase {
    private void lengthTest(String str, List list, byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PemWriter pemWriter = new PemWriter(new OutputStreamWriter(byteArrayOutputStream));
        PemObject pemObject = new PemObject(str, list, bArr);
        pemWriter.writeObject(pemObject);
        pemWriter.close();
        assertEquals(byteArrayOutputStream.toByteArray().length, pemWriter.getOutputSize(pemObject));
    }

    public static void main(String[] strArr) {
        TestRunner.run(suite());
    }

    public static Test suite() {
        TestSuite testSuite = new TestSuite("util tests");
        testSuite.addTestSuite(AllTests.class);
        return testSuite;
    }

    public void testPemLength() throws IOException {
        for (int i = 1; i != 60; i++) {
            lengthTest("CERTIFICATE", Collections.EMPTY_LIST, new byte[i]);
        }
        lengthTest("CERTIFICATE", Collections.EMPTY_LIST, new byte[100]);
        lengthTest("CERTIFICATE", Collections.EMPTY_LIST, new byte[101]);
        lengthTest("CERTIFICATE", Collections.EMPTY_LIST, new byte[102]);
        lengthTest("CERTIFICATE", Collections.EMPTY_LIST, new byte[103]);
        lengthTest("CERTIFICATE", Collections.EMPTY_LIST, new byte[1000]);
        lengthTest("CERTIFICATE", Collections.EMPTY_LIST, new byte[1001]);
        lengthTest("CERTIFICATE", Collections.EMPTY_LIST, new byte[1002]);
        lengthTest("CERTIFICATE", Collections.EMPTY_LIST, new byte[PointerIconCompat.TYPE_HELP]);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PemHeader("Proc-Type", "4,ENCRYPTED"));
        arrayList.add(new PemHeader("DEK-Info", "DES3,0001020304050607"));
        lengthTest("RSA PRIVATE KEY", arrayList, new byte[103]);
    }
}
