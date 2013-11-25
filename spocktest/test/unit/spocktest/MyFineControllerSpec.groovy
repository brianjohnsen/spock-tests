package spocktest

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(MyFineController)
class MyFineControllerSpec extends Specification {



    def "redirect action"() {
        when:
        controller.redirectaction("42")

        then:
        response.redirectUrl == "/myFine/myaction?cvr=42"
    }

    def "alm action"() {
        setup:
        controller.params.arg1 = 42

        expect:
        !controller.session.arg1

        when:
        def model = controller.myaction()

        then:
        model.sometext == "some text"
        model.arg1 == 84

        and:
        controller.session.arg1 == 84
    }

    def "render action"() {
        when:
        controller.renderaction("42")

        then:
        response.text == "more text 42"
    }

    def "render action json"() {
        when:
        controller.renderactionjson("42")

        then:
        response.text == '{"cvr":"42"}'
    }

}
