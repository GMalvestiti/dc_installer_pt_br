package com.riser876.data;

import java.io.Serializable;

public class InstallerData implements Serializable{
    private String version;
    private String latestVersion;
    private String installFolder;

    public InstallerData(String version, String latestVersion) {
        this.version = version;
        this.latestVersion = latestVersion;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLatestVersion() {
        return this.latestVersion;
    }

    public void setLatestVersion(String latestVersion) {
        this.latestVersion = latestVersion;
    }

    public String getInstallFolder() {
        return this.installFolder;
    }

    public void setInstallFolder(String installFolder) {
        this.installFolder = installFolder;
    }
}