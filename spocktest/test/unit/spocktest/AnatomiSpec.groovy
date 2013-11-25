package spocktest

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

class AnatomiSpec extends Specification {

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

    //1) Anatomi af en spec

    //2) Man kan skrive alm. tekst i navnet

    def "anatomi af en spec - man kan skrive alm tekst i navnet"() {
        expect:
        2 + 2 == 4
    }

}
