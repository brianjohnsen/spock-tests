package spocktest

import static org.junit.Assert.*


import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

import spock.lang.Specification;


@TestFor(MyFineService)
class MyFineServiceSpec extends Specification {
	
	def "beregn regner rigtigt"(){
		expect:
		service.beregn(tal1, tal2) == resultat
		
		where:
		tal1	| tal2	| resultat
		2		| 2		| 4
		0		| 0		| 0
	}
	
	def "kasterop kaster"(){
		when:
		service.kasterop()
		
		then:
		def exe = thrown(IllegalArgumentException)
		exe.message == "øv"
	}
	
}
