package spocktest

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(MyFineService)
class MyFineServiceSpec extends Specification {


    def setup() {
        service.anotherFineService = new AnotherFineService()
    }

    //beregn regner rigtigt (||)
    //thrown fra AnotherFineService (kasterop)
    //mock AnotherFineService (slip for thrown)
    //mock AnotherFineService (hentNoget) (flere parametre)
    //mock AnotherFineService (kardinalitet af kald)
    //partial mock af service (enBeregninn og megetTungMetode)


    def "beregn regner rigtigt"() {
        expect:
        service.beregn(tal1, tal2) == resultat

        where:
        tal1 | tal2 || resultat
        2    | 2    || 4
        0    | 0    || 0
    }


    def "forventer exception"() {
        when:
        service.kasterop()

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "øv"
    }


    def "mock af anden service"() {
        setup:
        service.anotherFineService = Mock(AnotherFineService)
        service.anotherFineService.kasterop() >> { return 42 }

        expect:
        service.kasterop() == 42
    }


    def "mock med flere parametre"() {
        expect:
        service.hentNoget() == 42

        when:
        service.anotherFineService = Mock(AnotherFineService)
        service.anotherFineService.hentNogetFraEnDyrRessource(_, _, _) >> { int i, String s, SomeClass someClass -> return 42 }

        then:
        service.hentNoget() == 42
    }


    def "kardinalitet på mocks"() {
        setup:
        service.anotherFineService = Mock(AnotherFineService)

        when:
        service.hentNoget()

        then:
        1 * service.anotherFineService.hentNogetFraEnDyrRessource(43, _, _)
        0 * service.anotherFineService.hentNogetFraEnDyrRessource(42, _, _)
    }

//Eksempel med JUnit
//    def strictControl = mockFor(MyService)
//    strictControl.demand.someMethod(0..2) { String arg1, int arg2 -> … }
//    strictControl.demand.static.aStaticMethod {-> … }


    def "partial mocking af service"() {
        given:
        def partialMock = Spy(MyFineService) {
            megetTungMetode(_, _) >> { arg1, arg2 -> 42 }
        }

        when:
        def resultat = partialMock.enBeregning()

        then:
        resultat == 42
    }


}
