package re;

class Choice extends RegEX
{
    public RegEX thisOne ;
    public
    RegEX thatOne ;

    public Choice (RegEX thisOne, RegEX thatOne){
        this.thisOne = thisOne ;
        this.thatOne = thatOne ;
    }
}