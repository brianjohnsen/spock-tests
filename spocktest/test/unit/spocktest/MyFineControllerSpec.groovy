package spocktest

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(MyFineController)
class MyFineControllerSpec extends Specification {


    //alm. return action - tjek parametre på model
    def "my action"() {
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


    //render action - tjek response.text
    def "render action"() {
        when:
        controller.renderaction("42")

        then:
        response.text == "more text 42"
    }


    //render action JSON - tjek response.text (i json format)
    def "render action json"() {
        when:
        controller.renderactionjson("42")

        then:
        response.text == '{"cvr":"42"}'
    }


    //redirect action - tjek response.redirectUrl
    def "redirect action"() {
        when:
        controller.redirectaction("42")

        then:
        response.redirectUrl == "/myFine/myaction?cvr=42"
    }

}
