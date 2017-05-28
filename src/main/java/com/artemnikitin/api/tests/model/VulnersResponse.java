package com.artemnikitin.api.tests.model;

import java.util.List;

public class VulnersResponse {

    private int statusCode;
    private VulnersJson body;

    public VulnersResponse(int statusCode, VulnersJson response) {
        this.statusCode = statusCode;
        this.body = response;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public VulnersJson getBody() {
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VulnersResponse that = (VulnersResponse) o;

        if (statusCode != that.statusCode) return false;
        return body != null ? body.equals(that.body) : that.body == null;
    }

    @Override
    public int hashCode() {
        int result = statusCode;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VulnersResponse{" +
                "statusCode=" + statusCode +
                ", body=" + body +
                '}';
    }

    public class VulnersJson {
        private String result;
        private Data data;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            VulnersJson that = (VulnersJson) o;

            if (result != null ? !result.equals(that.result) : that.result != null) return false;
            return data != null ? data.equals(that.data) : that.data == null;
        }

        @Override
        public int hashCode() {
            int result1 = result != null ? result.hashCode() : 0;
            result1 = 31 * result1 + (data != null ? data.hashCode() : 0);
            return result1;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "result='" + result + '\'' +
                    ", data=" + data +
                    '}';
        }

        public class Reason {

            private String packages;
            private String providedVersion;
            private String bulletinVersion;
            private String providedPackage;
            private String bulletinPackage;
            private String operator;
            private String bulletinID;

            public String getPackage() {
                return packages;
            }

            public void setPackage(String _package) {
                this.packages = _package;
            }

            public String getProvidedVersion() {
                return providedVersion;
            }

            public void setProvidedVersion(String providedVersion) {
                this.providedVersion = providedVersion;
            }

            public String getBulletinVersion() {
                return bulletinVersion;
            }

            public void setBulletinVersion(String bulletinVersion) {
                this.bulletinVersion = bulletinVersion;
            }

            public String getProvidedPackage() {
                return providedPackage;
            }

            public void setProvidedPackage(String providedPackage) {
                this.providedPackage = providedPackage;
            }

            public String getBulletinPackage() {
                return bulletinPackage;
            }

            public void setBulletinPackage(String bulletinPackage) {
                this.bulletinPackage = bulletinPackage;
            }

            public String getOperator() {
                return operator;
            }

            public void setOperator(String operator) {
                this.operator = operator;
            }

            public String getBulletinID() {
                return bulletinID;
            }

            public void setBulletinID(String bulletinID) {
                this.bulletinID = bulletinID;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Reason reason = (Reason) o;

                if (packages != null ? !packages.equals(reason.packages) : reason.packages != null)
                    return false;
                if (providedVersion != null ? !providedVersion.equals(reason.providedVersion) : reason.providedVersion != null)
                    return false;
                if (bulletinVersion != null ? !bulletinVersion.equals(reason.bulletinVersion) : reason.bulletinVersion != null)
                    return false;
                if (providedPackage != null ? !providedPackage.equals(reason.providedPackage) : reason.providedPackage != null)
                    return false;
                if (bulletinPackage != null ? !bulletinPackage.equals(reason.bulletinPackage) : reason.bulletinPackage != null)
                    return false;
                if (operator != null ? !operator.equals(reason.operator) : reason.operator != null)
                    return false;
                return bulletinID != null ? bulletinID.equals(reason.bulletinID) : reason.bulletinID == null;
            }

            @Override
            public int hashCode() {
                int result = packages != null ? packages.hashCode() : 0;
                result = 31 * result + (providedVersion != null ? providedVersion.hashCode() : 0);
                result = 31 * result + (bulletinVersion != null ? bulletinVersion.hashCode() : 0);
                result = 31 * result + (providedPackage != null ? providedPackage.hashCode() : 0);
                result = 31 * result + (bulletinPackage != null ? bulletinPackage.hashCode() : 0);
                result = 31 * result + (operator != null ? operator.hashCode() : 0);
                result = 31 * result + (bulletinID != null ? bulletinID.hashCode() : 0);
                return result;
            }

            @Override
            public String toString() {
                return "Reason{" +
                        "packages='" + packages + '\'' +
                        ", providedVersion='" + providedVersion + '\'' +
                        ", bulletinVersion='" + bulletinVersion + '\'' +
                        ", providedPackage='" + providedPackage + '\'' +
                        ", bulletinPackage='" + bulletinPackage + '\'' +
                        ", operator='" + operator + '\'' +
                        ", bulletinID='" + bulletinID + '\'' +
                        '}';
            }

        }

        public class Data {

            private List<Reason> reasons = null;
            private Cvss cvss;
            private List<String> cvelist = null;
            private String id;
            private String error;
            private Integer errorCode;

            public String getError() {
                return error;
            }

            public void setError(String error) {
                this.error = error;
            }

            public Integer getErrorCode() {
                return errorCode;
            }

            public void setErrorCode(Integer errorCode) {
                this.errorCode = errorCode;
            }

            public List<Reason> getReasons() {
                return reasons;
            }

            public void setReasons(List<Reason> reasons) {
                this.reasons = reasons;
            }

            public Cvss getCvss() {
                return cvss;
            }

            public void setCvss(Cvss cvss) {
                this.cvss = cvss;
            }

            public List<String> getCvelist() {
                return cvelist;
            }

            public void setCvelist(List<String> cvelist) {
                this.cvelist = cvelist;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Data data = (Data) o;

                if (reasons != null ? !reasons.equals(data.reasons) : data.reasons != null)
                    return false;
                if (cvss != null ? !cvss.equals(data.cvss) : data.cvss != null) return false;
                if (cvelist != null ? !cvelist.equals(data.cvelist) : data.cvelist != null)
                    return false;
                if (id != null ? !id.equals(data.id) : data.id != null) return false;
                if (error != null ? !error.equals(data.error) : data.error != null) return false;
                return errorCode != null ? errorCode.equals(data.errorCode) : data.errorCode == null;
            }

            @Override
            public int hashCode() {
                int result = reasons != null ? reasons.hashCode() : 0;
                result = 31 * result + (cvss != null ? cvss.hashCode() : 0);
                result = 31 * result + (cvelist != null ? cvelist.hashCode() : 0);
                result = 31 * result + (id != null ? id.hashCode() : 0);
                result = 31 * result + (error != null ? error.hashCode() : 0);
                result = 31 * result + (errorCode != null ? errorCode.hashCode() : 0);
                return result;
            }

            @Override
            public String toString() {
                return "Data{" +
                        "reasons=" + reasons +
                        ", cvss=" + cvss +
                        ", cvelist=" + cvelist +
                        ", id='" + id + '\'' +
                        ", error='" + error + '\'' +
                        ", errorCode=" + errorCode +
                        '}';
            }

        }

        public class Cvss {

            private double score;
            private String vector;

            public double getScore() {
                return score;
            }

            public void setScore(double score) {
                this.score = score;
            }

            public String getVector() {
                return vector;
            }

            public void setVector(String vector) {
                this.vector = vector;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }

                Cvss cvss = (Cvss) o;

                if (Double.compare(cvss.score, score) != 0) {
                    return false;
                }
                return vector != null ? vector.equals(cvss.vector) : cvss.vector == null;
            }

            @Override
            public int hashCode() {
                int result;
                long temp;
                temp = Double.doubleToLongBits(score);
                result = (int) (temp ^ (temp >>> 32));
                result = 31 * result + (vector != null ? vector.hashCode() : 0);
                return result;
            }

            @Override
            public String toString() {
                return "Cvss{" +
                    "score=" + score +
                    ", vector='" + vector + '\'' +
                    '}';
            }

        }
    }

}
