package spocktest

import static org.junit.Assert.*


import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

import spock.lang.Specification;


@TestFor(MyFineService)
class MyFineServiceSpec extends Specification {
	
	
	def setup(){
		service.anotherFineService = new AnotherFineService()
	}
	
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
	
	
	def "mock kasterop"(){
		setup:
		service.anotherFineService = Mock(AnotherFineService)
		service.anotherFineService.kasterop() >> {return 42}
		
		expect:
		service.kasterop() == 42
	}
	
}
