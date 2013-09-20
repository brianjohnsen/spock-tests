package spocktest

class MyFineService {

    AnotherFineService anotherFineService

    def enBeregning() {
        megetTungMetode(10, "hest")
    }

    def megetTungMetode(arg1, arg2) {
        //her sker en masse beregning og mange andre services kaldes!
        sleep(10000)
        return 0
    }


    int beregn(int tal1, int tal2) {
        tal1 * tal2
    }

    def kasterop() {
        anotherFineService.kasterop()
    }

    def hentNoget() {
        anotherFineService.hentNogetFraEnDyrRessource(43, "yep", new SomeClass())
    }
}
