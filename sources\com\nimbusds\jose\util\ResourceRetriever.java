package com.nimbusds.jose.util;

import java.io.IOException;
import java.net.URL;

public interface ResourceRetriever {
    Resource retrieveResource(URL url) throws IOException;
}
