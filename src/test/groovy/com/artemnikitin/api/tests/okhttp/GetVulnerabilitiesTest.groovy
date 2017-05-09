package com.artemnikitin.api.tests.okhttp

import com.artemnikitin.api.tests.model.VulnersRequest
import com.artemnikitin.api.tests.model.VulnersResponse
import com.google.gson.Gson
import spock.lang.Shared
import spock.lang.Specification

class GetVulnerabilitiesTest extends Specification {

    @Shared
    Gson gson = new Gson()

    def "For request with vulnerable packages list of vulnerabilities should be returned"() {
        given:
        def request = new VulnersRequest()
        request.os = "centos"
        request.version = "7"
        List<String> packages = new ArrayList<>()
        packages.add("nss-util-3.28.2-1.1.el7_3.x86_64")
        packages.add("util-linux-2.23.2-33.el7.x86_64")
        request.packages = packages

        when:
        def response = OkhttpExecutor.getResponse(request)
        def vulnersResponse = gson.fromJson(response.body().string(), VulnersResponse.class)

        then:
        response.code() == 200
        vulnersResponse.result == "OK"
        vulnersResponse.data.cvelist.size() > 0
        vulnersResponse.data.reasons.size() > 0
    }

    def "With empty request, error should be returned"() {
        given:
        def request = new VulnersRequest()

        when:
        def response = OkhttpExecutor.getResponse(request)
        def vulnersResponse = gson.fromJson(response.body().string(), VulnersResponse.class)

        then:
        response.code() == 200
        vulnersResponse.result == "ERROR"
        vulnersResponse.data.error.contains("Missing parameters")
    }

    def "With unsupported OS, error should be returned"() {
        given:
        def request = new VulnersRequest()
        request.os = "macOS"
        request.version = "10.12.5"
        request.setPackages(new ArrayList<>())

        when:
        def response = OkhttpExecutor.getResponse(request)
        def vulnersResponse = gson.fromJson(response.body().string(), VulnersResponse.class)

        then:
        response.code() == 200
        vulnersResponse.result == "ERROR"
        vulnersResponse.data.error.contains("Unknown operation system")
    }

}
