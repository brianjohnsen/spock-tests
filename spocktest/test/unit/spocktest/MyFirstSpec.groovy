package spocktest

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class MyFirstSpec extends Specification {

    def setup() {
        println "setup"
    }

    def cleanup() {
        println "clean"
    }

    def setupSpec() {
        println "setupSpec"
    }

    def cleanupSpec() {
        println "cleanupSpec"
    }

    //Anatomi af en test (given/when/then/where/unroll)

    @Unroll("tallet er #tal")
    def "man kan skrive alm tekst i metodenavnet"() {
        expect:
        tal == tal

        when:
        def dobbelt = tal * 2

        then:
        dobbelt > tal

        where:
        tal << [1, 2, 3, 4]
    }



    @Shared enStreng = "hej"

    @Unroll()
    def "et tal=#tal streng=#exps"() {
        expect:
        sum(tal) == exp

        where:
        tal | streng | exp | exps
        1   | "hej"  | 2   | enStreng
        2   | "hej"  | 4   | "hejx"
    }

    private int sum(tal) {
        return tal + tal
    }


}
