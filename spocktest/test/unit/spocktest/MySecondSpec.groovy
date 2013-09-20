package spocktest

import spock.lang.Specification

class MySecondSpec extends Specification {

    def "tester statisk mock"() {
        expect: "kalder metoden normalt"
        SomeClass.doStuff(42) == 42

        when: "mock"
        GroovyMock(SomeClass, global: true)
        SomeClass.doStuff(_) >> { "xxx" }

        then: "returnerer mocket værdi"
        SomeClass.doStuff(42) == "xxx"

    }


}
