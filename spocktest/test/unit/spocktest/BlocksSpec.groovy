package spocktest

import spock.lang.Specification
import spock.lang.Unroll

class BlocksSpec extends Specification {


    //Testblocks (given/when/then/where/unroll)

    @Unroll
    def "Det dobbelte af #anInt er #aDouble"() {
        given:
        def my = new MyClass()

        when:
        my.anInt = anInt

        then:
        my.double == aDouble

        where:
        anInt | aDouble
        1     | 2
        2     | 4
    }


    class MyClass {
        int anInt

        int getDouble() {
            anInt * 2
        }
    }


}
