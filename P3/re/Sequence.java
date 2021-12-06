package re;

 public class Sequence extends RegEX
    {
        public RegEX first ;
        public RegEX second ;

        public Sequence (RegEX first, RegEX second) {
            this.first = first ;
            this.second = second ;
        }

        public RegEX getFirst(){
            return first;
        }
        public RegEX getSecond(){
            return second;
        }

        public void setSecond(RegEX sec){
            this.second = sec;
        }
    }

