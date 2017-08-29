package com.bpe.monitor.version;

import com.jcabi.manifests.Manifests;
import org.springframework.stereotype.Component;

/**
 * Created by polinchakb on 10/14/16.
 */
@Component
public class Version {

    public String getVersion() throws Exception {
        try {
            return Manifests.read("Maven-Build-Version");
        } catch (Exception e) {
            return "Version Unknown";
        }
    }
}
