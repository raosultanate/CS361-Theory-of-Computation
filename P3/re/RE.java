package re;

import fa.nfa.NFA;

public class RE implements REInterface {

    private String regEx; // RegEx input string
    private int stateCount = 0;
    private RegExParser rep;

    /**
     * Default Constructor
     * @param regEx Regular expression
     */
    public RE(String regEx) {
        this.regEx = regEx;
        rep = new RegExParser(regEx);
    }

    @Override
    public NFA getNFA() {
        return null;
    }

    public static void main(String[] args){
        RegExParser ex = new RegExParser("(c|b)*");
        RegEX a = ex.parse();
        String chekc = "ccbb";
        RegEX aS = a;
        Sequence next = (Sequence) a;
        while(next.getSecond() != null){
            if((Sequence)next.getSecond() instanceof Sequence){
                next = (Sequence) next.getSecond();
                continue;
            }
            if((Primitive)next.getSecond() instanceof Primitive){
                System.out.println((Primitive)next.getSecond());
                continue;
            }

            /*if(next.getSecond() instanceof Sequence){
                next = (Sequence) next.getSecond();
            }*/




        }

    }

}
