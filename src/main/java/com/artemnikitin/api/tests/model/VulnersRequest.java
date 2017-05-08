package com.artemnikitin.api.tests.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VulnersRequest {

    private String os;
    private String version;

    @SerializedName("package")
    private List<String> packages = null;

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<String> getPackages() {
        return packages;
    }

    public void setPackages(List<String> packages) {
        this.packages = packages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VulnersRequest request = (VulnersRequest) o;

        if (os != null ? !os.equals(request.os) : request.os != null) return false;
        if (version != null ? !version.equals(request.version) : request.version != null)
            return false;
        return packages != null ? packages.equals(request.packages) : request.packages == null;
    }

    @Override
    public int hashCode() {
        int result = os != null ? os.hashCode() : 0;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (packages != null ? packages.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Request{" +
                "os='" + os + '\'' +
                ", version='" + version + '\'' +
                ", packages=" + packages +
                '}';
    }

}
