package spocktest

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class MyFirstSpec extends Specification {


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
