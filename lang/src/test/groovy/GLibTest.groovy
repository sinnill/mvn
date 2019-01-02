import spock.lang.Specification

class GLibTest extends Specification {
    def "someLibraryMethod returns true"() {
        setup:
        def lib = new GLib()

        when:
        def result = lib.someLibraryMethod()

        then:
        result == true
    }
}