package spocktest

class MyFineService {

    def findAlle(navn) {
		MyDomain.findAllByNavn(navn)
    }
	
	int beregn(int tal1, int tal2){
		tal1 * tal2
	}
	
	def kasterop(){
		throw new IllegalArgumentException("øv")
	}
}
