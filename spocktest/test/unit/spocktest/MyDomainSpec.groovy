package spocktest

import grails.buildtestdata.mixin.Build
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(MyDomain)
@Build([MyDomain, AnotherDomain])
class MyDomainSpec extends Specification {


    def "constraints og build"() {
        when:
        def domain = MyDomain.build()
        domain.save(flush: true)

        then: "build respekterer constraints"
        domain.dyr in ["hest", "ko"]
        domain.tal > 42
        domain.tal <= 44
        domain.others.size() > 0

        and: "old-metoden 'husker' tilstanden inden testen blev kørt!"
        old(MyDomain.count) < MyDomain.count
    }


}
