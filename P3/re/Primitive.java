package re;

class Primitive extends RegEX
{
    private char c;

    public Primitive(char c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Primitive{" +
                "c=" + c +
                '}';
    }
}
