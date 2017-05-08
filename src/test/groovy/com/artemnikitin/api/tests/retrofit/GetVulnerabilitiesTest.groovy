package com.artemnikitin.api.tests.retrofit

import com.artemnikitin.api.tests.model.VulnersRequest
import spock.lang.Specification

class GetVulnerabilitiesTest extends Specification {

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
        def response = RetrofitExecutor.getResponse(request)

        then:
        response.code() == 200
        response.body().result == "OK"
        response.body().data.cvelist.size() > 0
        response.body().data.reasons.size() > 0
    }

    def "With empty request, error should be returned"() {
        given:
        def request = new VulnersRequest()

        when:
        def response = RetrofitExecutor.getResponse(request)

        then:
        response.code() == 200
        response.body().result == "ERROR"
        response.body().data.error.contains("Missing parameters")
    }

    def "With unsupported OS, error should be returned"() {
        given:
        def request = new VulnersRequest()
        request.os = "macOS"
        request.version = "10.12.5"
        request.setPackages(new ArrayList<>())

        when:
        def response = RetrofitExecutor.getResponse(request)

        then:
        response.code() == 200
        response.body().result == "ERROR"
        response.body().data.error.contains("Unknown operation system")
    }

}
