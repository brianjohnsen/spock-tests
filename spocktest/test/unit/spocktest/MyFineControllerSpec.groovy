package spocktest

import static org.junit.Assert.*
import grails.test.mixin.*
import grails.test.mixin.support.*

import org.junit.*

import spock.lang.Specification;


@TestFor(MyFineController)
class MyFineControllerSpec extends Specification {
	
	def "alm action"(){
		setup:
		controller.params.xxx = 42
		
		when:
		def model = controller.myaction()
		
		then:
		model.sometext == "some text"
		model.xxx == 84
	}
	
	
	def "render action"(){
		when:
		def model = controller.renderaction("42")
		
		then:
		response.text == "more text 42"
	}
	
}
