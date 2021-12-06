package re;

import fa.nfa.NFA;

/*
 A parser to be constructed each time
 a regular expression needs to be parsed.
 */
class RegExParser {

    private String input;

    public RegExParser(String input)
    {
        this.input = input;
    }

    private char peek() {
        return input.charAt(0) ;
    }

    private void eat(char c) {
        if (peek() == c)
            this.input = this.input.substring(1) ;
        else
            throw new
                    RuntimeException("Expected: " + c + "; got: " + peek()) ;
    }

    private char next() {
        char c = peek() ;
        eat(c) ;
        return c ;
    }

    private boolean more() {
        return input.length() > 0 ;
    }

    private RegEX regex() {
        RegEX term = term() ;

        if (more() && peek() == '|') {
            eat ('|') ;
            RegEX regex = regex() ;
            return new Choice(term,regex) ;
        } else {
            return term ;
        }
    }


    private RegEX term() {
        RegEX factor = RegEX.blank ;

        while (more() && peek() != ')' && peek() != '|') {
            RegEX nextFactor = factor() ;
            factor = new Sequence(factor,nextFactor) ;
        }

        return factor ;
    }

    private RegEX base() {

        switch (peek()) {
            case '(':
                eat('(') ;
                RegEX r = regex() ;
                eat(')') ;
                return r;

            case '\\':
                eat ('\\') ;
                char esc = next() ;
                return new Primitive(esc) ;

            default:
                return new Primitive(next()) ;
        }
    }

    private RegEX factor() {

        RegEX base = base() ;

        while (more() && peek() == '*') {
            eat('*') ;
            base = new Repetition(base) ;
        }
        return base ;
    }

    public RegEX parse () {
        RegEX ex = regex();
        return ex;
    }
}


