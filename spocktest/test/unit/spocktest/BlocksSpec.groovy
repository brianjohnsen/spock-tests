package spocktest

import spock.lang.Specification
import spock.lang.Unroll

class BlocksSpec extends Specification {

    //Testblocks (given/when/then/where/unroll)

    @Unroll
    def "Det dobbelte af #tal er #dobbelt"() {
        given:
        def my = new MyClass()

        when:
        my.tal = tal

        then:
        my.dobbelt == dobbelt

        where:
        tal | dobbelt
        1   | 2
        2   | 4
    }


    def "noget med en streng"() {
        setup:
        def my = new MyClass(streng: "hest", tal: 42)

        when:
        my.tal = 43

        then:
        old(my.tal) < 43
        with(my) {
            tal == 43
            streng == "hest"
        }
    }


    class MyClass {
        int tal
        String streng

        int getDobbelt() {
            tal * 2
        }
    }


}
